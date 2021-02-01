package hatirlama2;

import java.util.Random;

public class Apocalypse {

	public static void main(String[] args) {
		 int boys =0 ;
		 int  girls = 0;
		 
		 int n = 10;//10 aile varsayalim
		 
		//Returning array 2 elemanli {3 ,5} gibi 0. ve 1. elemanini soyle alabiliyoruz
		 for(int i =0 ; i< n; i++) {
			 int[] genders = runOneFamily(); 
			 girls += genders[0];
			 boys  += genders[1];
		 }
		 
		 double avg = girls / (girls + boys) ;

		 System.out.println(avg);
	}
	
	static int[] runOneFamily() {
		Random random = new Random();
		int boys=0;
		int girls =0;
		
		while(girls ==0) {// untill we have a girl ,1 olunca loop durur
			if( random.nextBoolean()) //random true false degeri uretiyoruz
				girls = 1;
			else
				boys +=1;
		}
		
		int[] genders = { girls ,boys};
		
		return genders;		
	}

}
