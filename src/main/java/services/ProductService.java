package services;

import config.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repositories.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    /**
     * By default, @Transactional only rolls-back RuntimeException
     * You change the defaults easily like below
     */
    @Transactional (rollbackFor = Exception.class)
    public void addProduct(Product product) throws Exception{
        productRepository.addProduct(product);
        throw new Exception(":(");
    }
}
