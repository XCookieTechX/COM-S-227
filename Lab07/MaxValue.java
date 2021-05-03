package lab7;

public class MaxValue {
    public static void main(String[] args) {
        int[] test = {1, 1, 3, 4, 10, 6, 7, 8, 9};
        int result = maxValue(test, 0, test.length - 1);
        System.out.println(result);
    }
        public static int maxValue(int[] string, int start, int end){

            if(end - start <=  1) {
            	return Math.max(string[start], string[end]);
            }

            int mid = (start + end) / 2;
            int leftNum = maxValue(string, start, mid);
            int rightNum = maxValue(string, mid + 1, end);
            return Math.max( leftNum, rightNum);
        }
}
