package com.example.kiosk.level3;

import java.util.List;
import java.util.Scanner;

public class Kiosk {

    private List<MenuItem> menuItemList;

    public Kiosk(List<MenuItem> menuItemList) {
        this.menuItemList = menuItemList;
    }

    public void start() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("[ SHAKESHACK MENU ]");
            for (int i = 0; i < menuItemList.size(); i++) {
                MenuItem item = menuItemList.get(i);
                System.out.println((i + 1) + ". " + item.getName() + "\t" + "| W " + item.getPrice() + " | " + item.getDescription());
            }
            System.out.println("0. 종료\t| 종료");

            String input = sc.nextLine();
            if (input.equals("0")) {
                break;
            }

            int idx = Integer.parseInt(input) - 1;
            if (idx >= menuItemList.size()) {
                System.out.println("존재하지 않는 메뉴입니다. 초기화면으로 돌아갑니다.");
                System.out.println();
                continue;
            }

            System.out.println();
            System.out.println(menuItemList.get(idx).toString());
            System.out.println("주문을 이어하시려면 아무키나 눌러주세요 (0 입력시 종료)");
            if (sc.nextLine().equals("0")) {
                break;
            }
        }

        System.out.println("프로그램을 종료합니다.");
    }
}
