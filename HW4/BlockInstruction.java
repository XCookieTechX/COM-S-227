package hw4;

import java.util.ArrayList;

import api.DefaultNode;
import api.Instruction;
import api.Scope;
import parser.ProgramNode;

/**
 * Compound instruction representing a sequence of instructions.  Execution
 * of a block iterates through the sequence, calling execute() on each
 * one. When initially constructed, the block contains no instructions.  
 * Instruction objects are added to the sequence using the method
 * <pre>
 *     public void addStatement(Instruction s)
 * </pre>
 * <ul>
 *   <li>The number of children is the number of statements in
 *       this block (possibly zero).
 *   <li>The getLabel() method returns the string "Block".
 *   <li>The getText() method returns an empty string
 * </ul>
 */

public class BlockInstruction extends InstructionAbstract
{

  /**
   * list variable represents the sequence of instructions to be executed
   */
  private ArrayList<Instruction> list;

  /**
   * Constructs an empty sequence of instructions.
   */
  public BlockInstruction()
  {
    list = new ArrayList<>();
  }

  /**
   * Adds an instruction to this block.  The instructions will be executed
   * in the order added.
   * @param s
   *   instruction to be added to this block
   */
  public void addStatement(Instruction s)
  {
    list.add(s);
  }

  /**
   * Method that returns the label of this node as a string
   * @return Returns the label string for this node
   */
  @Override
  public String getLabel()
  {
    return "Block";
  }

  /**
   * Method that returns the number of children the expression has
   * @return returns the number of children the expression has
   */
  @Override
  public int getNumChildren() {
    return list.size();
  }

  /**
   * Returns the specified child node of this node
   * @param index the index of the child to return
   * @return the child at index
   */
  @Override
  public ProgramNode getChild(int index)
  {
    if (index >= 0 && index < list.size())
    {
      return list.get(index);
    }
    else
    {
      return new DefaultNode("Out of bounds index " + index + " for ParameterList.");
    }
  }

  /**
   * Executes the given instruction in the given scope. Note that an instruction may update the scope by creating variables or assigning new values to variables.
   * @param env scope in which this statement will be executed
   */
  @Override
  public void execute(Scope env)
  {
    for(int i = 0; i < list.size(); i++){
      list.get(i).execute(env);
    }
  }
}
