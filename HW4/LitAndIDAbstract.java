package hw4;

import api.DefaultNode;
import parser.ProgramNode;

public abstract class LitAndIDAbstract extends OpAbstract{

    /**
     * Method that returns the number of children the expression has
     * @return returns the number of children the expression has
     */
    @Override
    public int getNumChildren()
    {
        return 0;
    }

    /**
     * Method that returns the side of the operand either left or right
     * @param i The side of the operand that needs to be returned either 0 being left or 1 being right
     * @return returns the specified operand or prints an invalid index
     */
    @Override
    public ProgramNode getChild(int i)
    {
        return new DefaultNode("Invalid index " + i + " for type " + this.getClass().getName());
    }

}
