# Objects to Primitives


## Convert ArrayList of Integers to array of int

ArrayList<Integer> list = new ArrayList<>();
list.stream().mapToInt(i -> i).toArray();