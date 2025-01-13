package com.example.kiosk.challenge;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<MenuItem> orderList = new ArrayList<>();

    public void addOrderList(MenuItem item) {
        orderList.add(item);
    }

    public boolean isOrderListEmpty() {
        return orderList.isEmpty();
    }

    public int getOrderListSize() {
        return orderList.size();
    }

    public void clearOrderList() {
        orderList.clear();
    }

    public void printOrderMenu(int startIndex) {
        System.out.println("[ ORDER MENU ]");
        System.out.println((startIndex + 1) + ". Orders\t| 장바구니를 확인 후 주문합니다.");
        System.out.println((startIndex + 2) + ". Cancel\t| 진행중인 주문을 취소합니다.");
    }

    public String printAllOrderList() {
        System.out.println("[ Orders ]");

        double totalPrice = 0.0;
        for (int i = 0; i < orderList.size(); i++) {
            MenuItem item = orderList.get(i);
            System.out.println(item.printMenuItem());
            totalPrice += item.getPrice();
        }

        System.out.println();
        System.out.println("[Total]");
        DecimalFormat df = new DecimalFormat("#.##");
        String priceF = df.format(totalPrice);
        System.out.println("W " + priceF);

        System.out.println("1. 주문\t\t2. 메뉴판");
        return priceF;
    }
}
