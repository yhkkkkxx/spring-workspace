package com.hana.app.service;

import com.hana.app.data.entity.CartEntity;
import com.hana.app.data.entity.CateEntity;
import com.hana.app.frame.HanaService;
import com.hana.app.repository.CartRepository;
import com.hana.app.repository.CateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartService implements HanaService<CartEntity, Integer> {
    final private CartRepository cartRepository;

    @Override
    public CartEntity insert(CartEntity cartEntity) {
        return cartRepository.save(cartEntity);
    }

    @Override
    public Optional<CartEntity> get(Integer integer) {
        return cartRepository.findById(integer);
    }

    @Override
    public List<CartEntity> get() {
        return cartRepository.findAll();
    }

    @Override
    public Boolean delete(Integer integer) {
        cartRepository.deleteById(integer);
        return true;
    }

    @Override
    public CartEntity update(CartEntity cartEntity) {
        return cartRepository.save(cartEntity);
    }

    public List<CartEntity> findByCustId(String id) {
        return cartRepository.findByCustId(id);
    }
}
