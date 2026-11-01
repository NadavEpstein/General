public class Customer {

    private int ID;
    private String name;
    private String mail;

    public Customer(int ID, String name, String mail) throws IllegalArgumentException {
        if (ID < 1) {
            throw new IllegalArgumentException("Invalid ID");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Invalid name");
        }
        if (mail == null || mail.isBlank()) {
            throw new IllegalArgumentException("Invalid mail");
        }

        this.ID = ID;
        this.name = name;
        this.mail = mail;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public int getMail() {
        return mail;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            System.out.println("Invalid name");
            return;
        }

        this.name = name;
    }

    public void setMail(String mail) {
        if (mail == null || mail.isBlank()) {
            System.out.println("Invalid mail");
            return;
        }

        this.mail = mail;
    }
}
