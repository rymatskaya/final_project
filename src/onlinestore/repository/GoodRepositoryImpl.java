package onlinestore.repository;

import onlinestore.controller.Constants;
import onlinestore.domain.Good;
import onlinestore.domain.User;
import onlinestore.exception.FileException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GoodRepositoryImpl implements GoodRepository{
    public static List<Good> goods = new ArrayList<>();

    @Override
    public List<Good> getAllGoods() {

        Object object = deserializeObject(Constants.FILEPATHGOODS);
        if (object instanceof List<?>) {
            goods = (List<Good>) object;
        }
        return goods;
    }
    @Override
    public Optional<Good> addGood(Good good) {
        goods = getAllGoods();
        if (!(findGoodByCode(good.getCode()))) {
            goods.add(good);
            serializeObject(goods, Constants.FILEPATHGOODS);
            return Optional.of(good);
        } else
            throw new RuntimeException(String.format("Товар с кодом  %s существует", good.getCode()));
    }

    @Override
    public boolean findGoodByCode(String code) {
        goods = getAllGoods();

        for (Good good : goods) {
            if (good.getCode().equals(code)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public Optional<Good> getGoodByCode(String code) {
        goods = getAllGoods();

        for (Good good : goods) {
            if (good.getCode().equals(code)) {
                return Optional.of(good);
            }
        }

        return Optional.empty();
    }

    @Override
    public Optional<Good> updateGood(String code, String newName, String newBrand, String newCategory, Double newPrice, Integer newAge) {
        List<Good> goods = getAllGoods();
        Optional<Good> updatedGood = getGoodByCode(code);
        if (updatedGood.isPresent()) {
            Good good = updatedGood.get();
            good.setName(newName);
            good.setBrand(newBrand);
            good.setGoodType(newCategory);
            good.setPrice(newPrice);
            good.setAge(newAge);
            serializeObject(goods, Constants.FILEPATHGOODS);
            return Optional.of(good);

        } else {
            return Optional.empty(); // Пользователь не найден
        }

     }

    @Override
    public Optional<Good> deleteGood(String code) {
        Optional<Good> goodOptional = getGoodByCode(code);
        if (goodOptional.isPresent()) {
            Good good = goodOptional.get();
            goods.remove(good);
            serializeObject(goods, Constants.FILEPATHGOODS);
            return Optional.of(good);
        } else {
            return Optional.empty(); // Пользователь не найден
        }
    }

    @Override
    public List<Good> getGoodsByCategory(String category) {
        Object object = deserializeObject(Constants.FILEPATHGOODS);
        if (object instanceof List<?>) {
           goods = (List<Good>) object;
        }
        List <Good> goodList = new ArrayList<>();
        for (Good good : goods) {
            if (good.getGoodType().equals(category)) {
                goodList.add(good);
            }
        }
        return goodList;
    }

    @Override
    public List<Good> getGoodsByCategoryPrice(String category, Double price) {
        Object object = deserializeObject(Constants.FILEPATHGOODS);
        if (object instanceof List<?>) {
            goods = (List<Good>) object;
        }
        List <Good> goodList = new ArrayList<>();
        for (Good good : goods) {
            if (good.getGoodType().equals(category) && good.getPrice() > price) {
                goodList.add(good);
            }
        }
        return goodList;
    }

    public Object deserializeObject(String path) {
        Object object = null;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path))) {
            object = objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + Constants.FILEPATH);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Ошибка при десериализации: " + e.getMessage());
        } catch (Throwable e) {
            return new Object();
        }
        return object;
    }

    public void serializeObject(Object object, String path) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path))) {
            objectOutputStream.writeObject(object);
        } catch (Throwable e) {
            throw new FileException("Файл не найден!");
        }
    }
}
