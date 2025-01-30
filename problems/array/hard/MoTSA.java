package problems.array.hard;
/*
 * LEETCODE 4: Median of Two Sorted Array
 * Given two sorted arrays "nums1" and "nums2" of size m and n
 * respectively, return the median of the two sorted arrays.
 * 
 * The overall run time complexity should be O(log(m+n));
 */
public class MoTSA {
    public static void main(String[] args) {
    }

    public static double median(int[] nums1, int[] nums2) {
        // TODO

        // nums1 must be the smaller array
        if (nums1.length > nums2.length) 
            return median(nums2, nums1);
        
        // binary search nums1
        int left = 0;
        int right = nums1.length;
        while (left <= right) {
            
            // Partition nums1 and nums2
            int partition1 = (left + right) / 2;
            int partition2 = (nums1.length + nums2.length + 1) / 2 - partition1;

            // Find the maximum elements on the left of the partition
            int maxLeft1 = partition1 > 0 ? nums1[partition1 - 1] : Integer.MIN_VALUE;
            int maxLeft2 = partition2 > 0 ? nums2[partition2 - 1] : Integer.MIN_VALUE;
            int maxLeft = Math.max(maxLeft1, maxLeft2);

            // Find the minimum elements on the right of the partition
            int minRight1 = partition1 < nums1.length ? nums1[partition1] : Integer.MAX_VALUE;
            int minRight2 = partition2 < nums2.length ? nums2[partition2] : Integer.MAX_VALUE;
            int minRight = Math.min(minRight1, minRight2);

            // Check if the partition is correct
            if (maxLeft <= minRight) {
                // If the total length is even, return the average of the two middle elements
                if ((nums1.length + nums2.length) % 2 == 0) {
                    return (maxLeft + minRight) / 2.0;
                }
                // If the total length is odd, return the middle element
                else {
                    return maxLeft;
                }
            } else if (maxLeft1 > minRight2) {
                right = partition1 - 1;
            } else {
                left = partition1 + 1;
            }
        }

        return 0.0; // This should not be reached, just to satisfy Java's return requirements
    }
}
