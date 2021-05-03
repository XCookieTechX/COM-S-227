package hw3;
import java.util.ArrayList;
import java.util.Random;

import api.*;

/**
 * The Powers class contains the state and logic for an implementation of a game
 * similar to "2048".  The basic underlying state is an n by n grid of tiles, 
 * represented by integer values.  A zero in a cell is considered to be
 * "empty", and all other cells contain some power of two.  The game is played
 * by calling the method <code>shiftGrid()</code>, selecting one of the four
 * directions (LEFT, RIGHT, UP, DOWN). Each row or column is then collapsed
 * according to the algorithm described in the methods of <code>ShiftUtil</code>.
 * <p>
 * Whenever two cells are <em>merged</em>, the score is increased by the 
 * combined value of the two cells.
 * 
 * @author Christopher Brown
 */
public class Powers
{
  /**
   * The score variable stores the current score of the game
   */
  private int score;
  /**
   * The size variable stores the current size of the game/grid
   */
  private int size;
  /**
   * The grid variable stores the current grid of the game
   */
  private int[][] grid;
  /**
   * The rand variable stores the random object in the game
   */
  private Random rand;
  /**
   * The util variable stores the shiftUtil object in the game
   */
  private ShiftUtil util;
  
  /**
   * Constructs a game with a grid of the given size, using a default
   * random number generator.  Initially there should be two
   * nonempty cells in the grid selected by the method <code>generateTile()</code>.
   * @param givenSize
   *   size of the grid for this game
   * @param givenUtil
   *   instance of ShiftUtil to be used in this game
   */
  public Powers(int givenSize, ShiftUtil givenUtil)
  {
    this(givenSize, givenUtil, new Random());

  }
  
  /**
   * Constructs a game with a grid of the given size, using the given
   * instance of <code>Random</code> for its random number generator.
   * Initially there should be two nonempty cells in the grid selected 
   * by the method <code>generateTile()</code>.
   * @param givenSize
   *   size of the grid for this game
   * @param givenUtil
   *   instance of ShiftUtil to be used in this game
   * @param givenRandom
   *   given instance of Random
   */
  public Powers(int givenSize, ShiftUtil givenUtil, Random givenRandom)
  {
    score = 0;
    util = givenUtil;
    size = givenSize;
    rand = givenRandom;

    //constructs a new grid
    grid = new int[size][size];
    for(int i = 0; i < grid.length; i++){
      for(int j = 0; j < grid[i].length; j++){
        grid[i][j] = 0;
      }
    }

    //sets the first random tile
    TilePosition tile = generateTile();
    grid[tile.getRow()][tile.getCol()] = tile.getValue();

    //sets the second random tile if there is room for one
    if(generateTile() != null){
      tile = generateTile();
      grid[tile.getRow()][tile.getCol()] = tile.getValue();
    }


  }
  
  /**
   * Returns the value in the cell at the given row and column.
   * @param row
   *   given row
   * @param col
   *   given column
   * @return
   *   value in the cell at the given row and column
   */
  public int getTileValue(int row, int col)
  {

    return grid[row][col];
  }
  
  /**
   * Sets the value of the cell at the given row and column.
   * <em>NOTE: This method should not normally be used by clients outside
   * of a testing environment.</em>
   * @param row
   *   given row
   * @param col
   *   given col
   * @param value
   *   value to be set
   */
  public void setValue(int row, int col, int value)
  {
    grid[row][col] = value;
  }
  
  /**
   * Returns the size of this game's grid.
   * @return
   *   size of the grid
   */
  public int getSize()
  {
    return size;
  }
  
  /**
   * Returns the current score.
   * @return
   *   score for this game
   */
  public int getScore()
  {
    return score;
  }
  
  /**
   * Copy a row or column from the grid into a new one-dimensional array.  
   * There are four possible actions depending on the given direction:
   * <ul>
   *   <li>LEFT - the row indicated by the index <code>rowOrColumn</code> is
   *   copied into the new array from left to right
   *   <li>RIGHT - the row indicated by the index <code>rowOrColumn</code> is
   *   copied into the new array in reverse (from right to left)
   *   <li>UP - the column indicated by the index <code>rowOrColumn</code> is
   *   copied into the new array from top to bottom
   *   <li>DOWN - the row indicated by the index <code>rowOrColumn</code> is
   *   copied into the new array in reverse (from bottom to top)
   * </ul>
   * @param rowOrColumn
   *   index of the row or column
   * @param dir
   *   direction from which to begin copying
   * @return
   *   array containing the row or column
   */
  public int[] getRowOrColumn(int rowOrColumn, Direction dir)
  {
    int i;
    int j = 0;
    int[] rowOrCol = new int[size];
    if(dir == Direction.LEFT){
      for(i = 0; i < grid.length; i++){
        rowOrCol[i] = grid[rowOrColumn][i];
      }
    }else if(dir == Direction.RIGHT){
      for(i = grid.length - 1; i >= 0; i--){
        rowOrCol[j] = grid[rowOrColumn][i];
        j++;
      }
    }else if(dir == Direction.UP){
      for(i = 0; i < grid.length; i++){
        rowOrCol[i] = grid[i][rowOrColumn];
      }
    }else{
      for(i = grid.length - 1; i >= 0; i--){
        rowOrCol[j] = grid[i][rowOrColumn];
        j++;
      }
    }
    return rowOrCol;
  }
  
