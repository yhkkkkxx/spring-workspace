package com.hana.app.service;

import com.hana.app.data.entity.CateEntity;
import com.hana.app.data.entity.CustEntity;
import com.hana.app.frame.HanaService;
import com.hana.app.repository.CateRepository;
import com.hana.app.repository.CustRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustService implements HanaService<CustEntity, String> {
    final private CustRepository custRepository;

    @Override
    public CustEntity insert(CustEntity custEntity) {
        return custRepository.save(custEntity);
    }

    @Override
    public Optional<CustEntity> get(String string) {
        return custRepository.findById(string);
    }

    @Override
    public List<CustEntity> get() {
        return custRepository.findAll();
    }

    @Override
    public Boolean delete(String string) {
        custRepository.deleteById(string);
        return true;
    }

    @Override
    public CustEntity update(CustEntity custEntity) {
        return custRepository.save(custEntity);
    }
}
