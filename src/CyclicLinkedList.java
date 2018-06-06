public class CyclicLinkedList
{
	private Link current;
	
	public CyclicLinkedList()
	{
		current = null;
	}
	
	public boolean isEmpty()
	{
		return current == null;
	}
	
	public Link getCurrent()
	{
		return current;
	}
	
	public void insert(Link element)
	{
		if (isEmpty())
			current = element;
		else
		{
			Link next = current.next;
			
			if (next != null)
				element.next = next;
			else
				element.next = current;
			
			current.next = element;
		}
	}
	
	public Link find(int id, double dd)
	{
		if (isEmpty())
			return null;
		else
		{
			Link element = current;
			
			while (true)
			{
				if (element.iData == id && element.dData == dd)
					return element;
				else
				{
					element = element.next;
					
					if (element == null || element == current)
						return null;
				}
			}
		}
	}
	
	public boolean step()
	{
		boolean result = false;
		
		if (!isEmpty())
			if (current.next != null)
			{
				current = current.next;
				
				result = true;
			}
		
		return result;
	}
	
	public Link delete()
	{
		Link result = null;
		
		if (!isEmpty())
		{
			Link next = current.next;
			
			if (next == null)
			{
				result = current;
				current = null;
			}
			else
			{
				result = next;
				
				if (next.next != current)
					current.next = next.next;
				else
					current.next = null;
			}
		}
		
		return result;
	}
	
	public void displayList()
	{
		if (isEmpty()) System.out.println("List is empty");
		else
		{
			System.out.print("List:");
			
			Link element = current;
			
			while (true)
			{
				System.out.print(String.format(" {%d, %3f}", element.iData, element.dData));
				
				element = element.next;
				
				if (element == null || element == current)
					break;
			}
			
			System.out.println();
		}
	}
}
