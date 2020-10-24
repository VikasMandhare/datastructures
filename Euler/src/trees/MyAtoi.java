package trees;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyAtoi {

	public static int myAtoi(String str) {
		if (str.length() == 0)
			return 0;

		boolean firstChar = false;
		int index = 0;
		int multi = 1;
		String result = "";

		while (!firstChar) {
			if (str.charAt(index) == ' ') {
				index++;
				continue;
			}

			if (str.charAt(index) == '-') {
				index++;
				multi = multi * -1;
				continue;
			}

			boolean numFound = false;
			Pattern p = Pattern.compile("[0-9]");
			Matcher m = p.matcher(Character.toString(str.charAt(index)));
			while (m.find()) {
				numFound = true;
				result = result + str.charAt(index++);
				if (index < str.length()) {
					m = p.matcher(Character.toString(str.charAt(index)));
				} else {
					break;
				}
			}

			if (!numFound) {
				return 0;
			}
			firstChar = true;
		}
		if (result.length() <= 0)
			return 0;

		try {
			return Integer.parseInt(result) * multi;
		} catch (NumberFormatException e) {
			return -2147483648;
		}
	}

	public static void main(String[] args) {
		// System.out.println(myAtoi("42"));
		// System.out.println(myAtoi(" -42"));
		// System.out.println(myAtoi("-91283472332"));
		System.out.println(myAtoi("1"));
	}

}
