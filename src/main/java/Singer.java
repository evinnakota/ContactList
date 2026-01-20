public class Singer extends Person {
    private String part;

    public Singer(String fName, String lName, String pNumber, String part) {
        super(fName, lName, pNumber);
        this.part = part;
    }

    public String getPart() {
        return part;
    }

    @Override
    public String toString() {
        return super.toString() + " " + this.part;
    }
}
