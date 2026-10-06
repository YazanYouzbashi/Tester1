package main;


import gui.TeeLaden.TeeladenControl;
import gui.Warenubersicht.WarenuebersichtControl;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        new TeeladenControl(primaryStage);
        
        Stage fensterTeeladen =  new Stage();
        new WarenuebersichtControl(fensterTeeladen);
    }

    public static void main(String[] args) {
        launch(args);
    }
}



//123,Pfeffermintze,nein,Pfefferminze