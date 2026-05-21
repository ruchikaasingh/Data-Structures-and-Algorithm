class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> set= new HashSet<>();

        //divide all numbers of arr1 into prefixes by slicing them
        for(int elem: arr1){
            while(elem>0){
                set.add(elem);
                elem/= 10;
            }
        }
        int maxlen=0;

        //compare against arr1 for bigger val of prefix
        for(int elem: arr2){
            while(elem>0){
                if(set.contains(elem)){
                    maxlen= Math.max(String.valueOf(elem).length() , maxlen);
                    break; //got bigger common slice so break
                }
                else{
                    elem/=10; //slice the number more
                }
            }
        }
        return maxlen;
    }
}