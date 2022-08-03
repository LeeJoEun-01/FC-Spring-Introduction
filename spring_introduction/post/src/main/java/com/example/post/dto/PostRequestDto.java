package com.example.post.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostRequestDto {

    private String account;
    private String email;
    private String address;
    private String password;
    @JsonProperty("phone_number")
    private String phoneNumber;
    //JsonProperty 어노테이션을 사용하면
    // 두 개의 이름 다 매칭이 가능하다!

    @JsonProperty("OTP")
    private String OTP;
    //이렇게 camel case도 아니고 snake case도 아닐 때나 특정한 값일 때 사용

    public String getOTP() {
        return OTP;
    }

    public void setOTP(String OTP) {
        this.OTP = OTP;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // 상단바 > code > generate > getter and setter
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "PostRequestDto{" +
                "account='" + account + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", OTP='" + OTP + '\'' +
                '}';
    }
}
