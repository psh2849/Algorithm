/*
 * https://programmers.co.kr/learn/courses/30/lessons/42579
 */
package programmers_lv3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class PRO8 {

	static class Music {
		String genre;
		int play;
		int idx;

		public Music(String genre, int play, int idx) {
			this.genre = genre;
			this.play = play;
			this.idx = idx;
		}
	}

	static int[] solution(String[] genres, int[] plays) {
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < genres.length; i++) {
			map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
		}
		
		ArrayList<String> genList = new ArrayList<>();
		while(map.size() != 0) {
			int max = -1;
			String maxKey = "";
			for(String key : map.keySet()) {
				int value = map.get(key);
				if(max < value) {
					max = value;
					maxKey = key;
				}
			}
			genList.add(maxKey);
			map.remove(maxKey);
		}
		
		ArrayList<Music> musicList = new ArrayList<>();
		for(String music : genList) {
			ArrayList<Music> result = new ArrayList<>();
			for(int i = 0; i < genres.length; i++) {
				if(genres[i].equals(music)) {
					result.add(new Music(music, plays[i], i));
				}
			}
			
			Collections.sort(result, new Comparator<Music>() {
				@Override
				public int compare(Music o1, Music o2) {
					// TODO Auto-generated method stub
					return o2.play - o1.play;
				}
			});
			
			if(result.size() == 1) {
				musicList.add(result.get(0));
			} else if(result.size() > 1){
				musicList.add(result.get(0));
				musicList.add(result.get(1));
			}
		}
		
		int[] answer = new int[musicList.size()];
		for(int i = 0; i < musicList.size(); i++) {
			answer[i] = musicList.get(i).idx;
		}
		
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] genres = { "classic", "pop", "classic", "classic", "pop" };
		int[] plays = { 500, 600, 150, 800, 2500 };
		solution(genres, plays);
	}

}
