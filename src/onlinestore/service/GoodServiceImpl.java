package onlinestore.service;

import onlinestore.controller.Constants;
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

    @Override
    public Optional<Good> getGoodByCode(String code) {
        if (code == null || code.trim().isEmpty()) {
            return Optional.empty();
        }
        return goodRepository.getGoodByCode(code);
    }

    @Override
    public Optional<Good> updateGood(String code, String newName, String newBrand, String newCategory, Double newPrice,
                                     Integer newAge) {
        if (code == null || code.trim().isEmpty() ) {
            return Optional.empty();
        }
        return goodRepository.updateGood(code, newName, newBrand, newCategory, newPrice, newAge);

    }

    public Optional<Good> deleteGood(String code) {
        if (code == null || code.trim().isEmpty() ) {
            return Optional.empty();
        }
        return goodRepository.deleteGood(code);
    }
    public List<Good> getGoodsByCategory(String category){
        if (category == null || category.trim().isEmpty() ) {
            return null;
        }
        return goodRepository.getGoodsByCategory(category);
    }

    public List<Good> getGoodsByCategoryPrice(String category, Double price) {
        if (category == null || category.trim().isEmpty() || price == 0.00 ) {
            return null;
        }
        return goodRepository.getGoodsByCategoryPrice(category, price);
    }


}
