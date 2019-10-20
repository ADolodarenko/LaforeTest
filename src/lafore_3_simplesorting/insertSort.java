package lafore_3_simplesorting;

// insertSort.java
// demonstrates insertion sort
// to run this program: C>java lafore_3_simplesorting.InsertSortApp
//--------------------------------------------------------------
class ArrayIns
   {
   private long[] a;                 // ref to array a
   private int nElems;               // number of data items
//--------------------------------------------------------------
   public ArrayIns(int max)          // constructor
      {
      a = new long[max];                 // create the array
      nElems = 0;                        // no items yet
      }
//--------------------------------------------------------------
   public void insert(long value)    // put element into array
      {
      a[nElems] = value;             // insert it
      nElems++;                      // increment size
      }
//--------------------------------------------------------------
   public void display()             // displays array contents
      {
      for(int j=0; j<nElems; j++)       // for each element,
         System.out.print(a[j] + " ");  // display it
      System.out.println("");
      }
//--------------------------------------------------------------
   public void insertionSort()
      {
      int in, out;
      int copyQnt = 0, compareQnt = 0;

      for(out=1; out<nElems; out++)     // out is dividing line
         {
         long temp = a[out];            // remove marked item
         in = out;                      // start shifts at out
         while(in>0) // until one is smaller,
            {
            	compareQnt++;
            	
				if (a[in-1] >= temp)
				{
					a[in] = a[in - 1];            // shift item to right
					copyQnt++;
					--in;
				}// go left one position
				else
					break;
            }
         a[in] = temp;                  // insert marked item
         }  // end for
	
		  System.out.println("Compared: " + compareQnt + " times(s)");
		  System.out.println("Copied: " + copyQnt + " times(s)");
      }  // end insertionSort()
//--------------------------------------------------------------
	   public long median()
	   {
	   	ArrayIns newArr = new ArrayIns(nElems);
	   	
	   	for (int i = 0; i < nElems; i++)
	   		newArr.insert(a[i]);
	   	
	   	newArr.insertionSort();
	   	
	   	return newArr.a[nElems/2];
	   }
	   //--------------------------------------------------------------
	   public void noDups()
	   {
	   	
	   	insertionSort();
		
		   System.out.println("noDups: before setting MIN");
	   	display();
	   	
	   	int dups = 0;
	   	
	   	for (int i = 0; i < nElems - 1; i++)
			if (a[i] != Long.MIN_VALUE)
				for (int j = i + 1; j < nElems; j++)
					if (a[j] == a[i])
					{
						a[j] = Long.MIN_VALUE;
						dups++;
					}
		
		   System.out.println("noDups: after setting MIN");
		   display();
	   	
		   for (int i = 1; i < nElems; i++)
		   	if (a[i] != Long.MIN_VALUE)
			{
				int j = i - 1;
				
				while (j > 0)
				{
					if (a[j] == Long.MIN_VALUE && a[j - 1] != Long.MIN_VALUE)
					{
						a[j] = a[i];
						a[i] = Long.MIN_VALUE;
						
						break;
					}
					
					j--;
				}
			}
			
			nElems = nElems - dups;
		
		   System.out.println("noDups: after moving");
		   display();
	   }
   }// end class lafore_3_simplesorting.ArrayIns


////////////////////////////////////////////////////////////////
class InsertSortApp
   {
   public static void main(String[] args)
      {
         int maxSize = 10000;
         ArrayIns arr;
         arr = new ArrayIns(maxSize);
	
	
		  for (int i = 0; i < maxSize; i++)
		  {
			  long value = (long) (Math.random() * (maxSize - 1));
			  arr.insert(value);
		  }
	
		  long startTime = System.currentTimeMillis();
	
		  arr.insertionSort();
	
		  long endTime = System.currentTimeMillis();
	
		  System.out.println(endTime - startTime);
         
		  
         
         
         /*arr.insert(10);
         arr.insert(100);
         arr.insert(22);
         arr.insert(115);
         arr.insert(10);
         arr.insert(15);
         arr.insert(22);
         
         arr.noDups();*/
         
      }
   }
