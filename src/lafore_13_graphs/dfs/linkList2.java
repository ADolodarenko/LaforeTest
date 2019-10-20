package lafore_13_graphs.dfs;

class Link
{
   private int key;
   private Vertex vertex;
   private Link next;

   public Link(int key, Vertex vertex)
   {
      this.key = key;
      this.vertex = vertex;
   }

   public int getKey()
   {
   	  return this.key;
   }

   public void setNext(Link next)
   {
   	  this.next = next;
   }

   public Link getNext()
   {
   	  return this.next;
   }

   public Vertex getVertex()
   {
   	  return this.vertex;
   }

   public void displayLink()
   {
      System.out.print("{" + key + ", " + vertex.label + "} ");
   }
}

class LinkList
{
   private Link first;

   public LinkList()
   {
      first = null;
   }

   public void insertFirst(int key, Vertex vertex)
   {
      Link newLink = new Link(key, vertex);
      newLink.setNext(first);
      first = newLink;
   }

   public Link find()
   {
      Link current = first;

      while (current != null)
      {
      	 Vertex currentVertex = current.getVertex();

         if ( !currentVertex.wasVisited )
            return current;
         else
            current = current.getNext();
      }

      return current;
   }

   public Link delete(int key)
   {
      Link current = first;
      Link previous = first;

      while (current.getKey() != key)
      {
         if (current.getNext() == null)
            return null;
         else
         {
            previous = current;
            current = current.getNext();
         }
      }

      if (current == first)
         first = first.getNext();
      else
         previous.setNext(current.getNext());

      return current;
   }

   public void displayList()
   {
      System.out.print("List (first-->last): ");
      Link current = first;

      while (current != null)
      {
         current.displayLink();
         current = current.getNext();
      }

      System.out.println();
   }
}
