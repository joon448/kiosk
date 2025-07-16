package lv7;

public enum CustomerType {
    VETERAN("국가 유공자", 0.1),
    MILITARY("군인",0.05),
    STUDENT("학생",0.03),
    GENERAL("일반", 0.0);

    private String name;
    private double discountRate;

    CustomerType(String s, double v) {
        this.name = s;
        this.discountRate = v;
    }

    public String getName() {
        return name;
    }
    public double getDiscountRate() {
        return discountRate;
    }
}
