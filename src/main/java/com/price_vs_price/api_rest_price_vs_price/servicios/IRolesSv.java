package com.price_vs_price.api_rest_price_vs_price.servicios;

import java.util.List;

import com.price_vs_price.api_rest_price_vs_price.modelos.Roles;

public interface IRolesSv {

    public List<Roles> buscar();

    public Roles guardar(Roles rol);

    public Roles buscarPorId(Long id);

    public void eliminar(Long id);
}
