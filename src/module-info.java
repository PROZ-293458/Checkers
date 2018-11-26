/**
 * 
 */
/**
 * @author Kaczmii
 *
 */
module Checkers 
{
	requires javafx.graphics;
	requires javafx.fxml;
	requires javafx.controls;
	requires javafx.base;
	
	opens com.kaczmii.game.checkers to javafx.graphics;
	opens com.kaczmii.game.checkers.view to javafx.fxml;
	opens com.kaczmii.game.checkers.controller to javafx.fxml;
}