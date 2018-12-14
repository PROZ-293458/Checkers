package com.kaczmii.game.checkers.model;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import com.kaczmii.game.checkers.controller.BoardController;
import com.kaczmii.game.checkers.model.Piece.Color;

import javafx.application.Platform;

public class AsynchConsumer implements MessageListener 
{
	private Color player;
	private BoardController boardController;
	
	public void setPlayer( Color player )
	{
		this.player = player;
	}
	
	public void setController( BoardController controller )
	{
		boardController = controller;
	}
	@Override
	public void onMessage(Message message) 
	{
		if (message instanceof TextMessage)
		{
			try 
			{
				int playerValue;
				int[] fieldCoordinates = new int[2];
				int[] pieceCoordinates = new int[2];
				char[] parameters = ((TextMessage) message).getText().toCharArray();
				String temporary = new String(((TextMessage) message).getText());
				System.out.printf("Odebrano wiadomoœæ:'%s'%n", ((TextMessage) message).getText());
				if ( temporary.length() == 5 )
				{
					playerValue = Integer.parseInt(Character.toString(parameters[0]));
					fieldCoordinates[0] = Integer.parseInt(Character.toString(parameters[1]));
					fieldCoordinates[1] = Integer.parseInt(Character.toString(parameters[2]));
					pieceCoordinates[0] = Integer.parseInt(Character.toString(parameters[3]));
					pieceCoordinates[1] = Integer.parseInt(Character.toString(parameters[4]));
					System.out.println(Integer.parseInt(Character.toString(parameters[0])));
					System.out.println(Integer.parseInt(Character.toString(parameters[1])));
					System.out.println(Integer.parseInt(Character.toString(parameters[2])));
					System.out.println(Integer.parseInt(Character.toString(parameters[3])));
					System.out.println(Integer.parseInt(Character.toString(parameters[4])));
					if ( playerValue == 1 && player == Piece.Color.WHITE )
					{
						Platform.runLater( () ->
						{
							boardController.MessageMove( fieldCoordinates, pieceCoordinates);
						});
					}
					if ( playerValue == 0 && player == Piece.Color.RED )
					{
						Platform.runLater( () ->
						{
							boardController.MessageMove( fieldCoordinates, pieceCoordinates);
						});
					}
				}
			}
			catch (JMSException e) 
			{
				e.printStackTrace();
			}
		}
	}
}