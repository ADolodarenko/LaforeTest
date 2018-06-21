package lafore_5_linkedlists;

public class CyclicLinkedListStackTest
{
	public static void main(String[] args)
	{
		CyclicLinkedListStack stack = new CyclicLinkedListStack();
		
		stack.push(12, 100);
		stack.push(11, 250);
		stack.push(8, 45);
		
		while (!stack.isEmpty())
		{
			Link element = stack.pop();
			System.out.println(String.format("{%d, %3f}", element.iData, element.dData));
		}
	}
}
