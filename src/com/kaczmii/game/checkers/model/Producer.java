package com.kaczmii.game.checkers.model;

import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.JMSProducer;
import javax.jms.Queue;

import com.kaczmii.game.checkers.model.Piece.Color;

public class Producer 
{
	private JMSContext jmsContext;
	private JMSProducer jmsProducer;
	private Queue queue;

	public Producer(String url, String queueName) throws JMSException 
	{
		ConnectionFactory connectionFactory = new com.sun.messaging.ConnectionFactory();
		// [hostName][:portNumber][/serviceName]
		// 7676 numer portu, na którym JMS Service nas³uchuje po³¹czeñ	
		// "localhost:7676/jms"
		jmsContext = connectionFactory.createContext();
		((com.sun.messaging.ConnectionFactory) connectionFactory).setProperty(com.sun.messaging.ConnectionConfiguration.imqAddressList, url);
		jmsProducer = jmsContext.createProducer();
		queue = new com.sun.messaging.Queue("ATJQueue"); // "ATJQueue"
	}

	public void sendQueueMessage(String msg) 
	{
		jmsProducer.send(queue, msg);
	}

	protected void finalize() 
	{
		if (jmsContext != null)
			jmsContext.close();
	}
	
	public String buildString (Color player, int[] fieldCoordinates, int[] pieceCoordinates)
	{
		String temporary = new String();
		String message = new String();
		if ( player == Piece.Color.WHITE )
			temporary = "0";
		else
			temporary = "1";
		message = temporary + Integer.toString(fieldCoordinates[0]) + Integer.toString(fieldCoordinates[1])
				+ Integer.toString(pieceCoordinates[0]) + Integer.toString(pieceCoordinates[1]);
		System.out.println(message);
		return message;
	}
}
