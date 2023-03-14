package shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.entities.ProductImageEntity;

public interface ProductImageRepository extends JpaRepository<ProductImageEntity, Integer> {
    ProductImageEntity findByName(String name);
}
