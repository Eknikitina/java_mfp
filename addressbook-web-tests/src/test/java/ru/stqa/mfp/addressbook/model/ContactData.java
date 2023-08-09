package ru.stqa.mfp.addressbook.model;

import java.util.Objects;

public class ContactData {
    private int id = Integer.MAX_VALUE;;
    private String name;
    private String lastname;
    private String mobile;
    private String email;
    private String group;
    private String home;
    private String work;

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
    public int getId() {
        return id;
    }

    public String getHome() {
        return home;
    }
    public String getWork() {
        return work;
    }
    public ContactData withId(int id) {
        this.id = id;
        return this;
    }
    public ContactData withName(String name) {
        this.name = name;
        return this;
    }
    public ContactData withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }
    public ContactData withMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }
    public ContactData withEmail(String email) {
        this.email = email;
        return this;
    }
    public ContactData withGroup(String group) {
        this.group = group;
        return this;
    }
    public ContactData withHome(String home) {
        this.home = home;
        return this;
    }
    public ContactData withWork(String work) {
        this.work = work;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(lastname, that.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastname);
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }

}
