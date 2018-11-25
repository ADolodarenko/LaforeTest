package lafore_11_hashtables.tree;

public class HashTable
{
	private Tree[] hashArray;   // array of trees
	private int arraySize;

	public HashTable(int size)        // constructor
	{
		arraySize = size;
		hashArray = new Tree[arraySize];  // create array
		for(int j=0; j < arraySize; j++)          // fill array
			hashArray[j] = new Tree();     // with lists
	}
	// -------------------------------------------------------------
	public void displayTable()
	{
		for(int j = 0; j < arraySize; j++) // for each cell,
		{
			System.out.print(j + ". "); // display cell number
			hashArray[j].displayTree(); // display list
		}
	}
	// -------------------------------------------------------------
	public int hashFunc(int key)      // hash function
	{
		return key % arraySize;
	}
	// -------------------------------------------------------------
	public void insert(Node theNode)  // insert a node
	{
		int key = theNode.iData;
		double value = theNode.dData;
		int hashVal = hashFunc(key);   // hash the key
		hashArray[hashVal].insert(key, value); // insert at hashVal
	}  // end insert()
	// -------------------------------------------------------------
	public void delete(int key)       // delete a node
	{
		int hashVal = hashFunc(key);   // hash the key
		hashArray[hashVal].delete(key); // delete node
	}  // end delete()
	// -------------------------------------------------------------
	public Node find(int key)         // find node
	{
		int hashVal = hashFunc(key);   // hash the key
		Node theNode = hashArray[hashVal].find(key);  // get node
		return theNode;                // return node
	}
}
