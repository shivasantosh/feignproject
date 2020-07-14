package com.order.feign.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.order.exception.ProductNotFoundException;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ProductFeignServiceFallBack implements ProductFeignService{

	private static final Logger LOGGER = LogManager.getLogger(ProductFeignServiceFallBack.class);

	private final Throwable cause;

	public ProductFeignServiceFallBack(Throwable cause) {
		this.cause = cause;
	}

	@Override
	public ResponseEntity<String> validateProduct(long productId) {
		// my code for updating errors in my DB
		//throw exception to the client
		LOGGER.error(cause.getMessage());
		LOGGER.info("thrown exception from upstream so entered fall back");
		throw new ProductNotFoundException("PRODUCT_NOT_FOUND", "PRODUCT_NOT_FOUND");
	}

}
