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
            try {
                // 메인 메뉴
                displayMainMenu();

                // Order 메뉴
                if (!order.isOrderListEmpty()) {
                    System.out.println();
                    order.displayOrderMenu(menuList.size());
                }

                final int MENU_OPTION_COUNT = menuList.size();
                final int CANCEL_OPTION_INDEX = MENU_OPTION_COUNT + 2;

                input = sc.nextLine();
                if (input.equals("0")) {
                    break;
                }

                int menuIdx = Integer.parseInt(input) - 1;
                if (menuIdx >= (menuList.size() + 2) || menuIdx < 0) {
                    throw new InputException();
                }
                System.out.println();

                if (menuIdx < MENU_OPTION_COUNT) {
                    // MenuItem 장바구니 담는 과정 및 UI
                    displayMenuItem(menuIdx, input, sc);
                } else if (!order.isOrderListEmpty() && menuIdx < CANCEL_OPTION_INDEX + 1) {
                    if (menuIdx == (MENU_OPTION_COUNT + 1)) {
                        order.displayRemoveOrder(input, sc);
                        continue;
                    }

                    // 장바구니 결제 및 할인
                    order.displayOrderList();
                    order.displayPaymentOrderAndDiscount(input, sc);
                } else {
                    throw new InputException();
                }
                System.out.println();
            } catch (InputException e) {
                System.out.println(e.getMessage());
                continue;
            } catch (NumberFormatException e) {
                System.out.println("숫자만 입력해주세요. 초기화면으로 돌아갑니다.");
                continue;
            }
        }

        System.out.println("프로그램을 종료합니다.");
    }

    private void displayMainMenu() {
        System.out.println("[ MAIN MENU ]");
        for (int i = 0; i < menuList.size(); i++) {
            Menu menu = menuList.get(i);
            System.out.println((i + 1) + ". " + menu.getCategory());
        }
        System.out.println("0. 종료\t| 종료");
    }

    private void displayMenuItem(int menuIdx, String input, Scanner sc) throws InputException {
        menuList.get(menuIdx).printAllMenuItem();
        System.out.println("0. 뒤로가기");

        input = sc.nextLine();
        if (input.equals("0")) {
            System.out.println();
            return;
        }

        int menuItemIdx = Integer.parseInt(input) - 1;
        if (menuItemIdx >= menuList.get(menuIdx).getMenuItemList().size() || menuItemIdx < 0) {
            throw new InputException();
        }

        MenuItem selectItem = menuList.get(menuIdx).getMenuItem(menuItemIdx);
        System.out.println(selectItem);
        System.out.println();

        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인\t\t2. 취소");
        input = sc.nextLine();

        switch (input) {
            case "1": {
                System.out.println(selectItem.getName() + " 이 장바구니에 추가되었습니다.");
                order.addOrderList(selectItem);
                break;
            }
            case "2": {
                System.out.println("장바구니에 추가하지 않았습니다. 초기화면으로 돌아갑니다.");
                break;
            }
            default: {
                throw new InputException();
            }
        }
    }
}
