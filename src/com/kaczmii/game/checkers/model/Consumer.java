package com.kaczmii.game.checkers.model;

import javax.jms.ConnectionFactory;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.TextMessage;

import com.kaczmii.game.checkers.controller.BoardController;
import com.kaczmii.game.checkers.model.Piece.Color;

public class Consumer 
{
	private JMSContext jmsContext;
	private JMSConsumer jmsConsumer;
	private Queue queue;
	private Color player;
	private BoardController controller;

	public Consumer(String url, String queueName, Color player, BoardController controller) throws JMSException 
	{
		ConnectionFactory connectionFactory = new com.sun.messaging.ConnectionFactory();
		jmsContext = connectionFactory.createContext();
		// 7676 numer portu, na którym JMS Service nas³uchuje po³¹czeñ
		// [hostName][:portNumber][/serviceName] np. "localhost:7676/jms"
		((com.sun.messaging.ConnectionFactory)connectionFactory).setProperty(com.sun.messaging.ConnectionConfiguration.imqAddressList, url);
		
		if ( player == Piece.Color.RED)
		{
			queue = new com.sun.messaging.Queue("QueueRed");
		}
		else
			queue = new com.sun.messaging.Queue("QueueWhite");
		jmsConsumer = jmsContext.createConsumer(queue);
		this.player = player;
		this.controller = controller;
	}
	public String receiveQueueMessage() throws JMSException 
	{
		Message msg = jmsConsumer.receive(10); // 10 ms
		if (msg instanceof TextMessage)
			return ((TextMessage) msg).getText();
		return null;
	}
	protected void finalize() 
	{
		if (jmsConsumer!= null)
			jmsConsumer.close();
		if (jmsContext != null)
			jmsContext.close();
	}
	public void receiveQueueMessageAsync() throws InterruptedException 
	{
		AsynchConsumer aconsumer = new AsynchConsumer();
		aconsumer.setPlayer( player );
		aconsumer.setController(controller);
		jmsConsumer.setMessageListener(aconsumer);
	}
}