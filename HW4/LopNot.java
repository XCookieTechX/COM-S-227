package hw4;

import api.Expression;
import api.Scope;

/**
 * Node type representing a logical expression 
 * with the "not" operator. If expr evaluates to zero, 
 * then this expression evaluates to 1; otherwise, this
 * expression evaluates to 0. 
 * <ul>
 *   <li>There is one child, the expression to be logically negated
 *   <li>The getLabel() method returns the string "!".
 *   <li>The getText() method returns an empty string.
 * </ul>
 */

public class LopNot extends SingleExpressionAbstract
{
  /**
   * The variable exp represents the given expression
   */
  private Expression expr;

  /**
   * Constructs a unary expression that represents the logical negation
   * of the given expression.  
   * @param expr
   *   the logical expression to be negated
   */
  public LopNot(Expression expr)
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
    return "!";
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
    if(val == 0){
      return 1;
    }else{
      return 0;
    }
  }
}
