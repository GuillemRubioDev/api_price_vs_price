package com.price_vs_price.api_rest_price_vs_price.controladores;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.price_vs_price.api_rest_price_vs_price.modelos.Roles;
import com.price_vs_price.api_rest_price_vs_price.servicios.RolesSvImpl;

@RestController
@RequestMapping("/api/v1")
public class RolesControlador {

    @Autowired
    RolesSvImpl rolesSv;

    @GetMapping("/roles")
    public List<Roles> obtenerRoles() {
        return rolesSv.buscar();

    }

    @PostMapping("/guardar")
    public ResponseEntity<Roles> guardarRol(@RequestBody Roles rol) {
        Roles nuevo_rol = rolesSv.guardar(rol);
        return new ResponseEntity<>(nuevo_rol, HttpStatus.CREATED);
    }

    @GetMapping("/roles/{id}")
    public ResponseEntity<Roles> obtenerRolPorId(@PathVariable Long id) {
        Roles rolPorId = rolesSv.buscarPorId(id);
        return ResponseEntity.ok(rolPorId);
    }

    @PutMapping("/roles/{id}")
    public ResponseEntity<Roles> actualizar(@PathVariable Long id, Roles rol) {
        Roles rolesPorId = rolesSv.buscarPorId(id);
        rolesPorId.setName(rol.getName());

        Roles rolActualizado = rolesSv.guardar(rolesPorId);
        return new ResponseEntity<>(rolActualizado, HttpStatus.CREATED);
    }

    @DeleteMapping("/roles/{id}")
    public ResponseEntity<HashMap<String, Boolean>> eliminarRol(@PathVariable Long id) {
        this.rolesSv.eliminar(id);

        HashMap<String, Boolean> estadoRolesEliminado = new HashMap<>();
        estadoRolesEliminado.put("eliminado", true);
        return ResponseEntity.ok(estadoRolesEliminado);

    }

}
