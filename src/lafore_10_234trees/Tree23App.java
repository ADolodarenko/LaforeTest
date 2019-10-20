package lafore_10_234trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
* Дерево 2-3. Поддерживает:
* вывод содержимого, поиск, вставку элементов, в том числе, если это требует разбиения
* родителя листового (разбиваемого) узла, т.е. метод split() - рекурсивный. insert() - до
* обнаржения узла никакие разбиения не выполняются. Предусмотрена возможность разбиения корневого узла, если он -
* листовой.*/
public class Tree23App
{
	public static void main(String[] args) throws IOException
	{
		long value;
		Tree23 tree = new Tree23();
		
		while(true)
		{
			System.out.print("Enter first letter of ");
			System.out.print("show, insert, find: ");
			char choice = getChar();
			switch(choice)
			{
				case 's':
					tree.displayTree();
					break;
				case 'i':
					System.out.print("Enter value to insert: ");
					value = getInt();
					
					tree.insert(value);
					
					break;
				case 'f':
					System.out.print("Enter value to find: ");
					value = getInt();
					
					int found = tree.find(value);
					
					if(found != -1)
						System.out.println("Found "+value);
					else
						System.out.println("Could not find "+value);
					break;
				default:
					System.out.print("Invalid entry\n");
			}
		}
		
	}
	
	public static String getString() throws IOException
	{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}
	
	public static char getChar() throws IOException
	{
		String s = getString();
		return s.charAt(0);
	}
	
	public static int getInt() throws IOException
	{
		String s = getString();
		return Integer.parseInt(s);
	}
}

class Tree23
{
	private Node root = new Node(3);
	
	public int find(long key)
	{
		Node curNode = root;
		int childNumber;
		while(true)
		{
			if(( childNumber=curNode.findItem(key) ) != -1)
				return childNumber;
			else if( curNode.isLeaf() )
				return -1;
			else
				curNode = getNextChild(curNode, key);
		}
	}
	
	public void insert(long dValue)
	{
		Node curNode = root;
		DataItem tempItem = new DataItem(dValue);
		
		while (true)
		{
			if (curNode.isLeaf())
				break;
			else
				curNode = getNextChild(curNode, dValue);
		}
		
		if (curNode.isFull())
			split(curNode, tempItem);
		else
			curNode.insertItem(tempItem);
	}
	
	public int split(Node thisNode, DataItem newItem)
	{
		Node parent;
		Node newRight = new Node(3);
		int itemIndexInParent, itemIndexInThis;
		
		DataItem[] items = {thisNode.removeItem(), thisNode.removeItem(), newItem};
		itemIndexInThis = sort3Items(items);
		
		Node child1 = thisNode.disconnectChild(1);
		Node child2 = thisNode.disconnectChild(2);
		
		thisNode.insertItem(items[0]);
		
		if(thisNode == root)
		{
			root = new Node(3);
			parent = root;
			root.connectChild(0, thisNode);
		}
		else
			parent = thisNode.getParent();
		
		if (parent.isFull())
			itemIndexInParent = split(parent, items[1]);
		else
		{
			itemIndexInParent = parent.insertItem(items[1]);
			int n = parent.getNumItems();
			
			for(int j = n - 1; j > itemIndexInParent; j--)
			{
				Node temp = parent.disconnectChild(j);
				parent.connectChild(j + 1, temp);
			}
		}
		
		parent.connectChild(itemIndexInParent + 1, newRight);
		
		newRight.insertItem(items[2]);
		newRight.connectChild(0, child1);
		newRight.connectChild(1, child2);
		
		return itemIndexInThis;
	}
	
	private int sort3Items(DataItem[] items)
	{
		int result = 2;
		
		if (items[0].dData > items[1].dData)
		{
			DataItem tmpItem = items[0];
			items[0] = items[1];
			items[1] = tmpItem;
		}
		
		if (items[0].dData > items[2].dData)
		{
			DataItem tmpItem = items[0];
			items[0] = items[2];
			items[2] = tmpItem;
			
			result = 0;
		}
		
		if (items[1].dData > items[2].dData)
		{
			DataItem tmpItem = items[1];
			items[1] = items[2];
			items[2] = tmpItem;
			
			if (result == 2)
				result = 1;
		}
		
		return result;
	}
	
	public Node getNextChild(Node theNode, long theValue)
	{
		int j;
		
		int numItems = theNode.getNumItems();
		for(j=0; j<numItems; j++)
		{
			if( theValue < theNode.getItem(j).dData )
				return theNode.getChild(j);
		}
		return theNode.getChild(j);
	}
	
	public void displayTree()
	{
		recDisplayTree(root, 0, 0);
	}
	
	private void recDisplayTree(Node thisNode, int level,
								int childNumber)
	{
		System.out.print("level="+level+" child="+childNumber+" ");
		thisNode.displayNode();
		
		int numItems = thisNode.getNumItems();
		for(int j = 0; j < numItems + 1; j++)
		{
			Node nextNode = thisNode.getChild(j);
			if (nextNode != null)
				recDisplayTree(nextNode, level+1, j);
			else
				return;
		}
	}
}