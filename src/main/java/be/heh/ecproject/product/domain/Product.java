package be.heh.ecproject.product.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Product {
    private final long id;
    private final String productName;
    private final String description;
    private final double unitPrice;
    private final String imageUrl;
}
