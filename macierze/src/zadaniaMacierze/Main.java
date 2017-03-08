package zadaniaMacierze;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/*
 * http://wklej.org/id/2845531/txt/
 * Pierwsza liczba na wyjściu to liczba roznych sum
 * Druga liczba sum o największej ilości powtorzen(wystapien)
 * Trzecia liczba to srednia wszystkich sum
*/

public class Main {
	
	public static int RoznicaSum(int[] wierszMacierzym, int[][] M) {
		int indeksWierszaLewegoGornego = wierszMacierzym[0];
		int indeksKolumnyLewejGornej = wierszMacierzym[1];
		int indeksWierszaPrawegoDolnego = wierszMacierzym[2];
		int indeksKolumnyPrawejDolnej = wierszMacierzym[3];
		int roznicaSum = 0;
		
		List<Integer> wycinekMacierzyM = new ArrayList<>(); 
		
		for (int i = indeksWierszaLewegoGornego; i <= indeksWierszaPrawegoDolnego; i++) {
			for (int j = indeksKolumnyLewejGornej; j <= indeksKolumnyPrawejDolnej; j++) {
				wycinekMacierzyM.add(M[i][j]);
			}
		}
		
		for (Integer elementMacierzyM : wycinekMacierzyM) {
			roznicaSum += elementMacierzyM;
		}
	
		return roznicaSum;
	}
	
	public static void main(String[] args) {
		Scanner skaner = null;
		try {
			skaner = new Scanner(new File(System.getProperty("user.dir") + "/src/zadaniaMacierze/m3"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		int wczytywanyWierz = 0;
		int wierszMacierzyM = 0; 
		int wierzMacierzym = 0;
		int n = 0;
		int k = 0;
		int[][] M = null;
		int[][] m = null;
		String[] wszytywanaLinia;
		
		do {
			wszytywanaLinia = skaner.nextLine().split(" ");
			if (wczytywanyWierz == 0) {
				n = Integer.parseInt(wszytywanaLinia[0]);
				k = Integer.parseInt(wszytywanaLinia[1]);
				M = new int[n][n];
				m = new int[k][4];
			} else if (wczytywanyWierz <= n) {
				for (int kolumnaMacierzyM = 0; kolumnaMacierzyM < wszytywanaLinia.length; kolumnaMacierzyM++) {
					M[wierszMacierzyM][kolumnaMacierzyM] = Integer.parseInt(wszytywanaLinia[kolumnaMacierzyM]);
				}
				wierszMacierzyM++;
			} else if (wczytywanyWierz > n) {
				for (int kolumnaMacierzym = 0; kolumnaMacierzym < wszytywanaLinia.length; kolumnaMacierzym++) {
					m[wierzMacierzym][kolumnaMacierzym] = Integer.parseInt(wszytywanaLinia[kolumnaMacierzym]);
				}
				wierzMacierzym++;
			}
			wczytywanyWierz++;
		} while (skaner.hasNext());
		skaner.close();

		int[] wierszMacierzym = new int[4];
		Map<Integer, Integer> listaRoznicSum = new HashMap<>();
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				wierszMacierzym[j] = m[i][j];
			}
			int wynikRoznicySum = RoznicaSum(wierszMacierzym, M);
			if (listaRoznicSum.containsKey(wynikRoznicySum)) {
				listaRoznicSum.put(wynikRoznicySum, listaRoznicSum.get(wynikRoznicySum) + 1);
			} else {
				listaRoznicSum.put(wynikRoznicySum, 1);
			}
		}

		int najwiekszaIloscPowtorzen = 0;
		int maxIloscWystapien = Collections.max(listaRoznicSum.values());;
		for (Integer klucz : listaRoznicSum.keySet()) {
			int iloscWystapien = listaRoznicSum.get(klucz);
			if (iloscWystapien == maxIloscWystapien) {
				najwiekszaIloscPowtorzen++;
			}
		}
		
		int sumaWszystkichSum = 0;
		int iloscWszystkichSum = 0;
		for (Integer klucz : listaRoznicSum.keySet()) {
			int iloscWystapien = listaRoznicSum.get(klucz);
			for (int wystapienie = 0; wystapienie < iloscWystapien; wystapienie++) {
				sumaWszystkichSum += klucz;
				iloscWszystkichSum++;
			}
		}		

		System.out.println("Wynik: " + listaRoznicSum.size() + " " + najwiekszaIloscPowtorzen + " " + sumaWszystkichSum/iloscWszystkichSum);
		
		for (int i = 0; i < M.length; i++) {
			System.out.print("[");
			for (int j = 0; j < M[i].length; j++) {
				System.out.print(M[i][j] + " ");
			}
			System.out.print("]");
			System.out.println();
		}

		System.out.println("");
		
		for (int i = 0; i < m.length; i++) {
			System.out.print("[");
			for (int j = 0; j < m[i].length; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.print("]");
			System.out.println();
		}

	}

}
