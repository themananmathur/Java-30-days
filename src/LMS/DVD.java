package LMS;

public class DVD extends LibraryItem {
    private String title;
    private String director;
    private int runtimeMinutes;

    public DVD(String id, String title, String director, int runtimeMinutes) {
        super(id);
        this.title = title;
        this.director = director;
        this.runtimeMinutes = runtimeMinutes;
    }

    public String getTitle() { return title; }
    public String getDirector() { return director; }
    public int getRuntimeMinutes() { return runtimeMinutes; }

    public void setTitle(String title) { this.title = title; }
    public void setDirector(String director) { this.director = director; }
    public void setRuntimeMinutes(int minutes) { this.runtimeMinutes = minutes; }

    @Override
    public void displayInfo() {
        System.out.printf("DVD  | Title: %s | Director: %s | ID: %s | Runtime: %d min%n",
                title, director, getItemId(), runtimeMinutes);
    }

    @Override
    public String toString() {
        return "DVD[" + title + ", director=" + director + ", id=" + getItemId() + "]";
    }
}
