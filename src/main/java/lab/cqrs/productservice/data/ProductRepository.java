package lab.cqrs.productservice.data;

import lab.cqrs.productservice.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends MongoRepository<Product, Long> {
    @Override
    Optional<Product> findById(Long integer);
}
