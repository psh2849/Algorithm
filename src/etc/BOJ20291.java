package etc;

import java.util.*;
import java.io.*;

public class BOJ20291 {
	static class File implements Comparable<File>{
		String name;
		int count;
		
		public File(String name, int count) {
			this.name = name;
			this.count = count;
		}
		
		public int compareTo(File o) {
			return this.name.compareTo(o.name);
		}
	}
	
	static int n;
	static HashMap<String, Integer> map = new HashMap<>();
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			
			int index = str.indexOf(".");
			String temp = "";
			for(int j = index + 1; j < str.length(); j++) {
				temp += str.charAt(j);
			}
			if(map.containsKey(temp)) {
				map.put(temp, map.get(temp) + 1);
			} else {
				map.put(temp, 1);
			}
		}

		ArrayList<File> file = new ArrayList<>();
	
		for(String name : map.keySet()) {
			file.add(new File(name, map.get(name)));
		}
		
		Collections.sort(file);
		for(int i = 0; i < file.size(); i++) {
			System.out.println(file.get(i).name + " " + file.get(i).count);
		}
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
