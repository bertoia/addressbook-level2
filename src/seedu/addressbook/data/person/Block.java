package seedu.addressbook.data.person;

public class Block {
	private final String block;
	
	public Block(String block) {
		this.block = block;
	}

    @Override
    public String toString() {
        return block;
    }
}
