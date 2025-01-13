package com.example.kiosk.challenge;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Order {

    private List<MenuItem> orderList = new ArrayList<>();
    private Double totalPrice;

    public void addOrderList(MenuItem item) {
        orderList.add(item);
    }

    public boolean isOrderListEmpty() {
        return orderList.isEmpty();
    }

    public BigDecimal getTotalPrice() {
        BigDecimal bd = new BigDecimal(totalPrice);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd;
    }

    public int getOrderListSize() {
        return orderList.size();
    }

    public void removeOrderList(String name, Scanner sc) throws InputException {
        String input = name;
        List<MenuItem> list = orderList.stream().filter((value) -> value.getName().equals(name)).toList();
        if (list.isEmpty()) {
            System.out.println("해당하는 상품 목록이 없습니다!");
        } else {
            System.out.println();
            System.out.println("[ Selected Orders ]");
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i).printMenuItem());
            }
            System.out.println();
            System.out.println("해당 상품들을 정말로 취소하시겠습니까?");
            System.out.println("1. 예\t\t2. 아니오");

            input = sc.nextLine();

            if (input.equals("1")) {
                System.out.println("선택한 상품들이 성공적으로 취소되었습니다.");
                orderList.removeAll(list);
            } else if(input.equals("2")){
                System.out.println("상품 삭제를 취소하였습니다. 초기화면으로 돌아갑니다.");
            } else {
                throw new InputException();
            }
        }
    }

    public void clearOrderList() {
        orderList.clear();
    }

    public void displayOrderMenu(int startIndex) {
        System.out.println("[ ORDER MENU ]");
        System.out.println((startIndex + 1) + ". Orders\t| 장바구니를 확인 후 주문합니다.");
        System.out.println((startIndex + 2) + ". Cancel\t| 진행중인 주문을 취소합니다.");
    }

    public void printAllOrderList() {
        System.out.println("[ Orders ]");

        double sum = 0;
        for (int i = 0; i < orderList.size(); i++) {
            MenuItem item = orderList.get(i);
            System.out.println(item.printMenuItem());
            sum += item.getPrice();
        }

        totalPrice = sum;
    }

    public void displayOrderList() {
        printAllOrderList();

        System.out.println();
        System.out.println("[Total]");

        System.out.println("W " + getTotalPrice());

        System.out.println("1. 주문\t\t2. 메뉴판");
    }
}