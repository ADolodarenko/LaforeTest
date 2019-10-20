package lafore_14_weighted_graphs;

public class Edge
{
	private int weight;
	private Vertex adjacent;

	public Edge(int weight, Vertex adjacent)
	{
		this.weight = weight;
		this.adjacent = adjacent;
	}

	public int getWeight()
	{
		return weight;
	}

	public Vertex getAdjacent()
	{
		return adjacent;
	}
}
