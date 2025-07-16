package lv5;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private List<Menu> menus = new ArrayList<>();

    public Kiosk(){
        initializeMenus();
    }

    public List<Menu> getMenus(){
        return menus;
    }

    public void setMenus(List<Menu> menus){
        this.menus = menus;
    }

    public void start(){
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag){
            flag = selectMenu(scanner);
        }
        scanner.close();
    }

    private void initializeMenus(){
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

    private void printMenus() {
        System.out.println("[ SHAKESHACK MENU ]");
        for(int i = 0; i < menus.size(); i++){
            Menu menu = menus.get(i);
            System.out.printf("%-2d. %s%n", i+1, menu.getCategory());
        }
        System.out.println("0 . 종료");
    }

    private boolean selectMenu(Scanner scanner){
        printMenus();
        int num = getUserInput(scanner);

        if (num == 0){
            System.out.println("프로그램을 종료합니다.\n");
            return false;
        }
        if (num < 0 || num > menus.size()) {
            System.out.println("잘못된 입력입니다.\n");
            return true;
        }

        Menu menu = menus.get(num - 1);
        selectMenuItem(menu, scanner);
        return true;
    }

    private void selectMenuItem(Menu menu, Scanner scanner){
        int num;
        while(true){
            menu.printMenuItems();
            num = getUserInput(scanner);

            if (num == 0){
                System.out.println("초기 화면으로 돌아갑니다.\n");
                return;
            }
            if (num < 0 || num > menu.getMenuItems().size()) {
                System.out.println("잘못된 입력입니다.\n");
                continue;
            }

            MenuItem menuItem = menu.getMenuItems().get(num - 1);
            System.out.printf("%-2d. %-15s | ₩ %-6d | %s%n", num, menuItem.getName(), menuItem.getPrice(), menuItem.getDetail());
            System.out.println("주문이 완료되었습니다.\n");
            return;
        }
    }

    private int getUserInput(Scanner scanner){
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e){
            scanner.nextLine();
            return -1;
        }
    }
}