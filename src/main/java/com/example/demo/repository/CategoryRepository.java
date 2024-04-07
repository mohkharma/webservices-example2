package com.example.demo.repository;

import com.example.demo.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring recognize repositories by the fact that they extend one of the predefined Repository interfaces
 * JpaRepositoryIt has full API CrudRepository and PagingAndSortingRepository. So, basically, Jpa Repository contains the APIs for basic CRUD operations, the APIS for pagination, and the APIs for sorting.
 * Author: Mohammed Kharma
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
