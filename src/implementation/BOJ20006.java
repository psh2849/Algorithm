package implementation;

import java.util.*;
import java.io.*;

public class BOJ20006 {
	
	static class Room {
		List<User> users = new ArrayList<>();
	}
	
	static class User implements Comparable<User> {
		int level = 0;
		String nickname;

		public User(int level, String nickname) {
			this.level = level;
			this.nickname = nickname;
		}

		@Override
		public int compareTo(User o) {
			// TODO Auto-generated method stub
			return this.nickname.compareTo(o.nickname);
		}
	}

	static int player, maxRoom, level, count;
	static String nickname;
	static ArrayList<Room> rooms = new ArrayList<>();;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		player = Integer.parseInt(st.nextToken());
		maxRoom = Integer.parseInt(st.nextToken());

		for (int i = 0; i < player; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			level = Integer.parseInt(st.nextToken());
			nickname = st.nextToken();
			boolean isEntered = false;
			
			for(Room room : rooms) {
				if(room.users.size() >= maxRoom) continue;
				
				int l =  room.users.get(0).level;
				if(!room.users.isEmpty() && l - 10 <= level && l + 10 >= level) {
					isEntered = true;
					room.users.add(new User(level, nickname));
					break;
				}
			}
			
			if(!isEntered) {
				Room room = new Room();
				room.users.add(new User(level, nickname));
				rooms.add(room);
			}
		}

		for (Room room : rooms) {
			Collections.sort(room.users);
			
			if (room.users.size() == maxRoom) {
				System.out.println("Started!");
			} else {
				System.out.println("Waiting!");
			}
			
			for(int i = 0; i < room.users.size(); i++) {
				System.out.println(room.users.get(i).level + " " + room.users.get(i).nickname);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
