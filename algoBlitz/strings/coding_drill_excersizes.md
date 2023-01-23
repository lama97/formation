
## countTargetString 
Q. Given a string and a target string, count the number of times the target string shows up in the input string. String parts that were already counted cannot be counted again (no overlapping allowed).

Example:
Input: "111", target = "11"
Output: 1 (if the overlapping was allowed, the answer would be 2)

```java
int countTargetString(String input, String target) {
    int count = 0;
    int index = input.indexOf(target);
    while (index != -1) {
        count++;
        index = input.indexOf(target, index + target.length());
    }
    return count;
}

```

## removeTargetStringFTimes
Given a string, a target string, and a frequency ```f```, remove the target ```f``` number of times from the beginning of the input string. If ```f``` exceeds the number of target strings appeared in the input string, do nothing.

```java
public  String removeTargetStringFTimes(String input, String target, int f) {
    String originalString = input;
    int count = 0;
    int index = input.indexOf(target);
    while (index != -1 && count < f) {
      input = input.replaceFirst(target,"");
      count++;
      index = input.indexOf(target);
    }

    if(count<f) return originalString;
    return input;
}
```

**alternative** instead of ```replaceFirst()```, you can split the string into seg1 & seg2 and concatenate them after removing the target from the input: 

```java
public static String removeTargetStringFTimes(String input, String target, int f) {
    String originalString = input;
    int count = 0;
    int index = input.indexOf(target);
    while (index != -1 && count < f) {
      String seg1 = input.substring(0,index);
      String seg2 = input.substring(index+target.length());
      input = seg1.concat(seg2);
      count++;
      index = input.indexOf(target);
    }
    if(count<f) return originalString;
    return input;
}```

## alphabeticShift
Given a string, your task is to replace each of its characters by the next one in the English alphabet; i.e. replace `a` with `b`, replace `b` with `c`, etc (`z` would be replaced by `a`).

__Example__
For `inputString = "crazy"`, the output should be `solution(inputString) = "dsbaz"`.

### Approach 1 

```java
String alphabeticShift(String inputString) {
    StringBuilder output = new StringBuilder();
    for (char c : inputString.toCharArray()) {
        if (c == 'z') {
            output.append('a');
        } else if (c == 'Z') {
            output.append('A');
        } else {
            output.append((char)(c + 1));
        }
    }
    return output.toString();
}
```
For each character, if the character is 'z' or 'Z', the algorithm appends 'a' or 'A' respectively. Otherwise, it appends the next character in the alphabet by adding 1 to the character's ASCII value.

### Approach 2 
```java
String alphabeticShift(String inputString) {
    return inputString.replaceAll("[a-yA-Y]", "$0a").replace("z", "a").replace("Z", "A");
}
```
This version uses the replaceAll() method to replace all lowercase and uppercase letters in the range 'a' to 'y' and 'A' to 'Y' with the next letter in the alphabet by using a regular expression and a backreference. Then, it replaces 'z' and 'Z' with 'a' and 'A' using the replace() method.

the regular expression used in this algorithm is "[a-yA-Y]".

- [] is used to define a character set. A character set is a set of characters that you want to match.
- a-y inside the square bracket will match any lowercase alphabet from 'a' to 'y'
- A-Y inside the square bracket will match any uppercase alphabet from 'A' to 'Y'
- $0 is a backreference to the entire match. It means the entire match is replaced by itself with the next letter in the alphabet.

## sortCharsByFreq
Given any string `str`, sort the characters in descending order based on the number of occurrences of each character in the string `str`.

Return an array of the characters in order. You may assume each character has a distinct frequency.

eg: `"gggghhleee"` => `["g", "e", "h", "l"]`

```java
char[] sortCharsByFreq(String){
Map<Character,Integer> charFrequency = new HashMap<>();
for (char c: str.toCharArray()){
	charFrequency.put(c,charFrequency.getOrDefault(c,0) + 1);
}

List<Map.Entry<Character,Integer>> list = new ArrayList<>(charFrequency.entrySet());
list.sort((o1,o2) -> o1.getValue().compareTo(o2.getValue()));

char[] result = new char[list.size()];
for (int i=0; i<list.size();i++){
	result[i] = list.get(i).getKey();
}

return result;
}
```


