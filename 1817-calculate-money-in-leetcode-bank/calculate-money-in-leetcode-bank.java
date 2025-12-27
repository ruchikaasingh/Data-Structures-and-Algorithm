class Solution {
    public int totalMoney(int n) {
        int total = 0;
        int weekStart = 1;

        for (int day = 1; day <= n; day++) {
            total += weekStart;
            weekStart++;

            // Every 7 days, reset weekStart correctly
            if (day % 7 == 0) {
                weekStart = day / 7 + 1;
            }
        }
        return total;
    }
}
