package lafore_14_weighted_graphs;

class Vertex
{
   public char label;        // label (e.g. 'A')
   public boolean isInTree;
   public LinkList adjacents;

   public Vertex(char lab)   // constructor
   {
      label = lab;
      isInTree = false;
      adjacents = new LinkList();
   }

   public void display()
   {
      System.out.print(label + ": ");

      adjacents.displayList();
   }
}

class Graph
{
   private final int MAX_VERTS = 20;
   private final int INFINITY = 1000000;
   private Vertex vertexList[]; // list of vertices
   private int nVerts;          // current number of vertices
   private int nTree;           // number of verts in tree
   private int currentVert;     // current vertex
   private int startToCurrent;  // distance to currentVert

   public Graph()               // constructor
   {
      vertexList = new Vertex[MAX_VERTS];

      nVerts = 0;
   }

   public void addVertex(char lab)
   {
      vertexList[nVerts++] = new Vertex(lab);
   }

   public void addEdge(int start, int end, int weight)
   {
   	  vertexList[start].adjacents.insertFirst(new Edge(weight, vertexList[end]));
   }

   public void display()
   {
      for (int i = 0; i < nVerts; i++)
         vertexList[i].display();
   }

}
////////////////////////////////////////////////////////////////
class PathApp
{
   public static void main(String[] args)
   {
      Graph theGraph = new Graph();
      theGraph.addVertex('A');     // 0
      theGraph.addVertex('B');     // 1
      theGraph.addVertex('C');     // 2  (start)
      theGraph.addVertex('D');     // 3
      theGraph.addVertex('E');     // 4

      theGraph.addEdge(0, 1, 50);  // AB 50
      theGraph.addEdge(0, 3, 80);  // AD 80
      theGraph.addEdge(1, 2, 60);  // BC 60
      theGraph.addEdge(1, 3, 90);  // BD 90
      theGraph.addEdge(2, 4, 40);  // CE 40
      theGraph.addEdge(3, 2, 20);  // DC 20
      theGraph.addEdge(3, 4, 70);  // DE 70
      theGraph.addEdge(4, 1, 50);  // EB 50

      System.out.println("Shortest paths");
      theGraph.display();
      System.out.println();
   }  // end main()
}
////////////////////////////////////////////////////////////////

