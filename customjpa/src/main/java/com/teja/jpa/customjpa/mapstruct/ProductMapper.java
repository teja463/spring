package com.teja.jpa.customjpa.mapstruct;

import java.util.List;
import com.teja.jpa.customjpa.dto.CustomerDTO;
import com.teja.jpa.customjpa.dto.ProductDTO;
import com.teja.jpa.customjpa.dto.ProductRequest;
import com.teja.jpa.customjpa.entity.Customer;
import com.teja.jpa.customjpa.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product mapProductRequestToProduct(ProductRequest productRequest);

    @Mapping(source = "id", target = "productId")
    @Mapping(source = "name", target = "productName")
    @Mapping(source = "price", target = "productPrice")
    ProductDTO mapProductToDTO(Product product);

    @Mapping(source = "id", target = "customerId")
    @Mapping(source = "name", target = "customerName")
    @Mapping(source = "address", target = "customerAddress")
    CustomerDTO mapCustomerToDTO(Customer customer);

    List<ProductDTO> mapProductsToDTOs(List<Product> product);
}
