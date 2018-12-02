package com.kaczmii.game.checkers.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import com.kaczmii.game.checkers.model.Field;
import com.kaczmii.game.checkers.model.Initialize;
import com.kaczmii.game.checkers.model.Piece;
import com.kaczmii.game.checkers.model.Search;

public class BoardController {

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
    
    
    private Piece[][] pieces;
    
    private Field[][] fields;
    
    private ImageView[][] imageViews;
    
    private void initializeImageViews()
    {
    	imageViews = new ImageView[8][8];
    	//white
    	//row 0
    	imageViews[1][0] = white10;
    	imageViews[3][0] = white30;
    	imageViews[5][0] = white50;
    	imageViews[7][0] = white70;
    	//row 1
    	imageViews[0][1] = white01;
    	imageViews[2][1] = white21;
    	imageViews[4][1] = white41;
    	imageViews[6][1] = white61;
    	//row 2
    	imageViews[1][2] = white12;
    	imageViews[3][2] = white32;
    	imageViews[5][2] = white52;
    	imageViews[7][2] = white72;
    	//red
    	//row 5
    	imageViews[0][5] = red05;
    	imageViews[2][5] = red25;
    	imageViews[4][5] = red45;
    	imageViews[6][5] = red65;
    	//row 6
    	imageViews[1][6] = red16;
    	imageViews[3][6] = red36;
    	imageViews[5][6] = red56;
    	imageViews[7][6] = red76;
    	//row 7
    	imageViews[0][7] = red07;
    	imageViews[2][7] = red27;
    	imageViews[4][7] = red47;
    	imageViews[6][7] = red67;
    }
    
    public void init()
    {
    	initializeImageViews(); 
    	pieces = Initialize.initPieces();
    	fields = Initialize.initFields();
    }
    
    @FXML
    void FieldClicked(MouseEvent event) 
    {
    	int[] coordinates;
    	coordinates = Search.findField(fields, event);
    	System.out.println("Coordinates are ");
    	System.out.println( coordinates[0]);
    	System.out.println("and");
    	System.out.println(coordinates[1]);
    	
    }

    @FXML
    void PieceClicked(MouseEvent event) 
    {
    	
    }

}
