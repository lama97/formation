# HashMap
![SortedMap in Java](https://media.geeksforgeeks.org/wp-content/uploads/20200807195934/SortedMap.png)

## HashMap (not sorted)
### Traversal of Hashmap
```java
for (Map.Entry<String,Integer> e : map.entrySet())
	System.out.println("Key: " + e.getKey() + 
	+ "Value: " + e.getValue());
										+ 
```

### Common Methods
#### 1. Compute(Key, BiFunction)
Attempts to compute a mapping for the specified key and its current mapped value (or null if there is no current mapping).
```java
map.compute("Name", (key, val)-> val.concat(" Singh"));
```
```java
map.compute("Key", (key, val)-> (val ==null)? 1 : val +1);
```

#### 2. ComputeIfAbsent(Key,Function)
If the specified key is not already associated with a value (or is mapped to null), attempts to compute its value using the given mapping function and enters it into this map unless null.

if key=10 not found in map:
```java
map.computeIfAbsent(10, k -> "Amarjit");
```

#### 3. ComputeIfPresent(Key,BiFunction)
```java
map.computeIfPresent("for",(key, val) -> val +1);
```
#### 4. merge(Key, Value, BiFunctional)
inserts the specified key/value mapping to the hashmap if the specified key is already not present
?
**Original HashMap:** {Amna=100, Ahmed=95, Sana=70, Ali=89}
```java
results.merge("Sara",  90,  (val1, val2) -> val1+val2);
System.out.println("Updated HashMap: "  + results);
results.merge("Sara",  76,  (val1, val2) -> val1+val2);
System.out.println("Updated HashMap: "  + results);
```
**Updated HashMap 1:** {Amna=100, Ahmed=95, Sana=70, Sara=90, Ali=89} 

**Updated HashMap 2:** {Amna=100, Ahmed=95, Sana=70, Sara=166, Ali=89}

#### 5. putIfAbsent(K key, V value)
If the specified key is not already associated with a value (or is mapped to null) associates it with the given value and returns null, else returns the current value.
```java
map.putIfAbsent("d",55555);
```

### Sort by Keys
#### Using Java8 Lambdas (objects)
```java
Map<Employee,Integer> employeeMap = new TreeMap<>((o1,o2) -> (int) (o1.getSalary()- o2.getSalary()))
```
#### Using Java8 Streams (objects) 
```java
employeeMap.entrySet.streams().
					sorted(Map.Entry.comparingByKey(
						(Comparator.comparing(Employee::getSalary))))
```						

### Sort by Values
#### Using Java8 Lambdas (primitives)
```java
        // Create a list from elements of HashMap
 		 List<Entry<String,Integer>> list = new ArrayList<>(entrySet);

 		 // Sort the list using lambda expression
 		 Collections.sort(list, (v1,v2) -> v1.getValue().compareTo(v2.getValue()));

 		 // put data from sorted list to hashmap
        HashMap<String, Integer> temp
            = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }

```


#### Using Java8 Streams
##### Version 1 (used for primitive values)
```java
			hm.entrySet()
                  .stream()
                  	.sorted((Map.Entry.comparingByValue()).forEach(System.out::println())
```

##### if you want it reversed ( add reversed() ) 

```java
			hm.entrySet()
                  .stream()
                  .sorted((Map.Entry.comparingByValue().reversed()).forEach(System.out::println())
```
##### Version 2 (used for primitive values)
```java
   HashMap<String, Integer> temp
            = hm.entrySet()
                  .stream()
                  .sorted((v1, v2)
                              -> v1.getValue().compareTo(
                                  v2.getValue()))
                  .collect(Collectors.toMap(
                      Map.Entry::getKey,
                      Map.Entry::getValue,
                      (e1, e2) -> e1, LinkedHashMap::new));
```
##### Version 3 (used for objects)
```java
employeeMap.entrySet.streams().
					sorted(Map.Entry.comparingByValue(
						(Comparator.comparing(Employee::getSalary))))
```


## TreeMap (keys are sorted)
### TreeMap class implements SortedMap interface 
### Time Complexity = O(nlogn) ~ sorted 
Consider using a TreeMap when you want a map that satisfies the following criteria:
-   null key or null value is not permitted.
-   The keys are sorted either by natural ordering or by a specified comparator.
### Changing comparator behavior 
store values in descending order:
```java
SortedMap<String, String> treeMap = new TreeMap<String,String>(new Comparator<String>(){
public int compare(String a, String b)
{
return b.compareTo(a);
}
});
```
## LinkedHashMap
#### similar to doubly Linked List 
- **Next & Previous** contains the address of the next or previous node of the LinkedHashMap respectively  

## Difference between 3 DS
|  |HashMap  | LinkedHashMap |TreeMap  | 
|--|--|--|--|
| *Get,Put,ContainsKey,Remove* | O(1) | O(1) |  O(1)| 
| *based on* | List of buckets | D-LinkedLists of Buckets |  Red-Black Binary Search Tree| 
| *Applications* | general | LRU Cache |  Sorted is required| 