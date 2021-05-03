package hw4;

import api.DefaultNode;
import api.Expression;
import api.Scope;
import parser.ProgramNode;

/**
 * Instruction type whose execution causes the value of an expression to
 * be printed to the console.
 * <ul>
 *   <li>There is one child, the expression whose value is to be printed.
 *   <li>The getLabel() method returns the string "Output".
 *   <li>The getText() method returns an empty string.
 * </ul>
 */

public class OutputInstruction extends InstructionAbstract
{

  /**
   * The variable exp represents the given expression
   */
  private Expression expr;
  
  /**
   * Constructs an output statement for the given expression.
   * @param expr
   *   given expression
   */
  public OutputInstruction(Expression expr)
  {
    this.expr = expr;
  }

  /**
   * Method that returns the label of this node as a string
   * @return Returns the label string for this node
   */
  @Override
  public String getLabel()
  {
    return "Output";
  }

  /**
   * Returns the specified child node of this node
   * @param i the index of the child to return
   * @return the child at index i
   */
  @Override
  public ProgramNode getChild(int i)
  {
    if (i == 0) {
      return expr;
    }
    else
    {
      return new DefaultNode("Invalid index " + i + " for type " + this.getClass().getName());
    }
  }

  /**
   * Executes the given instruction in the given scope. Note that an instruction may update the scope by creating variables or assigning new values to variables.
   * @param env scope in which this statement will be executed
   */
  @Override
  public void execute(Scope env)
  {
    System.out.print(expr.eval(env));

  }


}
