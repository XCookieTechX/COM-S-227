package lab7;

public class FindBalls {
    public static void main(String[] args) {
        System.out.println(getPyramidCount(5));
    }
    public static int getPyramidCount(int levels){
        if (levels == 1){
            return 1;
        }else{
            return (levels * levels + getPyramidCount(levels - 1));
        }
    }
}
