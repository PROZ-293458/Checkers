package com.kaczmii.game.checkers.model;

import static com.kaczmii.game.checkers.model.Piece.Type.*;

public class Piece 
{
	int x;
	int y;
	public enum Type {MAN, KING};
	public enum Color {WHITE, BLACK};
	Color color;
	Type type;
	
	public Piece(int x, int y, Color color)
	{
		this.x = x;
		this.y = y;
		this.color = color;
		type = MAN;
	}
	
	public Piece(Piece piece)
	{
		this(piece.getX(), piece.getY(), piece.getColor());
	}
	
	public void Move(int x, int y)
	{
		this.x = x;
		this.y = y;
		if (type == MAN && y == 7)
			setKing();
	}
	
	public Type setKing()
	{
		type = KING;
		return type;
	}
	
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public Color getColor()
	{
		return color;
	}
	
	public Type getType()
	{
		return type;
	}
}
