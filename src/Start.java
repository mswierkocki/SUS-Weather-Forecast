import java.io.FileNotFoundException;


public class Start {

	public static void main(String[] args) throws FileNotFoundException {
		Dane startDane = new Dane();
		startDane.odczytDanychZPliku();
		startDane.wypisztablice();
		startDane.czytajPoWierszu();
		startDane.wyœwietlTabliceRegulDecyzyjnych();


	}

}
