package com.example.kiosk.level2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<MenuItem> menuItemList = new ArrayList<>();
        menuItemList.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItemList.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuItemList.add(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItemList.add(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

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
