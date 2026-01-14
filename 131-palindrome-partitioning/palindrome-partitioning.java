class Solution {
    public List<List<String>> partition(String s) {
        int n = s.length();
        boolean[][] isPal = new boolean[n][n];

        // DP precompute palindromes (MCM-esque bottom up)
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 2) isPal[i][j] = true;
                    else isPal[i][j] = isPal[i + 1][j - 1];
                }
            }
        }

        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        dfs(0, s, isPal, path, res);
        return res;
    }

    private void dfs(int i, String s, boolean[][] isPal,
                     List<String> path, List<List<String>> res) {

        if (i == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int j = i; j < s.length(); j++) {
            // MCM-like partition from i to j
            if (!isPal[i][j]) continue;

            path.add(s.substring(i, j + 1));
            dfs(j + 1, s, isPal, path, res);
            path.remove(path.size() - 1);
        }
    }
}
