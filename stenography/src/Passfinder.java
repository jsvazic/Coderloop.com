import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;
import java.util.HashMap;

public class Passfinder {
	
	private static String getPassword(int n, String s) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		int size = s.length();
		String passwd = null;
		int maxCount = 0;
		for (int i = 0; i < size - n; i++) {
			String key = s.substring(i, i + n);
			int count;
			if (!(map.containsKey(key))) {
				count = 1;
			} else {
				count = map.get(key) + 1;
			}
			map.put(key, count);
			if (count > maxCount) {
				maxCount = count;
				passwd = key;
			}
		}
		
		char[] arr = passwd.toCharArray();
		StringBuilder sb = new StringBuilder();
		for (char ch : arr) {
			sb.append("0x").append(Integer.toHexString((int) ch));
		}
		return sb.toString();
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		String line;
		while ((line = br.readLine()) != null) {
			int idx   = line.indexOf(' ');
			int n     = Integer.parseInt(line.substring(0, idx).trim());
			String s  = line.substring(idx + 1).trim();
			System.out.println(getPassword(n, s));
		}
	}
}