package com.kaczmii.game.checkers.model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Field
{
	int x;
	int y;
	boolean isPiece;
	boolean isActive;
	public enum Type {NORMAL, END};
	Type type;
	Piece piece;
	static Image black;
	static Image orange;
	
	public Field()
	{
		
	}
	
	public Field(int x,int y, boolean isPiece, Type type, Piece piece)
	{
		this.x = x;
		this.y = y;
		this.isPiece = isPiece;
		this.type = type;
		if ( isPiece )
		{
			this.piece = piece;
		}
		else
			this.piece = null;
		isActive = false;
		black = new Image("/Solid_black.png", true);
		orange = new Image("/Orange.png", true);
	}
	
	public Field( Field field)
	{
		this(field.getXcoordinate(), field.getYcoordinate(), field.isPiece(), field.getType(), field.getPiece());
	}
	
	public Piece setPiece (Piece piece)
	{
		this.piece = piece;
		return piece;
	}
	
	public int getXcoordinate()
	{
		return x;
	}
	
	public int getYcoordinate()
	{
		return y;
	}
	
	public boolean isPiece()
	{
		return isPiece;
	}
	
	public boolean isActive()
	{
		return isActive;
	}
	
	public Type getType()
	{
		return type;
	}
	
	public Piece getPiece()
	{
		return piece;
	}
	public boolean setActive(boolean bool)
	{
		isActive = bool;
		return bool;
	}
	
	public static void imageChangeOrange( int[][] fieldscoordinates, ImageView[][] imageViewsFields, Field[][] fields)
	{
		for ( int i = 0 ; i < 2; i++ )
		{
			int x = fieldscoordinates[i][0];
			int y = fieldscoordinates[i][1];
			if ( x < 0 || y < 0)
				continue;
			fields[x][y].setActive(true);
			imageViewsFields[x][y].setImage(orange);
		}
	}
	
	public static void imageChangeBlack ( ImageView[][] imageViewsFields, Field[][] fields )
	{
		for ( int i = 0 ; i < 8 ; i++ )
		{
			for ( int j = 0 ; j < 8 ; j++ )
			{
				if ( fields[i][j] != null )
				{
					if ( fields[i][j].isActive() )
					{
						imageViewsFields[i][j].setImage(black);
						fields[i][j].setActive(false);
					}
				}
			}
		}
	}
	
}
