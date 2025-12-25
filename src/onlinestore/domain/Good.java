package onlinestore.domain;

import java.io.Serial;
import java.io.Serializable;

/**
 * Пример набора полей для товара Good: id, name, code, brand (Филипс, iphone, Huawei и т.д.),
 * category (Телефоны, стиральные машины и т.д.), price, ограничение по возрасту */
public class Good implements Serializable {
    @Serial
    private static final long serialVersionUID = 58289886658855L;
    private Integer id;
    private String name;
    private String code;
    private String brand;
    private Double price;
    private Integer age;
    private GoodType goodType;

    public Good(Integer id, String name, String code, String brand, Double price, Integer age, GoodType goodType) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.brand = brand;
        this.price = price;
        this.age = age;
        this.goodType = goodType;
    }

    public Good(String name, String code, String brand, Double price, GoodType goodType) {
        this.name = name;
        this.code = code;
        this.brand = brand;
        this.price = price;
        this.goodType = goodType;
    }

    public Good(String name, String code, String brand, Double price, Integer age, GoodType goodType) {
        this.name = name;
        this.code = code;
        this.brand = brand;
        this.price = price;
        this.age = age;
        this.goodType = goodType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public GoodType getGoodType() {
        return goodType;
    }

    public void setGoodType(GoodType goodType) {
        this.goodType = goodType;
    }

    @Override
    public String toString() {
        return "Good{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", age=" + age +
                ", goodType=" + goodType +
                '}';
    }
}
