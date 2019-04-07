package FirstProblem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {



    boolean isAnagram(String lhs, String rhs){

        Map<Character, Integer> map = new HashMap<>();

        for (int i=0;i<lhs.length();i++){
            if (map.get(lhs.charAt(i))==null){
                map.put(lhs.charAt(i), 1);
            }else{
                map.put(lhs.charAt(i), map.get(lhs.charAt(i))+1);
            }
        }

        int index=0;
        boolean result = (lhs.length()==rhs.length());
        while (result && index<rhs.length()){
            if (map.get(rhs.charAt(index))==null){
                result = false;
            }else{
                int counter = map.get(rhs.charAt(index));
                if (counter>1){
                    map.put(rhs.charAt(index), counter -1);
                }else {
                    map.remove(rhs.charAt(index));
                }
            }
            index++;
        }

        return result;
    }

}
