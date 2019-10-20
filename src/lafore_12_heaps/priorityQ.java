// priorityQ.java
// demonstrates priority queue
// to run this program: C>java PriorityQApp
package lafore_12_heaps;

////////////////////////////////////////////////////////////////
class PriorityQ
{
	private Heap elements;

	//-------------------------------------------------------------
	public PriorityQ(int maxSize)
	{
		elements = new Heap(maxSize);
	}
	//-------------------------------------------------------------
	public void insert(int item)    // insert item
	{
		elements.insert(item);
	}  // end insert()
	//-------------------------------------------------------------
	public int remove()             // remove maximum item
	{
		return elements.remove().getKey();
	}
	//-------------------------------------------------------------
	public int peekMax()            // peek at maximum item
	{
		Node maxNode = elements.peekFirst();

		if (maxNode == null)
			return -1;
		else
			return maxNode.getKey();
	}
	//-------------------------------------------------------------
	public boolean isEmpty()         // true if queue is empty
	{
		return elements.isEmpty();
	}
	//-------------------------------------------------------------
	public boolean isFull()          // true if queue is full
	{
		return elements.isFull();
	}
//-------------------------------------------------------------
}  // end class PriorityQ

class PriorityQAlt
{
	private Tree elements;

	//-------------------------------------------------------------
	public PriorityQAlt()
	{
		elements = new Tree();
	}
	//-------------------------------------------------------------
	public void insert(int item)    // insert item
	{
		elements.insert(item, item);
	}  // end insert()
	//-------------------------------------------------------------
	public int remove()             // remove maximum item
	{
		return elements.removeMax();
	}
	//-------------------------------------------------------------
	public int peekMax()            // peek at maximum item
	{
		return elements.peekMax();
	}
	//-------------------------------------------------------------
	public boolean isEmpty()         // true if queue is empty
	{
		return elements.isEmpty();
	}
	//-------------------------------------------------------------
	public boolean isFull()          // true if queue is full
	{
		return elements.isFull();
	}
//-------------------------------------------------------------
}
////////////////////////////////////////////////////////////////
class PriorityQApp
{
	public static void main(String[] args)
	{
		PriorityQAlt thePQ = new PriorityQAlt();
		thePQ.insert(30);
		thePQ.insert(50);
		thePQ.insert(10);
		thePQ.insert(40);
		thePQ.insert(20);

		while( !thePQ.isEmpty() )
		{
			int item = thePQ.remove();
			System.out.print(item + " ");  // 50, 40, 30, 20, 10
		}  // end while
		System.out.println("");
	}  // end main()
//-------------------------------------------------------------
}  // end class PriorityQApp
////////////////////////////////////////////////////////////////
