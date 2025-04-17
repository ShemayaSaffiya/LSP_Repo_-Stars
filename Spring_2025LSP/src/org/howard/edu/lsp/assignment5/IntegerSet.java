import java.util.ArrayList;
import java.util.List;

/**
 * this class represents a custom integer set with no duplicates.
 * it includes basic set operations like union, intersection, difference, and complement.
 * values are stored internally using an arraylist.
 */
public class IntegerSet {

    // list used to store values in the set
    private List<Integer> numbers = new ArrayList<>();

    // default constructor
    public IntegerSet() {
    }

    // constructor that accepts an existing list
    public IntegerSet(ArrayList<Integer> existingValues) {
        this.numbers = existingValues;
    }

    /**
     * removes everything from the set
     */
    public void clear() {
        numbers.clear();
    }

    /**
     * returns how many values are in the set
     */
    public int length() {
        return numbers.size();
    }

    /**
     * checks if this set and another set contain the same values
     */
    @Override
    public boolean equals(Object other) {
        if (other == null || !(other instanceof IntegerSet)) {
            return false;
        }

        if (other == this) {
            return true;
        }

        IntegerSet otherSet = (IntegerSet) other;

        if (otherSet.numbers.size() != this.numbers.size()) {
            return false;
        }

        return otherSet.numbers.containsAll(this.numbers) && this.numbers.containsAll(otherSet.numbers);
    }

    /**
     * checks if the set has a certain value
     */
    public boolean contains(int num) {
        return numbers.contains(num);
    }

    /**
     * returns the highest value in the set
     */
    public int largest() {
        if (this.isEmpty()) {
            throw new RuntimeException("cannot find largest value: set is empty.");
        }

        int max = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) > max) {
                max = numbers.get(i);
            }
        }
        return max;
    }

    /**
     * returns the smallest value in the set
     */
    public int smallest() {
        if (this.isEmpty()) {
            throw new RuntimeException("cannot find smallest value: set is empty.");
        }

        int min = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) < min) {
                min = numbers.get(i);
            }
        }
        return min;
    }

    /**
     * adds a number to the set if it isn’t already there
     */
    public void add(int num) {
        if (!numbers.contains(num)) {
            numbers.add(num);
        }
    }

    /**
     * removes a number from the set if it exists
     */
    public void remove(int num) {
        if (numbers.contains(num)) {
            numbers.remove(Integer.valueOf(num));
        }
    }

    /**
     * adds values from another set, skipping duplicates
     */
    public void union(IntegerSet anotherSet) {
        for (Integer num : anotherSet.numbers) {
            if (!this.numbers.contains(num)) {
                this.numbers.add(num);
            }
        }
    }

    /**
     * keeps only values that exist in both sets
     */
    public void intersect(IntegerSet anotherSet) {
        if (!this.equals(anotherSet)) {
            this.numbers.retainAll(anotherSet.numbers);
        }
    }

    /**
     * removes all values from this set that exist in the other set
     */
    public void diff(IntegerSet anotherSet) {
        this.numbers.removeAll(anotherSet.numbers);
    }

    /**
     * replaces this set with values that are in the other set but not in this one
     */
    public void complement(IntegerSet universalSet) {
        List<Integer> temp = new ArrayList<>(universalSet.numbers);
        temp.removeAll(this.numbers);
        this.numbers = temp;
    }

    /**
     * checks if the set has no values
     */
    boolean isEmpty() {
        return length() == 0;
    }

    /**
     * returns the set as a string
     */
    @Override
    public String toString() {
        return numbers.toString();
    }
}
