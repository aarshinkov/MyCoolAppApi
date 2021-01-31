package com.aarshinkov.rest.mycoolapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.aarshinkov.rest.mycoolapp.entities.ProductEntity;

/**
 *
 * @author Atanas Yordanov Arshinkov
 * @since 1.0.0
 */
@Repository
public interface ProductsRepository extends JpaRepository<ProductEntity, Long> {
    
    ProductEntity findByProductId(Long productId);
    
    void deleteByProductId(Long productId);
}
