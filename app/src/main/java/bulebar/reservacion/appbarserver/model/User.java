package bulebar.reservacion.appbarserver.model;

/**
 * Created by MDJ16 on 12/02/2018.
 */

public class User {
    private  String name,password,phone,IsStaff;

    public User() {
    }

    public User(String name, String password, String phone, String isStaff) {
        this.name = name;
        this.password = password;
        this.phone = phone;
        IsStaff = isStaff;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIsStaff() {
        return IsStaff;
    }

    public void setIsStaff(String isStaff) {
        IsStaff = isStaff;
    }
}
