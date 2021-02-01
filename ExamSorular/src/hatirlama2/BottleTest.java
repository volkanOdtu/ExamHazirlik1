package hatirlama2;

import java.util.ArrayList;
import java.util.Random;

class Bottle{
	int id;
	boolean poisoned = false;
	
	public Bottle(int id) {
		this.id = id;
	}

	public int getId() { return id; }

	public void setId(int id) { this.id = id; }

	public boolean isPoisoned() { return poisoned; }

	public void setPoisoned(boolean poisoned) { this.poisoned = poisoned;}	
}
class TestStrip{
	public static int DAYS_FOR_RESULT = 7;
	private ArrayList<ArrayList<Bottle>> dropsByDay = new ArrayList<ArrayList<Bottle>>();
	private int id;
	
	public TestStrip(int id) {
		this.id = id;
	}
	public int getId() {
		return this.id;
	}
	//Resize list of days/drops to be large enough
	public void sizeDropsForDay(int day) {
		while(dropsByDay.size() <= day)
			dropsByDay.add(new ArrayList<Bottle>());
	}
	//add drop from bottle on specific day
	public void addDropOnDay(int day ,Bottle bottle) {
		sizeDropsForDay(day);
		ArrayList<Bottle> drops =  dropsByDay.get(day);
		drops.add(bottle);
	}
	//Checks if any of the bottles in the set are poisoned
	private boolean hasPoison(ArrayList<Bottle> bottles) {
		for(Bottle b:bottles) {
			if(b.isPoisoned()) return true;
		}
		return false;
	}
	
	public ArrayList<Bottle> getLastWeeksBottles(int day){
		if( day < DAYS_FOR_RESULT)
			return null;
		
		return dropsByDay.get(day -DAYS_FOR_RESULT);
	}
	//Checks for poisoned bottles since before DAYS_FOR_RESULT
	public boolean isPositiveOnDay(int day) {
		int testDay = day - DAYS_FOR_RESULT;
		
		if(testDay < 0 || testDay >= dropsByDay.size())
			return false;
		for(int d =0; d <= testDay ;d++) {
			ArrayList<Bottle> bottles = dropsByDay.get(d);
			if(hasPoison(bottles))
				return true;
		}
		return false;
	}
}
public class BottleTest {

	static int findPoisonedBottle(ArrayList<Bottle> bottles ,ArrayList<TestStrip> testStrips) {
		int today =0;
		while( bottles.size() > 1 && testStrips.size() >0) {
			runTestSet(bottles ,testStrips, today);
			//Wait for results
			today+= TestStrip.DAYS_FOR_RESULT;
			
			for( TestStrip testStrip:testStrips) {
				if(testStrip.isPositiveOnDay(today)){
					bottles = testStrip.getLastWeeksBottles(today);
					testStrips.remove(testStrip);
					break;
				}
			}
		}
		
		if(bottles.size() == 1) {
			System.out.println("Suspected bottle is " + bottles.get(0).getId() +  " on day " + today );
			return bottles.get(0).getId();
		}
		return -1;
	}
	static void runTestSet(ArrayList<Bottle> bottles ,ArrayList<TestStrip> testStrips ,int day) {
		int index =0;
		
		for(Bottle bottle:bottles) {
			TestStrip testStrip = testStrips.get(index);
			testStrip.addDropOnDay(day, bottle);
			index = (index + 1) % testStrips.size();
		}
	}
	
	public static ArrayList<Bottle> createBottles(int nBottles, int poisoned) {
		ArrayList<Bottle> bottles = new ArrayList<Bottle>();
		for (int i = 0; i < nBottles; i++) {
			bottles.add(new Bottle(i));
		}
		
		if (poisoned == -1) {
			Random random = new Random();
			poisoned = random.nextInt(nBottles);
		}
		bottles.get(poisoned).setPoisoned(true);
		
		System.out.println("Added poison to bottle " + poisoned);
		
		return bottles;
	}
	
	public static ArrayList<TestStrip> createTestStrips(int nTestStrips) {
		ArrayList<TestStrip> testStrips = new ArrayList<TestStrip>();
		for (int i = 0; i < nTestStrips; i++) {
			testStrips.add(new TestStrip(i));
		}
		return testStrips;
	}
	
	public static void main(String[] args) {
	
		int nBottles = 1000;
		int nTestStrips = 10;
		
		for (int poisoned = 0; poisoned < nBottles; poisoned++) {
			ArrayList<Bottle> bottles = createBottles(nBottles, poisoned);
			ArrayList<TestStrip> testStrips = createTestStrips(nTestStrips);
			
			int poisonedId = findPoisonedBottle(bottles, testStrips);
			
			System.out.println("Suspected Bottle: " + poisonedId);
			
			if (poisonedId != poisoned) {
				System.out.println("ERROR");
				break;
			}
		}
	}

}
