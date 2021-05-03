package hw4;

import api.*;
import parser.ProgramNode;

/**
 * Expression representing the value of a function call. All expressions
 * in the argument list are evaluated with respect to the current scope,
 * and the resulting values are associated with the corresponding parameter names in
 * a new "local" Scope.  This local scope is used to evaluate the function body
 * (its BlockInstruction) and after that, the function return expression. 
 * Variables in the current scope are not accessible during execution of the function
 * body.
 * The eval method of this call expression returns value of the function's
 * return expression.
 * <ul>
 *   <li>There are two children; the first is the Function object, and the second 
 *   is the argument list.
 *   <li>The getLabel() method returns the string "Call".
 *   <li>The getText() method returns the getText() string of the Function
 * </ul>
 */

public class CallExpression extends OpAbstract
{

  /**
   * the funct variable represents the function to be called
   */
  private Function funct;

  /**
   * the list variable represents the arguments to the function
   */
  private ArgList list;

  /**
   * scope with which an expression is to be evaluated
   */
  private Scope scope;


  /**
   * Constructs a CallExpression for the given function and argument list.
   * @param f
   *   the function to be called
   * @param args
   *   the arguments to the function
   */
  public CallExpression(Function f, ArgList args)
  {
    this.funct = f;
    this.list = args;
    scope = new Scope();


  }
  
  /**
   * Sets the Function object for this CallExpression
   * @param f
   *   the function to be called
   */
  public void setFunction(Function f)
  {
    this.funct = f;
  }

  /**
   * Method that returns the label of this node as a string
   * @return Returns the label string for this node
   */
  @Override
  public String getLabel()
  {
    return "Call";
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
      return funct;
    }
    else if (i == 1)
    {
      return list;
    }
    else
    {
      return new DefaultNode("Invalid index " + i + " for type " + this.getClass().getName());
    }
  }

  /**
   * Returns the value of this expression in the given scope. If the expression contains no variables, the scope is ignored.
   * @param env scope with which this expression is to be evaluated
   * @return returns the value of the expression in the given scope
   */
  @Override
  public int eval(Scope env)
  {
    int i;
    int finalReturn;
    Expression exp;
    ParameterList paramlist;
    Identifier id;
    String paramName;
    Instruction instr;
    Expression expNext;

    for(i = 0; i < list.getNumChildren(); i++){
      exp = (Expression) list.getChild(i);
      paramlist = (ParameterList) funct.getChild(0);
      id = (Identifier) paramlist.getChild(i);
      paramName = id.getText();
      scope.put(paramName, exp.eval(env));
    }

    instr = (Instruction) funct.getChild(1);
    expNext = (Expression) funct.getChild(2);
    finalReturn = expNext.eval(scope);

    return finalReturn;
  }

  /**
   * Method that returns any additional text, if any
   * @return returns the additional text
   */
  @Override
  public String getText()
  {
    return funct.getText();
  }

}
