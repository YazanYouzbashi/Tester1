package gui.Warenubersicht;

import business.TeeladenModel;
import javafx.stage.Stage;
public class WarenuebersichtControl {	
	private WarenuebersichtView
 		warenuebersichtView;
	private TeeladenModel teesModel;
	public WarenuebersichtControl(Stage primaryStage){
 		this.teesModel = teesModel.getInstance(); 		
		this.warenuebersichtView 
		 	= new WarenuebersichtView(this, primaryStage,
			teesModel);
	}
}

