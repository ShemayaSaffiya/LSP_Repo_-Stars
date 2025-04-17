package org.howard.edu.lsp.assignment5;

public class Driver {

    public static void main(String[] args) {

                   

                    // set1

                    IntegerSet set1 = new IntegerSet();

                    // Testing add() method

                    set1.add(1);

                    set1.add(2);

                    set1.add(3);

                    // Testing toString() method

                    System.out.println("Value of Set1: " + set1.toString());

                    // Testing smallest() method

                    System.out.println("Smallest value in Set1: " + set1.smallest());

                    // Testing largest() method

                    System.out.println("Largest value in Set1: " + set1.largest());



                   

                    // Creating set2

                    IntegerSet set2 = new IntegerSet();

                    // Testing add() method

                    set2.add(3);

                    set2.add(4);

                    set2.add(5);

                    // Testing toString() method

                    System.out.println("Value of Set2: " + set2.toString());

                    // Testing smallest() method

                    System.out.println("Smallest value in Set2: " + set2.smallest());

                    // Testing largest() method

                    System.out.println("Largest value in Set2: " + set2.largest());

                    // Testing equals method

                    System.out.println("Set1 equals Set2: " + set1.equals(set2)); // Expected output: false

                    // Testing union method

                    set1.union(set2);

                    System.out.println("Union of Set1 and Set2: ");

                    System.out.println(set1.toString()); //   Result: [1,2,3,4,5]

                    // Testing length() method

                    System.out.println("Current value of Set1: " + set1.toString());

                    System.out.println("Current value of Set2: " + set2.toString());

                    System.out.println("Length of Set1: " + set1.length());

                    System.out.println("Length of Set2: " + set2.length());

                    set1.intersect(set2); // union of set1 and set2

                    System.out.println("Result of intersection of Set1 and Set2: " + set1.toString());

                    System.out.println("Current value of Set1: " + set1.toString());

                    System.out.println("Current value of Set2: " + set2.toString());



                    System.out.println("Set1 equals Set2: " + set1.equals(set2)); // Expected output: true



                   

                    // Testing diff method

                    set1.diff(set2);

                    System.out.println("Difference between set1 and set2: " + set1.toString()); // Expected output: []

                   

                    // Testing isEmpty() method

                    System.out.println("Current value of Set1: " + set1.toString());

                    System.out.println("Current value of Set2: " + set2.toString());

                    System.out.println("Is set1 empty: " + set1.isEmpty()); // Expected output: true

                    System.out.println("Is set2 empty: " + set2.isEmpty()); // Expected output: false

                   

                    // Testing equals() method

                    System.out.println("Set1 equals Set2: " + set1.equals(set2)); // Expected output: false

                   

                    // Resetting set1 to original values [1, 2, 3]

                    System.out.println("Resetting set1 to original values.");

                    set1.add(1);

                    set1.add(2);

                    set1.add(3);

                    // Confirming set1 was reconstructed correctly

                    System.out.println("Current value of Set1: " + set1.toString());

                    System.out.println("Current value of Set2: " + set2.toString());

                   

                    // Testing contains method

                    System.out.println("Is 5 in Set1: " + set1.contains(5)); // Expected output: false

                    System.out.println("Is 5 in Set2: " + set2.contains(5)); // Expected output: true

                   

                    // Testing complement() method

                    set1.complement(set2);

                    System.out.println("Complement of set1 with respect to set2: " + set1.toString()); // Expected output: [4, 5]

                   

                    // Testing clear() method

                    set1.clear();

                    System.out.println("Set 1 after clearing: " + set1.toString());

                   

                    // Testing remove method

                    System.out.println("Current value of Set2: " + set2.toString());

                    set2.remove(3);

                    set2.remove(4);

                    set2.remove(5);

                    System.out.println("Current value of Set2 after removing elements: " + set2.toString());
    }
}
                    

                   