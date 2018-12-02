package com.kaczmii.game.checkers.model;

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
		if ( isPiece )
		{
			isActive = false;
		}
		else
		{
			isActive = true;
		}
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
}
