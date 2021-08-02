package lab.cqrs.productservice.web;

import lab.cqrs.productservice.domain.Product;
import lab.cqrs.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping
    public void addProduct(@RequestBody Product product){
        productService.add(product);
    }

    @DeleteMapping("{productNumber}")
    public void deleteProduct(@PathVariable Long productNumber){
        productService.delete(productNumber);
    }
}
