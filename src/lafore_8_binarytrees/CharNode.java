package lafore_8_binarytrees;

public class CharNode
{
    private char character;
    private CharNode leftChild;
    private CharNode rightChild;

    public CharNode(char character)
    {
        this.character = character;
    }

    public char getCharacter()
    {
        return character;
    }

    public CharNode getLeftChild()
    {
        return leftChild;
    }

    public void setLeftChild(CharNode leftChild)
    {
        this.leftChild = leftChild;
    }

    public CharNode getRightChild()
    {
        return rightChild;
    }

    public void setRightChild(CharNode rightChild)
    {
        this.rightChild = rightChild;
    }

    public void display()
    {
        System.out.println(character);
    }
}
