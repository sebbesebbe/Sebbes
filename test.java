import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test {

	static String input;

	public static void main(String[] args) throws IOException {

		int rangeStart = -1;
		int rangeEnd = -1;

		input = readInput();
		while (input.length() > 0) {
			int page = getNextPage();
			if (page == rangeEnd + 1) {
				rangeEnd = page;
			} else {
				writeRange(rangeStart, rangeEnd, ", ");
				rangeStart = page;
				rangeEnd = page;
			}
		}
		writeRange(rangeStart, rangeEnd, "");

	}

	public static void writeRange(int rangeStart, int rangeEnd, String delim) {
		if (rangeStart == -1 || rangeEnd == -1) {
			return;
		}
		if (rangeStart == rangeEnd) {
			System.out.print(rangeStart + delim);
			return;
		} else {
			System.out.print(rangeStart + "-" + rangeEnd + delim);
		}
	}

	public static int getNextPage() throws IOException {
		int blankPos = input.indexOf(" ");
		int a;
		if (blankPos == -1) {
			a = Integer.parseInt(input);
			input = "";
		} else {
			String s = input.substring(0, blankPos);
			a = Integer.parseInt(s);
			input = input.substring(blankPos + 1);
		}
		return a;
	}

	public static String readInput() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Page numbers: ");
		String s = reader.readLine();
		return s;
	}

}
