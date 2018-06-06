import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FlaviumTask
{
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args)
	{
		System.out.print("Set number of soldiers in the round: ");
		int amount = getNumber();
		
		System.out.print("Set the start number in the round: ");
		int first = getNumber();
		
		System.out.print("Set the step in the round: ");
		int step = getNumber();
		
		DeadRound round = new DeadRound(amount, first, step);
		
		if (round != null)
			round.start();
	}
	
	static int getNumber()
	{
		int result = 0;
		
		try
		{
			result = Integer.parseInt(reader.readLine());
		}
		catch (NumberFormatException e){}
		catch (IOException e){}
		
		return result;
	}
}
