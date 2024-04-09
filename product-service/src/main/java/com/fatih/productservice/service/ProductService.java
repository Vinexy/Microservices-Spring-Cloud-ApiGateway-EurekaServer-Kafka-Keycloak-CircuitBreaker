package com.fatih.productservice.service;

import com.fatih.productservice.dto.ProductRequest;
import com.fatih.productservice.dto.ProductResponse;
import com.fatih.productservice.mapper.ProductEntityMapper;
import com.fatih.productservice.model.Product;
import com.fatih.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;
    public void createProduct(ProductRequest productRequest){
        Product product = ProductEntityMapper.INSTANCE.dtoToEntity(productRequest);
        productRepository.save(product);
        log.info("Product {} is saved", product.getId());
    }


    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(ProductEntityMapper.INSTANCE::entityToResponse).toList();
    }


}
