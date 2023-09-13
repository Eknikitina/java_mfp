package ru.stqa.mfp.addressbook.model;

import com.google.gson.annotations.Expose;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.Objects;
@Entity
@Table(name = "addressbook")
public class ContactData {
    @Id
    @Column(name = "id")
    private int id = Integer.MAX_VALUE;
    @Expose
    @Column(name = "firstname")
    private String name;
    @Expose
    @Column(name = "lastname")
    private String lastname;
    @Expose
    @Column(name = "mobile")
    @Type(type = "text")
    private String mobile;
    @Expose
    @Column(name = "email")
    @Type(type = "text")
    private String email;
    @Expose
    @Transient
    private String group;
    @Expose
    @Column(name = "home")
    @Type(type = "text")
    private String home;
    @Expose
    @Column(name = "work")
    @Type(type = "text")
    private String work;
    @Expose
    @Column(name = "middlename")
    private String middlename;
    @Expose
    @Column(name = "nickname")
    private String nickname;
    @Expose
    @Column(name = "title")
    private String title;
    @Expose
    @Column(name = "company")
    private String company;
    @Expose
    @Column(name = "address")
    @Type(type = "text")
    private String address;
    @Expose
    @Column(name = "fax")
    @Type(type = "text")
    private String fax;
    @Expose
    @Column(name = "email2")
    @Type(type = "text")
    private String email2;
    @Expose
    @Column(name = "email3")
    @Type(type = "text")
    private String email3;

    @Expose
    @Column(name = "homepage")
    @Type(type = "text")
    private String homepage;
    @Transient
    private String allPhones;
    @Transient
    private String allEmail;

    @Transient
    private String address2;
    @Expose
    @Column(name = "photo")
    @Type(type = "text")
    private String photo;

    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", group='" + group + '\'' +
                ", home='" + home + '\'' +
                ", work='" + work + '\'' +
                ", middlename='" + middlename + '\'' +
                ", nickname='" + nickname + '\'' +
                ", title='" + title + '\'' +
                ", company='" + company + '\'' +
                ", address='" + address + '\'' +
                ", fax='" + fax + '\'' +
                ", email2='" + email2 + '\'' +
                ", email3='" + email3 + '\'' +
                ", homepage='" + homepage + '\'' +
                ", allPhones='" + allPhones + '\'' +
                ", allEmail='" + allEmail + '\'' +
                ", address2='" + address2 + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }



    public File getPhoto() {
        if (photo != null) {
            return new File (photo);
        } else {
            return null;
        }
    }
    public String getAllPhones() {
        return allPhones;
    }
    public String getAllEmail() {
        return allEmail;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }
    public String getAddress2() {
        return address2;
    }

    public String getAddress() {
        return address;
    }

    public String getFax() {
        return fax;
    }

    public String getEmail2() {
        return email2;
    }

    public String getEmail3() {
        return email3;
    }

    public String getHomepage() {
        return homepage;
    }

    public String getMiddlename() {
        return middlename;
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

    public int getId() {
        return id;
    }

    public String getHome() {
        return home;
    }

    public String getWork() {
        return work;
    }

    public String getNickname() {
        return nickname;
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

    public ContactData withMiddlename(String middlename) {
        this.middlename = middlename;
        return this;
    }

    public ContactData withNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public ContactData withTitle(String title) {
        this.title = title;
        return this;
    }

    public ContactData withCompany(String company) {
        this.company = company;
        return this;
    }

    public ContactData withAddress(String address) {
        this.address = address;
        return this;
    }
    public ContactData withAddress2(String address2) {
        this.address2 = address2;
        return this;
    }

    public ContactData withFax(String fax) {
        this.fax = fax;
        return this;
    }

    public ContactData withEmail2(String email2) {
        this.email2 = email2;
        return this;
    }

    public ContactData withEmail3(String email3) {
        this.email3 = email3;
        return this;
    }

    public ContactData withHomepage(String homepage) {
        this.homepage = homepage;
        return this;
    }

    public ContactData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    public ContactData withAllEmail(String allEmail) {
        this.allEmail = allEmail;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(lastname, that.lastname) && Objects.equals(mobile, that.mobile) && Objects.equals(email, that.email) && Objects.equals(group, that.group) && Objects.equals(home, that.home) && Objects.equals(work, that.work) && Objects.equals(middlename, that.middlename) && Objects.equals(nickname, that.nickname) && Objects.equals(title, that.title) && Objects.equals(company, that.company) && Objects.equals(address, that.address) && Objects.equals(fax, that.fax) && Objects.equals(email2, that.email2) && Objects.equals(email3, that.email3) && Objects.equals(homepage, that.homepage) && Objects.equals(allPhones, that.allPhones) && Objects.equals(allEmail, that.allEmail) && Objects.equals(address2, that.address2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastname, mobile, email, group, home, work, middlename, nickname, title, company, address, fax, email2, email3, homepage, allPhones, allEmail, address2);
    }

    public ContactData withPhoto(File photo) {
        this.photo = photo.getPath();
        return this;
    }

}
