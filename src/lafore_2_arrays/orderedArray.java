package lafore_2_arrays;

// orderedArray.java
// demonstrates ordered array class
// to run this program: C>java lafore_2_arrays.OrderedApp
////////////////////////////////////////////////////////////////
class OrdArray
   {
   private long[] a;                 // ref to array a
   private int nElems;               // number of data items
   //-----------------------------------------------------------
   public OrdArray(int max)          // constructor
      {
      a = new long[max];             // create array
      nElems = 0;
      }
   //-----------------------------------------------------------
   public int size()
      { return nElems; }
   //-----------------------------------------------------------
   public int find(long searchKey)
      {
      int lowerBound = 0;
      int upperBound = nElems-1;
      int curIn;

      while(true)
         {
         curIn = (lowerBound + upperBound ) / 2;
         if(a[curIn]==searchKey)
            return curIn;              // found it
         else if(lowerBound > upperBound)
            return nElems;             // can't find it
         else                          // divide range
            {
            if(a[curIn] < searchKey)
               lowerBound = curIn + 1; // it's in upper half
            else
               upperBound = curIn - 1; // it's in lower half
            }  // end else divide range
         }  // end while
      }  // end find()
   //-----------------------------------------------------------
   public void insert(long value)    // put element into array
      {
		  int lowerBound = 0;
		  int upperBound = nElems-1;
		  int curIn;
		  int j;
		  
		  while(true)
		  {
			  curIn = (lowerBound + upperBound ) / 2;
			  if(a[curIn] > value && (curIn == 0 || (curIn - 1 >= 0 && a[curIn - 1] < value)))
			  {
				  j = curIn;
				  break;
			  }
			  else if(lowerBound > upperBound)
			  {
				  j = nElems;
				  break;
			  }
			  else                          // divide range
			  {
				  if(a[curIn] < value)
					  lowerBound = curIn + 1; // it's in upper half
				  else
					  upperBound = curIn - 1; // it's in lower half
			  }  // end else divide range
		  }  // end while
		  
      for(int k=nElems; k>j; k--)    // move bigger ones up
         a[k] = a[k-1];
      a[j] = value;                  // insert it
      nElems++;                      // increment size
      }  // end insert()
   //-----------------------------------------------------------
   public boolean delete(long value)
      {
      int j = find(value);
      if(j==nElems)                  // can't find it
         return false;
      else                           // found it
         {
         for(int k=j; k<nElems; k++) // move bigger ones down
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
	   public OrdArray merge(OrdArray other)
	   {
	   		int maxSize = nElems;
	   		if (other != null)
	   			maxSize += other.nElems;
	   	
	   		OrdArray result = new OrdArray(maxSize);
	   		
	   		if (other == null)
			{
				for (int i = 0; i < nElems; i++)
					result.insert(a[i]);
			}
			else
			{
				int i = 0, j = 0;
				
				while (true)
				{
					if (i < nElems && j < other.nElems)
					{
						if (a[i] < other.a[j])
						{
							result.insert(a[i]);
							i++;
						}
						else if (a[i] == other.a[j])
						{
							result.insert(a[i]);
							i++;
							j++;
						}
						else
						{
							result.insert(other.a[j]);
							j++;
						}
					}
					else
					{
						while (i < nElems)
						{
							result.insert(a[i]);
							i++;
						}
						
						while (j < other.nElems)
						{
							result.insert(other.a[j]);
							j++;
						}
						
						break;
					}
				}
			}
			
	   		return result;
	   }
   }  // end class lafore_2_arrays.OrdArray
////////////////////////////////////////////////////////////////
class OrderedApp
   {
   public static void main(String[] args)
      {
      int maxSize = 100;             // array size
      OrdArray arr;                  // reference to array
      arr = new OrdArray(maxSize);   // create the array

      arr.insert(77);                // insert 10 items
      arr.insert(99);
      arr.insert(44);
      arr.insert(55);
      arr.insert(22);
      arr.insert(88);
      arr.insert(11);
      arr.insert(00);
      arr.insert(66);
      arr.insert(33);

      int searchKey = 55;            // search for item
      if( arr.find(searchKey) != arr.size() )
         System.out.println("Found " + searchKey);
      else
         System.out.println("Can't find " + searchKey);

      arr.display();                 // display items

      arr.delete(00);                // delete 3 items
      arr.delete(55);
      arr.delete(99);

      arr.display();                 // display items again
		  
		  OrdArray arr1 = new OrdArray(5);
		  arr1.insert(100);
		  arr1.insert(17);
		  arr1.insert(254);
		  arr1.insert(56);
		  arr1.insert(3);
	
		  OrdArray arr2 = new OrdArray(7);
		  arr2.insert(256);
		  arr2.insert(1405);
		  arr2.insert(18);
		  arr2.insert(5);
		  arr2.insert(99);
		  arr2.insert(33);
		  arr2.insert(11);
		  
		  OrdArray arr3 = arr1.merge(arr2);
	
		  System.out.print("Merged array:");
		  arr3.display();
	
	  }  // end main()
   }  // end class lafore_2_arrays.OrderedApp
