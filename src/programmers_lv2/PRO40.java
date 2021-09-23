package programmers_lv2;

public class PRO40 {

	static String solution(String m, String[] musicinfos) {
		String answer = "";
		int max = Integer.MIN_VALUE;
		m = changeStr(m);
		for (int i = 0; i < musicinfos.length; i++) {

			String[] str = musicinfos[i].split(",");
			String s = changeStr(str[3]);
			int time = calcTime(str[0], str[1]);

			if (time > s.length()) {
				StringBuilder melody = new StringBuilder();

				for (int j = 0; j < time / s.length(); j++) {
					melody.append(s);
				}

				melody.append(s.substring(0, time % s.length()));
				s = melody.toString();
			} else {
				s = s.substring(0, time);
			}

			if (s.contains(m) && s.length() > max) {
				max = s.length();
				answer = str[2];
			}
		}
		if (answer == "") {
			answer = "(None)";
		}

		return answer;
	}

	static String changeStr(String str) {
		str = str.replaceAll("C#", "H");
		str = str.replaceAll("D#", "J");
		str = str.replaceAll("F#", "I");
		str = str.replaceAll("G#", "K");
		str = str.replaceAll("A#", "L");

		return str;
	}

	static int calcTime(String str1, String str2) {
		int answer = 0;

		String[] s1 = str1.split(":");
		String[] s2 = str2.split(":");

		int start = Integer.valueOf(s1[0]) * 60 + Integer.valueOf(s1[1]);
		int end = Integer.valueOf(s2[0]) * 60 + Integer.valueOf(s2[1]);

		answer = end - start;

		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] musicinfos = { "12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF" };
		solution("ABC", musicinfos);
	}

}
