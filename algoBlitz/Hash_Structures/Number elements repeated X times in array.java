
import java.io.*;
import java.util.*;


class Solution {
  public static void main(String[] args) {
  // int[] arr1 = {1, 2, 3, 1, 2, 3};
  // System.out.println( "tc 1 = " + countEcactOccurrences(arr1, 2));
  //  int[] arr2 = {1, 2, 3, 1, 2, 3};
  // System.out.println( "tc 2 = " +countEcactOccurrences(arr2, 3));
   int[] arr3 = {100};
  System.out.println( "tc 3 = " +countEcactOccurrences(arr3, 100));
  }

/*

📆 PLAN
High-level outline of approach #: 
 - iterate through the array O(n)
 - at each element add it to map and increase count O(1)
 -  look through hashmap, check if the value mapped to the key == X, if yes, increment count O(n)
~O(n) for TC

'''
*/

public static int countEcactOccurrences(int[] arr, int exactOccurrences){

int count = 0;
HashMap<Integer,Integer> numberOccurence = new HashMap<Integer,Integer>();

for (int i=0; i<arr.length; i++){
  numberOccurence.merge(arr[i],1,(v1,v2) -> v1 + 1);
}

for (Map.Entry<Integer,Integer> item: numberOccurence.entrySet()){
  if (item.getValue() == exactOccurrences) count++;
    }

  return count;
  }
}