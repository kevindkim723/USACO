
package USOpen2018;

import java.io.*;
import java.util.*;

class threes {
	private HashSet<String> set = new HashSet<String>();
	private String x;
	private String y;
	private String z;

	public threes(String x, String y, String z) {
		set.add(x);
		set.add(y);
		set.add(z);
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public String getX() {
		return x;

	}

	public String getY() {
		return y;
	}

	public String getZ() {
		return z;
	}

	public boolean isTeamMatch() {

		return (set.size() == 2);
	}

	public boolean isSingleMatch() {
		return (set.size() == 1);
	}

	public String toString() {
		return x + y + z;
	}
}

public class tttt {
	public static void main(String[] args) throws IOException {
		BufferedReader fin = new BufferedReader(new FileReader("tttt.in"));
		PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("tttt.out")));
		String[][] board = new String[3][3];

		for (int i = 0; i < board.length; i++) {
			String[] input = fin.readLine().split("");
			for (int k = 0; k < board[i].length; k++) {
				board[i][k] = input[k];
			}
		}

		threes three = new threes("x", "y", "z");
		// System.out.println(three);

		ArrayList<threes> list = new ArrayList<threes>();
		for (int i = 0; i < 3; i++) {
			threes horizontal = new threes(board[i][0], board[i][1], board[i][2]);
			threes vertical = new threes(board[0][i], board[1][i], board[2][i]);
			list.add(vertical);
			list.add(horizontal);
		}
		list.add(new threes(board[0][0], board[1][1], board[2][2]));
		list.add(new threes(board[2][0], board[1][1], board[0][2]));
		HashSet<String> singles = new HashSet<String>();
		HashSet<String> teams = new HashSet<String>();
		for (threes t : list) {
			if (t.isSingleMatch()) {
				singles.add(t.toString());
			} else if (t.isTeamMatch()) {
				teams.add(t.getX());
				teams.add(t.getY());
				teams.add(t.getZ());
			} else {
				continue;
			}
		}
		fout.println(singles.size());
		fout.println((teams.isEmpty()) ? "0" : teams.size() - 1);
		fout.close();

	}

}
