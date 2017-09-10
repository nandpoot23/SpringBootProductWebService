package com.biscuit.product.service.rest.config;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.biscuit.product.service.rest.dao.ProductDao;

/**
 * @author mlahariya
 * @version 1.0, March 2017
 */

@Configuration
@ConditionalOnProperty(name = "rabbitmq.enable", havingValue = "true")
public class RabbitConfiguration {

	private static final Logger LOG = LoggerFactory
			.getLogger(RabbitConfiguration.class);

	@Autowired
	private Environment env;

	/**
	 * Use the AmqpAdmin bean to create a queue for our service. Give the queue
	 * a unique name for each cloud service that starts
	 * 
	 * @param admin
	 * @return
	 */
	@Bean(name = "myqueue")
	public Queue myQueue(AmqpAdmin admin) {
		String id = UUID.randomUUID().toString();
		id = env.getProperty("rabbitmq.queue.prefix", "") + id;
		Map<String, Object> args = new HashMap<>();
		args.put("x-max-length", 10);

		return new Queue(id, false, true, true, args);
	}

	/**
	 * Create an exchange that is a FanoutExchange. This will publish messages
	 * to ALL queues bound to this exchange.
	 * 
	 * @return
	 */
	@Bean
	FanoutExchange exchange() {
		return new FanoutExchange(env.getProperty("rabbitmq.exchange.name"));
	}

	/**
	 * Bind our queue to the exchange. All services when they load up will
	 * create a unique queue to bind to our fanout and will all receive
	 * messages.
	 * 
	 * @param queue
	 * @param exchange
	 * @return
	 */
	@Bean(name = "mybinding")
	Binding binding(@Qualifier("myqueue") Queue queue, FanoutExchange exchange) {
		LOG.info("Binding queue [" + queue + "] to exchange [" + exchange + "]");
		return BindingBuilder.bind(queue).to(exchange);
	}

	/**
	 * Attach our cache clearing listener, using the queue we have created.
	 * 
	 * 
	 * @param queue
	 * @param connectionFactory
	 * @param messageListenerAdapter
	 * @return
	 */
	@Bean
	public SimpleMessageListenerContainer containeraaaaa(
			@Qualifier("myqueue") Queue queue,
			ConnectionFactory connectionFactory,
			MessageListenerAdapter messageListenerAdapter) {
		SimpleMessageListenerContainer cont = new SimpleMessageListenerContainer(
				connectionFactory);

		cont.addQueues(queue);
		cont.setMessageListener(messageListenerAdapter);
		return cont;
	}

	@Bean
	public MessageListenerAdapter messageListenerAdapter(
			CacheManager cacheManager, ProductDao productDao) {
		return new MessageListenerAdapter(new JmsMessageListener(cacheManager,
				productDao), "handleMessage");
	}
}
