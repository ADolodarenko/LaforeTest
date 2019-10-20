package lafore_12_heaps;

public class AltHeapNode<T>
{
	private int key;
	private int value;
	private AltHeapNode parent;
	private AltHeapNode leftChild;
	private AltHeapNode rightChild;

	public AltHeapNode(int key, int value)
	{
		this.key = key;
		this.value = value;
	}

	public int getKey()
	{
		return this.key;
	}

	public void setKey(int key)
	{
		this.key = key;
	}

	public AltHeapNode getParent()
	{
		return parent;
	}

	public void setParent(AltHeapNode parent)
	{
		this.parent = parent;
	}

	public AltHeapNode getLeftChild()
	{
		return leftChild;
	}

	public void setLeftChild(AltHeapNode leftChild)
	{
		this.leftChild = leftChild;
	}

	public AltHeapNode getRightChild()
	{
		return rightChild;
	}

	public void setRightChild(AltHeapNode rightChild)
	{
		this.rightChild = rightChild;
	}

	public int getValue()
	{
		return value;
	}

	public void setValue(int value)
	{
		this.value = value;
	}
}
