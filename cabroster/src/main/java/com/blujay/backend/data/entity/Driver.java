package com.blujay.backend.data.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

// "Driver" is a reserved word in some SQL implementations
@Entity(name = "DriverInfo")
public class Driver extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    @NotNull
    @Size(min = 1, max = 255)
    private String name;

    @Size(min = 1, max = 255)
    private String licenseNumber;

    @NotNull
    @Size(min = 1, max = 20)
    private String contactNo;

    @Size(min = 1, max = 100)
    @Column(unique = true)
    private String email;

    @NotNull
    @Size(min = 1, max = 20)
    private String status;

    public Driver() {
        // An empty constructor is needed for all beans
    }

    public Driver(String name, String licenseNumber, String contactNo, String email, String status) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(contactNo);
        Objects.requireNonNull(status);
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.contactNo = contactNo;
        this.email = email;
        this.status = status;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
