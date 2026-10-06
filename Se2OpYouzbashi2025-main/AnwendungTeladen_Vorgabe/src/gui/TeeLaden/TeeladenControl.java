package gui.TeeLaden;

import java.io.IOException;

import business.TeeladenModel;
import business.Teesorte;
import javafx.stage.Stage;

public class TeeladenControl {

    TeeladenModel teModel;
    TeeladenView teView;

    public TeeladenControl(Stage primaryStage) {
        super();
        this.teModel = TeeladenModel.getInstance();
        this.teView = new TeeladenView(this, primaryStage, teModel);
    }

    void nehmeTeeAuf() {
        try {
            teModel.addTeeElement((new Teesorte(
                Integer.parseInt(teView.getTxtIdentnummer().getText()),
                teView.getTxtBezeichnung().getText(),
                teView.getTxtKategorie().getText(),
                teView.getTxtMitKoffein().getText(),
                teView.getTxtEnthalteneKraeuter().getText().split(";")
            )));

            teView.zeigeInformationsfensterAn("Die Teesorte wurde aufgenommen!");
        } catch (Exception exc) {
            teView.zeigeFehlermeldungsfensterAn(exc.getMessage());
        }
    }

    void leseAusDatei(String typ) {
        try {
            if ("csv".equals(typ)) {
                teModel.leseAusDatei(typ);
                teView.zeigeInformationsfensterAn("Die Daten wurde gelesen!");
            } else if ("txt".equals(typ)) {
            	  teModel.leseAusDatei(typ);
                  teView.zeigeInformationsfensterAn("Die Daten wurde gelesen!");
            }
            else {
                teView.zeigeInformationsfensterAn("Noch nicht implementiert!");
            }
        } catch (Exception exc) {
            teView.zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Lesen!");
        }
    }

    void TeeLadenInCsvDateiL() {
        try {
            teModel.schreibeTeesInCsvDatei();
        } catch (IOException exc) {
            teView.zeigeFehlermeldungsfensterAn("IOException beim Speichern!");
        } catch (Exception exc) {
            teView.zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Speichern!");
        }
    }
}
