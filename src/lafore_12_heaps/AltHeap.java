package lafore_12_heaps;

import java.util.Stack;

public class AltHeap
{
	private AltHeapNode root;
	private int heapSize;
	private int maxSize;
	private int maxPathLength;

	public AltHeap(int maxSize)
	{
		this.maxSize = maxSize;
		this.heapSize = 0;
		this.root = null;

		setMaxBinaryArrayLength();
	}

	public boolean isEmpty()
	{
		return heapSize == 0;
	}

	public boolean insert(int value)
	{
		if (isEmpty())
		{
			root = new AltHeapNode(++heapSize, value);

			return true;
		}
		else
		{
			if (heapSize == maxSize)
				return false;
			else
			{
				trickleUp(addNewNode(value));

				return true;
			}
		}
	}

	public AltHeapNode remove()
	{
		AltHeapNode oldRoot = this.root;

		moveLastNodeToRoot();
		trickleDown(this.root);

		return oldRoot;
	}

	public boolean change(int key, int newValue)
	{
		if (key < 0 || key > heapSize)
			return false;

		byte[] path = getPathToNode(key);

		AltHeapNode currentNode = root;
		for (int i = path.length - 2; i >= 0; i--)
		{
			if (path[i] == 1)
				currentNode = currentNode.getRightChild();
			else
				currentNode = currentNode.getLeftChild();
		}

		int oldValue = currentNode.getValue();
		currentNode.setValue(newValue);

		if(oldValue < newValue)
			trickleUp(currentNode);
		else
			trickleDown(currentNode);

		return true;
	}

	public void displayHeap()
	{
		Stack globalStack = new Stack();
		globalStack.push(root);
		int nBlanks = 32;
		boolean isRowEmpty = false;
		System.out.println("......................................................");
		while(isRowEmpty==false)
		{
			Stack localStack = new Stack();
			isRowEmpty = true;

			for(int j=0; j<nBlanks; j++)
				System.out.print(' ');

			while(globalStack.isEmpty()==false)
			{
				AltHeapNode temp = (AltHeapNode) globalStack.pop();
				if(temp != null)
				{
					System.out.print(temp.getValue() + "/" + temp.getKey());
					localStack.push(temp.getLeftChild());
					localStack.push(temp.getRightChild());

					if(temp.getLeftChild() != null ||
							temp.getRightChild() != null)
						isRowEmpty = false;
				}
				else
				{
					System.out.print("--");
					localStack.push(null);
					localStack.push(null);
				}
				for(int j=0; j<nBlanks*2-2; j++)
					System.out.print(' ');
			}  // end while globalStack not empty
			System.out.println();
			nBlanks /= 2;
			while(localStack.isEmpty()==false)
				globalStack.push( localStack.pop() );
		}  // end while isRowEmpty is false
		System.out.println("......................................................");
	}

	private void setMaxBinaryArrayLength()
	{
		int value = maxSize;
		int length = 0;

		while (value > 0)
		{
			length++;
			value >>= 1;
		}

		this.maxPathLength = length;
	}

	private AltHeapNode addNewNode(int value)
	{
		AltHeapNode newNode = new AltHeapNode(++heapSize, value);
		byte[] path = getPathToNode(heapSize);

		AltHeapNode parentNode = root;
		for (int i = path.length - 2; i > 0; i--)
		{
			if (path[i] == 1)
				parentNode = parentNode.getRightChild();
			else
				parentNode = parentNode.getLeftChild();
		}

		newNode.setParent(parentNode);

		if (path[0] == 1)
			parentNode.setRightChild(newNode);
		else
			parentNode.setLeftChild(newNode);

		return newNode;
	}

	private void moveLastNodeToRoot()
	{
		byte[] path = getPathToNode(heapSize);

		AltHeapNode bottomNode = root;
		for (int i = path.length - 2; i >= 0; i--)
		{
			if (path[i] == 1)
				bottomNode = bottomNode.getRightChild();
			else
				bottomNode = bottomNode.getLeftChild();
		}
		AltHeapNode parentNode = bottomNode.getParent();

		if (bottomNode == root)
			root = null;
		else
		{
			if (path[0] == 1)
				parentNode.setRightChild(null);
			else
				parentNode.setLeftChild(null);

			root.setValue(bottomNode.getValue());
		}

		heapSize--;
	}

	private byte[] getPathToNode(int key)
	{
		byte[] tempPath = new byte[maxPathLength];
		int number = key;
		int i = 0;

		while (number > 0)
		{
			tempPath[i++] = (byte) (number % 2);
			number = number / 2;
		}

		byte[] path = new byte[i];

		for (int j = 0; j < path.length; j++)
			path[j] = tempPath[j];

		return path;
	}

	private void trickleUp(AltHeapNode node)
	{
		AltHeapNode currentNode = node;
		AltHeapNode parentNode = currentNode.getParent();
		int bottomValue = currentNode.getValue();

		while ( currentNode != root &&
				parentNode.getValue() < bottomValue )
		{
			currentNode.setValue(parentNode.getValue());

			currentNode = parentNode;
			parentNode = parentNode.getParent();
		}

		currentNode.setValue(bottomValue);
	}

	private void trickleDown(AltHeapNode node)
	{
		int topValue = node.getValue();
		AltHeapNode currentNode = node;
		AltHeapNode leftChild = currentNode.getLeftChild();
		AltHeapNode rightChild = currentNode.getRightChild();
		AltHeapNode largerChild;

		while(leftChild != null || rightChild != null)
		{
			// find smaller child
			if(rightChild != null && ( leftChild.getValue() < rightChild.getValue() ))
				largerChild = rightChild;
			else
				largerChild = leftChild;
			// top >= largerChild?
			if( topValue >= largerChild.getValue() )
				break;
			// shift child up
			currentNode.setValue(largerChild.getValue());

			currentNode = largerChild;
			leftChild = currentNode.getLeftChild();
			rightChild = currentNode.getRightChild();
		}

		currentNode.setValue(topValue);
	}
}
