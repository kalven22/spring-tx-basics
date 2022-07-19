package main;

import config.Product;
import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import services.ProductService;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

        try (var c = new AnnotationConfigApplicationContext(ProjectConfig.class)){

            Product product = new Product("Table", 8);

            var productService = c.getBean(ProductService.class);
            productService.addProduct(product);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
