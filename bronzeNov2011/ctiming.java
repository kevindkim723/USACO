package bronzeNov2011;

public class ctiming {
	public static void main(String[] args) {
		int day = 12;
		int hr = 13;
		int min = 14;
		final int minutesNov = day * 24 * 60 + hr * 60 + min;
		int minutesNovElev = 11 * 24 * 60 + 11 * 60 + 11;
		int output = (minutesNov > minutesNovElev) ? minutesNov - minutesNovElev : -1;
		System.out.println(output);
	}

}
