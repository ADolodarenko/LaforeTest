package lafore_12_heaps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AltHeapMain
{
	public static void main(String[] args) throws IOException
	{
		int value, value2;
		AltHeap theHeap = new AltHeap(31);  // make a Heap; max size 31
		boolean success;

		theHeap.insert(1);           // insert 10 items
		theHeap.insert(2);
		theHeap.insert(3);
		theHeap.insert(4);
		theHeap.insert(5);

		while(true)                   // until [Ctrl]-[C]
		{
			System.out.print("Enter a letter for ");
			System.out.print("Show, Insert, Remove, Change: ");
			int choice = getChar();
			switch(choice)
			{
				case 's':                        // show
					theHeap.displayHeap();
					break;
				case 'i':                        // insert
					System.out.print("Enter value to insert: ");
					value = getInt();
					success = theHeap.insert(value);
					if( !success )
						System.out.println("Can't insert; heap full");
					break;
				case 'r':                        // remove
					if( !theHeap.isEmpty() )
						theHeap.remove();
					else
						System.out.println("Can't remove; heap empty");
					break;
				case 'c':                        // change
					System.out.print("Enter current key of item: ");
					value = getInt();
					System.out.print("Enter new value: ");
					value2 = getInt();
					success = theHeap.change(value, value2);
					if( !success )
						System.out.println("Invalid key");
					break;
				default:
					System.out.println("Invalid entry\n");
			}  // end switch
		}
	}

	public static String getString() throws IOException
	{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}
	//-------------------------------------------------------------
	public static char getChar() throws IOException
	{
		String s = getString();
		return s.charAt(0);
	}
	//-------------------------------------------------------------
	public static int getInt() throws IOException
	{
		String s = getString();
		return Integer.parseInt(s);
	}
}
