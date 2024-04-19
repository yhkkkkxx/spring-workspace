package com.hana.app.service;

import com.hana.app.data.entity.CustAddrEntity;
import com.hana.app.data.entity.CustEntity;
import com.hana.app.frame.HanaService;
import com.hana.app.repository.CustAddrRepository;
import com.hana.app.repository.CustRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustAddrService implements HanaService<CustAddrEntity, Integer> {
    final private CustAddrRepository custAddrRepository;

    @Override
    public CustAddrEntity insert(CustAddrEntity custAddrEntity) {
        return custAddrRepository.save(custAddrEntity);
    }

    @Override
    public Optional<CustAddrEntity> get(Integer integer) {
        return custAddrRepository.findById(integer);
    }

    @Override
    public List<CustAddrEntity> get() {
        return custAddrRepository.findAll();
    }

    @Override
    public Boolean delete(Integer integer) {
        custAddrRepository.deleteById(integer);
        return true;
    }

    @Override
    public CustAddrEntity update(CustAddrEntity custAddrEntity) {
        return custAddrRepository.save(custAddrEntity);
    }
}
