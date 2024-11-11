package com.example.dataconnect.repositories;

import com.example.dataconnect.dto.CategoryWithAmountDto;
import com.example.dataconnect.modelJPA.CategoryWithAmount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryWithAmountJPARepository extends JpaRepository<CategoryWithAmount, Long> {
    @Query(name = "category_amount", nativeQuery = true)
    List<CategoryWithAmountDto> findCategoryWithAmount();
}
