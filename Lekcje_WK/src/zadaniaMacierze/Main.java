package zadaniaMacierze;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner in = null;
		try {
			in = new Scanner(new File("/home/miszx/git/korepetycje/lekcjewk/Lekcje_WK/src/zadaniaMacierze/m3"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		int n = 0;
		int k = 0;
		int count = 0;
		int countM = 0;
		int countm = 0;
		Integer[][] M = null;
		Integer[][] m = null;
		String[] line;
		
		do {
			line = in.nextLine().split(" ");
			if (count == 0) {
				n = Integer.parseInt(line[0]);
				k = Integer.parseInt(line[1]);
				M = new Integer[n][n];
				m = new Integer[k][4];
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

		for (int i = 0; i < M.length; i++) {
			System.out.print("[");
			for (int j = 0; j < M[i].length; j++) {
				System.out.print(M[i][j] + " ");
			}
			System.out.print("]");
		}

		System.out.println("");
		
		for (int i = 0; i < m.length; i++) {
			System.out.print("[");
			for (int j = 0; j < m[i].length; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.print("]");
		}

	}

}
