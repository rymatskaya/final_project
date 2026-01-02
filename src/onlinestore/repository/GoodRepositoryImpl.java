package onlinestore.repository;

import onlinestore.controller.Constants;
import onlinestore.domain.Good;
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
