package com.kb.shop.service;

import com.kb.shop.domain.ShippingInfo;
import com.kb.shop.repository.ShippingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ShippingService {

    @Autowired
    ShippingRepository shippingRepository;

    public void createShippingInfo(ShippingInfo newShippingInfo) {
        shippingRepository.save(newShippingInfo);
    }

    public ShippingInfo getShippingInfo (Long id) {
        return shippingRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public ShippingInfo setShippingInfo (Long id, String status) {

        ShippingInfo shippingInfo = shippingRepository.findById(id).orElseThrow(NoSuchElementException::new);
        shippingInfo.setShippingStatus(status);
        shippingRepository.save(shippingInfo);

        return shippingInfo;
    }
}
