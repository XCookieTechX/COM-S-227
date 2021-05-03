package hw4;
import api.DefaultNode;
import api.Expression;
import parser.ProgramNode;


/**
 * An abstract class that implements the Expression interface. Has methods that all 8 of the classes that extend it have in common to reduce redundant code.
 * Those 8 classes include AopAdd, AopSubtract, AopDevide, AopMultiply, LopAnd, LopOr, RopLessThan, and RopEqual.
 */
public abstract class OpAbstract implements Expression {

	/**
	 * The variable lhs represents the left operand of the expression.
	 */
	private Expression lhs;

	/**
	 * The variable rhs represents the right operand of the expression
	 */
	private Expression rhs;

	/**
	 * Superclass constructor for the abstract class that assigns the left hand and right hand operands
	 * @param lhs expression for the left-hand-side operand
	 * @param rhs expression for the left-hand-side operand
	 */
	public void ObAbstract(Expression lhs, Expression rhs){
		this.lhs = lhs;
		this.rhs = rhs;
	}

	/**
	 * Method that converts the expression to a string so that it can be printed out
	 * @return returns a string that represents the expression
	 */
	@Override
	public String toString()
	{
		return makeString();
	}

	/**
	 * Method that returns the number of children the expression has
	 * @return returns the number of children the expression has
	 */
	@Override
	public int getNumChildren()
	{
		return 2;
	}

	/**
	 * Method that returns the side of the operand either left or right
	 * @param i The side of the operand that needs to be returned either 0 being left or 1 being right
	 * @return returns the specified operand or prints an invalid index
	 */
	@Override
	public ProgramNode getChild(int i)
	{
		if (i == 0)
		{
			return lhs;
		}
		else if (i == 1)
		{
			return rhs;
		}
		else
		{
			return new DefaultNode("Invalid index " + i + " for type " + this.getClass().getName());
		}
	}

	/**
	 * Method that returns any additional text, if any
	 * @return returns the additional text
	 */
	@Override
	public String getText()
	{
		return "";
	}

}
