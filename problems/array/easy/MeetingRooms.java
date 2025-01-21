package problems.array.easy;

import java.util.Arrays;

/*
 * LEETCODE 252: Meeting Rooms
 * Given an array of meeting time intervals consisting of start and end times
 * [[s1,e1], [s2,e2], ...] with s_i < e_i, determine if a person could attend all meetings.
 * 
 * SOLUTION: 
 * - Sptimal Solution: O(n) time, O(1) space
 *   Greedy Approach: sort by ending time and check if the last meeting taken ends before
 *   the next meeting starts, if not return false. 
 */
public class MeetingRooms {
    public static void main(String[] args) {
        int ex1[][] = {
            {0,30}, 
            {5,10}, 
            {15,20}
        };
        System.out.println(meetingRooms(ex1));

        int ex2[][] = {
            {7,10}, 
            {2,4}
        };
        System.out.println(meetingRooms(ex2));        
    }

    public static boolean meetingRooms(int[][] meetings) {
        if (meetings.length == 1)
            return true; 

        int start = 0;
        int finish = 1;

        // sort the meetings by their ending time
        Arrays.sort(meetings, (m1, m2) -> Integer.compare(m1[finish], m2[finish]));

        int lastMeetingEnds = meetings[0][1];

        for (int i = 1; i < meetings.length; i++) {
            if (lastMeetingEnds > meetings[i][start])
                return false;
            else 
                lastMeetingEnds = meetings[i][finish];
        }

        return true;
    }

}
