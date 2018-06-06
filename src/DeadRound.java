public class DeadRound
{
	private static final String TITLE = "Dead round: ";
	
	private int amount;
	private int firstNumber;
	private int step;
	private int theLast;
	
	private CyclicLinkedList list;
	
	public DeadRound(int amount, int firstNumber, int step)
	{
		checkParameters(amount, firstNumber, step);
		
		this.amount = amount;
		this.firstNumber = firstNumber;
		this.step = step;
		
		this.theLast = -1;
	}
	
	private void checkParameters(int amount, int firstNumber, int step)
	{
		if (amount < 1 || firstNumber < 1 || firstNumber > amount || step < 1)
			throw new IllegalArgumentException("Wrong parameters for round.");
	}
	
	public void start()
	{
		if (findFirst())
			dropElements();
		
		showTheLast();
	}
	
	private boolean findFirst()
	{
		boolean result = false;
		
		if (amount > 1)
		{
			createList();
			setInitialPosition();
			
			result = true;
		}
		else
			theLast = 1;
		
		return result;
	}
	
	private void setInitialPosition()
	{
		if (list != null)
		{
			Link current = list.getCurrent();
			
			while (current.iData != firstNumber)
			{
				list.step();
				
				current = list.getCurrent();
			}
		}
	}
	
	private void createList()
	{
		list = new CyclicLinkedList();
		
		list.insert(new Link(1, 1.0));
		
		for (int i = amount; i > 1; i--)
			list.insert(new Link(i, i));
	}
	
	private void dropElements()
	{
		if (list != null)
		{
			Link current = list.getCurrent();
			
			while (current.next != null)
			{
				for (int i = 1; i < step; i++)
					list.step();
				
				Link dead = list.delete();
				System.out.println(TITLE + "number " + dead.iData + " is dead.");
				
				list.step();
				
				current = list.getCurrent();
			}
			
			theLast = current.iData;
		}
	}
	
	private void showTheLast()
	{
		System.out.println(TITLE + "the last number is " + theLast);
	}
}
