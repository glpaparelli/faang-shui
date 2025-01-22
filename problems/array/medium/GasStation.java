package problems.array.medium;
/*
 * LEETCODE 134: Gas Station 
 * There are n gas station along a circular route, where the amount of
 * the gas at the i-th station is gas[i].
 *  
 * You have a car with an unlimited gas tank and it costs cost[i] of gas
 * to travel from the i-th station to its next (i+1)-th station. 
 * You begin your journey with an empty tank at one of the gas stations.
 * 
 * Given two integers arrays "gas" and "cost" return the starting gas
 * station's index if you can travel around the circuit once in the 
 * clockwise direction, otherwise return -1; 
 * 
 * If there exists a solution, it is guaranteed to be unique.
 * 
 * SOLUTION: 
 * - Optimal Solution, O(n) time and O(1) space.
 *   A mix of precomputation and greedyness, check the comments.
 */
public class GasStation {
    public static void main(String[] args) {
        int[] gas1 = new int[]{1,2,3,4,5};
        int[] cost1 = new int[]{3,4,5,1,2};
        System.out.println(canCompleteCircuit(gas1, cost1));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int tank = 0; // of gas left in the tank
        int gain = 0; // gas that we obtain from going from the current station to the next one

        // its the sum of all gains. 
        int totalGain = 0; 

        // select the first station to start.
        int start = 0; 
        for (int i = start; i < gas.length; i++) {
            // starting in the "start" station we obtain gain gas 
            gain = gas[i] - cost[i];
            tank += gain;
            totalGain = totalGain + gain;

            // if the tank is < 0 it means that we cannot move, 
            // the starting station do not allow us to complete the trip, 
            // we have to change it.
            if (tank < 0) {
                start = i+1;
                tank = 0;
            }
        }

        // if we perform a round trip the total gained gas has to be at least 0, 
        // otherwise it would not be possible to complete the trip.
        if (totalGain >= 0)
            return start;
        else 
            return -1;
    }
}
