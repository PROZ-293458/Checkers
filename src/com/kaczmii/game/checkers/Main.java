package com.kaczmii.game.checkers;

import java.util.List;

import com.kaczmii.game.checkers.controller.BoardController;
import com.kaczmii.game.checkers.model.Piece;
import com.kaczmii.game.checkers.model.Piece.Color;
import com.kaczmii.game.checkers.view.AlertBox;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application
{
	private static Color player;
	
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
			// ustawianie gracza w zaleznosci od argumnetu
			List<String> arguments = getParameters().getRaw();
			if ( arguments.size() != 1  )
			{
				AlertBox.show(AlertType.ERROR, "GRACZ", "Podano zle argumenty", "Wybierz gracza podajac w konsoli 1 - dla gracza czerwonego, 0 - dla gracza bialego", ButtonType.OK);
				return;
			}
			else if ( arguments.get(0).equals("0") )
				player = Piece.Color.WHITE;
			else if (arguments.get(0).equals("1") )
				player = Piece.Color.RED;
			else
			{
				AlertBox.show(AlertType.ERROR, "GRACZ", "èle wybrano gracza", "Wybierz gracza podajac w konsoli 1 - dla gracza czerwonego, 0 - dla gracza bialego", ButtonType.OK);
				return;
			}
				
			ViewLoader<GridPane, BoardController> viewLoader = new ViewLoader<GridPane, BoardController>("view/Board.fxml");
			GridPane gridPane = viewLoader.getLayout();
			BoardController boardController = viewLoader.getController();
			boardController.setPlayer( player );
			boardController.init();
			Scene scene = new Scene(gridPane);
			arg0.setScene(scene);
			arg0.setTitle("Checkers");
			arg0.show();
			if ( player == Piece.Color.RED )
				AlertBox.show(AlertType.INFORMATION, "GRACZ", "Gra gracz czerwony", "", ButtonType.OK);
			else
				AlertBox.show(AlertType.INFORMATION, "GRACZ", "Gra gracz bia≥y", "", ButtonType.OK);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	
}
