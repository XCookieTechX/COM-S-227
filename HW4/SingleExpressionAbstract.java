package hw4;

import api.DefaultNode;
import api.Expression;
import parser.ProgramNode;

public abstract class SingleExpressionAbstract implements Expression {

	/**
	 * The variable exp represents the given expression
	 */
	private Expression expr;

	/**
	 * The constructor for this abstract class
	 * @param expr represents the given expression
	 */
	public void SingleExpressionAbstract(Expression expr){
		this.expr = expr;
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
		return 1;
	}

	/**
	 * Returns the specified child node
	 * @param i the index of the child to return
	 * @return the child at index i
	 */
	@Override
	public ProgramNode getChild(int i)
	{
		if (i == 0){
			return expr;
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
