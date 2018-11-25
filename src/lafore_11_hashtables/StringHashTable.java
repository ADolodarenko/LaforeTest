package lafore_11_hashtables;

import java.util.ArrayList;
import java.util.List;

public class StringHashTable
{
	private String[] hashArray;
	private int arraySize;
	private String nonItem;

	public StringHashTable(int size)
	{
		arraySize = size;
		hashArray = new String[arraySize];
		nonItem = "";
	}

	public void displayTable()
	{
		System.out.print("Table: ");

		for (int j = 0; j < arraySize; j++)
		{
			if (hashArray[j] != null)
				System.out.print(hashArray[j] + "|");
			else
				System.out.print("**|");
		}

		System.out.println();
	}

	public int hashFunc(String key)
	{
		int hashVal = 0;

		for (int i = 0; i < key.length(); i++)
		{
			int letter = key.charAt(i) - 96;
			hashVal = (hashVal * 27 + letter) % arraySize;
		}

		return hashVal;
	}

	public int hashFuncAlt(long key, int arraySize)
	{
		//Work out number of digits in a group
		int digitsCount = 0;
		int maxIndex = arraySize - 1;
		while (maxIndex != 0)
		{
			++digitsCount;
			maxIndex /= 10;
		}

		//split the key
		List<Integer> keyDigits = new ArrayList<>();
		while (key > 0)
		{
			keyDigits.add(0, (int) (key % 10));
			key /= 10;
		}

		//initialize the result
		int sum = 0;
		int group = 0;
		int x = 0;
		//count
		for (int i = 0; i < keyDigits.size(); i++)
		{
			group = group * 10 + keyDigits.get(i);
			x++;

			if (x == digitsCount)
			{
				sum = sum + group;
				group = 0;
				x = 0;
			}
		}

		if (x != 0)
			sum = sum + group;

		return sum % arraySize;
	}

	public void insert(String value)
	{
		int hashVal = hashFunc(value);

		while (hashArray[hashVal] != null &&
				!hashArray[hashVal].isEmpty())
		{
			++hashVal;
			hashVal %= arraySize;
		}

		hashArray[hashVal] = value;
	}

	public String delete(String value)
	{
		int hashVal = hashFunc(value);

		while(hashArray[hashVal] != null)
		{
			if(hashArray[hashVal].equals(value))
			{
				String temp = hashArray[hashVal];
				hashArray[hashVal] = nonItem;
				return temp;
			}

			++hashVal;
			hashVal %= arraySize;
		}

		return null;
	}

	public String find(String value)
	{
		int hashVal = hashFunc(value);

		while(hashArray[hashVal] != null)
		{
			if(hashArray[hashVal].equals(value))
				return hashArray[hashVal];

			++hashVal;
			hashVal %= arraySize;
		}

		return null;
	}
}
