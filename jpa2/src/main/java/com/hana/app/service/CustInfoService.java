package com.hana.app.service;

import com.hana.app.data.entity.CustEntity;
import com.hana.app.data.entity.CustInfoEntity;
import com.hana.app.frame.HanaService;
import com.hana.app.repository.CustInfoRepository;
import com.hana.app.repository.CustRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustInfoService implements HanaService<CustInfoEntity, Integer> {
    final private CustInfoRepository custinInfoRepository;

    @Override
    public CustInfoEntity insert(CustInfoEntity custInfoEntity) {
        return custinInfoRepository.save(custInfoEntity);
    }

    @Override
    public Optional<CustInfoEntity> get(Integer integer) {
        return custinInfoRepository.findById(integer);
    }

    @Override
    public List<CustInfoEntity> get() {
        return custinInfoRepository.findAll();
    }

    @Override
    public Boolean delete(Integer integer) {
        custinInfoRepository.deleteById(integer);
        return true;
    }

    @Override
    public CustInfoEntity update(CustInfoEntity custInfoEntity) {
        return custinInfoRepository.save(custInfoEntity);
    }
}
