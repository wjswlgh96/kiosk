package com.example.kiosk.level1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("[ SHAKESHACK MENU ]");
            System.out.println("1. ShackBurger\t| W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거");
            System.out.println("2. SmokeShack\t| W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
            System.out.println("3. Cheeseburger\t| W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
            System.out.println("4. Hamburger\t| W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거");
            System.out.println("0. 종료\t| 종료");

            String input = sc.nextLine();
            if (input.equals("0")) {
                break;
            }

            switch (input) {
                case "1":{
                    System.out.println("1. ShackBurger 주문이 완료되었습니다.");
                    break;
                }
                case "2":{
                    System.out.println("2. SmokeShack 주문이 완료되었습니다.");
                    break;
                }
                case "3":{
                    System.out.println("3. Cheeseburger 주문이 완료되었습니다.");
                    break;
                }
                case "4":{
                    System.out.println("4. Hamburger 주문이 완료되었습니다.");
                    break;
                }
            }
            System.out.println();

            System.out.println("주문을 이어하시려면 아무키나 눌러주세요. (exit 입력 시 종료)");
            if (sc.nextLine().equals("exit")) {
                break;
            }
        }


        System.out.println();
        System.out.println("프로그램을 종료합니다.");
    }
}
