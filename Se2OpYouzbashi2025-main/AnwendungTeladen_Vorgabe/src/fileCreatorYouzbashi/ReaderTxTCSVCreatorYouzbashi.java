package fileCreatorYouzbashi;

public class ReaderTxTCSVCreatorYouzbashi extends ReaderCreatorYouzbashi {

	@Override
	public ReaderProductYouzbashi factoryMethod(String typ) {

		if ("csv".equals(typ)) {
			return new ReaderCSVProductYouzbashi();
		} else {
			return new ReaderTxTProductYouzbashi();
		}
		
		
	}

}
