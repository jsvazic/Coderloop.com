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
        BufferedReader br = new BufferedReader(new FileReader(args[0]));
        String line;
        while ((line = br.readLine()) != null) {
	    String[] words = line.split("\\W+");
	    for (String word : words) {
		line = line.replaceFirst("\\b("+word+")\\b", reverse(word));
	    }
	    System.out.println(line);
        }
    }
}
