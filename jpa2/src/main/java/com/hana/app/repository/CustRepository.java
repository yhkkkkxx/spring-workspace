package com.hana.app.repository;

import com.hana.app.data.entity.CartEntity;
import com.hana.app.data.entity.CustEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustRepository extends JpaRepository<CustEntity, String> {
}
