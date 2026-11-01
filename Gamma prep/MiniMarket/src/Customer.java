public class Customer {
    private final int ID;
    private String name;
    private String mail;

    public Customer(int ID, String name, String mail) {
        if (ID < 1) throw new IllegalArgumentException("Invalid ID");
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Invalid name");
        if (mail == null || mail.isBlank()) throw new IllegalArgumentException("Invalid mail");
        this.ID = ID;
        this.name = name;
        this.mail = mail;
    }

    public int getID() { return ID; }
    public String getName() { return name; }
    public String getMail() { return mail; }

    public void setName(String name) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Invalid name");
        this.name = name;
    }

    public void setMail(String mail) {
        if (mail == null || mail.isBlank()) throw new IllegalArgumentException("Invalid mail");
        this.mail = mail;
    }
}
