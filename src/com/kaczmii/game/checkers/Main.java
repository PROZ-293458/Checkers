package com.kaczmii.game.checkers;

import com.kaczmii.game.checkers.controller.BoardController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application
{

	public static void main(String args[] )
	{
		launch(args);
	}
	
	@Override
	public void init()
	{
		
	}
	
	@Override
	public void start(Stage arg0) throws Exception 
	{
		try
		{
			ViewLoader<GridPane, BoardController> viewLoader = new ViewLoader<GridPane, BoardController>("view/Board.fxml");
			GridPane gridpane = viewLoader.getLayout();
			BoardController boardController = viewLoader.getController();
			boardController.init();
			Scene scene = new Scene(gridpane);
			arg0.setScene(scene);
			arg0.setTitle("Calculator");
			arg0.show();
		}
		catch (Exception e) 
		{

	    e.printStackTrace();
		}
	}
	
	
}
