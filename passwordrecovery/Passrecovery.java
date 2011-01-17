import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class Passrecovery {
	public static void main(String[] args) throws Exception {
		BufferedReader br  = new BufferedReader(new FileReader(args[0]));
		List<String> words = new LinkedList<String>();
		String encryptedPW = br.readLine();
		String salt        = encryptedPW.substring(0, 2);
		String line;
		
		while ((line = br.readLine()) != null) {
			String[] arr = line.split("\\W");
			for (String str : arr) {
				if (str.length() < 6 && Pattern.matches("[a-zA-Z]+", str)) {
					words.add(str.toLowerCase());
				}
			}
		}
		
		String[] wordArr = words.toArray(new String[0]);
		for (int i = 0; i < wordArr.length; i++) {
			for (int j = 0; j < wordArr.length; j++) {
				String[] encArr = encrypt(wordArr[i], wordArr[j]);
				for (String pw : encArr) {
					if (encryptedPW.equals(JCrypt.crypt(salt, pw))) {
						System.out.println(pw);
						System.exit(0);
					}
				}
			}
		}
		System.err.println("No password found!");
	}
		
	private static String[] encrypt(String word1, String word2) {
		int length = word1.length() + word2.length();
		if (length >= 4 && length <= 7) {
			return new String[] { 
					word1 + "0" + word2,
					word1 + "2" + word2, 
					word1 + "4" + word2,
					word1 + "8" + word2 
				};
		}
		
		return new String[0];
	}
}
