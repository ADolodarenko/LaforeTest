package lafore_6_recursion;

import java.util.Arrays;

public class Util
{
	public static long power(int x, int y)
	{
		long result;
		
		if (y == 1)
			result = x;
		else
		{
			result = power(x * x, y/2);
			
			if (y % 2 != 0)
				result = result * x;
		}
		
		return result;
	}
	
	public static boolean backpack(int[] sourceKit, int sourceIndex,
								int[] destKit, int destIndex, int destWeight)
	{
		for (int i = sourceIndex; i < sourceKit.length; i++)
		{
			destKit[destIndex] = sourceKit[i];
			
			System.out.print(Arrays.toString(destKit) + ": ");
			
			int diff = destWeight - destKit[destIndex];
			
			System.out.println("target weight: " + diff);
			
			if (diff == 0)
				return true;
			
			if (diff > 0)
				if (backpack(sourceKit, i + 1, destKit, destIndex + 1, diff))
					return true;
			
			destKit[destIndex] = 0;
		}
		
		return false;
	}
	
	public static long mult(int x, int y)
	{
		if (y == 1)
			return x;
		else
			return x + mult(x, y - 1);
	}
}
