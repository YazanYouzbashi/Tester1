package fileCreatorYouzbashi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReaderTxTProductYouzbashi extends ReaderProductYouzbashi {

	BufferedReader ein;
	
	@Override
	public String[] leseAusDatei() throws IOException {
		
		this.ein= new BufferedReader(new FileReader("Teesorte.txt"));
		String [] ergebnisZeile = new String[5];
		String zeile = ein.readLine();
		int i = 0;
		while ( i < ergebnisZeile.length) {
			ergebnisZeile[i] = zeile;
			zeile = ein.readLine();
			i++;
		}
		
		return ergebnisZeile;
	}

	@Override
	public void schliesseDatei() throws IOException {
		ein.close();
		
	}

}
