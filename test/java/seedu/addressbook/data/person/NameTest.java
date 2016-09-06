package seedu.addressbook.data.person;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import seedu.addressbook.data.exception.IllegalValueException;

public class NameTest {

    private Name defaultName;

    @Before
    public void setup() throws IllegalValueException {
        defaultName = new Name("John K Smith");
    }

    @Test
    public void isSimilar_sameObject_returnsTrue() {
        assertTrue(defaultName.isSimilar(defaultName));
    }
    
    @Test
    public void isSimilar_nullArg_returnsFalse() {
        assertFalse(defaultName.isSimilar(null));
    }
    
    @Test
    public void isSimilar_differentCase_returnsTrue() throws IllegalValueException {
        final Name lowerCaseDefaultName = new Name("john k smith");
        assertTrue(defaultName.isSimilar(lowerCaseDefaultName));
    }
    
    @Test
    public void isSimilar_differentName_returnsFalse() throws IllegalValueException {
        final Name differentName = new Name("Mary J Watson");
        assertFalse(defaultName.isSimilar(differentName));
    }
    
    @Test
    public void isSimilar_subset_returnsTrue() throws IllegalValueException {
        final Name subsetDefaultNameA = new Name("John");
        final Name subsetDefaultNameB = new Name("K");
        final Name subsetDefaultNameC = new Name("Smith");
        final Name subsetDefaultNameD = new Name("John K");
        final Name subsetDefaultNameE = new Name("John Smith");
        assertTrue(defaultName.isSimilar(subsetDefaultNameA));
        assertTrue(defaultName.isSimilar(subsetDefaultNameB));
        assertTrue(defaultName.isSimilar(subsetDefaultNameC));
        assertTrue(defaultName.isSimilar(subsetDefaultNameD));
        assertTrue(defaultName.isSimilar(subsetDefaultNameE));
    }
    
    
}
