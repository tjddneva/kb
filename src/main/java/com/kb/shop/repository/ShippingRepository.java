package com.kb.shop.repository;

import com.kb.shop.domain.ShippingInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShippingRepository extends JpaRepository<ShippingInfo, Long> {

    Optional<ShippingInfo> findById(Long id);
}


