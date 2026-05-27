class Solution {
    public int numberOfSpecialChars(String word) {
        int n= word.length();

        HashMap<Character, Integer> map= new HashMap<>();
        for(int i=0; i<n; i++){
            char ch= word.charAt(i);
            if(ch>='a' && ch<='z'){
                if(map.containsKey(ch)){
                    map.replace(ch, i);
                }
                else{
                    map.put(ch, i);
                }
            }
            else{
                if(map.containsKey(ch)){
                    continue;
                }
                else{
                    map.put(ch, i);
                }
            }
        }
        
        int count=0;
        for(char ch= 'a' ; ch<= 'z'; ch++){
            if(map.containsKey(ch) && map.containsKey(Character.toUpperCase(ch))){
                if(map.get(ch)- map.get(Character.toUpperCase(ch)) < 0){
                    count++;
                }
            }
        }
        return count;
    }
}