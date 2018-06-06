public class Deque
{
	private int maxSize;
	private long[] queArray;
	private int front;
	private int rear;
	private int nItems;
	
	public Deque(int s)
	{
		maxSize = s;
		queArray = new long[maxSize];
		nItems = 0;
		front = 0;
		rear = -1;
	}
	
	public void insertLeft(long j)
	{
		if (!isFull())
		{
			if (rear == maxSize - 1)         // deal with wraparound
				rear = -1;
			queArray[++rear] = j;         // increment rear and insert
			nItems++;                     // one more item
		}
	}
	
	public long removeRight()         // take item from front of queue
	{
		if (!isEmpty())
		{
			long temp = queArray[front++]; // get value and incr front
			if (front == maxSize)           // deal with wraparound
				front = 0;
			nItems--;                      // one less item
			return temp;
		}
		else return -1;
	}
	
	public void insertRight(long j)
	{
		if (!isFull())
		{
			if (front == 0 && rear == -1)         // deal with wraparound
			{
				queArray[front] = j;         // increment rear and insert
				rear = 0;
			}
			else if (front == 0)
				front = maxSize;
			
			queArray[--front] = j;
			
			nItems++;                     // one more item
		}
	}
	
	public long removeLeft()         // take item from front of queue
	{
		if (!isEmpty())
		{
			long temp = queArray[rear--];
			if (rear == -1)
				rear = maxSize - 1;
			
			nItems--;
			
			return temp;
		}
		else return -1;
	}
	
	public boolean isEmpty()
	{
		return (nItems == 0);
	}
	
	public boolean isFull()
	{
		return (nItems == maxSize);
	}
	
	public int size()
	{
		return nItems;
	}
}
