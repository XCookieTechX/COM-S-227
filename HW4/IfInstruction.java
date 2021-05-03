package hw4;

import api.DefaultNode;
import api.Expression;
import api.Instruction;
import api.Scope;
import parser.ProgramNode;

/**
 * Instruction type representing a conditional.  A conditional has an
 * expression and two instructions.  If the expression evaluates to a 
 * nonzero value (i.e., "true"), the first instruction is executed; otherwise, the 
 * second instruction is executed.
 * <ul>
 *   <li>There are three children; the first is the expression, the second 
 *   is the instruction for the "true", the third is the instruction for
 *   the "false" branch
 *   <li>The getLabel() method returns the string "If".
 *   <li>The getText() method returns an empty string.
 * </ul>
 */

public class IfInstruction extends InstructionAbstract
{
  /**
   * The variable expr represents the expression to use in the condition
   */
  private Expression expr;

  /**
   * The variable instr0 represents the statement to be executed if the condition is true (nonzero)
   */
  private Instruction instr0;

  /**
   * the variable instr1 represents the statment to be executed if the condition is false (zero)
   */
  private  Instruction instr1;
  
  /**
   * Constructs a conditional statement from the given condition
   * and alternative actions.
   * @param condition
   *    an expression to use as the condition
   * @param s0
   *    statement to be executed if the condition is true (nonzero)
   * @param s1
   *    statement to be executed if the condition is false (zero)
   */
  public IfInstruction(Expression condition, Instruction s0, Instruction s1)
  {
    expr = condition;
    instr0 = s0;
    instr1 = s1;
  }

  /**
   * Method that returns the label of this node as a string
   * @return Returns the label string for this node
   */
  @Override
  public String getLabel()
  {
    return "If";
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
      return instr0;
    }
    else if(i == 2)
    {
     return instr1;
    }else{
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
    int value = expr.eval(env);
    if(value != 0){
      instr0.execute(env);
    }else{
      instr1.execute(env);
    }
  }
  

}
