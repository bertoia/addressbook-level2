package seedu.addressbook.data.person;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import seedu.addressbook.data.exception.IllegalValueException;

public class NameTest {

    private Name defaultName;

    @Before
    public void setup() {
        try {
            defaultName = new Name("John K Smith");
        } catch (IllegalValueException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void isSimilar_sameObject_returnsTrue() {
        assertTrue(defaultName.isSimilar(defaultName));
    }
}
