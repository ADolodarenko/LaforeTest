package lafore_13_graphs.warshall;

class StackX
{
   private final int SIZE = 20;
   private int[] st;
   private int top;

   public StackX()
   {
      st = new int[SIZE];    // make array
      top = -1;
   }

   public void push(int j)
   {
      st[++top] = j;
   }

   public int pop()          // take item off stack
   {
      return st[top--];
   }

   public int peek()         // peek at top of stack
   {
      return st[top];
   }

   public boolean isEmpty()  // true if nothing on stack
   {
      return (top == -1);
   }

}

class Vertex
{
   public char label;        // label (e.g. 'A')
   public boolean wasVisited;

   public Vertex(char lab)   // constructor
   {
      label = lab;
      wasVisited = false;
   }
}

class Graph
{
   private final int MAX_VERTS = 20;
   private Vertex vertexList[]; // list of vertices
   private int adjMat[][];      // adjacency matrix
   private int nVerts;          // current number of vertices
   private StackX theStack;

   public Graph()               // constructor
   {
      vertexList = new Vertex[MAX_VERTS];
                                          // adjacency matrix
      adjMat = new int[MAX_VERTS][MAX_VERTS];
      nVerts = 0;
      for (int j = 0; j < MAX_VERTS; j++)      // set adjacency
         for (int k = 0; k < MAX_VERTS; k++)   //    matrix to 0
            adjMat[j][k] = 0;
      theStack = new StackX();
   }

   public void addVertex(char lab)
      {
      vertexList[nVerts++] = new Vertex(lab);
      }

   public void addEdge(int start, int end)
   {
      adjMat[start][end] = 1;
      adjMat[end][start] = 1;
   }

   public void addOneWayEdge(int start, int end)
   {
      adjMat[start][end] = 1;
   }

   public void displayVertex(int v)
   {
      System.out.print(vertexList[v].label);
   }

   public void mst()  // minimum spanning tree (depth first)
   {
      vertexList[0].wasVisited = true;
      theStack.push(0);

      while( !theStack.isEmpty() )
      {
         int currentVertex = theStack.peek();

         int v = getAdjUnvisitedVertex(currentVertex);
         if(v == -1)
            theStack.pop();
         else
         {
            vertexList[v].wasVisited = true;
            theStack.push(v);

            displayVertex(currentVertex);
            displayVertex(v);
            System.out.print(" ");
         }
      }

      for (int j = 0; j < nVerts; j++)
         vertexList[j].wasVisited = false;
   }

   public int getAdjUnvisitedVertex(int v)
   {
      for(int j = 0; j < nVerts; j++)
         if (adjMat[v][j] == 1 && vertexList[j].wasVisited == false)
            return j;

      return -1;
   }

   public void makeTransitiveCurcuit()
   {
      for (int y = 0; y < nVerts; y++) //rows
         for (int x = 0; x < nVerts; x++) //columns
            if (adjMat[y][x] == 1)
               for (int z = 0; z < nVerts; z++)
                  if (adjMat[z][y] == 1)
                     adjMat[z][x] = 1;
   }

   public void displayAdjacentsMatrix()
   {
      System.out.print(" ");
      for (int i = 0; i < nVerts; i++)
         System.out.print(" " + vertexList[i].label);

      System.out.println();

      for (int i = 0; i < nVerts; i++)
      {
         System.out.print(vertexList[i].label);

         for (int j = 0; j < nVerts; j++)
            System.out.print(" " + adjMat[i][j]);

         System.out.println();
      }
   }
}
////////////////////////////////////////////////////////////////
class MSTApp
{
   public static void main(String[] args)
   {
      Graph theGraph = new Graph();
      theGraph.addVertex('A');    // 0  (start for mst)
      theGraph.addVertex('B');    // 1
      theGraph.addVertex('C');    // 2
      theGraph.addVertex('D');    // 3
      theGraph.addVertex('E');    // 4

      theGraph.addOneWayEdge(0, 2);     // AC
      theGraph.addOneWayEdge(1, 0);     // BA
      theGraph.addOneWayEdge(1, 4);     // BE
      theGraph.addOneWayEdge(4, 2);     // EC
      theGraph.addOneWayEdge(3, 4);     // DE

      System.out.print("Minimum spanning tree: ");
      theGraph.mst();             // minimum spanning tree
      System.out.println();

      System.out.println("Adjacents matrix: ");
      theGraph.displayAdjacentsMatrix();
      System.out.println();

      theGraph.makeTransitiveCurcuit();
      System.out.println("Adjacents matrix after making the transitive curcuit: ");
      theGraph.displayAdjacentsMatrix();
      System.out.println();

   }
}
////////////////////////////////////////////////////////////////

