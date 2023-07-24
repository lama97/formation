# Linked Lists
	https://coda.io/d/_dQj6eI0mP1R/Core-Algorithms_suE63#_lu1CC

## Sum Two Linked Lists of Equal Length
### Recursion
```java
public  static  int  sumNodesinLLRec(ListNode  head){
	if (head  ==  null){
		return  0;
	}
	return  head.val  + sumNodesinLLRec(head.next);
}
```
### Iterative
```java
public  static  int  sumNodesinLLItr(ListNode  head){

	if (head  ==  null) return  0;
	ListNode  curr  =  head;

	int  sum  =0;
	while (curr  !=  null){
		sum  +=  curr.val;
		curr  =  curr.next;
	}
	return  sum;
}
```
## Append an Element to a Linked List

### Recursion
```java
public  static  ListNode  appendNodeLLRec(ListNode  head, int  value){
	if (head  ==  null) return  new  ListNode(value,null);
	if (head.next  ==  null){
		head.next  =  new  ListNode(value,null);
		return  head;
	}
	head.next  =  appendNodeLLRec(head.next, value);
	return  head;
}
```
### Iterative
```java
public  static  ListNode  appendNodeLLItr(ListNode  head, int  value){
	ListNode  curr  =  head;
	if (curr  ==  null){
		return  new  ListNode(value,null);
	}
	while (curr.next  !=  null){
		curr  =  curr.next;
	}
	curr.next  =  new  ListNode(value, null);
	return  head;
}
```
## Find Kth Element from the End a Linked List in One Pass
### Iterative 
```java
public  static  int  findKthElementFromEndLL(ListNode  head, int  k){
	if ( head  ==  null) return  -1;
	
	ListNode  curr  =  head;
	ListNode  fast  =  head;
	int  count  =  0;
	
	while (fast  !=  null  &&  count  <  k){
		fast  =  fast.next;
		count++;
	}
	while (fast  !=  null){
		fast  =  fast.next;
		curr  =  curr.next;
		count++;
	}
	return  curr.val;
}
```
### Recursion
```java
public  static  int  findKthNodeFromEnd(ListNode  node, int  k)
{
	// base case
	if (node  ==  null) {
		return  0;
	}
	int  count  =  findKthNodeFromEnd(node.next, k) +  1;
	if (count  ==  k) {
		System.out.println("k'th node from the end is "  +  node.val);
	}
	return  count;
}
```
## Insert a Target Element in a Sorted Linked List
### Iterative
```java
public  static  ListNode  insertTargetElementItr(ListNode  head, int  target){
	ListNode  targetN  =  new  ListNode(target,null);
	if (head  ==  null  ||  head.val  >=  target){
		// insert at the beginning
		targetN.next  =  head;
		head  =  targetN;
	}else{
		ListNode  curr  =  head;
		while (curr.next  !=  null  &&  target  >  curr.next.val){
			// time to insert
			curr  =  curr.next;
		}
	targetN.next  =  curr.next;
	curr.next  =  targetN;
	}
	return  head;
}
```


### Recursion
```java
public  static  ListNode  insertTargetElementRecu(ListNode  head, int  target){
	if (head  ==  null  ||  head.val  >=  target){
		// insert at the beginning
		ListNode  targetN  =  new  ListNode(target,head);
		head  =  targetN;
		return  head;
	}
	if (head.next  !=  null  &&  target<head.next.val){
		ListNode  targetN  =  new  ListNode(target,head.next);
		head.next  =  targetN;
		return  head;
	}
	head.next  =  insertTargetElementRecu(head.next, target);
	return  head;
}
```
## Find Max Element in a Linked List

### Iterative
```java
public  static  int  findMaxItr(ListNode  head){
	int  max  =  Integer.MIN_VALUE;
	if (head  ==  null) return  -1;
	ListNode  curr  =  head;
	while (curr  !=  null){
		max  =  Math.max(max,curr.val);
		curr=  curr.next;
	}
	return  max;
}
```
### Recursion
```java
public  static  int  findMaxRecursive(ListNode  head){
	if (head  ==  null) return  Integer.MIN_VALUE;
	int  max  =  findMaxRecursive(head.next);
	
	return  Math.max(head.val, max);
}
```
## Remove k appearing Nodes in Linked List

