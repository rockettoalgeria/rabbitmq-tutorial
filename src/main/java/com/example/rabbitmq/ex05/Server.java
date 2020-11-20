package com.example.rabbitmq.ex05;

import com.rabbitmq.client.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.charset.StandardCharsets;

@SpringBootApplication
public class Server {

	private static final String QUEUE_NAME = "rpc_queue";

	private static int fib(int n) {
		if (n == 0) return 0;
		if (n == 1) return 1;
		return fib(n - 1) + fib(n - 2);
	}

	public static void main(String[] argv) throws Exception {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");

		try (Connection connection = factory.newConnection();
			 Channel channel = connection.createChannel()) {
			channel.queueDeclare(QUEUE_NAME, false, false, false, null);
			channel.queuePurge(QUEUE_NAME);

			channel.basicQos(1);

			System.out.println(" [x] Awaiting RPC requests");

			Object monitor = new Object();
			DeliverCallback deliverCallback = (consumerTag, delivery) -> {
				AMQP.BasicProperties replyProps = new AMQP.BasicProperties
						.Builder()
						.correlationId(delivery.getProperties().getCorrelationId())
						.build();

				String response = "";

				try {
					String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
					int n = Integer.parseInt(message);

					System.out.println(" [.] fib(" + message + ")");
					response += fib(n);
				} catch (RuntimeException e) {
					System.out.println(" [.] " + e.toString());
				} finally {
					channel.basicPublish("", delivery.getProperties().getReplyTo(), replyProps, response.getBytes(StandardCharsets.UTF_8));
					channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
					// RabbitMq consumer worker thread notifies the RPC server owner thread
					synchronized (monitor) {
						monitor.notify();
					}
				}
			};

			channel.basicConsume(QUEUE_NAME, false, deliverCallback, (consumerTag -> { }));
			// Wait and be prepared to consume the message from RPC client.
			while (true) {
				synchronized (monitor) {
					try {
						monitor.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}