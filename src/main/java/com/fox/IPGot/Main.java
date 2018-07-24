package com.fox.IPGot;

public class Main {
    public static void main(String[] args) {
        IPGotDTO dto = IPGot.getIP("178.212.241.195");
        System.out.println(dto.country_name);
    }
}
