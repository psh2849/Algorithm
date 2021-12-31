package simulation;

import java.util.*;
import java.io.*;

public class BOJ1173 {

	static int trainingTime, initHealth, maxHealth, increaseHealth, decreaseHealth;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		trainingTime = Integer.parseInt(st.nextToken());
		initHealth = Integer.parseInt(st.nextToken());
		maxHealth = Integer.parseInt(st.nextToken());
		increaseHealth = Integer.parseInt(st.nextToken());
		decreaseHealth = Integer.parseInt(st.nextToken());
		
		int count = 0;
		int time = 0;
		int cur = initHealth;
		while(count < trainingTime) {
			if(cur + increaseHealth <= maxHealth) {
				count++;
				time++;
				cur = cur + increaseHealth;
			} else {
				if(cur - decreaseHealth < initHealth) {
					cur = initHealth;
					time++;
				} else {
					cur = cur - decreaseHealth;
					time++;
				}
			}
			
			if(cur + increaseHealth > maxHealth && cur == initHealth) {
				System.out.println(-1);
				return;
			}
		}
		
		System.out.println(time);
	}

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		input();
	}

}