  /**
   * Updates the grid by copying the given one-dimensional array into
   * a row or column of the grid.
   * There are four possible actions depending on the given direction:
   * <ul>
   *   <li>LEFT - the given array is copied into the the row indicated by the 
   *   index <code>rowOrColumn</code> from left to right
   *   <li>RIGHT - the given array is copied into the the row indicated by the 
   *   index <code>rowOrColumn</code> in reverse (from right to left)
   *   <li>UP - the given array is copied into the column indicated by the 
   *   index <code>rowOrColumn</code> from top to bottom
   *   <li>DOWN - the given array is copied into the column indicated by the 
   *   index <code>rowOrColumn</code> in reverse (from bottom to top)
   * </ul>
   * @param arr
   *   the array from which to copy
   * @param rowOrColumn
   *   index of the row or column
   * @param dir
   *   direction from which to begin copying
   */
  public void setRowOrColumn(int[] arr, int rowOrColumn, Direction dir)
  {
    int i;
    int j = 0;

    if(dir == Direction.LEFT){
      for(i = 0; i < grid.length; i++){
        grid[rowOrColumn][i] = arr[i];
      }
    }else if(dir == Direction.RIGHT){
      for(i = grid.length - 1; i >= 0; i--){
        grid[rowOrColumn][i] = arr[j];
        j++;
      }
    }else if(dir == Direction.UP){
      for(i = 0; i < grid.length; i++){
        grid[i][rowOrColumn] = arr[i];
      }
    }else{
      for(i = grid.length - 1; i >= 0; i--){
        grid[rowOrColumn][i] = arr[j];
        j++;
      }
    }

  }

