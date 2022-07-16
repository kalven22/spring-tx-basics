package main;

import config.Product;
import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

        try (var c = new AnnotationConfigApplicationContext(ProjectConfig.class)){
            Product product = new Product("Mouse", 2);
            var template = c.getBean(JdbcTemplate.class);
            System.out.println(template.getDataSource().getConnection().getMetaData().getUserName());
            String selectSQL = "SELECT * FROM public.\"Product\"";
            String insertSQL = "INSERT INTO public.\"Product\"(\n" +
                    "\t\"Name\", \"Age\")\n" +
                    "\tVALUES (?, ?);";
            //template.execute("SELECT * FROM public.\"Product\"");
            template.update(insertSQL, product.getName(), product.getId());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
