package hw4;

import api.Expression;
import api.Scope;

/**
 * Node type representing a relational expression
 * with the "equals" operator.  If the two operands
 * evaluate the the same number, this expression evaluates
 * to 1; otherwise, it evaluates to zero.
 * <ul>
 *   <li>There are two children; the first is the left operand, and the second 
 *   is the right operand.
 *   <li>The getLabel() method returns the string "==".
 *   <li>The getText() method returns an empty string.
 * </ul>
 */

public class RopEqual extends OpAbstract
{
  /**
   * The variable lhs represents the left operand of the expression.
   */
  private Expression lhs;

  /**
   * The variable rhs represents the right operand of the expression
   */
  private Expression rhs;

  /**
   * Constructs an expression with the given left and right sides.
   * @param lhs
   *   expression for the left-hand-side operand
   * @param rhs
   *   expression for the left-hand-side operand
   */
  public RopEqual(Expression lhs, Expression rhs)
  {
    super.ObAbstract(lhs, rhs);
    this.lhs = lhs;
    this.rhs = rhs;
  }

  /**
   * Method that returns the label of this node as a string
   * @return Returns the label string for this node
   */
  @Override
  public String getLabel()
  {
    return "==";
  }

  /**
   * Returns the value of this expression in the given scope. If the expression contains no variables, the scope is ignored.
   * @param env scope with which this expression is to be evaluated
   * @return returns the value of the expression in the given scope
   */
  @Override
  public int eval(Scope env)
  {
    int leftVal = lhs.eval(env);
    int rightVal = rhs.eval(env);

    if(leftVal == rightVal){
      return 1;
    }else{
      return 0;
    }
  }

}