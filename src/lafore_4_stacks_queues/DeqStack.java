package lafore_4_stacks_queues;

import lafore_4_stacks_queues.Deque;

public class DeqStack
{
	private Deque deque;
	
	public DeqStack(int s)
	{
		deque = new Deque(s);
	}
	
	public void push(long j)
	{
		deque.insertLeft(j);
	}
	
	public long pop()
	{
		return deque.removeLeft();
	}
	
	public boolean isEmpty()
	{
		return deque.isEmpty();
	}
	
	public boolean isFull()
	{
		return deque.isFull();
	}
}
