package com.kaczmii.game.checkers.model;

public class Initialize 
{
	static private Piece[][] pieces;
	static private Field[][] fields;

	public static Piece[][] initPieces()
	{
		pieces = new Piece[8][8];
    	for ( int i = 0 ; i < 8 ; i++ )
    	{
    		for (int j = 0 ; j < 8 ; j++)
    		{
    			if ( j <= 2 )
    			{
    				if ( j % 2 == 0 )
    				{
    					if ( i % 2 == 1)
    					{
    						pieces[i][j] = new Piece(i, j, Piece.Color.WHITE);
    					}
    					else
    					{
    						pieces[i][j] = null;
    					}
    				}
    				else
    				{
    					if ( i % 2 == 1)
    					{
    						pieces[i][j] = null;
    					}
    					else
    					{
    						pieces[i][j] = new Piece(i, j, Piece.Color.WHITE);
    					}
    				}
    			}
    			else if(j >= 5)
    			{
    				if ( j % 2 == 1)
    				{
    					if ( i % 2 == 0)
    					{
    						pieces[i][j] = new Piece(i, j, Piece.Color.RED);
    					}
    					else
    					{
    						pieces[i][j] = null;
    					}
    				}
    				else
    				{
    					if ( i % 2 == 0)
    					{
    						pieces[i][j] = null;
    					}
    					else
    					{
    						pieces[i][j] = new Piece(i, j, Piece.Color.RED);
    					}
    				}
    			}
    			else
    			{
    				pieces[i][j] = null;
    			}
    		}
    	}
		return pieces;
	}
	
	static public Field[][] initFields()
	{
		fields = new Field[8][8];
		for ( int i = 0 ; i < 8 ; i++ )
		{
			for ( int j = 0 ; j < 8 ; j++ )
			{
				if ( j % 2 == 0)
				{
					// rows: 0 2 4 6 
					if ( i % 2 == 1 )
					{
						// columns: 1 3 5 7
						if ( j <= 2 )
						{
							// row 0 and 2
							if ( j == 0)
							{
								// row 0
								fields[i][j] = new Field(i, j, true, Field.Type.END, pieces[i][j] );
							}
							else
							{
								// row 2
								fields[i][j] = new Field(i, j, true, Field.Type.NORMAL, pieces[i][j] );
							}
							
						}
						else if ( j >= 5 )
						{
							// row 6
							fields[i][j] = new Field(i, j, true, Field.Type.NORMAL, pieces[i][j] );
						}
						else
						{
							// row 4
							fields[i][j] = new Field(i, j, false, Field.Type.NORMAL, null);
						}
					}
				}
				else
				{
					// rows: 1 3 5 7
					if ( i % 2 == 0 )
					{
						// columns: 0 2 4 6
						if ( j <= 2 )
						{
							// row 1
							fields[i][j] = new Field(i, j, true, Field.Type.NORMAL, pieces[i][j] );
						}
						else if ( j >= 5 )
						{
							// row 5 and 7
							if ( j == 5 )
							{
								// row 5
								fields[i][j] = new Field(i, j, true, Field.Type.NORMAL, pieces[i][j] );
							}
							else
							{
								//row 7
								fields[i][j] = new Field(i, j, true, Field.Type.END, pieces[i][j] );
							}
						}
						else
						{
							// row 3
							fields[i][j] = new Field(i, j, false, Field.Type.NORMAL, null);
						}
					}
				}
			}
		}
		return fields;
	}
}
