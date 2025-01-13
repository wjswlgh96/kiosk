package com.example.kiosk.level5;

import java.util.List;
import java.util.Scanner;

public class Kiosk {

    private List<Menu> menuList;

    public Kiosk(List<Menu> menuList) {
        this.menuList = menuList;
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
            input = sc.nextLine();
            if (input.equals("0")) {
                break;
            }

            int menuIdx = Integer.parseInt(input)  - 1;
            if (menuIdx >= menuList.size()) {
                System.out.println("존재하지 않는 메뉴입니다. 초기화면으로 돌아갑니다.");
                System.out.println();
                continue;
            }
            System.out.println();

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

            System.out.println(menuList.get(menuIdx).getMenuItem(menuItemIdx));
            System.out.println();
        }

        System.out.println("프로그램을 종료합니다.");
    }
}
