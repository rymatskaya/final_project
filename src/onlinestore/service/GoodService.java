package onlinestore.service;

import onlinestore.domain.Good;
import onlinestore.domain.User;

import java.util.List;
import java.util.Optional;

public interface GoodService {
    Optional<Good> getGoodByCode(String code) ;
    Optional<Good> addGood(Good good);
    List<Good> getAllGoods();
    boolean findGoodByCode(String code);
    Optional<Good> updateGood(
            String code, String newName, String newBrand, String newCategory, Double newpPrice,
            Integer newAge);
    Optional<Good> deleteGood(String code);
}
