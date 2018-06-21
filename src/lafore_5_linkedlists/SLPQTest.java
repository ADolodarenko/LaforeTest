package lafore_5_linkedlists;

public class SLPQTest
{
	public static void main(String[] args)
	{
		SortedListPriorityQueue queue = new SortedListPriorityQueue();
		queue.insert(100);
		queue.insert(12);
		queue.insert(56);
		queue.insert(777);
		queue.insert(33);
		
		if (!queue.isEmpty()) System.out.println(queue.peekMin());
		
		while (!queue.isEmpty()) System.out.println(queue.remove());
	}
}
