package onlinestore.service;

import onlinestore.domain.Good;
import onlinestore.domain.User;
import onlinestore.repository.GoodRepository;
import onlinestore.repository.UserRepository;

import java.util.List;
import java.util.Optional;

public class GoodServiceImpl implements GoodService{
    private GoodRepository goodRepository;
    public GoodServiceImpl(GoodRepository goodRepository) {
        this.goodRepository = goodRepository;
    }

    @Override
    public Optional<Good> addGood(Good good) {
        return goodRepository.addGood(good);
    }

    @Override
    public List<Good> getAllGoods() {
        return goodRepository.getAllGoods();
    }

    @Override
    public boolean findGoodByCode(String code) {
        return goodRepository.findGoodByCode(code);
    }
}
