package com.order.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "product",url = "http://localhost:10490", fallbackFactory =  ProductFallBackFactory.class)
public interface ProductFeignService {

	@PostMapping("/validate/product/{productId}")
	ResponseEntity<String> validateProduct(@PathVariable long productId);
}
