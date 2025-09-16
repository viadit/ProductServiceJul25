package org.example.productservicejul25.repositories;

import org.example.productservicejul25.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findByTitle(String title);

    Optional<Category> findById(long id);
}
