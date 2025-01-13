package com.example.kiosk.challenge;

import java.util.List;
import java.util.Scanner;

public class Kiosk {

    private final List<Menu> menuList;
    private final Order order;

    public Kiosk(List<Menu> menuList) {
        this.menuList = menuList;
        this.order = new Order();
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        String input;

        while (true) {
            System.out.println("[ MAIN MENU ]");
            for (int i = 0; i < menuList.size(); i++) {
                Menu menu = menuList.get(i);
                System.out.println((i + 1) + ". " + menu.getCategory());
            }
            System.out.println("0. 종료\t| 종료");

            if (!order.isOrderListEmpty()) {
                System.out.println();
                order.printOrderMenu(menuList.size());
            }

            input = sc.nextLine();
            if (input.equals("0")) {
                break;
            }

            int menuIdx = Integer.parseInt(input)  - 1;
            if (menuIdx >= (menuList.size() + 2)) {
                System.out.println("존재하지 않는 메뉴입니다. 초기화면으로 돌아갑니다.");
                System.out.println();
                continue;
            }
            System.out.println();

            if(menuIdx < menuList.size()) {
                menuList.get(menuIdx).printAllMenuItem();
                System.out.println("0. 뒤로가기");

                input = sc.nextLine();
                if (input.equals("0")) {
                    System.out.println();
                    continue;
                }

                int menuItemIdx = Integer.parseInt(input) - 1;
                if (menuItemIdx >= menuList.get(menuIdx).getMenuItemList().size()) {
                    System.out.println("존재하지 않는 메뉴입니다. 초기화면으로 돌아갑니다.");
                    System.out.println();
                    continue;
                }

                MenuItem selectItem = menuList.get(menuIdx).getMenuItem(menuItemIdx);
                System.out.println(selectItem);
                System.out.println();

                System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                System.out.println("1. 확인\t\t2. 취소");
                input = sc.nextLine();
                switch (input) {
                    case "1":{
                        System.out.println(selectItem.getName() + " 이 장바구니에 추가되었습니다.");
                        order.addOrderList(selectItem);
                        break;
                    }
                    case "2":{
                        System.out.println("장바구니에 추가하지 않았습니다. 초기화면으로 돌아갑니다.");
                        break;
                    }
                    default: {
                        System.out.println("잘못된 메뉴를 입력하셨습니다. 초기화면으로 돌아갑니다.");
                        continue;
                    }
                }
            } else {
                if (menuIdx == (menuList.size() + order.getOrderListSize())) {
                    System.out.println("진행중인 주문을 모두 취소하고, 초기화면으로 돌아갑니다.");
                    System.out.println();
                    order.clearOrderList();
                    continue;
                }

                System.out.println("아래와 같이 주문 하시겠습니까?");
                System.out.println();

                String totalPrice = order.printAllOrderList();

                input = sc.nextLine();
                switch (input) {
                    case "1": {
                        System.out.println("주문이 완료되었습니다. 금액은 W " + totalPrice + " 입니다.");
                        order.clearOrderList();
                        break;
                    }
                    case "2": {
                        System.out.println("메뉴판으로 돌아갑니다.");
                        System.out.println();
                        continue;
                    }
                    default: {
                        System.out.println("잘못된 메뉴를 입력하셨습니다. 초기화면으로 돌아갑니다.");
                        System.out.println();
                        continue;
                    }
                }
            }

            System.out.println();
        }

        System.out.println("프로그램을 종료합니다.");
    }
}
