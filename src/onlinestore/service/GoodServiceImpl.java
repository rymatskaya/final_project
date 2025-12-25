package onlinestore.service;

import onlinestore.repository.GoodRepository;
import onlinestore.repository.UserRepository;

public class GoodServiceImpl implements GoodService{
    private GoodRepository goodRepository;
    public GoodServiceImpl(GoodRepository goodRepository) {
        this.goodRepository = goodRepository;
    }
}
