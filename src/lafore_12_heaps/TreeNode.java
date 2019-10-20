package lafore_12_heaps;

public class TreeNode
{
	public int iData;              // data item (key)
	public double dData;           // data item
	public TreeNode leftChild;         // this node's left child
	public TreeNode rightChild;        // this node's right child

	public void displayNode()      // display ourself
	{
		System.out.print('{');
		System.out.print(iData);
		System.out.print(", ");
		System.out.print(dData);
		System.out.print("} ");
	}
}  // end class TreeNode
