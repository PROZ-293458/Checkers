package com.kaczmii.game.checkers.controller;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import com.kaczmii.game.checkers.model.Consumer;
import com.kaczmii.game.checkers.model.Field;
import com.kaczmii.game.checkers.model.Initialize;
import com.kaczmii.game.checkers.model.Piece;
import com.kaczmii.game.checkers.model.Piece.Color;
import com.kaczmii.game.checkers.model.Producer;
import com.kaczmii.game.checkers.model.Search;
import com.sun.messaging.jms.JMSException;

public class BoardController 
{
    @FXML
    private GridPane gridPane;

    @FXML
    private ImageView white41;

    @FXML
    private ImageView white01;

    @FXML
    private ImageView white21;

    @FXML
    private ImageView white61;

    @FXML
    private ImageView white70;

    @FXML
    private ImageView white52;

    @FXML
    private ImageView white32;

    @FXML
    private ImageView white12;

    @FXML
    private ImageView white72;

    @FXML
    private ImageView red05;

    @FXML
    private ImageView red67;

    @FXML
    private ImageView red47;

    @FXML
    private ImageView red27;

    @FXML
    private ImageView red07;

    @FXML
    private ImageView red76;

    @FXML
    private ImageView red56;

    @FXML
    private ImageView red36;

    @FXML
    private ImageView red16;

    @FXML
    private ImageView red65;

    @FXML
    private ImageView red45;

    @FXML
    private ImageView red25;

    @FXML
    private ImageView white10;

    @FXML
    private ImageView white30;

    @FXML
    private ImageView white50;
    
    @FXML
    private ImageView field10;

    @FXML
    private ImageView field30;

    @FXML
    private ImageView field50;

    @FXML
    private ImageView field01;

    @FXML
    private ImageView field72;

    @FXML
    private ImageView field52;

    @FXML
    private ImageView field32;

    @FXML
    private ImageView field12;

    @FXML
    private ImageView field70;

    @FXML
    private ImageView field61;

    @FXML
    private ImageView field41;

    @FXML
    private ImageView field21;

    @FXML
    private ImageView field05;

    @FXML
    private ImageView field74;

    @FXML
    private ImageView field54;

    @FXML
    private ImageView field34;

    @FXML
    private ImageView field14;

    @FXML
    private ImageView field63;

    @FXML
    private ImageView field43;

    @FXML
    private ImageView field23;

    @FXML
    private ImageView field03;

    @FXML
    private ImageView field76;

    @FXML
    private ImageView field56;

    @FXML
    private ImageView field36;

    @FXML
    private ImageView field16;

    @FXML
    private ImageView field65;

    @FXML
    private ImageView field45;

    @FXML
    private ImageView field25;

    @FXML
    private ImageView field67;

    @FXML
    private ImageView field47;

    @FXML
    private ImageView field27;

    @FXML
    private ImageView field07;

    
    private Piece[][] pieces;
    
    private Field[][] fields;
    
    private ImageView[][] imageViewsPieces;
    
    private ImageView[][] imageViewsFields;
    
    private Producer producer;
    
    private Consumer consumer;
    
    public Color player;
    
    private boolean flag; // flaga czy moze wykonac ruch
    
    private void initializeImageViews()
    {
    	
    	imageViewsPieces = new ImageView[8][8];
    	imageViewsFields = new ImageView[8][8];
    	//white
    	//row 0
    	imageViewsPieces[1][0] = white10;
    	imageViewsPieces[3][0] = white30;
    	imageViewsPieces[5][0] = white50;
    	imageViewsPieces[7][0] = white70;
    	
    	imageViewsFields[1][0] = field10;
    	imageViewsFields[3][0] = field30;
    	imageViewsFields[5][0] = field50;
    	imageViewsFields[7][0] = field70;
    	//row 1
    	imageViewsPieces[0][1] = white01;
    	imageViewsPieces[2][1] = white21;
    	imageViewsPieces[4][1] = white41;
    	imageViewsPieces[6][1] = white61;
    	
    	imageViewsFields[0][1] = field01;
    	imageViewsFields[2][1] = field21;
    	imageViewsFields[4][1] = field41;
    	imageViewsFields[6][1] = field61;
    	//row 2
    	imageViewsPieces[1][2] = white12;
    	imageViewsPieces[3][2] = white32;
    	imageViewsPieces[5][2] = white52;
    	imageViewsPieces[7][2] = white72;
    	
    	imageViewsFields[1][2] = field12;
    	imageViewsFields[3][2] = field32;
    	imageViewsFields[5][2] = field52;
    	imageViewsFields[7][2] = field72;
    	//row 3
    	imageViewsFields[0][3] = field03;
    	imageViewsFields[2][3] = field23;
    	imageViewsFields[4][3] = field43;
    	imageViewsFields[6][3] = field63;
    	//row 4
    	imageViewsFields[1][4] = field14;
    	imageViewsFields[3][4] = field34;
    	imageViewsFields[5][4] = field54;
    	imageViewsFields[7][4] = field74;
    	//red
    	//row 5
    	imageViewsPieces[0][5] = red05;
    	imageViewsPieces[2][5] = red25;
    	imageViewsPieces[4][5] = red45;
    	imageViewsPieces[6][5] = red65;
    	
    	imageViewsFields[0][5] = field05;
    	imageViewsFields[2][5] = field25;
    	imageViewsFields[4][5] = field45;
    	imageViewsFields[6][5] = field65;
    	//row 6
    	imageViewsPieces[1][6] = red16;
    	imageViewsPieces[3][6] = red36;
    	imageViewsPieces[5][6] = red56;
    	imageViewsPieces[7][6] = red76;
    	
    	imageViewsFields[1][6] = field16;
    	imageViewsFields[3][6] = field36;
    	imageViewsFields[5][6] = field56;
    	imageViewsFields[7][6] = field76;
    	//row 7
    	imageViewsPieces[0][7] = red07;
    	imageViewsPieces[2][7] = red27;
    	imageViewsPieces[4][7] = red47;
    	imageViewsPieces[6][7] = red67;
    	
    	imageViewsFields[0][7] = field07;
    	imageViewsFields[2][7] = field27;
    	imageViewsFields[4][7] = field47;
    	imageViewsFields[6][7] = field67;
    }
    
