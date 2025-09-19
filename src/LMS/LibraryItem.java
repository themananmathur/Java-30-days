package LMS;

public abstract class LibraryItem {
    protected String itemId;

    public LibraryItem(String itemId) {
        this.itemId = itemId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public abstract void displayInfo();
}
