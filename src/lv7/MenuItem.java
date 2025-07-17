package lv7;

public class MenuItem {
    private String name;
    private int price;
    private String detail;

    MenuItem(String name, int price, String detail) {
        this.name = name;
        this.price = price;
        this.detail = detail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

}