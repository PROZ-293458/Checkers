package com.kaczmii.game.checkers.model;

import static com.kaczmii.game.checkers.model.Piece.Type.*;

import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class Piece 
{
	int x;
	int y;
	public enum Type {MAN, KING};
	public enum Color {WHITE, RED};
	Color color;
	Type type;
	boolean isActive;
	
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
	
	public boolean isActive()
	{
		return isActive;
	}
	
	public boolean setActive( boolean bool )
	{
		isActive = bool;
		return bool;
	}
	
	public void movePiece ( int[] pieceCoordinates, int[] coordinates, ImageView[][] imageViewsFields, ImageView[][] imageViewsPieces, Field[][] fields, Piece[][] pieces, GridPane gridPane )
	{
		gridPane.getChildren().remove(imageViewsPieces[pieceCoordinates[0]][pieceCoordinates[1]]);
		gridPane.add(imageViewsPieces[pieceCoordinates[0]][pieceCoordinates[1]], coordinates[0], coordinates[1]);
		imageViewsPieces[coordinates[0]][coordinates[1]] = imageViewsPieces[pieceCoordinates[0]][pieceCoordinates[1]];
		imageViewsPieces[pieceCoordinates[0]][pieceCoordinates[1]] = null;
		pieces[coordinates[0]][coordinates[1]] = pieces[pieceCoordinates[0]][pieceCoordinates[1]];
		pieces[pieceCoordinates[0]][pieceCoordinates[1]] = null;
		Field.imageChangeBlack(imageViewsFields, fields);
		fields[pieceCoordinates[0]][pieceCoordinates[1]].setPiece(null);
		fields[coordinates[0]][coordinates[1]].setPiece(this);
		Move(coordinates[0], coordinates[1]);
		setActive(false);
		
	}
}
