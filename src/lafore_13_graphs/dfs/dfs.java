package lafore_13_graphs.dfs;


class StackX
{
   private final int SIZE = 20;
   private int[] st;
   private int top;

   public StackX()
   {
      st = new int[SIZE];
      top = -1;
   }

   public void push(int j)
   {
      st[++top] = j;
   }

   public int pop()
   {
      return st[top--];
   }

   public int peek()
   {
      return st[top];
   }

   public boolean isEmpty()
   {
      return (top == -1);
   }
}

class Vertex
{
   public char label;
   public boolean wasVisited;

   public Vertex(char lab)
   {
      label = lab;
      wasVisited = false;
   }
}

class Graph
{
	private final int MAX_VERTS = 20;
	private Vertex vertexList[];
	private LinkList[] adjacents;
	private int nVerts;
	private StackX theStack;

	public Graph()
	{
		vertexList = new Vertex[MAX_VERTS];

		adjacents = new LinkList[MAX_VERTS];
		nVerts = 0;
		for (int y = 0; y < MAX_VERTS; y++)
			adjacents[y] = new LinkList();

		theStack = new StackX();
	}

	public void addVertex(char lab)
	{
		vertexList[nVerts++] = new Vertex(lab);
	}

	public void addEdge(int start, int end)
	{
		adjacents[start].insertFirst(end, vertexList[end]);
		adjacents[end].insertFirst(start, vertexList[start]);
	}

	public void addOneWayEdge(int start, int end)
	{
		adjacents[start].insertFirst(end, vertexList[end]);
	}

	public void displayVertex(int v)
	{
		System.out.print(vertexList[v].label);
	}

	public void dfs()
	{
		dfs(0);
	}

	public void dfs(int start)
	{
		vertexList[start].wasVisited = true;
		displayVertex(start);
		theStack.push(start);

		while ( !theStack.isEmpty() )
		{
			int v = getAdjUnvisitedVertex(theStack.peek());
			if (v == -1)
				theStack.pop();
			else
			{
				vertexList[v].wasVisited = true;
				displayVertex(v);
				theStack.push(v);
			}
		}

		for (int j = 0; j < nVerts; j++)
			vertexList[j].wasVisited = false;
	}

	public void displayConnectednessTable()
	{
		for (int i = 0; i < nVerts; i++)
		{
			dfs(i);

			System.out.println();
		}
	}

	public int getAdjUnvisitedVertex(int v)
	{
		Link link = adjacents[v].find();

		if (link != null)
			return link.getKey();

		return -1;
	}
}

class DFSApp
{
   public static void main(String[] args)
   {
      Graph theGraph = new Graph();
      theGraph.addVertex('A');    // 0  (start for dfs)
      theGraph.addVertex('B');    // 1
      theGraph.addVertex('C');    // 2
      theGraph.addVertex('D');    // 3
      theGraph.addVertex('E');    // 4

      /*theGraph.addEdge(0, 1);     // AB
      theGraph.addEdge(1, 2);     // BC
      theGraph.addEdge(0, 3);     // AD
      theGraph.addEdge(3, 4);     // DE

      System.out.print("Visits: ");
      theGraph.dfs();             // depth-first search*/


      theGraph.addOneWayEdge(1, 0);  //BA
      theGraph.addOneWayEdge(0, 2);  //AC
      theGraph.addOneWayEdge(1, 4);  //BE
      theGraph.addOneWayEdge(4, 2);  //EC
      theGraph.addOneWayEdge(3, 4);  //DE

	   System.out.println("Edge connectedness table:");
	   theGraph.displayConnectednessTable();

      System.out.println();
   }
}
