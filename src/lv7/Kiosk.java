package lv7;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private List<Menu> menus = new ArrayList<>();
    private Cart cart;

    public Kiosk(){
        initializeMenus();
        cart = new Cart();
    }

    public void start(){
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag){
            flag = selectMenu(scanner);
        }
        scanner.close();
    }

    // 메뉴 리스트 초기화
    private void initializeMenus(){
        // 메뉴 리스트 생성 (버거)
        List<MenuItem> burgerItems = new ArrayList<>();
        burgerItems.add(new MenuItem("ShackBurger", 6900, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgerItems.add(new MenuItem("SmokeShack", 8900, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgerItems.add(new MenuItem("Cheeseburger", 6900, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgerItems.add(new MenuItem("Hamburger", 5400, "비프패티를 기반으로 야채가 들어간 기본버거"));
        menus.add(new Menu("Burgers", burgerItems));

        // 메뉴 리스트 생성 (음료)
        List<MenuItem> drinkItems = new ArrayList<>();
        drinkItems.add(new MenuItem("Coke", 2000, "톡 쏘는 청량감의 코카콜라"));
        drinkItems.add(new MenuItem("Sprite", 2000, "레몬라임 맛의 스프라이트"));
        drinkItems.add(new MenuItem("Lemonade", 3500, "상큼한 수제 레몬에이드"));
        menus.add(new Menu("Drinks", drinkItems));

        // 메뉴 리스트 생성 (디저트)
        List<MenuItem> dessertItems = new ArrayList<>();
        dessertItems.add(new MenuItem("Ice Cream", 3500, "바닐라맛 아이스크림"));
        dessertItems.add(new MenuItem("Chocolate Cake", 4500, "부드러운 초콜릿 케이크"));
        dessertItems.add(new MenuItem("Cookie", 2500, "달콤한 수제 쿠키"));
        dessertItems.add(new MenuItem("Brownie", 4000, "진한 브라우니"));
        menus.add(new Menu("Desserts", dessertItems));
    }

    // 메뉴 선택 기능
    private boolean selectMenu(Scanner scanner){
        printMenus();
        int num = getUserInput(scanner);

        if (num == 0){
            System.out.println("프로그램을 종료합니다.\n");
            return false;
        }

        int menuSize = menus.size();
        if (num < 0 || num > menuSize + 2) {
            System.out.println("잘못된 입력입니다.\n");
            return true;
        }

        if (!cart.getCartItems().isEmpty()) {
            // 장바구니 조회 입력 시
            if (num == menuSize + 1) {
                while(!cart.getCartItems().isEmpty()){
                    cart.printCart();
                    System.out.println("\n1. 주문     2. 수정     3. 뒤로 가기");
                    int choice = getUserInput(scanner);
                    // 3. 뒤로 가기 입력 시
                    if (choice == 3){
                        System.out.println("메뉴 화면으로 돌아갑니다.\n");
                        return true;
                    }

                    // 1. 주문 입력 시
                    if (choice == 1){
                        makeOrder(cart.getTotalPrice(), scanner);
                        cart.clearCart();
                        break;
                    }

                    // 2. 수정 입력 시
                    if (choice == 2){
                        askToEditCart(scanner);
                        continue;
                    }

                    System.out.println("잘못된 입력입니다.\n");
                }
                return true;
            }

            // 장바구니 삭제 입력 시
            if (num == menuSize + 2) {
                cart.clearCart();
                System.out.println("주문이 취소되었습니다.");
                return true;
            }
        }
        if (num > menuSize){
            System.out.println("잘못된 입력입니다.\n");
            return true;
        }
        Menu menu = menus.get(num - 1);
        selectMenuItem(menu, scanner);
        return true;
    }

    // 메뉴 아이템 선택 기능
    private void selectMenuItem(Menu menu, Scanner scanner){
        int num;
        while(true){
            menu.printMenuItems();
            num = getUserInput(scanner);

            if (num == 0){
                System.out.println("메뉴 화면으로 돌아갑니다.\n");
                return;
            }
            if (num < 0 || num > menu.getMenuItems().size()) {
                System.out.println("잘못된 입력입니다.\n");
                continue;
            }

            MenuItem menuItem = menu.getMenuItems().get(num - 1);
            System.out.printf("[선택] %-2d. %-15s | ₩ %-6d | %s%n%n", num, menuItem.getName(), menuItem.getPrice(), menuItem.getDetail());
            
            // 장바구니 추가 확인
            askToAddToCart(menuItem, scanner);
            return;
        }
    }

    //장바구니 추가 확인 기능
    private void askToAddToCart(MenuItem menuItem, Scanner scanner){
        int num;
        while(true) {
            System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
            System.out.println("1. 확인         2. 취소");
            num = getUserInput(scanner);
            if (num == 2) {
                System.out.println("메뉴 화면으로 돌아갑니다.");
                return;
            }
            if (num == 1) {
                // 장바구니 추가 수량 입력
                System.out.println("수량을 입력하세요.");
                int quantity = getUserInput(scanner);
                if (quantity <= 0) {
                    System.out.println("수량은 1개 이상이어야 합니다.\n");
                    continue;
                }
                // 장바구니 추가
                cart.addToCart(menuItem, quantity);
                System.out.printf("%s 이 장바구니에 추가되었습니다.%n%n", menuItem.getName());
                return;
            }

            System.out.println("잘못된 입력입니다.\n");
        }
    }
    
    // 장바구니 수정 기능
    private void askToEditCart(Scanner scanner){
        int num;
        while (!cart.getCartItems().isEmpty()) {
            cart.printCart();
            System.out.println("\n수정하실 항목 번호를 입력하세요. (0: 뒤로 가기)");
            num = getUserInput(scanner);
            if (num == 0){
                System.out.println("주문 화면으로 돌아갑니다.\n");
                return;
            }
            if (num < 0 || num > cart.getCartItems().size()) {
                System.out.println("잘못된 입력입니다.\n");
                continue;
            }
            CartItem cartItem = cart.getCartItems().get(num - 1);
            System.out.printf("\n[선택] %-2d. %-15s | ₩ %-6d * %d%n", num , cartItem.getMenuItem().getName(), cartItem.getMenuItem().getPrice(), cartItem.getQuantity());
            System.out.println("\n수량을 입력하세요. (0: 삭제)");
            int amount = getUserInput(scanner);
            if (amount == 0) {
                cart.removeFromCart(cartItem.getMenuItem());
                continue;
            }
            if (amount < 0) {
                System.out.println("잘못된 입력입니다.\n");
                continue;
            }
            cartItem.setQuantity(amount);
        }
    }

    // 주문 기능 및 할인율 적용
    private void makeOrder(int totalPrice, Scanner scanner) {
        double discountRate;
        while (true){
            System.out.println("할인 정보를 입력해주세요.");
            for(CustomerType c: CustomerType.values()){
                System.out.printf("%d . %-10s : %d%%%n",c.ordinal()+1, c.getName(), (int) (c.getDiscountRate()*100) );
            }
            int num = getUserInput(scanner);
            if (num <= 0 || num > CustomerType.values().length) {
                System.out.println("잘못된 입력입니다.\n");
                continue;
            }
            discountRate = CustomerType.values()[num-1].getDiscountRate();
            break;
        }

        System.out.printf("%n주문이 완료되었습니다. 금액은 %d원 입니다.%n%n",(int)(totalPrice*(1-discountRate)));

    }
    
    // 메뉴 출력 기능
    private void printMenus() {
        System.out.println("================================");
        System.out.println("[ SHAKESHACK MENU ]");
        for(int i = 0; i < menus.size(); i++){
            Menu menu = menus.get(i);
            System.out.printf("%-2d. %s%n", i+1, menu.getCategory());
        }
        System.out.println("0 . 종료");

        if (!cart.getCartItems().isEmpty()) {
            System.out.println("[ ORDER MENU ]");
            System.out.printf("%-2d. Orders       | 장바구니를 확인 후 주문합니다.%n", menus.size()+1);
            System.out.printf("%-2d. Cancel       | 진행 중인 주문을 취소합니다.%n", menus.size()+2);
        }
    }
    
    // 사용자 입력 처리 기능
    private int getUserInput(Scanner scanner){
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e){
            scanner.nextLine();
            return -1;
        }
    }

}