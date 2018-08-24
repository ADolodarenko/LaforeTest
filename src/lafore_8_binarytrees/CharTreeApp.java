package lafore_8_binarytrees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CharTreeApp
{
    public static void main(String[] args) throws IOException
    {
        //CharTree tree = getEntireCharTree(getTreeArray());
		CharTree tree = getEntireBalancedCharTree(getTreeArray());

        if (tree != null)
            tree.displayTree();
    }

    private static CharTree getEntireCharTree(CharTree[] trees)
    {
        if (trees == null || trees.length == 0)
            return null;

        CharTree tree = null;

        for (int i = 0; i < trees.length; i++)
            if (tree == null)
                tree = trees[i];
            else
            {
                CharTree parentTree = new CharTree(new CharNode('+'));
                parentTree.getRoot().setLeftChild(tree.getRoot());
                parentTree.getRoot().setRightChild(trees[i].getRoot());

                tree = parentTree;
            }

        return tree;
    }
    
    private static CharTree getEntireBalancedCharTree(CharTree[] trees)
	{
		if (trees == null || trees.length == 0)
			return null;
		
		int treesQuantity = trees.length;
		
		while (treesQuantity > 1)
		{
			CharTree parentTree = null;
			
			for (int i = 0; i < trees.length; i++)
			{
				if (trees[i] != null)
				{
					if (parentTree == null)
					{
						parentTree = new CharTree(new CharNode('+'));
						parentTree.getRoot().setLeftChild(trees[i].getRoot());
						
						trees[i] = parentTree;
					}
					else
					{
						parentTree.getRoot().setRightChild(trees[i].getRoot());
						
						trees[i] = null;
						treesQuantity--;
						
						parentTree = null;
					}
				}
			}
		}
		
		return trees[0];
	}

    private static CharTree[] getTreeArray() throws IOException
    {
        List<CharTree> nodeList = new ArrayList<>();

        while (true)
        {
            char character = getChar();
            if (character == ' ')
                break;

            nodeList.add(new CharTree(new CharNode(character)));
        }

        if (nodeList.isEmpty())
            return null;
        else
        {
            CharTree[] result = new CharTree[nodeList.size()];
            return nodeList.toArray(result);
        }
    }

    public static String getString() throws IOException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();

        if (s.length() > 0)
            return s;
        else
            return " ";
    }

    public static char getChar() throws IOException
    {
        String s = getString();
        return s.charAt(0);
    }
}
