package com.kaczmii.game.checkers.model;

import javafx.scene.input.MouseEvent;

public class Search 
{
	static public int[] findField(Field[][] fields, MouseEvent event)
	{
		int[] result;
		result = new int[2];
		for ( int i = 0 ; i < 8 ; i++ )
		{
			for ( int j = 0 ; j < 8 ; j++ )
			{
				 if ( event.getSource() == fields[i][j] )
				 {
					 result[0] = i;
					 result[1] = j;
				 }
			}
		}
		return result;
	}
	
	static public int[] findPiece(Piece[][] pieces, MouseEvent event)
	{
		int[] result;
		result = new int[2];
		for ( int i = 0 ; i < 8 ; i++ )
		{
			for ( int j = 0 ; j < 8 ; j++ )
			{
				 if ( event.getSource() == pieces[i][j] )
				 {
					 result[0] = i;
					 result[1] = j;
				 }
			}
		}
		return result;
	}
}
