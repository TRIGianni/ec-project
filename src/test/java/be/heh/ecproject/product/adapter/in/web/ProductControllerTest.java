package be.heh.ecproject.product.adapter.in.web;

import be.heh.ecproject.product.application.port.in.DisplayListProductsUseCase;
import be.heh.ecproject.product.domain.Product;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerTest {

    @LocalServerPort
    private int port; //récupérer # port du serveur Tomcat

    @MockBean
    private DisplayListProductsUseCase displayListProductsUseCase;

    @Test
    void retrieveListProducts() {

        Product product1 = new Product(1L,"prod1","description1",1.5,"http://1");
        Product product2 = new Product(2L,"prod2","description2",2.5,"http://2");
        Product product3 = new Product(3L,"prod3","description3",3.5,"http://3");
        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        products.add(product3);
        Map<String, Object> productsMap = new LinkedHashMap<>();
        productsMap.put("products",products);

        //Stub
        Mockito.when(displayListProductsUseCase.getProducts()).thenReturn(productsMap);

        RestAssured.baseURI ="http://localhost/api";
        given().
                port(port).
                when().
                get("/products").
                then().
                statusCode(200).
                body("products[0].productName",equalTo("prod1")).
                body("products.description",hasItems("description1","description2","description3"));
    }
}
