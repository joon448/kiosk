# Java 키오스크 프로젝트

## 목표
Java 기초부터 단계적으로 발전시키는 키오스크 어플리케이션 구현

&nbsp;

## 개발 프로세스

- Lv 1. 클래스 없이 기본 문법만으로 메뉴 선택 및 주문 기능 구현

- Lv 2. MenuItem 클래스를 도입해 객체 단위로 메뉴 관리

- Lv 3. Kiosk 클래스를 만들어 메인 흐름을 분리 및 구조화

- Lv 4. Menu 클래스를 도입하여 카테고리별 메뉴 구성

- Lv 5. 캡슐화를 통해 필드 접근 제한, Getter/Setter 도입

- Lv 6. (도전) Cart, CartItem 클래스를 통해 장바구니 기능 구현

- Lv 7. (도전) Enum, Lambda & Stream 등 고급 문법 적용 (할인 기능 등)

&nbsp;

## 실행 환경

- Java 17

&nbsp;

## 디렉토리 구조

```
kiosk/
├── lv1/               # Lv1. 기본 문법으로 구현
├── lv2/               # Lv2. MenuItem 도입
├── lv3/               # Lv3. Kiosk 클래스 도입
├── lv4/               # Lv4. Menu 클래스 도입
├── lv5/               # Lv5. 캡슐화 적용
├── lv6/               # Lv6. 장바구니 기능
├── lv7/               # Lv7. 할인 및 고급 문법
└── README.md
```

&nbsp;

## 주요 클래스 설명
| 클래스 |	설명 |
|--------|------|
MenuItem	| 메뉴 이름, 가격, 설명을 담는 클래스
Menu | 메뉴 카테고리별로 MenuItem을 묶는 클래스
Kiosk	| 전체 흐름을 제어하는 핵심 클래스 (start())
Cart	| 장바구니의 아이템들을 저장하고 총합을 계산
CartItem	| 메뉴 항목과 수량을 함께 관리하는 클래스
CustomerType	| 할인 정책을 위한 Enum 클래스 (Lv7)

&nbsp;

## 클래스 및 주요 메서드 설명

### 🔹 Lv 1. Kiosk without Class
- `Scanner`, `if`, `switch`, `while` 등 기본 문법  
- 전역 변수 없이 모두 main 메서드 내에서 처리

---

### 🔹 Lv 2. Kiosk with MenuItem Class

#### 📦 `MenuItem`
| 필드 | 설명 |
|------|------|
| `String name` | 메뉴 이름 |
| `int price` | 가격 |
| `String detail` | 설명 |

---

### 🔹 Lv 3. Kiosk with Kiosk Class

#### 📦 `Kiosk`
| 필드 | 설명 |
|------|------|
| `List<MenuItem> menuItems` | 해당 카테고리 내 메뉴 목록 |

| 메서드 | 설명 |
|--------|------|
| `start()` | 키오스크 실행 전체 흐름 담당 |

---

### 🔹 Lv 4. Kiosk with Menu Class

#### 📦 `Menu`
| 필드 | 설명 |
|------|------|
| `String category` | 메뉴 카테고리 이름 |
| `List<MenuItem> menuItems` | 해당 카테고리 내 메뉴 목록 |

| 메서드 | 설명 |
|--------|------|
| 생성자 | 카테고리 이름과 메뉴 아이템 리스트 초기화 |
| `getCategory()` | 카테고리 이름 반환 |
| `getMenuItems()` | 메뉴 리스트 반환 |

---

### 🔹 Lv 5. 캡슐화 적용
- 모든 클래스의 필드를 `private`으로 변경하여 외부 접근 제한
- 각 필드에 대해 `Getter`, `Setter` 메서드 제공
- 코드 리팩토링 진행

#### 📦 `Kiosk`
| 메서드 | 설명 |
|--------|------|
| `start()` | 키오스크 실행 전체 흐름 담당 |
| `initializeMenus()` | 카테고리별 메뉴 초기 설정 |
| `printMenus()` | 카테고리별 메뉴 출력 |
| `selectMenu(Scanner)` | 사용자 입력에 따른 메뉴 처리 |
| `selectMenuItem(Menu, Scanner)` | 서브메뉴 선택 처리 |
| `getUserInput(Scanner)` | 사용자 입력 처리 (예외 포함) |

---

