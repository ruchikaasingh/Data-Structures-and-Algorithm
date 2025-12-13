class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        int n = code.length;
        List<Coupon> list = new ArrayList<>();

        // allowed business lines
        Set<String> allowed = new HashSet<>(Arrays.asList(
                "electronics", "grocery", "pharmacy", "restaurant"
        ));

        for (int i = 0; i < n; i++) {
            if (!isActive[i]) continue;
            if (!allowed.contains(businessLine[i])) continue; // NEW RULE
            if (!isValid(code[i])) continue;
            list.add(new Coupon(businessLine[i], code[i]));
        }

        Collections.sort(list, (a, b) -> {
            int cmp = a.businessLine.compareTo(b.businessLine);
            if (cmp != 0) return cmp;
            return a.code.compareTo(b.code);
        });

        List<String> ans = new ArrayList<>();
        for (Coupon c : list) ans.add(c.code);
        return ans;
    }

    private boolean isValid(String s) {
        if (s == null || s.isEmpty()) return false;
        for (char c : s.toCharArray()) {
            if (!Character.isLetterOrDigit(c) && c != '_') return false;
        }
        return true;
    }

    static class Coupon {
        String businessLine, code;
        Coupon(String b, String c) {
            businessLine = b;
            code = c;
        }
    }
}
