package com.kaczmii.game.checkers.model;

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class Search 
{
	static public int[] findField(ImageView[][] imageViewsFields, Field[][] fields, MouseEvent event)
	{
		int[] result;
		result = new int[2];
		for ( int i = 0 ; i < 8 ; i++ )
		{
			for ( int j = 0 ; j < 8 ; j++ )
			{
				 if ( event.getSource() == imageViewsFields[i][j] )
				 {
					 result[0] = fields[i][j].getXcoordinate();
					 result[1] = fields[i][j].getYcoordinate();
				 }
			}
		}
		return result;
	}
	
	static public int[] findPiece(ImageView[][] imageViewsPieces, Piece[][] pieces, MouseEvent event)
	{
		int[] result;
		result = new int[2];
		for ( int i = 0 ; i < 8 ; i++ )
		{
			for ( int j = 0 ; j < 8 ; j++ )
			{
				 if ( event.getSource() == imageViewsPieces[i][j] )
				 {
					 System.out.println("Liczby to " +  i + " " + j);
					 
					 result[0] = pieces[i][j].getX();
					 result[1] = pieces[i][j].getY();
				 }
			}
		}
		return result;
	}
	
	static public int[][] indicateFields( int[] coordinates, Field[][] fields)
	{
		int[][] fieldscoordinates = new int[16][2];
		int x = coordinates[0];
		int y = coordinates[1];
		if ( fields[x][y].getPiece().getType() == Piece.Type.MAN )
		{
			if( fields[x][y].getPiece().getColor() == Piece.Color.WHITE)
			{
				if ( x+1 >= 0 && y+1 >= 0 && x+1 <= 7 && y+1 <=7)
				{
					if ( fields[x+1][y+1].isPiece() )
					{
						if ( fields[x+1][y+1].getPiece().getColor() == Piece.Color.RED )
						{
							if ( x+2 >= 0 && y+2 >= 0 && x+2 <= 7 && y+2 <=7)
							{
								if ( fields[x+2][y+2].isPiece()  )
								{
									fieldscoordinates[0][0] = -1;
									fieldscoordinates[0][1] = -1;
								}
								else
								{
									fieldscoordinates[0][0] = x+2;
									fieldscoordinates[0][1] = y+2;
								}
							}
							else
							{
								fieldscoordinates[0][0] = -1;
								fieldscoordinates[0][1] = -1;
							}
						}
						else
						{
							fieldscoordinates[0][0] = -1;
							fieldscoordinates[0][1] = -1;
						}
					}
					else
					{
						fieldscoordinates[0][0] = x+1;
						fieldscoordinates[0][1] = y+1;
					}
				}
				else
				{
					fieldscoordinates[0][0] = -1;
					fieldscoordinates[0][1] = -1;
				}
				
				if ( x-1 >= 0 && y+1 >= 0 && x-1 <= 7 && y+1 <=7)
				{
					if ( fields[x-1][y+1].isPiece() )
					{
						if ( fields[x-1][y+1].getPiece().getColor() == Piece.Color.RED)
						{
							if ( x-2 >= 0 && y+2 >= 0 && x-2 <= 7 && y+2 <=7)
							{
								if ( fields[x-2][y+2].isPiece())
								{
									fieldscoordinates[1][0] = -1;
									fieldscoordinates[1][1] = -1;
								}
								else
								{
									fieldscoordinates[1][0] = x-2;
									fieldscoordinates[1][1] = y+2;
								}
							}
							else
							{
								fieldscoordinates[1][0] = -1;
								fieldscoordinates[1][1] = -1;
							}
						}
						else
						{
							fieldscoordinates[1][0] = -1;
							fieldscoordinates[1][1] = -1;
						}
					}
					else
					{
						fieldscoordinates[1][0] = x-1;
						fieldscoordinates[1][1] = y+1;
					}
				}
				else
				{
					fieldscoordinates[1][0] = -1;
					fieldscoordinates[1][1] = -1;
				}
			}
			else
			{
				if ( x+1 >= 0 && y-1 >= 0 && x+1 <= 7 && y-1 <=7)
				{
					if ( fields[x+1][y-1].isPiece() )
					{
						if ( fields[x+1][y-1].getPiece().getColor() == Piece.Color.WHITE)
						{
							if ( x+2 >= 0 && y-2 >= 0 && x+2 <= 7 && y-2 <=7)
							{
								if ( fields[x+2][y-2].isPiece())
								{
									fieldscoordinates[0][0] = -1;
									fieldscoordinates[0][1] = -1;
								}
								else
								{
									fieldscoordinates[0][0] = x+2;
									fieldscoordinates[0][1] = y-2;
								}
							}
							else
							{
								fieldscoordinates[0][0] = -1;
								fieldscoordinates[0][1] = -1;
							}
						}
						else
						{
							fieldscoordinates[0][0] = -1;
							fieldscoordinates[0][1] = -1;
						}
						
					}
					else
					{
						fieldscoordinates[0][0] = x+1;
						fieldscoordinates[0][1] = y-1;
					}
				}
				else
				{
					fieldscoordinates[0][0] = -1;
					fieldscoordinates[0][1] = -1;
				}
				
				if ( x-1 >= 0 && y-1 >= 0 && x-1 <= 7 && y-1 <=7)
				{
					if ( fields[x-1][y-1].isPiece() )
					{
						if ( fields[x-1][y-1].getPiece().getColor() == Piece.Color.WHITE)
						{
							if ( x-2 >= 0 && y-2 >= 0 && x-2 <= 7 && y-2 <=7)
							{
								if ( fields[x-2][y-2].isPiece())
								{
									fieldscoordinates[1][0] = -1;
									fieldscoordinates[1][1] = -1;
								}
								else
								{
									fieldscoordinates[1][0] = x-2;
									fieldscoordinates[1][1] = y-2;
								}
							}
							else
							{
								fieldscoordinates[1][0] = -1;
								fieldscoordinates[1][1] = -1;
							}
						}
						else
						{
							fieldscoordinates[1][0] = -1;
							fieldscoordinates[1][1] = -1;
						}
						
					}
					else
					{
						fieldscoordinates[1][0] = x-1;
						fieldscoordinates[1][1] = y-1;
					}
				}
				else
				{
					fieldscoordinates[1][0] = -1;
					fieldscoordinates[1][1] = -1;
				}
			}
			for ( int i = 2 ; i < 16 ; i++ )
			{
				for ( int j = 0 ; j < 2 ; j++ )
				{
					fieldscoordinates[i][j] = -1;
				}
			}
		}
		else
		{
			int counter = 0;
			for ( int i = x-4, j = y-4 ; i < x+4 ; i++, j++ )
			{
				if ( i == x && j == y)
					continue;
				if ( i >= 0 && i <= 7 && j >= 0 && j <= 7)
				{
					if ( fields[i][j].isPiece() )
					{
						fieldscoordinates[counter][0] = i;
						fieldscoordinates[counter][1] = j;
						counter++;
					}
					else
					{
						fieldscoordinates[counter][0] = -1;
						fieldscoordinates[counter][1] = -1;
						counter++;
					}
				}
				else
				{
					fieldscoordinates[counter][0] = -1;
					fieldscoordinates[counter][1] = -1;
					counter++;
				}
			}
			for ( int i = x+4, j = y-4 ; i < x-4 ; i--, j++ )
			{
				if ( i == x && j == y)
					continue;
				if ( i >= 0 && i <= 7 && j >= 0 && j <= 7 )
				{
					if ( fields[i][j].isPiece() )
					{
						fieldscoordinates[counter][0] = i;
						fieldscoordinates[counter][1] = j;
						counter++;
					}
					else
					{
						fieldscoordinates[counter][0] = -1;
						fieldscoordinates[counter][1] = -1;
						counter++;
					}
				}
				else
				{
					fieldscoordinates[counter][0] = -1;
					fieldscoordinates[counter][1] = -1;
					counter++;
				}
			}
		}

		return fieldscoordinates;
	}
	
	static public void setEverythingFalse ( Piece[][] pieces, Field[][] fields, ImageView[][] imageViewsFields )
	{
		for ( int i = 0 ; i < 8 ; i++ )
		{
			for ( int j = 0 ; j < 8 ; j++ )
			{
				if ( pieces[i][j] != null )
				{
					pieces[i][j].setActive(false);
				}
				if ( fields[i][j] != null )
				{
					fields[i][j].setActive(false);
				}
			}
		}
		Field.imageChangeBlack(imageViewsFields, fields);
	}
	
	static public int[] findActivePiece ( Piece[][] pieces )
	{
		int[] coordinates = new int[2];
		boolean flag = false;
		for ( int i = 0 ; i < 8 ; i++ )
		{
			for ( int j = 0 ; j < 8 ; j++ )
			{
				if (pieces[i][j] != null)
				{
					if ( pieces[i][j].isActive() )
					{
						coordinates[0] = pieces[i][j].getX();
						coordinates[1] = pieces[i][j].getY();
						flag = true;
					}
				}
			}
		}
		if ( !flag )
		{
			coordinates[0] = coordinates[1] = -1;
		}
		return coordinates;
	}
}
