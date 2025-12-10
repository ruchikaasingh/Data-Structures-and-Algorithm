class Solution {
    public int lastStoneWeight(int[] stones) {
        ArrayList<Integer> st = new ArrayList<>();
        for(int x : stones) st.add(x);
        
        while(st.size() > 1) {
            Collections.sort(st);
            int a = st.remove(st.size()-1);
            int b = st.remove(st.size()-1);
            
            if(a != b) st.add(a-b);
        }
        
        return st.isEmpty() ? 0 : st.get(0);
    }
}
