import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TopFive {

    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		String line;
		Map<String, Integer> map = new HashMap<String, Integer>();
		while ((line = br.readLine()) != null) {
			int queryIdx = line.indexOf(", query=");
			String key = line.substring(queryIdx + 8, line.length() - 1);
			if (!map.containsKey(key)) {
				map.put(key, new Integer(0));
			}
			
			map.put(key, map.get(key) + 1);
		}
		
		QContainer[] arr = new QContainer[map.keySet().size()];
		int idx = 0;
		for (String key : map.keySet()) {
			arr[idx++] = new QContainer(key, map.get(key).intValue());
		}
		
		Arrays.sort(arr);
		for (int i = 0; i < 5; i++) {
			System.out.println(arr[i].key);
		}
	}
	
	static class QContainer implements Comparable<QContainer> {
		public final String key;
		public final int count;
		
		public QContainer(String key, int count) {
			this.key = key;
			this.count = count;
		}
		
		@Override
		public int compareTo(QContainer o) {
			if (this.equals(o)) {
				return 0;
			} else if (count > o.count) {
				return -1;
			} else if (count < o.count) {
				return 1;
			}
			
			return key.compareTo(o.key);
		}
		
		@Override
		public int hashCode() {
		    StringBuilder sb = new StringBuilder();
			return sb.append(key).append(count).toString().hashCode();
		}
		
		@Override
		public boolean equals(Object o) {
			if (!(o instanceof QContainer)) {
				return false;
			}
			
			return (o.hashCode() == hashCode());
		}
	}
}