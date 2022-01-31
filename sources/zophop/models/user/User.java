package zophop.models.user;

public class User {
    private String address;
    private String email;
    private String id;
    private String name;
    private String phone_number;

    public String getAddress() {
        return this.address;
    }

    public String getEmail() {
        return this.email;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getPhone_number() {
        return this.phone_number;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPhone_number(String str) {
        this.phone_number = str;
    }
}
