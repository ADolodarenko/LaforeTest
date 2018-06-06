// priorityQ.java
// demonstrates priority queue
// to run this program: C>java PriorityQApp
////////////////////////////////////////////////////////////////
class PriorityQ
   {
   // array in sorted order, from max at 0 to min at size-1
   private int maxSize;
   private long[] queArray;
   private int nItems;
//-------------------------------------------------------------
   public PriorityQ(int s)          // constructor
      {
      maxSize = s;
      queArray = new long[maxSize];
      nItems = 0;
      }
//-------------------------------------------------------------
   public void insert(long item)    // insert item
      {
         queArray[nItems++] = item;
      }  // end insert()
//-------------------------------------------------------------
   public long remove()             // remove minimum item
      {
      	int j = 0;
      	long result = queArray[j];
      	
      	if (nItems > 1)
		{
			for (int i = 1; i < nItems; i++)
			{
				if (queArray[i] < result)
				{
					result = queArray[i];
					j = i;
				}
			}
			
			for (int i = j + 1; i < nItems; i++)
				queArray[i - 1] = queArray[i];
		}
		
		nItems--;
		
		return result;
	  }
//-------------------------------------------------------------
   public long peekMin()            // peek at minimum item
      {
		  long result = queArray[0];
	
		  for (int i = 1; i < nItems; i++)
		  	if (queArray[i] < result)
			  result = queArray[i];
	
		  return result;
	  }
//-------------------------------------------------------------
   public boolean isEmpty()         // true if queue is empty
      { return (nItems==0); }
//-------------------------------------------------------------
   public boolean isFull()          // true if queue is full
      { return (nItems == maxSize); }
      
      
   public void display()
   {
   		PriorityQ temp = new PriorityQ(nItems);
   		
   		for (int i = 0; i < nItems; i++)
   			temp.insert(queArray[i]);
	
	   System.out.print("Queue: ");
   		while (!temp.isEmpty()) System.out.print(" " + temp.remove());
	   System.out.println();
   }
//-------------------------------------------------------------
   }  // end class PriorityQ
////////////////////////////////////////////////////////////////
class PriorityQApp
   {
   public static void main(String[] args)
      {
      PriorityQ thePQ = new PriorityQ(5);
      thePQ.insert(30);
      thePQ.insert(50);
      thePQ.insert(10);
      thePQ.insert(40);
      thePQ.insert(20);

      /*
      while( !thePQ.isEmpty() )
         {
         long item = thePQ.remove();
         System.out.print(item + " ");  // 10, 20, 30, 40, 50
         }  // end while
      System.out.println("");
      */
      thePQ.display();
      thePQ.display();
      
      
      }  // end main()
//-------------------------------------------------------------
   }  // end class PriorityQApp
////////////////////////////////////////////////////////////////
