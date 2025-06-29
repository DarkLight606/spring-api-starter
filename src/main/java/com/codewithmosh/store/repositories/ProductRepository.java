package com.codewithmosh.store.repositories;

import com.codewithmosh.store.dtos.ProductDto;
import com.codewithmosh.store.entities.Product;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 *
 @EntityGraph використовується для визначення графа сутностей (entity graph),
 який дозволяє завантажувати пов'язані дані (категорії) разом із основною сутністю (Product)
 в одному запиті.
 Завдяки цьому можна уникнути проблеми N+1 запитів,
 коли для кожного продукту виконується окремий запит для завантаження його категорії.
 */
public interface ProductRepository extends JpaRepository<Product, Long> {

    @EntityGraph(attributePaths = "category")
    List<Product> findByCategoryId(Byte category);

    @EntityGraph(attributePaths = "category")
    @Query("select p FROM Product p")
    List<Product> findAllWithCategory();
}