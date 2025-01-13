package com.example.kiosk.level5;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private MenuCategory category;
    private List<MenuItem> menuItemList = new ArrayList<>();

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
        for (int i = 0; i < menuItemList.size(); i++) {
            System.out.println((i + 1) + menuItemList.get(i).printMenuItem());
        }
    }
}
