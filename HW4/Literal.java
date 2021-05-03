package hw4;

import api.DefaultNode;
import api.Scope;
import parser.ProgramNode;

/**
 * Expression type representing a literal (int) value.
 * Evaluating a literal expression returns the given value.
 * <ul>
 *   <li>There are no children.
 *   <li>The getLabel() method returns the string "Int".
 *   <li>The getText() method returns the given value as a string.
 * </ul>
 */

public class Literal extends LitAndIDAbstract
{  
  /**
   * Value of this literal.
   */
  private int value;
  
  /**
   * Constructs a literal with the given value.
   * @param value
   *   int value for this literal.
   */
  public Literal(int value)
  {
    this.value = value;
  }

  /**
   * Method that returns the label of this node as a string
   * @return Returns the label string for this node
   */
  @Override
  public String getLabel()
  {
    return "Int";
  }

  /**
   * Method that returns any additional text, if any
   * @return returns the additional text
   */
  @Override
  public String getText()
  {
    return super.getText() + value;
  }


  /**
   * Returns the value of this expression in the given scope. If the expression contains no variables, the scope is ignored.
   * @param env scope with which this expression is to be evaluated
   * @return returns the value of the expression in the given scope
   */
  @Override
  public int eval(Scope env)
  {
    return value;
  }
}
