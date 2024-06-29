package com.kb.shop.controller;

import com.kb.shop.domain.ShippingInfo;
import com.kb.shop.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shipping")
public class ShippingController {

    @Autowired
    private ShippingService shippingService;

    // 배송 정보를 생성하는 POST 호출을 생성합니다. (path : /shipping)
    @PostMapping("/")
    public ResponseEntity<ShippingInfo> createShippingInfo(@RequestBody ShippingInfo newShippingInfo){
        try{
            shippingService.createShippingInfo(newShippingInfo);
            return new ResponseEntity<>(newShippingInfo, HttpStatus.CREATED);
        } catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    // 배송 정보를 확인하는 GET 호출을 생성합니다.  (path : /shipping)
    @GetMapping("/{id}")
    public ResponseEntity<ShippingInfo> getShippingInfo(@PathVariable Long id) {
        try{
            ShippingInfo shippingInfo = shippingService.getShippingInfo(id);
            return new ResponseEntity<>(shippingInfo, HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // 배송 Status를 변경하는 PUT 호출을 생성합니다. (path : /shipping)
    @PutMapping("/")
    public ResponseEntity<String> setShippingStatus(@RequestParam Long id, @RequestParam String status) {
        try{
            ShippingInfo shippingInfo = shippingService.setShippingInfo(id, status);
            return new ResponseEntity<>(shippingInfo.getShippingStatus(), HttpStatus.OK);
        } catch (RuntimeException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
