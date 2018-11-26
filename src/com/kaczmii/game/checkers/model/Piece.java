package com.kaczmii.game.checkers.model;

import static com.kaczmii.game.checkers.model.Piece.Color.*;
import static com.kaczmii.game.checkers.model.Piece.Type.*;

public class Piece 
{
	int x;
	int y;
	enum Type {MAN, KING};
	enum Color {WHITE, BLACK};
	Color color;
	Type type;
	
	Piece(int x, int y, Color color)
	{
		this.x = x;
		this.y = y;
		this.color = color;
		type = MAN;
	}
	
	void Move ( int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	Type setKing()
	{
		type = KING;
		return type;
	}
	
	
	int getX()
	{
		return x;
	}
	
	int getY()
	{
		return y;
	}
	
	Color getColor()
	{
		return color;
	}
	
	Type getType()
	{
		return type;
	}
	
}
