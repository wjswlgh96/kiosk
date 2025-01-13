package com.example.kiosk.challenge;

public class MenuItem {

    private final String name;
    private final double price;
    private final String description;

    public MenuItem(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String printMenuItem() {
        return name + "\t| W " + price + " | " + description;
    }

    @Override
    public String toString() {
        return "선택한 메뉴 : " + name + " | W " + price + " | " + description;
    }
}
