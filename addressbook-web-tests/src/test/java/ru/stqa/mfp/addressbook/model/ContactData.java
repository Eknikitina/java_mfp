package ru.stqa.mfp.addressbook.model;

public class ContactData {
  private final String name;
  private final String lastname;
  private final String mobile;
  private final String email;
  private final String group;

  public ContactData(String name, String lastname, String mobile, String email, String group) {
    this.name = name;
    this.lastname = lastname;
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
}
