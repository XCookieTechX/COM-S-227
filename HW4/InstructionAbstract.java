package hw4;

import api.Instruction;

public abstract class InstructionAbstract implements Instruction {


	/**
	 * Method that returns the number of children the expression has
	 * @return returns the number of children the expression has
	 */
	@Override
	public int getNumChildren() {
		return 2;
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

	/**
	 * Method that converts the expression to a string so that it can be printed out
	 * @return returns a string that represents the expression
	 */
	@Override
	public String toString()
	{
		return makeString();
	}

}
