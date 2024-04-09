package com.fatih.productservice.mapper;

import com.fatih.productservice.dto.ProductRequest;
import com.fatih.productservice.dto.ProductResponse;
import com.fatih.productservice.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductEntityMapper {
    ProductEntityMapper INSTANCE = Mappers.getMapper(ProductEntityMapper.class);

    @Mapping(target="id", ignore=true)
    Product dtoToEntity(ProductRequest productDTO);

    ProductResponse entityToResponse(Product product);
}
