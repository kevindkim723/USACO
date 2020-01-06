
public class aids {
	public static void main(String[] args) {
		String group1[] = { "Bella", "Blue" };
		String group2[] = { "Bethany", "Bella" };
		String newGroup[] = new String[3];
		String output = "";
		String word = "Barbie";
		int counter = 0;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				if (group1[i].equals(group2[j])) {
					if (i == 0) {
						output = group1[i];
						output = output.concat(group1[i+1]);
						output = (group2[1 - j]).concat(output);
					}
					if (i == 1) {
						output = group1[i-1];
						output = output.concat(group1[i]);
						output = output.concat(group2[1 - j]);
					}
				}
			}
		}
		System.out.println(output);
	}
}
