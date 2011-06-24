import java.io.*;
import java.util.regex.*;

public class ReverseWords {
    public static String reverse(String str) {
		char[] arr = str.toCharArray();
		StringBuilder sb = new StringBuilder();
		for (int i = arr.length - 1; i >= 0; i--) {
			sb.append(arr[i]);
		}

		return sb.toString();
    }

    public static void main(String[] args) throws Exception {
		Pattern pattern = Pattern.compile("(\\W*)(\\w+)(\\W*)");
        BufferedReader br = new BufferedReader(new FileReader(args[0]));
        String line;
        while ((line = br.readLine()) != null) {
			Matcher matcher = pattern.matcher(line);
			StringBuilder sb = new StringBuilder();
			matcher.find();
			while (!matcher.hitEnd()) {
				sb.append(matcher.group(1)).append(reverse(matcher.group(2)))
						.append(matcher.group(3));
				
				matcher.find();
			}
			System.out.println(sb.toString());
        }
    }
}