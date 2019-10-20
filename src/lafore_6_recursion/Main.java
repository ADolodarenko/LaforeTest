package lafore_6_recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main
{
	public static void main(String[] args)
	{
		treeShowTest();
		
		//multTest();
		
		//utilBackpackTest();
		
		//utilPowerTest();
	}
	
	private static void treeShowTest()
	{
		TreeShow show = new TreeShow(16);
		show.makeBranches(0, show.getRowLength(), 0);
		show.display();
	}
	
	private static void multTest()
	{
		final String messageX = "Give me the x: ";
		final String messageY = "Give me the y: ";
		
		int x = getInt(messageX);
		int y = getInt(messageY);
		
		while (x > 0 && y > 0)
		{
			System.out.println(Util.mult(x, y));
			
			x = getInt(messageX);
			y = getInt(messageY);
		}
	}
	
	private static void utilBackpackTest()
	{
		int[] sourceKit = {11, 8, 7, 6, 5};
		int[] destKit = new int[sourceKit.length];
		
		Util.backpack(sourceKit, 0, destKit, 0, 20);
		
		for (int i = 0; i < destKit.length; i++)
			if (destKit[i] > 0)
				System.out.print(destKit[i] + " ");
			else
				break;
	}
	
	private static void utilPowerTest()
	{
		final String messageX = "Give me the x: ";
		final String messageY = "Give me the y: ";
		
		int x = getInt(messageX);
		int y = getInt(messageY);
		
		while (x > 0 && y > 0)
		{
			System.out.println(Util.power(x, y));
			
			x = getInt(messageX);
			y = getInt(messageY);
		}
	}
	
	static int getInt(String message)
	{
		System.out.print(message);
		
		int result = 0;
		
		try
		{
			result = Integer.parseInt(getString());
		}
		catch (NumberFormatException e)
		{}
	
		return result;
	}
	
	static String getString()
	{
		String result = null;
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try
		{
			result = reader.readLine();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return result;
	}
}
