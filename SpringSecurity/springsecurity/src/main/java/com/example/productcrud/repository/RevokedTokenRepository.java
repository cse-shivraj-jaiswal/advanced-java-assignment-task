package com.example.productcrud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.productcrud.model.RevokedToken;

@Repository
public interface RevokedTokenRepository extends CrudRepository<RevokedToken, String> {
    boolean existsByToken(String token);
}
