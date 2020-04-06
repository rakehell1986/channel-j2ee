package com.oc.channel.tests;

/**
 * Created by tigershome on 2020/4/3.
 */
public class HouseInfo {

    private String province;
    private String city;
    private String address;

    public HouseInfo() {}
    public HouseInfo(String province, String city, String address) {
        this.province = province;
        this.city = city;
        this.address = address;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