  /**
   * Plays one step of the game by shifting the grid in the given direction.
   * Returns a <code>MoveResult</code> object containing a list of Descriptor 
   * objects describing all moves performed, and a <code>TilePosition</code> object describing
   * the position and value of a newly added tile, if any. 
   * If no tiles are actually moved, the returned <code>MoveResult</code> object contains an 
   * empty list and has a null value for the new <code>TilePosition</code>.
   * <p>
   * If any tiles are moved or merged, a new tile is selected according to the 
   * <code>generate()</code> method and is added to the grid.
   * <p>
   * The shifting of each individual row or column must be performed by the 
   * method <code>shiftAll</code> of <code>ShiftUtil</code>. 
   * 
   * @param dir
   *   direction in which to shift the grid
   * @return
   *   MoveResult object containing move descriptors and new tile position
   */
  public MoveResult doMove(Direction dir)
  {
    MoveResult result = new MoveResult();
    ArrayList<Shift> list;
    int[] arr;
    int i;
    int j;
    int flag = 0;

    //left
    if(dir == Direction.LEFT){
      for(i = 0; i < grid.length; i++){

        //moves the grid 1 array at a time by calling shiftAll
        arr = getRowOrColumn(i, Direction.LEFT);
        list = util.shiftAll(arr);
        setRowOrColumn(arr, i, Direction.LEFT);

        //finds if there is a shift or merge, then adds that to the descriptor arraylist
        if(list.size() > 0){
          flag = 1;
          for(j = 0; j < list.size(); j++){
            Descriptor desc = new Descriptor(list.get(j), i, Direction.LEFT);
            result.addMove(desc);

            //adds score if there is a merge
            if(list.get(j).isMerge()){
              score += list.get(j).getNewIndex();
            }
          }
        }

      }
      //generates and places a new random tile if a shift or merge has occurred
      if(flag == 1){
        TilePosition tile = generateTile();
        grid[tile.getRow()][tile.getCol()] = tile.getValue();
        result.setNewTile(tile);
      }

      //right
    }else if(dir == Direction.RIGHT){
      for(i = 0; i < grid.length; i++){
        //moves the grid 1 array at a time by calling shiftAll
        arr = getRowOrColumn(i, Direction.RIGHT);
        list = util.shiftAll(arr);
        setRowOrColumn(arr, i, Direction.RIGHT);

        //finds if there is a shift or merge, then adds that to the descriptor arraylist
        if(list.size() > 0){
          flag = 1;
          for(j = 0; j < list.size(); j++){
            Descriptor desc = new Descriptor(list.get(j), i, Direction.RIGHT);
            result.addMove(desc);

            //adds score if there is a merge
            if(list.get(j).isMerge()){
              score += list.get(j).getNewIndex();
            }
          }
        }

      }
      //generates and places a new random tile if a shift or merge has occurred
      if(flag == 1){
        TilePosition tile = generateTile();
        grid[tile.getRow()][tile.getCol()] = tile.getValue();
        result.setNewTile(tile);
      }


      //up
    }else if(dir == Direction.UP){
      for(i = 0; i < grid.length; i++){
        //moves the grid 1 array at a time by calling shiftAll
        arr = getRowOrColumn(i, Direction.UP);
        list = util.shiftAll(arr);
        setRowOrColumn(arr, i, Direction.UP);

        //finds if there is a shift or merge, then adds that to the descriptor arraylist
        if(list.size() > 0){
          flag = 1;
          for(j = 0; j < list.size(); j++){
            Descriptor desc = new Descriptor(list.get(j), i, Direction.UP);
            result.addMove(desc);

            //adds score if there is a merge
            if(list.get(j).isMerge()){
              score += list.get(j).getNewIndex();
            }
          }
        }

      }
      //generates and places a new random tile if a shift or merge has occurred
      if(flag == 1){
        TilePosition tile = generateTile();
        grid[tile.getRow()][tile.getCol()] = tile.getValue();
        result.setNewTile(tile);
      }

      //down
    }else{
      for(i = 0; i < grid.length; i++){
        //moves the grid 1 array at a time by calling shiftAll
        arr = getRowOrColumn(i, Direction.DOWN);
        list = util.shiftAll(arr);
        setRowOrColumn(arr, i, Direction.DOWN);

        //finds if there is a shift or merge, then adds that to the descriptor arraylist
        if(list.size() > 0){
          flag = 1;
          for(j = 0; j < list.size(); j++){
            Descriptor desc = new Descriptor(list.get(j), i, Direction.DOWN);
            result.addMove(desc);

            //adds score if there is a merge
            if(list.get(j).isMerge()){
              score += list.get(j).getNewIndex();
            }
          }
        }

      }
      //generates and places a new random tile if a shift or merge has occurred
      if(flag == 1){
        TilePosition tile = generateTile();
        grid[tile.getRow()][tile.getCol()] = tile.getValue();
        result.setNewTile(tile);
      }
    }

    return result;
  }

  /**
   * Use this game's instance of <code>Random</code> to generate
   * a new tile.  The tile's row and column must be an empty cell
   * of the grid, and the tile's value is either 2 or 4. 
   * The tile is selected in such a way that
   * <ul>
   *   <li>All empty cells of the grid are equally likely
   *   <li>The tile's value is a 2 with 90% probability and a 4 with 10% probability
   * </ul>
   * This method does not modify the grid.  If the grid has no
   * empty cells, returns null.
   * @return
   *   a new TilePosition containing the row, column, and value of the
   *   selected new tile, or null if the grid has no empty cells
   */
  public TilePosition generateTile()
  {

    //finds positions that are available to put a tile there if any
    ArrayList<TilePosition> list = new ArrayList<TilePosition>();
    for(int i = 0; i < grid.length; i++){
      for(int j = 0; j < grid[i].length; j++){
        if(grid[i][j] == 0){
          TilePosition tile = new TilePosition(i, j, 0);
          list.add(tile);
        }
      }
    }

    if(list.size() >= 1){
      int value;
      int col;
      int row;
      int[] pos = {2, 2, 2, 2, 2, 2, 2, 2, 2, 4};
      int temp = rand.nextInt(10);
      value = pos[temp];
      int tilePos;


      //if the array only has 1 item in it
      if(list.size() == 1){
        TilePosition tile = list.get(0);
        col = tile.getCol();
        row = tile.getRow();

        tile = new TilePosition(row, col, value);

        return tile;
      }else{
        TilePosition tile = list.get(rand.nextInt(list.size()));
        col = tile.getCol();
        row = tile.getRow();

        tile = new TilePosition(row, col, value);

        return tile;
      }
    }

    return null;
  }

}
  










