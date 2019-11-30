package com.codegym.repository;

import com.codegym.model.Category;
import com.codegym.model.Phone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface PhoneRepository extends PagingAndSortingRepository <Phone, Long> {
    Page<Phone> findAllByNameContaining(String name, Pageable pageable);
    Iterable<Phone> findAllByCategory(Category category);
}
