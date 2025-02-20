package problems.strings;
/*
 * Question: https://leetcode.com/discuss/interview-question/5304069/amazon-OA-new-grad
 */
public class Amazon3 {
    public static void main(String[] args) {
        System.out.println(maxNumberOfParcels(new int[]{1,2,3,2,6,3}));
        System.out.println(maxNumberOfParcels(new int[]{1,3,4,2,1,6,8,1,2,12,3}));
    }

    public static int maxNumberOfParcels(int[] weights) {
        int res = 0; 

        int max = weights[0];

        int left = 0; 
        int right = left + 1;

        while (right < weights.length) {

            if (max < weights[right]) {
                max = weights[right];
                right++;
            }
            else {
                res++; 
                left = right+1; 
                right = left+1;
            }
        }

        return res;
    }
}