### Iterative
```java
public  static  ListNode  removeKApprearingNodes(ListNode  head, int  k ){
	if (head  ==  null) return  null;
	ListNode  curr  =  head;
	ListNode  prev  =  null;
	HashMap<Integer,Integer> map  =  new  HashMap<>();
	while (curr  !=  null){
		map.merge(curr.val, 1, (a,b) ->  a+b);
		if ( map.get(curr.val) >=  k){
			// remove the element
			prev.next  =  curr.next;
		}else{
			prev  =  curr;
		}
		curr  =  curr.next;
	}
	return  head;
}
```

### Recursion
```java
public  static  ListNode  removeKApprearingNodesRecursive(ListNode  head, int  k ){
	ListNode  sentinel  =  new  ListNode(-1);
	sentinel.next  =  head;
	removeKApprearingNodesRecursiveHelper(sentinel,k ,new  HashMap<Integer,Integer>());
	return  head;
}

public  static  void  removeKApprearingNodesRecursiveHelper(ListNode  head, int  k, HashMap<Integer,Integer> map){
	if (head.next  ==  null) return;
		map.merge(head.next.val, 1, (a,b) ->  a+b);
		if (map.get(head.next.val) >=  k){
		// remove node
			head.next  =  head.next.next;
		}
	removeKApprearingNodesRecursiveHelper(head.next,k, map);
}
```

##  Print alternating nodes by frequency and level 
```java
public  static  String  printAltH(ListNode  node, int  freq, int  level){
	if (node  ==  null) return  "";
	if (level%freq  ==  0) {
		return  node.val  +  printAltH(node.next,freq,level+1);
	}
	return  printAltH(node.next,freq,level+1);
}
```
## Remove Target Node in Linked List

### Recursion (this solution only applies to removing the first encounter of "target")
```java
public  static  ListNode  removeTargetNodeLLRecursive(ListNode  head, int  target){
	if (head  ==  null) return  head;
	if (head.val  ==  target){
		return  head.next;
	}
	head.next  =  removeTargetNodeLLRecursive(head.next, target);
	return  head;
}
```
### Iterative
```java
public  static  ListNode  removeTargetNodeLLItr(ListNode  head, int  target){
	ListNode  sentinel  =  new  ListNode(0);
	sentinel.next  =  head;
	ListNode  prev  =  sentinel, curr  =  head;
	while (curr  !=  null) {
		if (curr.val  ==  target) prev.next  =  curr.next;
		else  prev  =  curr;
		curr  =  curr.next;
	}
	return  sentinel.next;
}
```
## Reverse Linked List 
### Recursion
```java
public  static  ListNode  reverseLLRecursive(ListNode  head){ 
	if(head  ==  null) {
		return  head;
	}
	// last node or only one node
	if(head.next  ==  null) {
		return  head;
	}
	ListNode  newHeadNode  =  reverseLLRecursive(head.next);
	// change references for middle chain
	head.next.next  =  head;
	head.next  =  null;
	// send back new head node in every recursion
	return  newHeadNode;
}
```
### Iterative 
```java
public  static  ListNode  reverseLLItr(ListNode  head){
	if ( head  ==  null) return  head;
	ListNode  prev  =  null;
	ListNode  curr  =  head;
	while (curr  !=  null){
		ListNode  next  =  curr.next;
		curr.next  =  prev;
		prev  =  curr;
		curr  =  next;
	}
	return  prev;
}
```

## Find Middle Node in LinkedList 
```java
public  static  int  findMiddleNode(ListNode  head){
	if (head  ==  null) return  -1;
	ListNode  slow  =  head;
	ListNode  fast  =  head;
	while(fast.next  !=  null  &&  fast.next.next  !=  null){
		fast  =  fast.next.next;
		slow  =  slow.next;
	}
	return  slow.val;
}
```
## Remove last Quarter Nodes in Linked List
Note, this may potentially needs to be reviewed as this done on the basis that 1/4 = 2 (1/2) 
```java
public  static  ListNode  removeLastQuarterNodes(ListNode  head){
	ListNode  slow  =  head;
	ListNode  fast  =  head.next;
	while(fast  !=  null){
		fast  =  fast.next;
		slow  =  slow.next;
	}
	slow.next  =  null;
	return  head;
}
```