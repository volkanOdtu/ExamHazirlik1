package collections2;

import java.awt.font.NumericShaper;
import java.util.Random;

class Cell{
	int row;
	int column ;
	int number;
	boolean isBomb = false; // *
	boolean isExposed = false;// empty =0, 1 ,2
	boolean isGuess = false; //?
	
	public Cell(int row ,int colum) {
		this.row = row;
		this.column = colum;
		this.isBomb = false;
		this.number = 0;
	}
	public void setRowAndColumn(int row ,int column) {
		this.column = column;
		this.row = row;
	}
	public void setBomb(boolean isBomb) {
		this.isBomb = isBomb;
		number = -1;
	}
	public void incrementNumber() {
			number++;
	}
	public boolean isBlank() {
		return number==0;
	}
	public boolean isExposed() {
		return isExposed;
	}
	public boolean flip() {
		isExposed = true;
		return !isBomb;
	}
	public boolean isBomb() {
		return isBomb;
	}
	public boolean toggleGuess() {
		if(!isExposed)
			isGuess = !isGuess;
		
		return isGuess;
	}
	public String getSurfaceState() {
		if(isExposed)
			return getUndersideState();
		else if(isGuess)
			return "B";
		else
			return "? ";
	}
	public String getUndersideState() {
		if(isBomb)
			return "* ";
		else if (number > 0)
			return Integer.toString(number) + " ";
		else
			return " ";
	}
}

class Board{
	private int nrows;
	private int ncols;
	private int nbombs =0;
	Cell[][] cells;
	Cell[] bombs;
	int numUnxposedRemaining;
	
	public Board(int rows,int cols ,int bombs) {
		this.nrows = rows;
		this.ncols = cols;
		this.nbombs = bombs;
		initializeBoard();
		shuffleBoard();
		setNumberedCells();
		
		numUnxposedRemaining = nrows * ncols - nbombs;
	}
	private void initializeBoard() {
		cells = new Cell[nrows][ncols];
		bombs = new Cell[nbombs];
		
		for(int i=0 ;i < nrows; i++) {
			for(int j =0 ; j <ncols ; j++)
				cells[i][j] = new Cell(i, j);
		}
		
		for(int i=0 ; i< nbombs; i++) {
			int r = i/ ncols;
			int c = (i - r * ncols) % ncols;
			bombs[i]= cells[r][c]; //bomb array i cell[][] deki bi Cell e set ediliyo
			bombs[i].setBomb(true);
		}
	}
	
	private void shuffleBoard() {
		int nCells = nrows * ncols;
		Random random = new Random();
		for (int index1 = 0; index1 < nCells; index1++) {
			int index2 = index1 + random.nextInt(nCells - index1);
			if (index1 != index2) {
				/* Get cell at index1. */
				int row1 = index1 / ncols;
				int column1 = (index1 - row1 * ncols) % ncols;
				Cell cell1 = cells[row1][column1];
				
				/* Get cell at index2. */
				int row2 = index2 / ncols;
				int column2 = (index2 - row2 * ncols) % ncols;
				Cell cell2 = cells[row2][column2];
				
				/* Swap. */
				cells[row1][column1] = cell2;
				cell2.setRowAndColumn(row1, column1);
				cells[row2][column2] = cell1;
				cell1.setRowAndColumn(row2, column2);				
			}
		}
	}
	private boolean inBounds(int row ,int column) {
		return row >= 0 && row < nrows && column>=0 && column < ncols;
	}
	
	private void setNumberedCells() {
		int[][] deltas = { // Offsets of 8 surrounding cells
				{-1, -1}, {-1, 0}, {-1, 1},
				{ 0, -1},          { 0, 1},
				{ 1, -1}, { 1, 0}, { 1, 1}
		};
		for (Cell bomb : bombs) {
			int row = bomb.row;
			int col = bomb.column;
			for (int[] delta : deltas) {
				int r = row + delta[0];
				int c = col + delta[1];
				if (inBounds(r, c)) {
					cells[r][c].incrementNumber();
				}
			}
		}
	}
	private boolean flipCell(Cell cell) {
		if(!cell.isExposed && !cell.isGuess  ) {
			cell.flip();
			numUnxposedRemaining--;
			return true;
		}
		return false;
	}
	
	private void expandBlank(Cell cell) {
		
	}
}
	
public class MineSweeper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Cell[][] allCells = new Cell[2][3];
		
		for(int i=0 ; i< 2; i++)
			for(int j=0 ; j <3 ;j++) {
				allCells[i][j] = new Cell(i, j);
			}
		for(int x=0; x <2 ; x++)
			for(int y =0 ; y <3 ;y++)
				System.out.println((allCells[x][y]).row + ":" + (allCells[x][y]).column);
	}

}
