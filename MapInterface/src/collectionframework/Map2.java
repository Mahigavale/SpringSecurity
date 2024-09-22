package collectionframework;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Map2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
//		Map<Integer,Integer> mp2=new TreeMap<Integer,Integer>();
//		
//		mp2.put(23, 23);
//		mp2.put(2, 67);
//		mp2.put(3, 64);
//		
//		//sort =Ascending order :=store
//		System.out.println(mp2);
		
		
		 PriorityQueue<Integer> q1=new PriorityQueue<Integer>();
		q1.add(34);
		q1.add(12);
		q1.add(23);
		q1.add(3);
		q1.add(22);
		q1.add(45);
		//peek :head dosen't remove.
		//poll : head remove,modifies queue.
		
		System.out.println(q1);
		System.out.println(q1.peek());
		
		System.out.println(q1.poll());
		System.out.println(q1);
		//Comparator comp=q1.comparator();
		
		//System.out.println(q1);
	}
	

}
