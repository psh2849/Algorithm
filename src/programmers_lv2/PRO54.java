package programmers_lv2;
import java.util.*;

public class PRO54 {

	public int[] solution(int[] fees, String[] records) {
        HashMap<String, Integer> intime = new HashMap<>();
        TreeMap<String ,Integer> result = new TreeMap<>();
        
        for(int i = 0; i < records.length;i++){ 
            String[] str = records[i].split(" ");
            String[] time = str[0].split(":");
            int getMinutes = Integer.valueOf(time[0]) * 60 + Integer.valueOf(time[1]);
            
            if(str[2].equals("IN")) {
                intime.put(str[1], getMinutes);
                if(!result.containsKey(str[1])) {
                    result.put(str[1], 0);
                } 
            } else {
                result.put(str[1], result.get(str[1]) + getMinutes - intime.get(str[1]));
                intime.remove(str[1]);
            }
        }
        
        intime.forEach((key, val) -> {
            result.put(key, result.get(key) + 23 * 60 + 59 - val);
        });
        
        
        int[] answer = new int[result.size()];
        int idx = 0;
        for(int val : result.values()) {
            answer[idx] = fees[1];
            if(val > fees[0]) {
                answer[idx] += Math.ceil((val - fees[0]) / (double)fees[2]) * fees[3];
            } 
            idx++;
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
