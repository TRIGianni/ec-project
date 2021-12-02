package be.heh.ecproject.product.adapter.in.web;

import be.heh.ecproject.product.application.port.in.DisplayListProductsUseCase;
import be.heh.ecproject.product.domain.Message;
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

    @GetMapping(value = "/public")
    public Message publicEndpoint() {
        return new Message("All good. You DO NOT need to be authenticated to call /api/public.");
    }

    @GetMapping(value = "/private")
    public Message privateEndpoint() {
        return new Message("All good. You can see this because you are Authenticated.");
    }

    @GetMapping(value = "/private-scoped")
    public Message privateScopedEndpoint() {
        return new Message("All good. You can see this because you are Authenticated with a Token granted the 'read:messages' scope");
    }
}
