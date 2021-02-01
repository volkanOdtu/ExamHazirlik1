package collections;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample extends Thread {

	//static HashMap<Integer,String> mHashMap =new HashMap<Integer,String>();
	static ConcurrentHashMap<Integer, String> mHashMap =new ConcurrentHashMap<Integer,String>();
	
	public void run() { 
		 try {
			 Thread.sleep(1000);
			 mHashMap.put(103, "D");
			
		} catch (Exception e) {
			System.out.println("Child Thread going to add element"); 
		}
	 }
	 
	 
	public static void main(String[] args) throws InterruptedException {
	
		mHashMap.put(100, "A");
		mHashMap.put(101, "B");
		mHashMap.put(102, "C");
		ConcurrentHashMapExample ex = new ConcurrentHashMapExample();
		ex.start();
		
		for( Object o : mHashMap.entrySet() ) {
			Object temp = o;
			System.out.println(o);
			Thread.sleep(1000);
		}
		System.out.println(mHashMap);
		
	}

}
