package lafore_8_binarytrees;

import java.util.Stack;

public class CharTree
{
    private CharNode root;

    public CharTree()
    {
        this.root = null;
    }

    public CharTree(CharNode root)
    {
        this.root = root;
    }

    public CharNode getRoot()
    {
        return root;
    }

    public void traverse(int traverseType)
    {
        switch(traverseType)
        {
            case 1: System.out.print("\nPreorder traversal: ");
                preOrder(root);
                break;
            case 2: System.out.print("\nInorder traversal:  ");
                inOrder(root);
                break;
            case 3: System.out.print("\nPostorder traversal: ");
                postOrder(root);
                break;
        }

        System.out.println();
    }

    private void preOrder(CharNode localRoot)
    {
        if(localRoot != null)
        {
            System.out.print(localRoot.getCharacter() + " ");
            preOrder(localRoot.getLeftChild());
            preOrder(localRoot.getRightChild());
        }
    }

    private void inOrder(CharNode localRoot)
    {
        if(localRoot != null)
        {
            inOrder(localRoot.getLeftChild());
            System.out.print(localRoot.getCharacter() + " ");
            inOrder(localRoot.getRightChild());
        }
    }

    private void postOrder(CharNode localRoot)
    {
        if(localRoot != null)
        {
            postOrder(localRoot.getLeftChild());
            postOrder(localRoot.getRightChild());
            System.out.print(localRoot.getCharacter() + " ");
        }
    }

    public void displayTree()
    {
        Stack globalStack = new Stack();
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println("......................................................");

        while(isRowEmpty==false)
        {
            Stack localStack = new Stack();
            isRowEmpty = true;

            for (int j = 0; j < nBlanks; j++)
                System.out.print(' ');

            while (globalStack.isEmpty() == false)
            {
                CharNode temp = (CharNode)globalStack.pop();
                if(temp != null)
                {
                    System.out.print(temp.getCharacter());
                    localStack.push(temp.getLeftChild());
                    localStack.push(temp.getRightChild());

                    if(temp.getLeftChild() != null || temp.getRightChild() != null)
                        isRowEmpty = false;
                }
                else
                {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }

                for (int j = 0; j < nBlanks*2 - 2; j++)
                    System.out.print(' ');
            }

            System.out.println();
            nBlanks /= 2;
            while (localStack.isEmpty() == false)
                globalStack.push( localStack.pop() );
        }

        System.out.println("......................................................");
    }
}
