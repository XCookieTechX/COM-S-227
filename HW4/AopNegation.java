package hw4;

import api.Expression;
import api.Scope;

/**
 * Arithmetic negation expression (unary minus).  
 * <ul>
 *   <li>There is one child, the expression to be negated
 *   <li>The getLabel() method returns the string "Negative".
 *   <li>The getText() method returns an empty string.
 * </ul>
 */

public class AopNegation extends SingleExpressionAbstract
{
  /**
   * The variable exp represents the given expression
   */
  private Expression expr;

  /**
   * Constructs a new unary expression representing the negative
   * of the given expression.
   * @param expr
   *   arithmetic expression to be negated
   */
  public AopNegation(Expression expr)
  {
    super.SingleExpressionAbstract(expr);
    this.expr = expr;
  }

  /**
   * Method that returns the label of this node as a string
   * @return Returns the label string for this node
   */
  @Override
  public String getLabel()
  {
    return "Negative";
  }

  /**
   * Returns the value of this expression in the given scope. If the expression contains no variables, the scope is ignored.
   * @param env scope with which this expression is to be evaluated
   * @return returns the value of the expression in the given scope
   */
  @Override
  public int eval(Scope env)
  {
    int val = expr.eval(env);
    return val * -1;
  }

}
