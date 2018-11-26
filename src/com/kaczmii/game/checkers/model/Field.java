package com.kaczmii.game.checkers.model;

import com.kaczmii.game.checkers.model.Piece;

public class Field 
{
	int x;
	int y;
	boolean isPiece;
	boolean isActive;
	enum Type {NORMAL, END};
	Type type;
	Piece piece;
	
	Field(int x,int y, boolean isPiece, Type type)
	{
		this.x = x;
		this.y = y;
		this.isPiece = isPiece;
		this.type = type;
		if ( isPiece )
		{
			isActive = false;
		}
		else
		{
			isActive = true;
		}
	}
	Piece setPiece (Piece piece)
	{
		this.piece = piece;
		return piece;
	}
}
