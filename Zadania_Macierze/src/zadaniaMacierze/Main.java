package zadaniaMacierze;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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
	
	public static int RoznicaSum(int[] wsp, int[][] M) {
		int xx = wsp[0];
		int xy = wsp[1];
		int yx = wsp[2];
		int yy = wsp[3];
		int wynik = 0;
		
		List<Integer> tmp = new ArrayList<>(); 
		
		for (int i = xx; i <= yx; i++) {
			for (int j = xy; j <= yy; j++) {
				tmp.add(M[i][j]);
			}
		}
		
		for (Integer integer : tmp) {
			wynik += integer;
		}
		
		return wynik;
	}
	
	public static void main(String[] args) {
		
		Scanner in = null;
		try {
			in = new Scanner(new File("/home/miszx/git/korepetycje/lekcjewk/Zadania_Macierze/src/zadaniaMacierze/m3"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		int n = 0;
		int k = 0;
		int count = 0;
		int countM = 0; 
		int countm = 0;
		int[][] M = null;
		int[][] m = null;
		String[] line;

		int SumaRoznic = 0;
		int NajwIloscPowt = 0;
		int SredniaSum = 0;		
		
		do {
			line = in.nextLine().split(" ");
			if (count == 0) {
				n = Integer.parseInt(line[0]);
				k = Integer.parseInt(line[1]);
				M = new int[n][n];
				m = new int[k][4];
			} else if (count <= n) {
				for (int i = 0; i < line.length; i++) {
					M[countM][i] = Integer.parseInt(line[i]);
				}
				countM++;
			} else if (count > n) {
				for (int i = 0; i < line.length; i++) {
					m[countm][i] = Integer.parseInt(line[i]);
				}
				countm++;
			}
			count++;
		} while (in.hasNext());
		in.close();

		int[] wspXY = new int[4];
		Map<Integer, Integer> ListaRoznic = new HashMap<>();
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				wspXY[j] = m[i][j];
			}
			int wynik = RoznicaSum(wspXY, M);
			if (ListaRoznic.containsKey(wynik)) {
				ListaRoznic.put(wynik, ListaRoznic.get(wynik) + 1);
			} else {
				ListaRoznic.put(wynik, 1);
			}
			SredniaSum += wynik;
		}

		int tmpMax = 0;
		for (Integer i : ListaRoznic.keySet()) {
			int x = ListaRoznic.get(i);
			if (x >= tmpMax) {
				tmpMax = x;
			}
			SumaRoznic += i;
		}
		
		for (Integer i : ListaRoznic.keySet()) {
			int x = ListaRoznic.get(i);
			if (x == tmpMax) {
				NajwIloscPowt++;
			}
		}

		System.out.println("Wynik: " + ListaRoznic.size() + " " + NajwIloscPowt + " " + SumaRoznic/SredniaSum);
		
//		for (int i = 0; i < M.length; i++) {
//			System.out.print("[");
//			for (int j = 0; j < M[i].length; j++) {
//				System.out.print(M[i][j] + " ");
//			}
//			System.out.print("]");
//			System.out.println();
//		}
//
//		System.out.println("");
//		
//		for (int i = 0; i < m.length; i++) {
//			System.out.print("[");
//			for (int j = 0; j < m[i].length; j++) {
//				System.out.print(m[i][j] + " ");
//			}
//			System.out.print("]");
//			System.out.println();
//		}

	}

}
