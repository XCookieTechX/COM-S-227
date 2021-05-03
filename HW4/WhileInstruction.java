package hw4;

import api.DefaultNode;
import api.Expression;
import api.Instruction;
import api.Scope;
import parser.ProgramNode;

/**
 * Instruction type representing a while-loop.  A loop has an
 * expression and an instruction.  If the expression evaluates to a 
 * nonzero value (i.e., "true"), the instruction is executed
 * and the expression is re-evaluated, and this process continues 
 * until the expression evaluates to 0 ("false").
 * <ul>
 *   <li>There are two children; the first is the expression, the second 
 *   is the instruction
 *   <li>The getLabel() method returns the string "While".
 *   <li>The getText() method returns an empty string.
 * </ul>
 */

public class WhileInstruction extends InstructionAbstract
{

  /**
   * The variable expr represents the expression for the loop condition
   */
  private Expression expr;

  /**
   * the variable instr represents the instruction for the loop body
   */
  private Instruction instr;
  
  /**
   * Constructs a while statement from the given condition and body
   * @param condition
   *   expression for the loop condition
   * @param s
   *   instruction for the loop body
   */
  public WhileInstruction(Expression condition, Instruction s)
  {
    this.expr = condition;
    this.instr = s;

  }

  /**
   * Method that returns the label of this node as a string
   * @return Returns the label string for this node
   */
  @Override
  public String getLabel()
  {
    return "While";
  }

  /**
   * Executes the given instruction in the given scope. Note that an instruction may update the scope by creating variables or assigning new values to variables.
   * @param env scope in which this statement will be executed
   */
  @Override
  public void execute(Scope env)
  {
    int value = expr.eval(env);

    while(value != 0){
      instr.execute(env);
      value = expr.eval(env);
    }
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
      return expr;
    }
    else if (i == 1)
    {
      return instr;
    }
    else
    {
      return new DefaultNode("Invalid index " + i + " for type " + this.getClass().getName());
    }
  }

}