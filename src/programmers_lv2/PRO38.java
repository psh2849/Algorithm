/*
 * https://programmers.co.kr/learn/courses/30/lessons/17686
 */
package programmers_lv2;

import java.util.Arrays;
import java.util.Comparator;

public class PRO38 {
	
	static String[] solution(String[] files) {
		String[] answer = {};
		
		Arrays.sort(files, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				String head1 = o1.split("[0-9]")[0];
				String head2 = o2.split("[0-9]")[0];
				
				int result = head1.toLowerCase().compareTo(head2.toLowerCase());
			
				if(result == 0) {
					result = convertNum(o1, head1) - convertNum(o2,head2);
				}
				
				return result;
			}
		});
		
		return files;
	}
	
	static int convertNum(String str, String head) {
		str = str.substring(head.length());
		String result = "";
		
		for(char c : str.toCharArray()) {
			if(Character.isDigit(c) && result.length() < 5) {
				result += c;
			} else {
				break;
			}
		}
	
		return Integer.valueOf(result);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
		solution(files);
	}

}
