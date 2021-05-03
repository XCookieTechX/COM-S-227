package postage1;

import static java.lang.Math.ceil;
import java.util.Scanner;
public class PostageUtil
{
  /**
   * Returns the cost of postage for a letter of the given weight.
   * @param weight
   *   given weight in ounces
   * @return
   *   cost of postage for the weight
   */
  public static double computePostage(double weight)
  {
    double cost;

    if (weight <= 1) {
      cost = .47;
    }else{
      if (weight <= 3.5){
        cost = .47 + ceil(weight - 1) * .21;
      }else{
        cost = .94 + ceil(weight - 1) * .21;
      }
    }
    return cost;
  }
  public static void main(String[] args)
  {
    Scanner scnr = new Scanner(System.in);
    double weight = scnr.nextDouble();

    System.out.println(computePostage(weight));
  }
}