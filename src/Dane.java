import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Dane {


	// Podajemy dok�adno�� na pocz�tku
	double dokladnosc = 0.7;
	
	// Tablica z danymi
	public String  [][] dane = new String[50][50]; // Przyk�adowo okre�lamy d�ugo�� tablicy 50
	
	
	// tablica atrybut�w
	int i=0; // zmienna pomocnicza
	int p=0; // zmienna pomocnicza
	int k=0; //zmienna pomocnicza
	int liczbaWierszy;
	int liczbaKolumn;
	int wierszWTabeliRegulDecyzyjnych=0;
	int liczbaWierszyDoRegul;
	public double liczbaDecyzji;
	
	public double licznikWsparcia;
	
	public String [][] atrybuty= new String[50][10]; // Przyk�adowo okre�lamy d�ugo�� tablicy 50
	public String [] atrybutyWartosci= new String[50]; // Przyk�adowo okre�lamy d�ugo�� tablicy 50
	public String [] atrybutyKontrPrzyk�adu= new String[50]; // Przyk�adowo okre�lamy d�ugo�� tablicy 50
	public String [][] tablicaRegulDecyzyjnych = new String [50][50];
	public int [] tablicaKolumnDoUszczegolnien= new int[50]; // Przyk�adowo okre�lamy d�ugo�� tablicy 50
	public List<String> listaUszczegolnien = new ArrayList<String>();
//	public String [] tablicaUszczegolnien= new String[50]; // Przyk�adowo okre�lamy d�ugo�� tablicy 50
	
	
	String odczytanyString;
	String s;
	String decyzja;
	String zus;
	boolean istniejeKontrprzyk�ad=false;
	boolean dokladnoscWystarczajaca=false;
	boolean uszczegolnienie=false;

	int wmw;
	int kmw;

	
int nkt=0; // zmienna potrzebna do Tablicy kolumn uszczeg�lnionych
String str;  // zmienna zawieraj�ca nazw� uszczeg�lnionego pola
int aa=0; // zmienna potrzebna przy uszczegolnieniu
	
	
	public void odczytDanychZPliku() throws FileNotFoundException{
	// czytanie danych z pliku tekstowego
	Scanner odczyt = new Scanner(new File("weather.nominal.arff"));

while((odczyt.hasNext())){  // odczytuje dop�ki nie koniec pliku tekstowego
	
	odczytanyString=odczyt.next();
	
	// wype�niamy tablic� atrybutami
	if (odczytanyString.equals("@attribute")){
		int jj=0;
		String odt4 =odczyt.nextLine();
		StringTokenizer st = new StringTokenizer(odt4, "@{,} ", false);
		while(st.hasMoreTokens()) {
			atrybuty[i][jj]=st.nextToken();
//			System.out.println(atrybuty[i][jj]);		
			jj++;
			}
		
		i++;
	}
	
	
	// wype�niamy tablic� danymi
	if(odczytanyString.equals("@data")){
		
		while((odczyt.hasNext())){
			odczytanyString=odczyt.next();
		StringTokenizer st = new StringTokenizer(odczytanyString,",");
		while(st.hasMoreTokens()){
				for(int j=0;j<=i-1;j++){
					dane[p][j]=st.nextToken();
//					System.out.println(dane[p][j]);
					k=k+1;
				}
				  
		}
		p++;
	}
	}
	
}
liczbaWierszy=p-1;
liczbaKolumn=k/p-1;
liczbaWierszyDoRegul = liczbaWierszy;

		}

	// wypisanie tablicy z danymi
	  public void wypisztablice() {
		  
		    for(int pp = 0; pp <=liczbaWierszy; pp++) {
		      for(int j = 0; j <=liczbaKolumn; j++) {
		        System.out.printf("%12s",dane[pp][j]);
		      }
		      System.out.println("");
		    }
		    System.out.println("");
		  }  

	  
// ------------------------------------------------------------------------------------------------------------
	  //ALGORYTM AQ
	  
	 public void czytajPoWierszu(){
		 int iw=0;
		 while(liczbaWierszy!=0){
			 for(int j=0; j<=liczbaKolumn;j++){
				 atrybutyWartosci[j]=dane[iw][j];
			 }
			 // rozpatrujemy i-ty wiersz
			 decyzja=atrybutyWartosci[liczbaKolumn];
			 System.out.println("decyzja: " + decyzja);
			 
			 // szukamy kontrPrzyk�adu
			 czyIstniejeKontrPrzyk�ad();
			 for(int i=0; i<=liczbaWierszy-1;i++){
			 for(int j=0; j<=liczbaKolumn;j++){  // przesuwamy o jeden wiersz w g�r�
				 dane[i][j]= dane[i+1][j];
			 }
			 }
			 liczbaWierszy=liczbaWierszy-1;
			 
			 wypisztablice();
			 
			 }
	 
	 }
			
	 public boolean czyIstniejeKontrPrzyk�ad(){
		 for(int g=0; g<=liczbaWierszy;g++){
			 
			 if(!dane[g][liczbaKolumn].equals(decyzja)){
				 System.out.print("Kontr przyk�ad to: "); 
				 for(int j=0; j<=liczbaKolumn;j++){
					 atrybutyKontrPrzyk�adu[j]=dane[g][j];
				System.out.print(" " + atrybutyKontrPrzyk�adu[j]);
				 }
				 System.out.println(" ");
				 istniejeKontrprzyk�ad=true;
				 
				 System.out.println("kontr przyk�ad istnieje");
				 // Je�li kontr przyk�ad istnieje to liczymy wsparcia
				liczWsparcie();
				Dokladnoscwystarczajc�ca();
				if(dokladnoscWystarczajaca==true){
					
					break;
				}
				
			 }	
			 
			 }
		 if(istniejeKontrprzyk�ad== false){
			 System.out.println("Brak kontr przyk�adu");
			 for(int hh=0;hh<=liczbaWierszy;hh++){
				 for(int dd=0;dd<=liczbaKolumn;dd++){
			 System.out.print(tablicaRegulDecyzyjnych[hh][dd]);
				 }
				 System.out.println();
		 }
		 }
		return istniejeKontrprzyk�ad;
	 
	 }
	 
	 
	 public boolean Dokladnoscwystarczajc�ca(){
		 return dokladnoscWystarczajaca;
	 }
	 
	 
	 public void liczLiczbaDezycji(){
		 liczbaDecyzji=0;
		 for(int i=0;i<=liczbaWierszy;i++){
			  
			  if(dane[i][liczbaKolumn].equals(decyzja)){
				  liczbaDecyzji=liczbaDecyzji+1;  // liczymy ile jest decyzji
				  
			  }
		  }
		  System.out.println("Liczba decyzji na " + decyzja + " wynosi " + liczbaDecyzji);
	 }
	  
	  public void liczWsparcie(){ 

		  double wsparcie=0;
		  double Maxwspracie =wsparcie;
		  int wmw=0;
		  int kmw=0;
		  
		  liczLiczbaDezycji();
		  
		  if(uszczegolnienie==true){
			  nkt=0;
			  // Najpierw po kolumnach
			  
for(int f=0;f<=liczbaKolumn-1;f++){
	double[] liczbaA= new double[15];
	
				 //Dla wybranej kolumny sprawdzamy wszystkie wiersze
	
	doKontynuacji: for(int h=0;h<=liczbaWierszy;h++){
					  
//		System.out.println(listaUszczegolnien.get(1));
//		System.out.println("ROZMIAR LISTY: " + listaUszczegolnien.size());
					//Warunek uszczeg�lnienia
//		System.out.println("AA: " + aa);
		
					  
					  try {
						  str=listaUszczegolnien.get(aa);
						}catch (IndexOutOfBoundsException e) {
							continue doKontynuacji;
						}
//					  System.out.println("STR: " + str);
					  if(!dane[h][tablicaKolumnDoUszczegolnien[nkt]].equals(str)){
						  aa=0;
						  nkt=0;
					  }
					  
					  else if(dane[h][tablicaKolumnDoUszczegolnien[nkt]].equals(str)){
					  
						
						 
						  if(f!=tablicaKolumnDoUszczegolnien[nkt]){ 
							  if(aa<listaUszczegolnien.size()-1){
									 aa++;
									 nkt++;
									 continue doKontynuacji;
								 }
//							  aa=0;
//							  nkt=0;
							  
							  // Rozpatrujemy dalsze kolumny
							// Bierzymy tylko te kt�re nie spe�niaj� kontr przyk�adu
							  if(!dane[h][f].equals(atrybutyKontrPrzyk�adu[f])){
								  if(dane[h][liczbaKolumn].equals(decyzja)){ // w ostatniej kolumnie
									                                         // musi si� zawiera�
									                                         // nasza decyzja
									  
										  for(int kk=1; kk<atrybuty[f].length;kk++){
											 if(dane[h][f].equals(atrybuty[f][kk])){
										
													liczbaA [kk]=liczbaA [kk] +1;
													 }
											 }
											  }
					}
											 }
									  
									  
									  
								  }
								  
						  }
	
	for(int kk=0;kk<atrybuty[f].length;kk++){
		  if(liczbaA[kk]!=0){
			   
			 wsparcie=liczbaA[kk]/liczbaDecyzji;
			 if(wsparcie>Maxwspracie){
				 Maxwspracie=wsparcie;
				 wmw =f; kmw=kk;
//				 System.out.println("wmw: " + wmw);
//				 System.out.println("kmw: " + kmw);
				 licznikWsparcia = liczbaA[kmw];
			 }
			 
	  System.out.println("Wsparcie dla " +  atrybuty[f][kk] + " wynosi " +wsparcie );

		  }
	  }
	
	
	  }
System.out.println("licznik Wsparcia " + licznikWsparcia);
				  
System.out.println("Maksymalne wspracie posiada atrybut " + atrybuty[wmw][kmw]+
		  " i wynosi: "+ Maxwspracie);		  

		  
}

		  else{
		  for(int f=0;f<=liczbaKolumn-1;f++){
				 double[] liczbaA= new double[15];
				  for(int h=0;h<=liczbaWierszy;h++){
					  for(int kk=0; kk<atrybuty[f].length;kk++){

						 if(dane[h][f].equals(atrybuty[f][kk])){
							 if(!dane[h][f].equals(atrybutyKontrPrzyk�adu[f])){

								 if(dane[h][liczbaKolumn].equals(decyzja)){
								 
								liczbaA [kk]=liczbaA [kk] +1;
								 }
						 }
						  }

						 }
					
					  }
				  for(int kk=0;kk<atrybuty[f].length;kk++){
					  if(liczbaA[kk]!=0){
						   
						 wsparcie=liczbaA[kk]/liczbaDecyzji;
						 if(wsparcie>Maxwspracie){
							 Maxwspracie=wsparcie;
							 wmw =f; kmw=kk;
//							 System.out.println("wmw: " + wmw);
//							 System.out.println("kmw: " + kmw);
						 }
				  System.out.println("Wsparcie dla " +  atrybuty[f][kk] + " wynosi " +wsparcie );
		
					  }
				  }
				  }
		  }
		  System.out.println("Maksymalne wspracie posiada atrybut " + atrybuty[wmw][kmw]+
				  " i wynosi: "+ Maxwspracie);

		 // liczymy dok�adno�c dla atrybuty z najlepszym wsparciem
		  // tylko po wierszach patrzymy
		  double mianownikDokladnosci=0;
		  double licznikDokladnosci=0;
		  if(uszczegolnienie==true){
		
			  listaUszczegolnien.add(atrybuty[wmw][kmw]);
			  
			  nkt++;
			  tablicaKolumnDoUszczegolnien[nkt]=wmw;
			  System.out.println();
			  System.out.println(tablicaKolumnDoUszczegolnien[0]);
			  System.out.println(tablicaKolumnDoUszczegolnien[1]);
			  System.out.println();
			  System.out.println(listaUszczegolnien.toString());
			  int hkt=0;
			  aa=0;
			  str=listaUszczegolnien.get(aa);
			  doKontynuacji2:  for(int ii=0;ii<=liczbaWierszy;ii++){
				  
				  
				  if(!dane[ii][tablicaKolumnDoUszczegolnien[hkt]].equals(str)){
				  hkt=0;
				  aa=0;
				  str=listaUszczegolnien.get(aa);
				  }
			  else if(dane[ii][tablicaKolumnDoUszczegolnien[hkt]].equals(str)){
				  
				  if(aa<listaUszczegolnien.size()-1){
					  hkt++;
					  aa++;
					  str=listaUszczegolnien.get(aa);
					  
						 continue doKontynuacji2;
					 }
				  else{
					  mianownikDokladnosci=mianownikDokladnosci+1;
					  
				  }
				  
			  }
				  
				 
		  
			 
				  
			  }
//			  nkt++;
			  
			  licznikDokladnosci=licznikWsparcia;
			  System.out.println("licznik dok�adno�ci: " + licznikDokladnosci);
			  System.out.println("Mianownik dok�adno�ci: " + mianownikDokladnosci);
			  listaUszczegolnien.remove(atrybuty[wmw][kmw]);
			  
		  }
		  else{
		  for(int ii=0;ii<=liczbaWierszy;ii++){
			 
			  if(dane[ii][wmw].equals(atrybuty[wmw][kmw])){
				  mianownikDokladnosci=mianownikDokladnosci+1;
				  if(dane[ii][liczbaKolumn].equals(decyzja)){
					  licznikDokladnosci=licznikDokladnosci+1;
				  }
			  }
		  }
		  }

		  // Sprawdzamy czy spe�niona zostaje dok�adno��
		  // Je�eli tak to dodajemy do zbioru regu�
		  
		  double wyliczonaDokladnosc=licznikDokladnosci/mianownikDokladnosci;
		  if(wyliczonaDokladnosc>=dokladnosc){
		  System.out.println("Dok�adno�� jest spe�niona i wynosi: " + wyliczonaDokladnosc);
		  
		  (tablicaRegulDecyzyjnych[wierszWTabeliRegulDecyzyjnych][wmw])=(atrybuty[wmw][kmw]);
		  
		  wierszWTabeliRegulDecyzyjnych=wierszWTabeliRegulDecyzyjnych+1;
		  dokladnoscWystarczajaca=true;
		  uszczegolnienie=false;

		  listaUszczegolnien.clear();
		  nkt=0;
		  }
		  else{
			  System.out.println("dokladno�c nie jest spe�niona");
			  dokladnoscWystarczajaca=false;
			  uszczegolnienie=true;

		  listaUszczegolnien.add(atrybuty[wmw][kmw]);
			  tablicaKolumnDoUszczegolnien[nkt]=wmw;

		  }
	  }

	  public void wy�wietlTabliceRegulDecyzyjnych(){
		  
		  for(int tt=0;tt<=liczbaWierszyDoRegul;tt++){
			  for(int rr=0;rr<=liczbaKolumn;rr++){
				 System.out.print( tablicaRegulDecyzyjnych[tt][rr]+ " ");
			  }
			  System.out.println();
		  }
	  }
	  
	  
	
	
}
