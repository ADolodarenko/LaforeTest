package lafore_4_stacks_queues;

// lafore_4_stacks_queues.Queue.java
// demonstrates queue
// to run this program: C>java lafore_4_stacks_queues.QueueApp
////////////////////////////////////////////////////////////////
class Queue
   {
   private int maxSize;
   private long[] queArray;
   private int front;
   private int rear;
   private int nItems;
//--------------------------------------------------------------
   public Queue(int s)          // constructor
      {
      maxSize = s;
      queArray = new long[maxSize];
      front = 0;
      rear = -1;
      nItems = 0;
      }
//--------------------------------------------------------------
   public void insert(long j)   // put item at rear of queue
      {
      if(rear == maxSize-1)         // deal with wraparound
         rear = -1;
      queArray[++rear] = j;         // increment rear and insert
      nItems++;                     // one more item
      }
//--------------------------------------------------------------
   public long remove()         // take item from front of queue
      {
      long temp = queArray[front++]; // get value and incr front
      if(front == maxSize)           // deal with wraparound
         front = 0;
      nItems--;                      // one less item
      return temp;
      }
//--------------------------------------------------------------
   public long peekFront()      // peek at front of queue
      {
      return queArray[front];
      }
//--------------------------------------------------------------
   public boolean isEmpty()    // true if queue is empty
      {
      return (nItems==0);
      }
//--------------------------------------------------------------
   public boolean isFull()     // true if queue is full
      {
      return (nItems==maxSize);
      }
//--------------------------------------------------------------
   public int size()           // number of items in queue
      {
      return nItems;
      }
      
      public void display()
	  {
		  System.out.print("lafore_4_stacks_queues.Queue");
		  
	  	if (isEmpty())
	  		System.out.println(" is empty");
	  	else if (nItems == 1)
	  		System.out.println(": " + queArray[front]);
	  	else
		{
			System.out.print(":");
			
			int i = front;
			
			while (i != rear)
			{
				System.out.print(" " + queArray[i]);
				
				if (i == maxSize - 1)
					i = 0;
				else i++;
			}
			
			System.out.println(" " + queArray[i]);
		}
	  
	  }
//--------------------------------------------------------------
   }  // end class lafore_4_stacks_queues.Queue
////////////////////////////////////////////////////////////////
class QueueApp
   {
   public static void main(String[] args)
      {
      	
      	Deque d = new Deque(10);
      	d.insertLeft(10);
      	d.insertLeft(20);
		  System.out.println(d.removeRight());
		  d.insertRight(30);
		  d.insertRight(40);
		  System.out.println(d.removeLeft());
	
		  System.out.println(d.size());
    
		  DeqStack stack = new DeqStack(10);
		  stack.push(100);
		  stack.push(200);
		  System.out.println(stack.pop());
		  System.out.println(stack.pop());
      
      /*lafore_4_stacks_queues.Queue theQueue = new lafore_4_stacks_queues.Queue(5);  // queue holds 5 items

      theQueue.insert(10);            // insert 4 items
      theQueue.insert(20);
      theQueue.insert(30);
      theQueue.insert(40);

      theQueue.remove();              // remove 3 items
      theQueue.remove();              //    (10, 20, 30)
      theQueue.remove();

      theQueue.insert(50);            // insert 4 more items
      theQueue.insert(60);            //    (wraps around)
      theQueue.insert(70);
      theQueue.insert(80);
      
      theQueue.display();

      while( !theQueue.isEmpty() )    // remove and display
         {                            //    all items
         long n = theQueue.remove();  // (40, 50, 60, 70, 80)
         System.out.print(n);
         System.out.print(" ");
         }
      System.out.println("");*/
      }  // end main()
	   
   }  // end class lafore_4_stacks_queues.QueueApp
////////////////////////////////////////////////////////////////
