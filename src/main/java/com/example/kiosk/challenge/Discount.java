package com.example.kiosk.challenge;

public enum Discount {
    MEN_OF_NATIONAL_MERIT(10.0, "국가유공자"),
    SOLDIER(5.0, "군인"),
    STUDENT(3.0, "학생"),
    NORMAL(0.0, "일반");

    private double discount;
    private String name;

    Discount(double discount, String name) {
        this.discount = discount;
        this.name = name;
    }

    public double getDiscount() {
        return discount;
    }

    public String getName() {
        return name;
    }
}
