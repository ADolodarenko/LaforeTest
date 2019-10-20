package lafore_4_stacks_queues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Cashbox
{
	private BufferedReader reader;
	private Queue[] boxes;
	
	public static void main(String[] args) throws IOException
	{
		new Cashbox().run();
	}
	
	public Cashbox()
	{
		initReader();
	}
	
	void run() throws IOException
	{
		long value;
		int number = getNumber("Input number of cashboxes");
		
		boxes = new Queue[number];
		
		number = getNumber("Input the size of a cashbox");
		
		for (int i = 0; i < boxes.length; i++)
			boxes[i] = new Queue(number);
		
		String input;
		while (!"exit".equals(input = getString("Input a command")))
		{
			displayCashboxes();
			
			switch (input)
			{
				case "client":
					value = getLong("Client value");
					number = getNumber("Which cashbox - [0-" + (boxes.length - 1) + "]");
					boxes[number].insert(value);
					break;
				case "proc":
					processCashboxes();
					break;
			}
		}
		
		closeReader();
	}
	
	private void processCashboxes()
	{
		int number = (int)(Math.random() * boxes.length * 10);
		
		for (int i = 0; i < boxes.length; i++)
			if (i == number)
			{
				long value = boxes[i].remove();
				System.out.println(value + " in the cashbox " + i + " has been processed.");
				
				break;
			}
	}
	
	private void displayCashboxes()
	{
		for (Queue box : boxes)
			box.display();
	}
	
	void initReader()
	{
		reader = new BufferedReader(new InputStreamReader(System.in));
	}
	
	void closeReader() throws IOException
	{
		reader.close();
	}
	
	String getString(String prompt) throws IOException
	{
		System.out.print(prompt + ": ");
		return reader.readLine();
	}
	
	int getNumber(String prompt) throws IOException
	{
		return Integer.parseInt(getString(prompt));
	}
	
	long getLong(String prompt) throws IOException
	{
		return Long.parseLong(getString(prompt));
	}
}
