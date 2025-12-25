package onlinestore.domain;

public enum GoodType {
    FOOD("Продовольственные товары"),
    HOUSEGOLD("Хозяйственные товары"),
    HABERDASHERY("Галантерейные товары"),
    CONSTRUCTION("Строительные материалы"),
    SPORT("Спортивные товары");

    private String type;

    GoodType (String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
