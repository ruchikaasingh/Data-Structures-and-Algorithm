class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, List<Character>> map = new HashMap<>();
        for (String a : allowed) {
            String key = a.substring(0, 2);
            char c = a.charAt(2);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(c);
        }

        Set<String> bad = new HashSet<>();
        return dfs(bottom, map, bad);
    }

    private boolean dfs(String row, Map<String, List<Character>> map, Set<String> bad) {
        if (row.length() == 1) return true;
        if (bad.contains(row)) return false;
        List<String> nextRows = new ArrayList<>();
        buildNextRows(row, 0, new StringBuilder(), map, nextRows);
        if (nextRows.isEmpty()) {
            bad.add(row);
            return false;
        }
        for (String next : nextRows) {
            if (dfs(next, map, bad)) return true;
        }
        bad.add(row);
        return false;
    }

    private void buildNextRows(String row, int idx, StringBuilder sb,
                               Map<String, List<Character>> map, List<String> res) {
        if (idx == row.length() - 1) {
            res.add(sb.toString());
            return;
        }
        String key = row.substring(idx, idx + 2);
        List<Character> list = map.get(key);
        if (list == null) return;
        for (char c : list) {
            sb.append(c);
            buildNextRows(row, idx + 1, sb, map, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
