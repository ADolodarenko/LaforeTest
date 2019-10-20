package lafore_5_linkedlists;

public class DoublyLinkedListDeque
{
	private DoublyLinkedList list;
	
	public DoublyLinkedListDeque()
	{
		list = new DoublyLinkedList();
	}
	
	public void insertLeft(long j)
	{
		list.insertFirst(j);
	}
	
	public long removeRight()         // take item from front of queue
	{
		return list.deleteLast().dData;
	}
	
	public void insertRight(long j)
	{
		list.insertLast(j);
	}
	
	public long removeLeft()         // take item from front of queue
	{
		return list.deleteFirst().dData;
	}
	
	public boolean isEmpty()
	{
		return list.isEmpty();
	}
	
	public int size()
	{
		return list.size();
	}
}
