package lv3;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("ShackBurger", 6900, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("SmokeShack", 8900, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Cheeseburger", 6900, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Hamburger", 5400, "비프패티를 기반으로 야채가 들어간 기본버거"));

        Scanner scanner = new Scanner(System.in);
        int num;
        while (true){
            System.out.println("[ SHAKESHACK MENU ]");
            for (int i = 0; i < menuItems.size(); i++) {
                MenuItem menuItem = menuItems.get(i);
                System.out.printf("%-2d. %-12s | ₩ %-6d | %s%n", i+1 , menuItem.name, menuItem.price, menuItem.detail);
            }
            System.out.println("0 . 종료         | 종료");

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
            if (num < 0 || num > menuItems.size()) {
                System.out.println("잘못된 입력입니다.\n");
                continue;
            }
            MenuItem menuItem = menuItems.get(num - 1);
            System.out.printf("%-2d. %-12s | ₩ %-6d | %s%n", num, menuItem.name, menuItem.price, menuItem.detail);
            System.out.println("주문이 완료되었습니다.\n");
        }
        scanner.close();
    }
}