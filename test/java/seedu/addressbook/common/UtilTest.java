package seedu.addressbook.common;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static seedu.addressbook.common.Utils.elementsAreUnique;
import static seedu.addressbook.common.Utils.isAnyNull;

import java.util.ArrayList;

public class UtilTest {

    @Before
    public void setup() {}
    
    /**
     * Test method isAnyNull
     */
    @Test
    public void isAnyNull_noInput_returnsFalse() {
        assertFalse(isAnyNull());
    }

    @Test
    public void isAnyNull_singleNullInput_returnsTrue() {
        final Integer input = null;
        assertTrue(isAnyNull(input));
    }

    @Test
    public void isAnyNull_multiNullInput_returnsTrue() {
        final String inputA = null;
        final String inputB = null;
        assertTrue(isAnyNull(inputA, inputB));
    } 

    @Test
    public void isAnyNull_someNullInput_returnsTrue() {
        final String inputA = "abc";
        final String inputB = null;
        final String inputC = "def";
        assertTrue(isAnyNull(inputA, inputB, inputC));
    }

    @Test
    public void isAnyNull_noNullInput_returnsFalse() {
        final String input = "abc";
        assertFalse(isAnyNull(input));
    }
    
    @Test
    public void isAnyNull_multiNoNullInput_returnsFalse() {
        final String inputA = "abc";
        final String inputB = "def";
        final String inputC = "ghi";
        assertFalse(isAnyNull(inputA, inputB, inputC));
    }
    
    /**
     * Test method elementsAreUnique
     */
    @Test
    public void elementsAreUnique_emptyInput_returnsTrue() {
        final ArrayList<String> input = new ArrayList<String>();
        assertTrue(elementsAreUnique(input));
    }

    @Test
    public void elementsAreUnique_singleInput_returnsTrue() {
        final ArrayList<String> input = new ArrayList<String>();
        input.add("1");
        assertTrue(elementsAreUnique(input));
    }

    @Test
    public void elementsAreUnique_multiUniqueInput_returnsTrue() {
        final ArrayList<String> input = new ArrayList<String>();
        input.add("1");
        input.add("2");
        assertTrue(elementsAreUnique(input));
    }

    @Test
    public void elementsAreUnique_nonUniqueInput_returnsFalse() {
        final ArrayList<String> input = new ArrayList<String>();
        input.add("1");
        input.add("2");
        input.add("1");
        assertFalse(elementsAreUnique(input));
    }
}
