package org.howard.edu.lsp.assignment6;


import java.util.ArrayList;
import java.util.List;

public class IntegerSet {

             

                private List<Integer> set = new ArrayList<Integer>();

                public IntegerSet() {
                   

                }
      
                public IntegerSet(ArrayList<Integer> set) {

                                this.set = set;

                }

               

                /**

                * this removes all elements from the set.

                */

                public void clear() {

                                set.clear(); // the predefined java method

                }

     

                public int length() {

                                return set.size();

                }

               

                /**

                * Compares this set to another object for equality and two sets are equal if they contain the same elements, regardless of order.

                */

                @Override

                public boolean equals(Object o) {

                                if (o == null || !(o instanceof IntegerSet)) { // returns false if set is null or not an IntegerSet

                                                return false;

                                }

                                if (o == this) { // if o is the same object as this they are obviously equal

                                                return true;

                                }

                               

                                IntegerSet set = (IntegerSet) o; // cast o to integer set

                               

                                if (set.set.size() != this.set.size()) { // if the two sets are not the same length they are not equal (since there are no dupes_

                                                return false;

                                }

                               

                                if (set.set.containsAll(this.set) && this.set.containsAll(set.set)) {

                                                return true; // returns false on first encounter with integer that is not in both sets

                                }

                return false;

                               

                }

                /**

                * Checks if the set contains the specified value.

                */

                public boolean contains(int value) {

                                return set.contains(value);

                }

               

                /**

                * Returns the largest element in the set.

                * @return the largest integer

                * @throws IntegerSetException if empty

                */

                public int largest() throws IntegerSetException {

                                if (this.isEmpty()) {

                        throw new IntegerSetException("Cannot determine largest element: the set is empty.");

                    }

                               

                                int largest = set.get(0);

                               

                                for (int i = 1; i < set.size(); i++) {

                                                if (set.get(i) > largest) {

                                                                largest = set.get(i);

                                                }

                                }

                               

                                return largest;

                }

               

                /**

                * Returns the smallest element in the set.

                * @return the smallest integer

                * @throws IntegerSetException if empty

                */

                public int smallest() throws IntegerSetException {

                                if (this.isEmpty()) {

                        throw new IntegerSetException("Smallest element cannot be determined: the set is empty.");

                    }

                               
                                int smallest = set.get(0);

                               

                                for (int i = 1; i < set.size(); i++) {

                                                if (set.get(i) < smallest) {

                                                                smallest = set.get(i);

                                                }

                                }

                               

                    return smallest;

                               

                }

               

                /**

                * this adds a value to the set if it is not already present.
                */

                public void add(int item) { // adds item to the set or does nothing if it is in set

                                if (set.contains(item)) {

                                                return;

                                }

                                else {

                                                set.add(item);

                                }

                }

               

                /**

                * Removes a value from the set if it is present.

                * @param item the value to remove

                */

                public void remove(int item) {

                                // do nothing if item is not in set

                                if (!set.contains(item)) {

                                                return;

                                }

                                else { // remove item from set

                                                set.remove(Integer.valueOf(item));

                                }

                }

               

                /**

                * Modifies this set to be the union of itself and another set.

                * @param intSetb the other set to union with

                */

                public void union(IntegerSet intSetb) {

                                for (Integer item : intSetb.set) {

                                    if (!this.set.contains(item)) { // avoids adding duplicates

                                        this.set.add(item);

                                    }

                                }

                }

               

                /**

                * Modifies this set to be the intersection of itself and another set.

                * @param intSetb the other set to intersect with

                */

                public void intersect(IntegerSet intSetb) {

                                // if the sets are equal, either set is the intersection of both

                                if (!this.equals(intSetb)) {

                                                this.set.retainAll(intSetb.set);

                                }

                }

               

                /**

                * Removes all elements in the other set from this set.

                * @param intSetb the other set whose elements will be removed from this one

                */

                public void diff(IntegerSet intSetb) {

                                this.set.removeAll(intSetb.set); // predefined Java method to remove all elements in input from set calling it

                }

               

                /**

                * Replaces this set with the complement relative to another set.

                */

                public void complement(IntegerSet intSetb) {

                                List<Integer> result = new ArrayList<>(intSetb.set);

                    result.removeAll(this.set);

                    this.set = result;

                }

               

                /**

                * Checks if the set is empty.

                * @return true if the set has no elements, false otherwise

                */

                boolean isEmpty() {

                                if (length() == 0) {

                                                return true;

                                }

                               

                                return false;

                }

               

                /**

                * Returns a string representation of the set.

                * @return a string in the format [element1, element2, ...]

                */

                @Override

                public String toString() {

                                return set.toString();

                }

}