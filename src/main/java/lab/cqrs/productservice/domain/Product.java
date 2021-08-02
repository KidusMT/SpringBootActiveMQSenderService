package lab.cqrs.productservice.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Product {
    @Id
    private Long productNumber;
    private String name;
    private Double price;
}

