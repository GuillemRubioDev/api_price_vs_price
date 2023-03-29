package com.price_vs_price.api_rest_price_vs_price.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.price_vs_price.api_rest_price_vs_price.modelos.Roles;

@Repository
public interface RolesRepositorio extends JpaRepository<Roles, Long> {

}
