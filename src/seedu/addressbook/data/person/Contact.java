package seedu.addressbook.data.person;

public abstract class Contact {
    public final String value;
    private boolean isPrivate;
    
    public Contact(String value, boolean isPrivate) {
        this.value = value;
        this.isPrivate = isPrivate;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        Class<?> c = this.getClass();
        return other == this // short circuit if same object
                || (c.isInstance(other) // isInstance handles nulls
                && this.value.equals(((Contact) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
