package ru.stqa.mfp.addressbook.model;

import java.util.Objects;

public class ContactData {
    private int id;
    private final String name;
    private final String lastname;
    private final String mobile;
    private final String email;
    private final String group;

    public ContactData(String lastname, String name, String mobile, String email, String group) {
        this.id = Integer.MAX_VALUE;
        this.lastname = lastname;
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.group = group;
    }
    public ContactData(int id, String lastname, String name, String mobile, String email, String group) {
        this.id = id;
        this.lastname = lastname;
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {

      return lastname;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    public String getGroup() {
        return group;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }


    @Override
    public String toString() {
        return "ContactData{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return Objects.equals(name, that.name) && Objects.equals(lastname, that.lastname) && Objects.equals(mobile, that.mobile) && Objects.equals(email, that.email) && Objects.equals(group, that.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastname, mobile, email, group);
    }
}
