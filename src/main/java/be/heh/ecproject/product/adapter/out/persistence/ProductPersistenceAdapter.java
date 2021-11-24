package be.heh.ecproject.product.adapter.out.persistence;

import be.heh.ecproject.product.application.port.in.DisplayListProductsUseCase;
import be.heh.ecproject.product.domain.Product;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class ProductPersistenceAdapter implements DisplayListProductsUseCase {
    private final ProductRepository productRepository;
    @Override
    public Map<String, Object> getProducts() {
        List<ProductJpaEntity> productsJpa = productRepository.findAll();
        //mapper
        List<Product> productList = new ArrayList<>();
        Map<String,Object> productMap = new HashMap<>();

        for (ProductJpaEntity prod: productsJpa) {
            productList.add(new Product(prod.getId(),prod.getProductName(), prod.getDescription(), prod.getUnitPrice(),prod.getImageUrl()));
        }
        //---
        productMap.put("products",productList);
        return productMap;
    }
}
