package com.example.kiosk.challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Menu {

    private final MenuCategory category;
    private final List<MenuItem> menuItemList = new ArrayList<>();

    public Menu(MenuCategory category) {
        this.category = category;
    }

    public MenuCategory getCategory() {
        return category;
    }

    public void addMenuItem(MenuItem item) {
        menuItemList.add(item);
    }

    public List<MenuItem> getMenuItemList() {
        return menuItemList;
    }

    public MenuItem getMenuItem(int index) {
        return menuItemList.get(index);
    }

    public void printAllMenuItem() {
        System.out.println("[ " + category +"MENU ]");
        AtomicInteger idx = new AtomicInteger(1);
        menuItemList.forEach((value) -> {
            System.out.println((idx.get()) + ". " + value.printMenuItem());
            idx.getAndIncrement();
        });
    }
}