### 🔹 Lv 6. 장바구니 기능 추가

#### 📦 `CartItem`
| 필드 | 설명 |
|------|------|
| `MenuItem menuItem` | 선택된 메뉴 아이템 |
| `int quantity` | 수량 |

#### 📦 `Cart`
| 메서드 | 설명 |
|--------|------|
| `addToCart(MenuItem, quantity)` | 장바구니에 아이템 추가 |
| `removeFromCart(MenuItem)` | 장바구니에 아이템 삭제 |
| `printCart()` | 장바구니 목록 출력 |
| `getCartItems()` | 장바구니 전체 아이템 반환 |
| `setCartItems()` | 장바구니 전체 아이템 설정 |
| `getTotalPrice()` | 총 결제 금액 계산 |
| `clearCart()` | 장바구니 초기화 |

---

### 🔹 Lv 7. Enum, 스트림 기능 적용

#### 📦 `CustomerType (enum)`
| 상수 | 할인율 |
|------|--------|
| `VETERAN` | 10% |
| `MILITARY` | 5% |
| `STUDENT` | 3% |
| `GENERAL` | 0% |

#### 📦 장바구니 할인 적용 및 Stream 활용
- 장바구니 가격 필터링에 `Stream.filter()` 사용
- 할인율 계산에 `Enum` 매핑 및 조건별 처리 로직 포함

&nbsp;

## 개발 중 해결한 문제들

#### 🟨 Lv 1. `nextInt()` 후 `nextLine()`이 바로 안 먹힘
- **원인:** `nextInt()`가 숫자 입력만 처리하고, 개행문자 `\n`은 버퍼에 남기기 때문
- **해결:** `scanner.nextLine()`을 추가로 호출하여 개행문자를 소비

#### 🟨 Lv 1. `nextInt()`에 문자열 입력 시 예외 발생
- **원인:** `int` 타입에 문자열이 들어와서 `InputMismatchException` 발생
- **해결:** `try-catch`로 예외 처리하고, 입력 실패 시 루프 재시작

#### 🟩 Lv 2. 문자열 출력 정렬이 안 맞는 문제 
- **원인:** 메뉴마다 이름 길이가 달라서 정렬이 깨짐
- **해결:** printf로 양식을 지정하여 해결함

  ```System.out.printf("%-2d. %-12s | ₩ %-6d | %s%n", menuItem.id, menuItem.name, menuItem.price, menuItem.detail);```

#### 🟦 Lv 3. MenuItem 리스트를 어디서 생성할 것인가에 대한 고민
- **결론:** Kiosk 생성자 내에서 생성하는 것이 더 적절하다고 판단
- **이유:** Class의 역할 및 책임을 확실히 하기 위함. Main에서 리스트를 생성하고 넘기는 경우, 해당 리스트 생성에 대한 책임이 Main, Kiosk 둘로 나뉘게 됨

#### 🟪 Lv 5. 가독성 향상을 위해 코드 리팩토링을 어떻게 할 것인가 고민
- **원인:** 어느 단위로 메소드를 쪼개야 할지 고민
- **해결:** 기능 단위로 메소드를 분할함(ex. 사용자 인풋 메서드)

#### 🟧 Lv 6. 장바구니 기능 구현을 위한 클래스 설계 고민
- **원인:** 단순히 메뉴 아이템을 담는 것이 아니라 수량까지 관리해야 하는데, Cart 클래스에서 수량을 관리하기는 복잡함
- **해결:** CartItem 클래스를 추가로 구현하여 수량과 메뉴아이템 정보를 담음

#### 🟥 Lv 7. printf에서 %출력이 안되는 문제
- **원인:** %를 포맷지정자로 인식하기 때문
- **해결:** %%를 사용하면 '%' 출력 가능

#### 🟥 Lv 7. toList()의 사용 문제
- **원인:** toList()는 불변리스트로 만들기 때문에 이후에 add, remove할 수 없음
- **해결:** collect(Collectors.toList())를 대신 사용

&nbsp;


## 향후 개선 방향
- 메뉴 정보를 파일로 저장하거나 DB 연동

&nbsp;


## 학습 포인트
- Java 기초 문법 (Scanner, 조건문, 반복문 등)
- 객체지향 설계 (클래스 분리, 캡슐화)
- Enum, 람다, 스트림 API 활용
- 사용자 입력 예외 처리 및 UX 개선
