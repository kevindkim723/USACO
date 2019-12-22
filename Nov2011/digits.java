package bronzeNov2011;
//brute force method

import java.util.ArrayList;

public class digits {
	public static void main(String[] args) {

		String b2 = "1010";
		String b3 = "212";

		for (int i = 0; i < b2.length(); i++) {
			String tempb2 = "";
			if (b2.charAt(i) == '0') {
				tempb2 = (i == b2.length() - 1) ? b2.substring(0, i) + "1"
						: b2.substring(0, i) + "1" + b2.substring(i + 1, b2.length());
			} else {
				tempb2 = (i == b2.length() - 1) ? b2.substring(0, i) + "0"
						: b2.substring(0, i) + "0" + b2.substring(i + 1, b2.length());
			}

			for (int k = 0; k < b3.length(); k++) {

				String tempb3 = b3;
				for (int j = 0; j <= 2; j++) {
					if (Character.getNumericValue(b3.charAt(k)) == j) {

						continue;
					} else {
						tempb3 = (k == b3.length() - 1) ? b3.substring(0, k) + Integer.toString(j)
								: b3.substring(0, k) + Integer.toString(j) + b3.substring(k + 1, b3.length());

						if (convertBase(tempb3, 3) == convertBase(tempb2, 2)) {
							System.out.println("ans: " + convertBase(tempb2, 2));
						}
					}
				}
			}
		}

	}

	private static int convertBase(String s, int base) {
		int sum = 0;
		for (int i = 0; i < s.length(); i++) {
			for (int j = i; j < s.length(); j++) {
				for (int k = 0; i < s.length(); i++) {

					int at = Character.getNumericValue(s.charAt(s.length() - i - 1));
					sum += Math.pow(base, i) * at;

				}

			}
		}
		return sum;

	}

}
