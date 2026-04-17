class Solution {
    public boolean isAnagram(String s, String t) {

        HashMap<Character, Integer> map1= new HashMap<>(); //string s
        HashMap<Character, Integer> map2= new HashMap<>(); //String t

        for(char ch: s.toCharArray()){
            int count1= map1.getOrDefault(ch, 0)+1;
            map1.put(ch, count1);
        }

        for(char ch: t.toCharArray()){
            int count2= map2.getOrDefault(ch, 0)+1;
            map2.put(ch, count2);
        }

        return map1.equals(map2);

    }
}