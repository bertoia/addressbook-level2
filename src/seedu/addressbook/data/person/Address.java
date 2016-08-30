package seedu.addressbook.data.person;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {
    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public static final String EXAMPLE = "a/123, Clementi Ave 3, #12-34, 231534";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Postal code should only contain numbers";
    public static final String ADDRESS_VALIDATION_REGEX = "(?<block>.*)\\s*,\\s*(?<street>.*)\\s*,\\s*"
                                                        + "(?<unit>.*)\\s*,\\s*(?<postalCode>\\d*)";
    public static final Pattern ADDRESS_PATTERN= Pattern.compile(ADDRESS_VALIDATION_REGEX);
    
    private final Block block;
    private final Street street;
    private final Unit unit;
    private final PostalCode postalCode;

    public Address(String address, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        address = address.trim();
        if (!isValidAddress(address)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        Matcher matcher = ADDRESS_PATTERN.matcher(address);
        matcher.find();
        this.block = new Block(matcher.group("block"));
        this.street = new Street(matcher.group("street"));
        this.unit = new Unit(matcher.group("unit"));
        this.postalCode = new PostalCode(matcher.group("postalCode"));
    }

    /**
     * Returns true if a given string is a valid address.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %s", block, street, unit, postalCode);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.value.equals(((Address) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}