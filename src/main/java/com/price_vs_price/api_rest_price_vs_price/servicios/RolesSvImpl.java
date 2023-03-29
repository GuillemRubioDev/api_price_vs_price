package com.price_vs_price.api_rest_price_vs_price.servicios;

import java.util.List;

import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.price_vs_price.api_rest_price_vs_price.modelos.Roles;
import com.price_vs_price.api_rest_price_vs_price.repositorios.RolesRepositorio;

@Service
public class RolesSvImpl implements IRolesSv {

    @Autowired
    RolesRepositorio rolesRepositorio;

    @Override
    public List<Roles> buscar() {
        return rolesRepositorio.findAll();
    }

    @Override
    public Roles guardar(Roles rol) {
        return rolesRepositorio.save(rol);
    }

    @Override
    public Roles buscarPorId(Long id) {
        return rolesRepositorio.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        rolesRepositorio.deleteById(id);
    }

}