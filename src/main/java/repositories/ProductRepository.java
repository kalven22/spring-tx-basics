package repositories;

import config.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addProduct(Product product){
        String insertSQL = "INSERT INTO public.\"Product\"(\n" +
                "\t\"Name\", \"Age\")\n" +
                "\tVALUES (?, ?);";
        jdbcTemplate.update(insertSQL, product.getName(), product.getAge());

    }
}
