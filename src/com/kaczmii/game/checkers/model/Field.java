package com.kaczmii.game.checkers.model;

import com.kaczmii.game.checkers.model.Piece;

import javafx.scene.image.ImageView;

public class Field
{
	int x;
	int y;
	boolean isPiece;
	boolean isActive;
	enum Type {NORMAL, END};
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
		this(field.getX(), field.getY(), field.getIsPiece(), field.getType(), field.getPiece());
	}
	
	public Piece setPiece (Piece piece)
	{
		this.piece = piece;
		return piece;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public boolean getIsPiece()
	{
		return isPiece;
	}
	
	public boolean getIsActive()
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
