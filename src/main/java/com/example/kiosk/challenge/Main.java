package com.example.kiosk.challenge;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Menu burgers = new Menu(MenuCategory.Burgers);
        burgers.addMenuItem(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgers.addMenuItem(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgers.addMenuItem(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgers.addMenuItem(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        Menu drinks = new Menu(MenuCategory.Drinks);
        drinks.addMenuItem(new MenuItem("Fountain Soda", 3.6, "코카콜라, 코카콜라 제로, 스프라이트, 환타 오렌지, 환타 그레이프, 환타 파인애플"));
        drinks.addMenuItem(new MenuItem("Abita Root Beer", 5.0, "청량감 있는 독특한 미국식 무알콜 탄산음료"));

        Menu desserts = new Menu(MenuCategory.Desserts);
        desserts.addMenuItem(new MenuItem("Shack Attack", 6.2, "진한 초콜릿 커스터드에 퍼지 소스와 세 가지 초콜릿 토핑이 블렌딩된 쉐이크쉑의 대표 콘크리트"));
        desserts.addMenuItem(new MenuItem("Gangnam", 6.2, "고소한 콩가루와 쇼트브레드, 딸기잼이 어우러진 쉐이크쉑 강남의 시그니처 콘크리트"));

        List<Menu> menuList = new ArrayList<>();
        menuList.add(burgers);
        menuList.add(drinks);
        menuList.add(desserts);

        Kiosk kiosk = new Kiosk(menuList);
        kiosk.start();
    }
}
