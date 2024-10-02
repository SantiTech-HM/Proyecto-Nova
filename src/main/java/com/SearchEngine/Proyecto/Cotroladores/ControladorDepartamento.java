package com.SearchEngine.Proyecto.Cotroladores;


import com.SearchEngine.Proyecto.Entidades.Departamento;
import com.SearchEngine.Proyecto.ExcepcionGlobal.ExcepcionGlobal;
import com.SearchEngine.Proyecto.InterfacesDeServicio.ISDepartamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v3/")
@CrossOrigin(value = "http://localhost:4200")
public class ControladorDepartamento {

    @Autowired

    private ISDepartamento isDepartamento;

    @GetMapping("departamentos")
    public List<Departamento> laistarDepartamentos() {
        return isDepartamento.listarDepartamentos();
    }

    @GetMapping("departamento/{id}")
    public ResponseEntity<Departamento> buscarDepartamentoPorIdo(@PathVariable Long id) {
        Departamento departamento = isDepartamento.buscarDepartamentoPorId(id);
        if (departamento == null) {
            throw new ExcepcionGlobal("Id de estado no encntrado"  + id);

        }
        return ResponseEntity.ok(departamento);
    }

    @PostMapping("departamento")
    public Departamento guardarDepartamento(@RequestBody Departamento departamento){
        return isDepartamento.guardarDepartamento(departamento);
    }
    @PutMapping("departamento/{id}")
    public ResponseEntity<Departamento> buscarDepartamentoPorIdo(@PathVariable Long id, @RequestBody Departamento departamentoObjeto){
        Departamento departamento = isDepartamento.buscarDepartamentoPorId(id);
        if (departamento == null){
            throw new ExcepcionGlobal("departamento no encontrado");
        }
        departamento.setId(departamentoObjeto.getId());
        departamento.setNombre(departamentoObjeto.getNombre());
        departamento.setPais(departamentoObjeto.getPais());

        Departamento actualizarDepartamento = isDepartamento.guardarDepartamento(departamento);
        return ResponseEntity.ok(actualizarDepartamento);

    }

    @DeleteMapping("departamento/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarDepartamento(@PathVariable Long id){
        Departamento departamento = isDepartamento.buscarDepartamentoPorId(id);

        if (departamento == null){
            throw new ExcepcionGlobal("departamento no encontrado " + id);

        }
        isDepartamento.eliminarDepartamento(departamento);
        Map<String,Boolean> respuesta = new HashMap<>();
        respuesta.put("departamento elminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }


}
