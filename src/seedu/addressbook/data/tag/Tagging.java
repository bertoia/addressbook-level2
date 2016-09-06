package seedu.addressbook.data.tag;
import seedu.addressbook.data.person.Person;

public class Tagging {
    private String TAGGING_STRING_FORMAT = "%s %s %s";
    private Person person;
    private Tag tag;
    private boolean isAdd;
    
    public Tagging(Person person, Tag tag, boolean isAdd) {
        this.person = person;
        this.tag = tag;
        this.isAdd = isAdd;
    }
    
    @Override
    public String toString() {
        String sign = isAdd ? "+ " : "- ";
        return String.format(TAGGING_STRING_FORMAT, sign, person, tag);
    }
}
