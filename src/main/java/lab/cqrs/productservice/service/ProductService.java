package lab.cqrs.productservice.service;

import lab.cqrs.productservice.data.ProductRepository;
import lab.cqrs.productservice.domain.Product;
import lab.cqrs.productservice.integration.JmsSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    JmsSender jmsSender;

    public void add(Product product){
        productRepository.save(product);
        jmsSender.sendMessage(product);
    }

    public void delete(Long productNumber){
        Optional<Product> optionalProduct = productRepository.findById(productNumber);
        optionalProduct.ifPresent(product -> {
            productRepository.delete(product);
            System.out.println(product);
            jmsSender.sendMessage(product);
        });
    }
    public Product getProduct(Long productNumber){
        return productRepository.findById(productNumber).orElseGet(() -> null);
    }
    public Collection<Product> findAll(){
        return productRepository.findAll();
    }
}
