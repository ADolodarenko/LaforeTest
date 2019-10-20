package lafore_14_weighted_graphs;

public class LinkList
{
	private Link first;

	public LinkList()
	{
		first = null;
	}

	public boolean isEmpty()
	{
		return (first == null);
	}

	public void insertFirst(Edge edge)
	{
		Link newLink = new Link(edge);
		newLink.setNext(first);
		first = newLink;
	}

	public Link deleteFirst()
	{
		if (first == null)
			return null;
		else
		{
			Link temp = first;
			first = first.getNext();
			return temp;
		}
	}

	public void displayList()
	{
		Link current = first;

		while (current != null)
		{
			current.displayLink();
			current = current.getNext();
		}

		System.out.println();
	}
}
