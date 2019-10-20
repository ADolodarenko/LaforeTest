package lafore_5_linkedlists;

public class SortedListPriorityQueue
{
	private SortedList list;
	
	public SortedListPriorityQueue()          // constructor
	{
		list = new SortedList();
	}
	
	public void insert(long item)    // insert item
	{
		list.insert(item);
	}
	
	public long remove()             // remove minimum item
	{
		return list.remove().dData;
	}
	
	public long peekMin()            // peek at minimum item
	{
		return list.peek().dData;
	}
	
	public boolean isEmpty()         // true if queue is empty
	{
		return list.isEmpty();
	}
	
	public void display()
	{
		list.displayList();
	}
}
