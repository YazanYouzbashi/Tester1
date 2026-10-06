package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import fileCreatorYouzbashi.ReaderTxTCSVCreatorYouzbashi;
import ownUtil.Observable;
import ownUtil.Observer;
import fileCreatorYouzbashi.ReaderCreatorYouzbashi;
import fileCreatorYouzbashi.ReaderProductYouzbashi;

public class TeeladenModel implements Observable {

    ArrayList<Teesorte> teesorte = new ArrayList<Teesorte>();
    Vector<Observer> observers = new Vector<Observer>();
    
    private static TeeladenModel instance;
    
    
    //Constructure
    private TeeladenModel() {
	
	}

    public ArrayList<Teesorte> getTeesorte() {
        return teesorte;
    }
    
    public static TeeladenModel getInstance() {
    	
    	if (instance == null) {
    		instance = new TeeladenModel();
    	}
    	return instance;
    }
    
    public void addTeeElement(Teesorte teesorte) {
    	this.teesorte.add(teesorte);
    }
    
    public void leseAusDatei(String typ) throws IOException {
    	
    	
    	ReaderCreatorYouzbashi c1 = new ReaderTxTCSVCreatorYouzbashi();
    	ReaderProductYouzbashi p1 = c1.factoryMethod(typ);
    	
    	String [] zeile = p1.leseAusDatei();
    	 this.teesorte.add(new Teesorte(
                 Integer.parseInt(zeile[0]),
                 zeile[1],
                 zeile[2],
                 zeile[3],
                 zeile[4].split("_")
             ));
    	 p1.schliesseDatei(); 	
    	 notifyObserver();
    }
    
    
    public void schreibeTeesInCsvDatei() throws IOException {
        BufferedWriter aus = new BufferedWriter(new FileWriter("TeesortenAusgabe.csv", true));
        for (Teesorte teesorte2 : teesorte) {
        aus.write(teesorte2.gibTeesorteZurueck(';'));
        }
        aus.close();
      
    }

	@Override
	public void addObserver(Observer obs) {
		this.observers.addElement(obs);
		
	}

	@Override
	public void removeObserver(Observer obs) {
		this.observers.remove(obs);
		
	}

	@Override
	public void notifyObserver() {
		for (Observer observer : observers) {
			observer.update();
		}
		
	}
}



/*
public void leseAusDatei(String typ) throws IOException {
    if ("csv".equals(typ)) {
        BufferedReader ein = new BufferedReader(new FileReader("Teesorte.csv"));
        String[] zeile = ein.readLine().split(";");
        this.teesorte = new Teesorte(
            Integer.parseInt(zeile[0]),
            zeile[1],
            zeile[2],
            zeile[3],
            zeile[4].split("_")
        );
        ein.close();
    }
}
*/