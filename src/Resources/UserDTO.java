package Resources;

public class UserDTO {
    
    private String name;
    private String email;
    private String contact;
    private String pass; 
    private String confirmpass;



    public UserDTO(String name, String email, String contact, String pass, String confirmpass) {
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.pass = pass;
        this.confirmpass = confirmpass;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return this.contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPass() {
        return this.pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getConfirmpass() {
        return this.confirmpass;
    }

    public void setConfirmpass(String confirmpass) {
        this.confirmpass = confirmpass;
    }
    
}
