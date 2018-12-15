package com.kaczmii.game.checkers.model;

import static com.kaczmii.game.checkers.model.Piece.Type.*;

import javafx.scene.image.Image;
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
	}
	
	public Type setKing(ImageView[][] imageViewsPieces)
	{
		if ( color == Piece.Color.WHITE )
		{
			imageViewsPieces[this.getX()][this.getY()].setImage(new Image("/WhiteKing.png", true));
		}
		else
		{
			imageViewsPieces[this.getX()][this.getY()].setImage(new Image("/RedKing.png", true));
		}
		
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
		if ( Math.abs(pieceCoordinates[0] - coordinates[0]) == 2 )
		{
			int[] hitCoordinates = new int[2];
			if ( pieceCoordinates[0] > coordinates[0] )
			{
				hitCoordinates[0] = coordinates[0] + 1;
			}
			else
			{
				hitCoordinates[0] = coordinates[0] - 1;
			}
			if ( pieceCoordinates[1] > coordinates[1] )
			{
				hitCoordinates[1] = coordinates[1] + 1;
			}
			else
			{
				hitCoordinates[1] = coordinates[1] - 1;
			}
			fields[hitCoordinates[0]][hitCoordinates[1]].setPiece(null);
			pieces[hitCoordinates[0]][hitCoordinates[1]] = null;
			gridPane.getChildren().remove(imageViewsPieces[hitCoordinates[0]][hitCoordinates[1]]);
		}
		Field.imageChangeBlack(imageViewsFields, fields);
		fields[pieceCoordinates[0]][pieceCoordinates[1]].setPiece(null);
		fields[coordinates[0]][coordinates[1]].setPiece(this);
		Move(coordinates[0], coordinates[1]);
		if ( (coordinates[1] == 7 || coordinates[1] == 0 ) && pieces[coordinates[0]][coordinates[1]].getType() == Piece.Type.MAN )
		{
			pieces[coordinates[0]][coordinates[1]].setKing(imageViewsPieces);
		}
		setActive(false);
	}
	public void moveKing  ( int[] pieceCoordinates, int[] coordinates, ImageView[][] imageViewsFields, ImageView[][] imageViewsPieces, Field[][] fields, Piece[][] pieces, GridPane gridPane )
	{
		int counter = 0;
		gridPane.getChildren().remove(imageViewsPieces[pieceCoordinates[0]][pieceCoordinates[1]]);
		gridPane.add(imageViewsPieces[pieceCoordinates[0]][pieceCoordinates[1]], coordinates[0], coordinates[1]);
		imageViewsPieces[coordinates[0]][coordinates[1]] = imageViewsPieces[pieceCoordinates[0]][pieceCoordinates[1]];
		imageViewsPieces[pieceCoordinates[0]][pieceCoordinates[1]] = null;
		pieces[coordinates[0]][coordinates[1]] = pieces[pieceCoordinates[0]][pieceCoordinates[1]];
		pieces[pieceCoordinates[0]][pieceCoordinates[1]] = null;
		// bice
		if ( Math.abs(pieceCoordinates[0] - coordinates[0]) > 1 )
		{
			int[][] hitCoordinates = new int[5][2];
			if ( pieceCoordinates[0] > coordinates[0] && pieceCoordinates[1] > coordinates[1] )
			{
				for ( int i = coordinates[0]+1, j = coordinates[1]+1; i < pieceCoordinates[0] ; i++, j++ )
				{
					hitCoordinates[counter][0] = i;
					hitCoordinates[counter][1] = j;
					counter++;
				}
			}
			if ( pieceCoordinates[0] < coordinates[0] && pieceCoordinates[1] > coordinates[1] )
			{
				for ( int i = coordinates[0]-1, j = coordinates[1]+1; i > pieceCoordinates[0] ; i--, j++ )
				{
					hitCoordinates[counter][0] = i;
					hitCoordinates[counter][1] = j;
					counter++;
				}
			}
			if ( pieceCoordinates[0] < coordinates[0] && pieceCoordinates[1] < coordinates[1] )
			{
				for ( int i = coordinates[0]-1, j = coordinates[1]-1; i > pieceCoordinates[0] ; i--, j-- )
				{
					hitCoordinates[counter][0] = i;
					hitCoordinates[counter][1] = j;
					counter++;
				}
			}
			if ( pieceCoordinates[0] > coordinates[0] && pieceCoordinates[1] < coordinates[1] )
			{
				for ( int i = coordinates[0]+1, j = coordinates[1]-1; i < pieceCoordinates[0] ; i++, j-- )
				{
					hitCoordinates[counter][0] = i;
					hitCoordinates[counter][1] = j;
					counter++;
				}
			}
			for ( int i = 0 ;  i < counter ; i++ )
			{
				System.out.println(hitCoordinates[i][0]);
				System.out.println(hitCoordinates[i][1]);
				if ( fields[hitCoordinates[i][0]][hitCoordinates[i][1]].isPiece() )
				{
					fields[hitCoordinates[i][0]][hitCoordinates[i][1]].setPiece(null);
					pieces[hitCoordinates[i][0]][hitCoordinates[i][1]] = null;
					gridPane.getChildren().remove(imageViewsPieces[hitCoordinates[i][0]][hitCoordinates[i][1]]);
				}
			}
		}
		Field.imageChangeBlack(imageViewsFields, fields);
		fields[pieceCoordinates[0]][pieceCoordinates[1]].setPiece(null);
		fields[coordinates[0]][coordinates[1]].setPiece(this);
		Move(coordinates[0], coordinates[1]);
		setActive(false);
	}
}
