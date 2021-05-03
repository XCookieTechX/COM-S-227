package hw4;

import api.DefaultNode;
import api.Expression;
import api.Scope;
import parser.ProgramNode;

/**
 * Implementation of Instruction that represents an assignment to a 
 * variable in the current scope.  Execution of an assignment instruction
 * causes the scope to be updated with the new value of the variable.
 * If the variable name is not already in the scope, it is added.
 * <ul>
 *   <li>There are two children; the first is the identifier, and the second 
 *   is the expression.
 *   <li>The getLabel() method returns the string "Assign".
 *   <li>The getText() method returns the getText() string of the identifier
 * </ul>
 */

public class AssignmentInstruction extends InstructionAbstract
{

  /**
   * the Identifier variable represents the identifier
   */
  private Identifier variable;

  /**
   * The expression variable represents the expression to be assigned
   */
  private Expression expression;
  
  /**
   * Constructs an assignment instruction representing v = e.
   * @param v
   *   the identifier
   * @param e
   *   the expression to be assigned
   */
  public AssignmentInstruction(Identifier v, Expression e)
  {
    variable = v;
    expression = e;
  }

  /**
   * Method that returns the label of this node as a string
   * @return Returns the label string for this node
   */
  @Override
  public String getLabel()
  {
    return "Assign";
  }

  /**
   * Method that returns any additional text, if any
   * @return returns the additional text
   */
  @Override
  public String getText()
  {
    return variable.getText();
  }

  /**
   * Returns the specified child node of this node
   * @param i the index of the child to return
   * @return the child at index i
   */
  @Override
  public ProgramNode getChild(int i)
  {
    if (i == 0)
    {
      return variable;
    }
    else if (i == 1)
    {
      return expression;
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
    String name = variable.getText();
    int value = expression.eval(env);
    
    // update the scope with the new value
    env.put(name, value);
  }
}
