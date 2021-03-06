package hatirlama2;

import java.security.AllPermission;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//Java program to Print all possible paths from 
//top left to bottom right of a mXn matrix

class NodeG{
	NodeG left,right;
	
	int x ,y;
	public NodeG(int x ,int y) {
		this.x = x; this.y = y;
	}
}
public class Udemy 
{


	/* mat: Pointer to the starting of mXn matrix
i, j: Current position of the robot (For the first call use 0,0)
m, n: Dimentions of given the matrix
pi: Next index to be filed in path array
*path[0..pi-1]: The path traversed by robot till now (Array to hold the
				path need to have space for at least m+n elements) */
	static ArrayList<int[]> allPaths = new ArrayList<int[]>();
	static int yMax, xMax;
	
	private static void printArr(int path[]) {
		
		for (int l = 0; l < path.length; l++) 
		{
			System.out.print(path[l] + " ");
		}
					
		System.out.println();
	}
	private static void printMatrix(int matrix[][],  int y, int x, int paths[], int pathItemIndex)
	{
		paths[pathItemIndex] = matrix[y][x];
		
		// Reached the bottom of the matrix so we are left with only option to move right
		if (y == yMax - 1) 
		{
			for (int xCurr = x + 1; xCurr < xMax; xCurr++) //sirayla sona dogru ekliyoruz
			{
				paths[pathItemIndex + (xCurr - x)] = matrix[y][xCurr];
			}
			printArr(paths);
			return;
		}
		
		// Reached the right corner of the matrix we are left with only the downward movement.
		if (x == xMax - 1) 
		{
			for (int yCurr = y + 1; yCurr < yMax; yCurr++) 
			{
				paths[pathItemIndex + (yCurr - y)] = matrix[yCurr][x];
			}
			printArr(paths);
			return;
		}
		
		printMatrix(matrix,  y + 1, x, paths, pathItemIndex + 1);// Print all the paths that are possible after moving down		
		printMatrix(matrix,  y, x + 1, paths, pathItemIndex + 1); // Print all the paths that are possible after moving right
	}
	static int pathCount =0;
	
	static void findPaths(Stack<NodeG> nodes ,NodeG currNode ,List<NodeG> nodesInPath)  {
		if(currNode == null ) return;
		
		nodesInPath.add(currNode);
		
		if(currNode.x == 2 && currNode.y == 2)
			pathCount++;
		
		findPaths(nodes, currNode.left, nodesInPath);
		findPaths(nodes, currNode.right, nodesInPath);
		
	}
	// Driver code
	public static void main(String[] args) 
	{
		yMax = 3;
		xMax = 3;
		int matrix[][] = { { 1, 2, 3 }, 
						   { 4, 5, 6 },
						   { 7, 8, 9 }};
		
		int pathLength = yMax + xMax- 1;
		int[] paths = new int[pathLength];
		
		
		
		printMatrix(matrix, 0, 0, paths , 0);
		
	}
}

