package lv1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num;
        boolean flag = true;
        while (flag){
            // 메뉴 출력
            System.out.print("[ SHAKESHACK MENU ]\n"+
                    "1. ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거\n" +
                    "2. SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거\n" +
                    "3. Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거\n" +
                    "4. Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거\n" +
                    "0. 종료          | 종료\n");

            // 사용자 입력 및 예외처리
            try {
                num = scanner.nextInt();
            } catch (InputMismatchException e){
                System.out.println("잘못된 입력입니다.\n");
                scanner.nextLine();
                continue;
            }

            // 사용자 입력에 따른 주문 결과 출력
            switch (num){
                case 1:
                    System.out.println("1. ShackBurger   | ₩ 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거");
                    System.out.println("주문 완료되었습니다.\n");
                    break;
                case 2:
                    System.out.println("2. SmokeShack    | ₩ 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
                    System.out.println("주문 완료되었습니다.\n");
                    break;
                case 3:
                    System.out.println("3. Cheeseburger  | ₩ 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
                    System.out.println("주문 완료되었습니다.\n");
                    break;
                case 4:
                    System.out.println("4. Hamburger     | ₩ 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거");
                    System.out.println("주문 완료되었습니다.\n");
                    break;
                case 0:
                    flag = false;
                    System.out.println("프로그램을 종료합니다.\n");
                    break;
                default:
                    System.out.println("잘못된 입력입니다.\n");
            }
        }
        scanner.close();
    }
}