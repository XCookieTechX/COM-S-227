package hw4;

import api.DefaultNode;
import api.Scope;
import parser.ProgramNode;

/**
 * Expression type representing an identifier (variable).
 * An identifier contains a string to be used as a variable name.
 * Evaluating an identifier expression returns the value
 * in the current Scope that is associated with the variable name.
 * Throws an InterpreterException if the name isn't in the current
 * Scope.
 * <ul>
 *   <li>There are no children.
 *   <li>The getLabel() method returns the string "Id".
 *   <li>The getText() method returns the given name.
 * </ul>
 */

public class Identifier extends LitAndIDAbstract
{
  private String name;
  
  /**
   * Constructs an identifier using the given string name.
   * @param givenName
   *   name for this identifier
   */
  public Identifier(String givenName)
  {
    name = givenName;
  }

  /**
   * Method that returns the label of this node as a string
   * @return Returns the label string for this node
   */
  @Override
  public String getLabel()
  {
    return "Id";
  }

  /**
   * Method that returns any additional text, if any
   * @return returns the additional text
   */
  @Override
  public String getText()
  {
    return name;
  }

  /**
   * Returns the value of this expression in the given scope. If the expression contains no variables, the scope is ignored.
   * @param env scope with which this expression is to be evaluated
   * @return returns the value of the expression in the given scope
   */
  @Override
  public int eval(Scope env)
  {
    return env.get(name);
  }
}
