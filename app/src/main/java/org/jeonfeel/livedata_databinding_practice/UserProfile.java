package org.jeonfeel.livedata_databinding_practice;

public class UserProfile {

    public static final int MALE = 0;
    public static final int FEMALE = 0;

    private String name;
    private String phone;
    private String address;
    private int gender;
    private String profileUrl;

    public UserProfile(String name, String phone, String address, int gender, String profileUrl) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.gender = gender;
        this.profileUrl = profileUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }
}
