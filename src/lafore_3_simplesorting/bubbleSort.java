package lafore_3_simplesorting;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

// bubbleSort.java
// demonstrates bubble sort
// to run this program: C>java lafore_3_simplesorting.BubbleSortApp
////////////////////////////////////////////////////////////////
class ArrayBub
   {
   private long[] a;                 // ref to array a
   private int nElems;               // number of data items
//--------------------------------------------------------------
   public ArrayBub(int max)          // constructor
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
   public void bubbleSort()
      {
      int rightOut, in;
      int leftOut = 0;

      for(rightOut=nElems-1; rightOut>nElems/2; rightOut--)   // outer loop (backward)
	  {
		  for (in = leftOut; in < rightOut; in++)        // inner loop (forward)
			  if (a[in] > a[in + 1])       // out of order?
				  swap(in, in + 1);          // swap them
		  
		  for (in = rightOut-1; in > leftOut; in--)
		  	  if (a[in] < a[in - 1])
		  	  	  swap(in, in - 1);
		  
		  leftOut++;
	  }
      }  // end bubbleSort()
//--------------------------------------------------------------
	   public void oddEvenSort()
	   {
	   		boolean mod = true;
	   	
	   		while (mod)
			{
				mod = false;
				
				for (int i = 0; i < nElems - 1; i++)
					if (i % 2 != 0)
						if (a[i] > a[i + 1])
						{
							swap(i, i + 1);
							mod = true;
						}
				
				for (int i = 0; i < nElems - 1; i++)
					if (i % 2 == 0)
						if (a[i] > a[i + 1])
						{
							swap(i, i + 1);
							mod = true;
						}
			}
	   }
//--------------------------------------------------------------
   private void swap(int one, int two)
      {
      long temp = a[one];
      a[one] = a[two];
      a[two] = temp;
      }
//--------------------------------------------------------------
   }  // end class lafore_3_simplesorting.ArrayBub
////////////////////////////////////////////////////////////////
class BubbleSortApp
   {
   public static void main(String[] args)
      {
      int maxSize = 20;
      ArrayBub arr;
      arr = new ArrayBub(maxSize);

         for (int i = 0; i < maxSize; i++)
		 {
		 	long value = (long)(Math.random() * (maxSize - 1));
		 	arr.insert(value);
		 }
		 
		 arr.display();
	
		  /*for (int i = 0; i < maxSize; i++)
			  arr.insert(i);*/
      
      	 DateFormat format = new SimpleDateFormat("ddMMyyyy HH:mm:ss");
		 System.out.println(format.format(Calendar.getInstance().getTime()));
		  
		 arr.oddEvenSort();
	
		 System.out.println(format.format(Calendar.getInstance().getTime()));
		 
		 arr.display();
		 
      }
   }
////////////////////////////////////////////////////////////////
