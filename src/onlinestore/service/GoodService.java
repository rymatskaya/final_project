package onlinestore.service;

import onlinestore.domain.Good;
import onlinestore.domain.User;

import java.util.List;
import java.util.Optional;

public interface GoodService {
    Optional<Good> addGood(Good good);
    List<Good> getAllGoods();
    boolean findGoodByCode(String code);
}
