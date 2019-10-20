package lafore_14_weighted_graphs;

public class Link
{
	private Edge edge;
	private Link next;

	public Link(Edge edge)
	{
		this.edge = edge;
	}

	public void displayLink()
	{
		System.out.print("{" + edge.getWeight() + "=>" + edge.getAdjacent().label + ")} ");
	}

	public Link getNext()
	{
		return next;
	}

	public void setNext(Link next)
	{
		this.next = next;
	}
}
