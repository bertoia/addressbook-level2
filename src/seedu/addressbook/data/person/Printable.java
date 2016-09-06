package seedu.addressbook.data.person;

public interface Printable {
    final String detailIsPrivate = "(private) ";
    String getPrintableString();
}
