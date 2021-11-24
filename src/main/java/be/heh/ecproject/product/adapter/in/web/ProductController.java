package be.heh.ecproject.product.adapter.in.web;

import be.heh.ecproject.product.application.port.in.DisplayListProductsUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(path="/api", produces="application/json")
@CrossOrigin(origins="*")
@RequiredArgsConstructor

public class ProductController {
    private final DisplayListProductsUseCase displayListProductsUseCase;

    @GetMapping("/products")
    public Map<String, Object> getProducts() {
        return displayListProductsUseCase.getProducts();
    }
}
