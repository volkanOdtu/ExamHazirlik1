package collections2;

import java.util.List;

//2.soru



public class GercekExam1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	 public int generalizedGCD(int num, int[] arr)
	 {
		 int mxDivider = 1;
		 int[] sortedArr = selectionSort(arr);
		 
		/* for(int x =0 ; x < sortedArr.length ; x++)
		 {
			 if( sortedArr[x])
		 }*/
		  
	        return 0;
	 }
	 
	 public int[] selectionSort(int[] theArray)
		{
			int minimum;
			int minimumIndex;
			int arraySize = theArray.length;
			
			for( int x =0 ; x < arraySize ; x++)
			{
				minimum =  theArray[x];
				minimumIndex = x;
				//Bu for loop tum dizideki minimum elemani buluyor
				for( int y = x ; y < arraySize ; y++)
				{
					if( theArray[y] < minimum  )
					{
						minimum = theArray[y];
						minimumIndex  = y;
					}
				}
				swapValues(x, minimumIndex,theArray);
			}
			
			return theArray;
		}

		public  void swapValues(int indexOne ,int indexTwo,int[] theArray)
		{
			int temp = theArray[indexOne];
			theArray[indexOne] = theArray[indexTwo];
			theArray[indexTwo] = temp;
		}
		static class Solution
		{
		    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
		    public int checkWinner(List<List<String>> codeList, 
		                           List<String> shoppingCart)
			{
		        // WRITE YOUR CODE HERE
		    	return 0;
		    }
		    // METHOD SIGNATURE ENDS
		}
}

