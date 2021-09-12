/*
 * 14003. 가장 긴 증가하는 부분 수열 5 
 */
package binarySearch;
import java.io.*;
import java.util.*;

public class BOJ14003{

    static int N;
    static ArrayList<Integer> list= new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
       
        N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] saveIndex = new int[N];
       
        
        list.add(Integer.MIN_VALUE);
        
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++) {
            if(list.get(list.size()-1) < arr[i]) {
                list.add(arr[i]);
                saveIndex[i] = list.size() - 1;
            }
            else {
                int left = 1;
                int right = list.size() - 1;

                while (left < right) {
                    int mid = (left + right) / 2;
                    if(list.get(mid) < arr[i]) {
                        left = mid + 1;
                    }else {
                        right = mid;
                    }
                }
                list.set(right, arr[i]);
                saveIndex[i] = right;
            }
        }
        sb.append(list.size() - 1 + "\n");

        int index = list.size() - 1;
        Stack<Integer> stack = new Stack<>();
        
        for(int i = N-1; i >= 0; i--) {
            if(saveIndex[i] == index) {
                index--;
                stack.push(arr[i]);
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }
        
        System.out.println(sb);
    }
}
