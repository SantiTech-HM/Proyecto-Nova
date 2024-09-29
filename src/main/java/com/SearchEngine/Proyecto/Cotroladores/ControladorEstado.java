package com.SearchEngine.Proyecto.Cotroladores;


import com.SearchEngine.Proyecto.Entidades.Estado;
import com.SearchEngine.Proyecto.ExcepcionGlobal.ExcepcionGlobal;
import com.SearchEngine.Proyecto.InterfacesDeServicio.ISEstado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v3/")
@CrossOrigin(value = "http://localhost:4200")
public class ControladorEstado {

    @Autowired

    private ISEstado isEstado;

    @GetMapping("estados")
    public List<Estado> laistarEstados() {
        return isEstado.listarEstados();
    }

    @GetMapping("estados/{id}")
    public ResponseEntity<Estado> buscarEstadoPorIdo(@PathVariable Long id) {
        Estado estado = isEstado.buscarEstadoPorId(id);
        if (estado == null) {
            throw new ExcepcionGlobal("Id de estado no encntrado"  + id);

        }
        return ResponseEntity.ok(estado);
    }

    @PostMapping("estado")
    public Estado guardarEstado(@RequestBody Estado estado){
        return isEstado.guardarEstado(estado);
    }
    @PutMapping("estado/{id}")
    public ResponseEntity<Estado> buscarEstadoPorIdo(@PathVariable Long id, @RequestBody Estado estadoObjeto){
        Estado estado = isEstado.buscarEstadoPorId(id);
        if (estado == null){
            throw new ExcepcionGlobal("Estado no encontrado");
        }
        estado.setId(estadoObjeto.getId());
        estado.setNombre(estadoObjeto.getNombre());
        estado.setEstado(estadoObjeto.getEstado());

        Estado actualizarEstado = isEstado.guardarEstado(estado);
        return ResponseEntity.ok(actualizarEstado);

    }

    @DeleteMapping("estado/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarEstado(@PathVariable Long id){
        Estado estado = isEstado.buscarEstadoPorId(id);

        if (estado == null){
            throw new ExcepcionGlobal("Estado no encontrado " + id);

        }
        isEstado.eliminarEstado(estado);
        Map<String,Boolean> respuesta = new HashMap<>();
        respuesta.put("Estado elminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }


}
