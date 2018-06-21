package lafore_6_recursion;

public class TreeShow
{
	private int rowLength;
	private char[][] chars;
	
	public TreeShow(int rowLength)
	{
		this.rowLength = rowLength;
		
		int rowsQnt = (int)(Math.log(this.rowLength)/Math.log(2)) + 1;
		
		chars = new char[rowsQnt][this.rowLength];
	}
	
	public int getRowLength()
	{
		return rowLength;
	}
	
	public void makeBranches(int left, int right, int currentRow)
	{
		if (currentRow > chars.length - 1)
			return;
		else
		{
			int length = right - left;
			int middle = length/2;
			
			for (int i = left; i < right; i++)
				chars[currentRow][i] = '-';
			
			chars[currentRow][left + middle] = 'X';
			
			makeBranches(left, left + middle, currentRow + 1);
			makeBranches(left + middle, right, currentRow + 1);
		}
	}
	
	public void display()
	{
		for (int i = 0; i < chars.length; i++)
		{
			for (int j = 0; j < chars[i].length; j++)
				System.out.print(chars[i][j]);
			
			System.out.println();
		}
	}
}