    public void init() throws javax.jms.JMSException,InterruptedException
    {
    	initializeImageViews(); 
    	pieces = Initialize.initPieces();
    	fields = Initialize.initFields();
    	try
    	{
    		producer = new Producer("localhost:4848/jms", "producer");
        	consumer = new Consumer("localhost:4848/jms", "consumer", player, this);
        	consumer.receiveQueueMessageAsync();
    	}
    	catch ( JMSException e)
    	{
    		
    	}
    	
    }
    
   public void setPlayer( Color player )
   {
	   this.player = player;
   }
    
    @FXML
    void FieldClicked(MouseEvent event) throws InterruptedException
    {
    	int[] coordinates;
    	int[] pieceCoordinates;
    	coordinates = Search.findField(imageViewsFields, fields, event);
    	pieceCoordinates = Search.findActivePiece(pieces);
    	if ( pieceCoordinates[0] != -1 && fields[coordinates[0]][coordinates[1]].isActive() )
    	{
    		if ( pieces[pieceCoordinates[0]][pieceCoordinates[1]].getType() == Piece.Type.MAN)
    		{
    			pieces[pieceCoordinates[0]][pieceCoordinates[1]].movePiece(pieceCoordinates, coordinates, imageViewsFields, imageViewsPieces, fields, pieces, gridPane);
    		}
    		else
    		{
    			pieces[pieceCoordinates[0]][pieceCoordinates[1]].moveKing(pieceCoordinates, coordinates, imageViewsFields, imageViewsPieces, fields, pieces, gridPane);
    		}
    		producer.sendQueueMessage( producer.buildString(player, coordinates, pieceCoordinates) );
    		flag = true;
    	}
    	
    	
    }

    @FXML
    void PieceClicked(MouseEvent event) 
    {
    	int[] coordinates; // clicked field's coordinates
    	int[][] fieldscoordinates; // coordinates of fields, which can be used to move a piece
    	coordinates = Search.findPiece(imageViewsPieces, pieces, event); // znalezienie kliknietego pionka
    	// check if piece is the same color as player
    	if ( pieces[coordinates[0]][coordinates[1]].getColor() != player )
    	{
    		return;
    	}
    	if ( flag )
    	{
    		return;
    	}
    	if ( !pieces[coordinates[0]][coordinates[1]].isActive() )
    	{
    		// jesli jest aktywny to ustaw na pomaranczowe mozliwe do wyboru
    		Search.setEverythingFalse(pieces, fields, imageViewsFields);
    		fieldscoordinates = Search.indicateFields(coordinates, fields);
        	Field.imageChangeOrange(fieldscoordinates, imageViewsFields, fields);
        	pieces[coordinates[0]][coordinates[1]].setActive(true);
    	}
    	else
    	{
    		Field.imageChangeBlack(imageViewsFields, fields);
    		pieces[coordinates[0]][coordinates[1]].setActive(false);
    	}
    }
    
    public void MessageMove( int[] fieldsCoordinates, int[] pieceCoordinatesMessage)
    {
    	int[] coordinates = fieldsCoordinates;
    	int[] pieceCoordinates = pieceCoordinatesMessage;
    	if ( pieceCoordinates[0] != -1 && fields[coordinates[0]][coordinates[1]].isActive() )
    	{
    		if ( pieces[pieceCoordinates[0]][pieceCoordinates[1]].getType() == Piece.Type.MAN)
    		{
    			pieces[pieceCoordinates[0]][pieceCoordinates[1]].movePiece(pieceCoordinates, coordinates, imageViewsFields, imageViewsPieces, fields, pieces, gridPane);
    		}
    		else
    		{
    			pieces[pieceCoordinates[0]][pieceCoordinates[1]].moveKing(pieceCoordinates, coordinates, imageViewsFields, imageViewsPieces, fields, pieces, gridPane);
    		}
    		flag = false;
    	}
    }

}
