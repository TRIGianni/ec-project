package be.heh.ecproject.product.adapter.out.persistence;

import be.heh.ecproject.product.domain.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProductPersistenceAdapterTest {

        @Autowired
        private ProductRepository productRepository;
        private ProductPersistenceAdapter productPersistenceAdapter;

        @Test
        @Sql({"/SQL/createTable.sql","/SQL/insert_data.sql"})
        void getProducts(){
            productPersistenceAdapter = new ProductPersistenceAdapter(productRepository);
            Map<String, Object> map = new HashMap<>();
            ArrayList<Product> products;

            map = productPersistenceAdapter.getProducts();

            products = (ArrayList<Product>)map.get("products");

            assertEquals("prod1",products.get(0).getProductName());
            assertEquals("description1",products.get(0).getDescription());
            assertEquals(1.5,products.get(0).getUnitPrice());

        }
}
