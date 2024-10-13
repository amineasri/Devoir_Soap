package com.example.soap_dev.repo;

import com.example.soap_dev.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdctRepo extends JpaRepository<Product,Integer> {
}
