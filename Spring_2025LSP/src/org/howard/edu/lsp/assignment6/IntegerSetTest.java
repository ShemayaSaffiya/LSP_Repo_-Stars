package org.howard.edu.lsp.assignment6;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

//create a class

public class IntegerSetTest {

    private IntegerSet set1;

    private IntegerSet set2;

    @BeforeEach

    public void setUp() {

        set1 = new IntegerSet();

        set2 = new IntegerSet();

    }

    @Test

    @DisplayName("Check if add() properly includes values in string")

    public void testAddAndToString() {

        set1.add(5);

        set1.add(10);

        String result = set1.toString();

        assertTrue(result.contains("5"));

        assertTrue(result.contains("10"));

    }


    @Test

    @DisplayName("Confirm values are removed and check if empty")

    public void testClearAndIsEmpty() {

        set1.add(1);

        set1.add(2);

        set1.clear();

        assertTrue(set1.isEmpty());
        
    }
 

    @Test

    @DisplayName("Verify size after adding items")

    public void testLength() {

        set1.add(1);

        set1.add(2);

        set1.add(2);  // duplicate, shouldn't be counted

        assertEquals(2, set1.length());

    }

 

    @Test

    @DisplayName("Make sure contains() correctly finds or rejects values")

    public void testContains() {

        set1.add(3);

        assertTrue(set1.contains(3));

        assertFalse(set1.contains(99));

    }

 

    @Test

    @DisplayName("Test empty state before/after operations")

    public void testIsEmpty() {

        assertTrue(set1.isEmpty());

 

        set1.add(5);

        assertFalse(set1.isEmpty());

 

        set1.clear();

        assertTrue(set1.isEmpty());

    }

 

    @Test

    @DisplayName("Test equals() on reordered elements")

    public void testEquals() {

        set1.add(1);

        set1.add(2);

        set2.add(2);

        set2.add(1);

        assertTrue(set1.equals(set2));

    }

 

    @Test

    @DisplayName("Test remove() works and doesn’t affect untouched elements")

    public void testRemove() {

        set1.add(10);

        set1.add(20);

        set1.remove(10);

        assertFalse(set1.contains(10));

        assertTrue(set1.contains(20));

 

        set1.remove(999);  // doesn't exist, should do nothing

        assertTrue(set1.contains(20));

    }

 

    @Test

    @DisplayName("Ensure toString() correctly formats set at different stages")

    public void testToString() {

        assertEquals("[]", set1.toString());

 

        set1.add(10);

        String output1 = set1.toString();

        assertTrue(output1.contains("10"));

        assertTrue(output1.startsWith("["));

        assertTrue(output1.endsWith("]"));

 

        set1.add(20);

        set1.add(30);

        String output2 = set1.toString();

        assertTrue(output2.contains("20"));

        assertTrue(output2.contains("30"));

        assertTrue(output2.startsWith("["));

        assertTrue(output2.endsWith("]"));

    }

 

    @Test

    @DisplayName("Test union of two sets merges unique elements")

    public void testUnion() {

        set1.add(1);

        set1.add(2);

        set2.add(2);

        set2.add(3);

 

        set1.union(set2);

 

        assertTrue(set1.contains(1));

        assertTrue(set1.contains(2));

        assertTrue(set1.contains(3));

        assertEquals(3, set1.length());

    }

 

    @Test

    @DisplayName("Ensure intersect() leaves only common elements")

    public void testIntersect() {

        set1.add(1);

        set1.add(2);

        set1.add(3);

        set2.add(2);

        set2.add(3);

        set2.add(4);

 

        set1.intersect(set2);

 

        assertTrue(set1.contains(2));

        assertTrue(set1.contains(3));

        assertFalse(set1.contains(1));

        assertFalse(set1.contains(4));

        assertEquals(2, set1.length());

    }

 

    @Test

    @DisplayName("Test diff() removes shared values")

    public void testDiff() {

        set1.add(1);

        set1.add(2);

        set1.add(3);

        set2.add(2);

        set2.add(4);

 

        set1.diff(set2);

 

        assertTrue(set1.contains(1));

        assertTrue(set1.contains(3));

        assertFalse(set1.contains(2));

        assertFalse(set1.contains(4));

    }

 

    @Test

    @DisplayName("Test complement() creates proper relative set")

    public void testComplement() {

        set1.add(1);

        set1.add(2);

        set2.add(1);

        set2.add(2);

        set2.add(3);

        set2.add(4);

 

        set1.complement(set2);

 

        assertTrue(set1.contains(3));

        assertTrue(set1.contains(4));

        assertFalse(set1.contains(1));

        assertFalse(set1.contains(2));

    }

 

    @Test

    @DisplayName("Test largest() and its exception on empty set")

    public void testLargest() throws IntegerSetException {

        set1.add(5);

        set1.add(99);

        set1.add(12);

        assertEquals(99, set1.largest());

 

        set1.clear();

        assertThrows(IntegerSetException.class, () -> set1.largest());

    }

 

    @Test

    @DisplayName("Test the smallest() and then confirm exception for empty set")

    public void testSmallest() throws IntegerSetException {

        set1.add(7);

        set1.add(-3);

        set1.add(22);

        assertEquals(-3, set1.smallest());

 
        set1.clear();

        assertThrows(IntegerSetException.class, () -> set1.smallest());

    }

}
