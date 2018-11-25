package lafore_11_hashtables;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringHashTableApp
{
	public static void main(String[] args) throws IOException
	{
		String item;
		int size;

		System.out.print("Enter size of hash table: ");
		size = getInt();

		StringHashTable theHashTable = new StringHashTable(size);

		while (true)
		{
			System.out.print("Enter first letter of ");
			System.out.print("show, insert, delete, or find: ");
			char choice = getChar();
			switch(choice)
			{
				case 's':
					theHashTable.displayTable();
					break;
				case 'i':
					System.out.print("Enter key value to insert: ");
					item = getString();
					theHashTable.insert(item);
					break;
				case 'd':
					System.out.print("Enter key value to delete: ");
					item = getString();
					theHashTable.delete(item);
					break;
				case 'f':
					System.out.print("Enter key value to find: ");
					item = getString();
					item = theHashTable.find(item);
					if(item != null)
					{
						System.out.println("Found " + item);
					}
					else
						System.out.println("Could not find " + item);
					break;
				case 'c':
					System.out.print("Enter a key: ");
					long key = getLong();
					System.out.print("Enter the size of the array: ");
					size = getInt();
					System.out.println("Hash is " + theHashTable.hashFuncAlt(key, size));
				default:
					System.out.print("Invalid entry\n");
			}
		}
	}

	public static String getString() throws IOException
	{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}

	public static char getChar() throws IOException
	{
		String s = getString();
		return s.charAt(0);
	}

	public static int getInt() throws IOException
	{
		String s = getString();
		return Integer.parseInt(s);
	}

	public static long getLong() throws IOException
	{
		String s = getString();
		return Long.parseLong(s);
	}
}
