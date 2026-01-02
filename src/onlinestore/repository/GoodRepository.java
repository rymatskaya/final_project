package onlinestore.repository;

import onlinestore.domain.Good;
import onlinestore.domain.User;

import java.util.List;
import java.util.Optional;

public interface GoodRepository {
    Optional<Good> addGood(Good good);
    List<Good> getAllGoods();
    boolean findGoodByCode(String code);
}
