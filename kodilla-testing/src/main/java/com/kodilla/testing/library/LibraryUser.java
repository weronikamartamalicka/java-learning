package com.kodilla.testing.library;

import java.util.Objects;

public class LibraryUser {

    String firstName;
    String lastName;
    int peselId;

    public LibraryUser(String firstName, String lastName, int peselId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.peselId = peselId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getPeselId() {
        return peselId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPeselId(int peselId) {
        this.peselId = peselId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof LibraryUser)) return false;
        LibraryUser that = (LibraryUser) o;
        return getPeselId() == that.getPeselId() && Objects.equals(getFirstName(), that.getFirstName()) && Objects.equals(getLastName(), that.getLastName());
    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = result * 31 + lastName.hashCode();
        result = result * 31 + peselId;
        return result;
    }
}
