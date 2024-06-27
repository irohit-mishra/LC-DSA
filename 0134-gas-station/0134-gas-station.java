class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
     int totalGas = 0;
        int totalCost = 0;
        int currentTank = 0;
        int startStation = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            currentTank += gas[i] - cost[i];
            if (currentTank < 0) {
                currentTank = 0;
                startStation = i + 1;
            }
        }

        return totalGas >= totalCost ? startStation : -1;
    }   
    
}