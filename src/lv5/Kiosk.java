package lv5;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    public List<Menu> menus = new ArrayList<>();

    public Kiosk(){
        List<MenuItem> burgerItems = new ArrayList<>();
        burgerItems.add(new MenuItem("ShackBurger", 6900, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgerItems.add(new MenuItem("SmokeShack", 8900, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgerItems.add(new MenuItem("Cheeseburger", 6900, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgerItems.add(new MenuItem("Hamburger", 5400, "비프패티를 기반으로 야채가 들어간 기본버거"));
        menus.add(new Menu("Burgers", burgerItems));

        List<MenuItem> drinkItems = new ArrayList<>();
        drinkItems.add(new MenuItem("Coke", 2000, "톡 쏘는 청량감의 코카콜라"));
        drinkItems.add(new MenuItem("Sprite", 2000, "레몬라임 맛의 스프라이트"));
        drinkItems.add(new MenuItem("Lemonade", 3500, "상큼한 수제 레몬에이드"));
        menus.add(new Menu("Drinks", drinkItems));

        List<MenuItem> dessertItems = new ArrayList<>();
        dessertItems.add(new MenuItem("Ice Cream", 3500, "바닐라맛 아이스크림"));
        dessertItems.add(new MenuItem("Chocolate Cake", 4500, "부드러운 초콜릿 케이크"));
        dessertItems.add(new MenuItem("Cookie", 2500, "달콤한 수제 쿠키"));
        dessertItems.add(new MenuItem("Brownie", 4000, "진한 브라우니"));
        menus.add(new Menu("Desserts", dessertItems));
    }
    public void start(){
        Scanner scanner = new Scanner(System.in);
        int num;
        while (true){
            System.out.println("[ SHAKESHACK MENU ]");
            for(int i = 0; i < menus.size(); i++){
                Menu menu = menus.get(i);
                System.out.printf("%-2d. %s%n", i+1, menu.getCategory());
            }
            System.out.println("0 . 종료");

            try {
                num = scanner.nextInt();
            } catch (InputMismatchException e){
                System.out.println("잘못된 입력입니다.\n");
                scanner.nextLine();
                continue;
            }

            if (num == 0){
                System.out.println("프로그램을 종료합니다.\n");
                break;
            }
            if (num < 0 || num > menus.size()) {
                System.out.println("잘못된 입력입니다.\n");
                continue;
            }

            Menu menu = menus.get(num - 1);
            List<MenuItem> menuItems = menu.getMenuItems();
            while(true){
                System.out.printf("[ %s MENU ]%n", menu.getCategory());
                for (int i = 0; i < menuItems.size(); i++) {
                    MenuItem menuItem = menuItems.get(i);
                    System.out.printf("%-2d. %-12s | ₩ %-6d | %s%n", i+1 , menuItem.name, menuItem.price, menuItem.detail);
                }
                System.out.println("0 . 뒤로 가기");

                try {
                    num = scanner.nextInt();
                } catch (InputMismatchException e){
                    System.out.println("잘못된 입력입니다.\n");
                    scanner.nextLine();
                    continue;
                }

                if (num == 0){
                    System.out.println("초기 화면으로 돌아갑니다.\n");
                    break;
                }
                if (num < 0 || num > menuItems.size()) {
                    System.out.println("잘못된 입력입니다.\n");
                    continue;
                }
                MenuItem menuItem = menuItems.get(num - 1);
                System.out.printf("%-2d. %-12s | ₩ %-6d | %s%n", num, menuItem.name, menuItem.price, menuItem.detail);
                System.out.println("주문이 완료되었습니다.\n");
                break;
            }
        }
        scanner.close();
    }
}