import java.util.ArrayList;

public class Phonebook {
       public String phone;

       public String name;
       public String sex;
       public String address;
       public String group;
       public String email;
       public String birthday;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Phonebook( String phone, String name, String sex, String address, String group, String birthday, String email) {

        this.phone = phone;
        this.name = name;
        this.sex = sex;
        this.address = address;
        this.group = group;
        this.birthday = birthday;
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }





    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public  String getCVS() {
        return String.format("%s,%s,%s,%s,%s,%s,%s",phone, name,sex, address, group, birthday,email);
    }
    @Override
    public String toString() {
        return "Phonebook{" +
                "phone='" + phone + '\'' +

                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", group='" + group + '\'' +
                ", email='" + email + '\''+
                '}';
    }

}
