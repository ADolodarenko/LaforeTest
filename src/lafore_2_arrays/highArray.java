package lafore_2_arrays;

// highArray.java
// demonstrates array class with high-level interface
// to run this program: C>java lafore_2_arrays.HighArrayApp
////////////////////////////////////////////////////////////////
class HighArray
   {
   private long[] a;                 // ref to array a
   private int nElems;               // number of data items
   //-----------------------------------------------------------
   public HighArray(int max)         // constructor
      {
      a = new long[max];                 // create the array
      nElems = 0;                        // no items yet
      }
   //-----------------------------------------------------------
   public boolean find(long searchKey)
      {                              // find specified value
      int j;
      for(j=0; j<nElems; j++)            // for each element,
         if(a[j] == searchKey)           // found item?
            break;                       // exit loop before end
      if(j == nElems)                    // gone to end?
         return false;                   // yes, can't find it
      else
         return true;                    // no, found it
      }  // end find()
   //-----------------------------------------------------------
   public void insert(long value)    // put element into array
      {
      a[nElems] = value;             // insert it
      nElems++;                      // increment size
      }
   //-----------------------------------------------------------
   public boolean delete(long value)
      {
      int j;
      for(j=0; j<nElems; j++)        // look for it
         if( value == a[j] )
            break;
      if(j==nElems)                  // can't find it
         return false;
      else                           // found it
         {
         for(int k=j; k<nElems-1; k++) // move higher ones down
            a[k] = a[k+1];
         nElems--;                   // decrement size
         return true;
         }
      }  // end delete()
   //-----------------------------------------------------------
   public void display()             // displays array contents
      {
      for(int j=0; j<nElems; j++)       // for each element,
         System.out.print(a[j] + " ");  // display it
      System.out.println("");
      }
   //-----------------------------------------------------------
      public long removeMax()
      {
         long result = -1;
         
         for (int i = 0; i < nElems; i++)
            if (a[i] > result)
               result = a[i];
         
         if (result != -1)
         	delete(result);
         
         return result;
      }
      //-----------------------------------------------------------
      public void noDups()
	  {
		  long specValue = Long.MIN_VALUE;
		
		  for (int i = 0; i < nElems; i++)
			  if (a[i] > specValue)
				  specValue = a[i];
	  	
		  specValue++;
		  
		  for (int i = 0; i < nElems; i++)
		  	for (int j = i + 1; j < nElems; j++)
				if (a[j] == a[i])
					a[j] = specValue;
		  
		  while (find(specValue))
			  delete(specValue);
	  }
   }  // end class lafore_2_arrays.HighArray
////////////////////////////////////////////////////////////////
class HighArrayApp
   {
   public static void main(String[] args)
      {
      int maxSize = 100;            // array size
      HighArray arr;                // reference to array
      arr = new HighArray(maxSize); // create the array

      arr.insert(77);               // insert 10 items
      arr.insert(99);
      arr.insert(44);
      arr.insert(55);
      arr.insert(22);
      arr.insert(88);
      arr.insert(11);
      arr.insert(00);
      arr.insert(66);
      arr.insert(33);
		  arr.insert(112);

      arr.display();                // display items

      int searchKey = 35;           // search for item
      if( arr.find(searchKey) )
         System.out.println("Found " + searchKey);
      else
         System.out.println("Can't find " + searchKey);

      arr.delete(00);               // delete 3 items
      arr.delete(55);
      arr.delete(99);

      arr.display();                // display items again
	
		  System.out.println("Max value in array was: " + arr.removeMax());
		  
		  arr.display();
	
		  System.out.print("Creating new sorted array...	");
		  
		  HighArray sortedArr = new HighArray(maxSize);
		  while (true)
		  {
		  	long maxValue = arr.removeMax();
		  	
		  	if (maxValue == -1)
		  		break;
		  	
		  	sortedArr.insert(maxValue);
		  }
	
		  System.out.println("Done.");
	
		  System.out.print("Sorted array: ");
		  sortedArr.display();
		  
		  HighArray arr1 = new HighArray(10);
		  arr1.insert(2);
		  arr1.insert(17);
		  arr1.insert(-300);
		  arr1.insert(12);
		  arr1.insert(226);
		  arr1.insert(2);
		  arr1.insert(-300);
		  arr1.insert(-300);
		  arr1.insert(789);
		  arr1.insert(500);
	
		  System.out.print("Before deleting dups:");
		  arr1.display();
		  
		  arr1.noDups();
	
		  System.out.print("After deleting dups:");
		  arr1.display();
		  
      }  // end main()
   }  // end class lafore_2_arrays.HighArrayApp
