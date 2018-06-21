package lafore_5_linkedlists;

public class CyclicLinkedListStack
{
	private CyclicLinkedList list;
	
	public CyclicLinkedListStack()
	{
		list = new CyclicLinkedList();
	}
	
	public boolean isEmpty()
	{
		return list.isEmpty();
	}
	
	public void push(int id, double value)
	{
		list.insert(new Link(id, value));
	}
	
	public Link pop()
	{
		if (isEmpty())
			return null;
		else
			return list.delete();
	}
}
