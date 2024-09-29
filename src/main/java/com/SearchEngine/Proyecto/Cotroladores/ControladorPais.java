package com.SearchEngine.Proyecto.Cotroladores;


import com.SearchEngine.Proyecto.Entidades.Pais;
import com.SearchEngine.Proyecto.ExcepcionGlobal.ExcepcionGlobal;
import com.SearchEngine.Proyecto.InterfacesDeServicio.ISPais;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("api/v2/")
@CrossOrigin(value = "http://localhost:4200")
public class ControladorPais {

    @Autowired
    private ISPais isPais;

    @GetMapping("paises")
    public List<Pais> listarPaises() {
        return isPais.listarPaises();
    }
    @GetMapping("pais/{id}")
    public ResponseEntity<Pais> buscarPaisPorId(@PathVariable Long id) {

        Pais pais = isPais.buscarPaisPorId(id);
        if (pais == null) {
            throw new ExcepcionGlobal("Id de pais no encontrado" + id);
        }
        return ResponseEntity.ok(pais);
    }
    @PostMapping("pais")
    public Pais guardarPais(@RequestBody Pais pais) {
        return isPais.guardarPais(pais);
    }

    @PutMapping("pais/{id}")
    public ResponseEntity<Pais> buscarPaisPorId(@PathVariable Long id, @RequestBody Pais paisObjeto){
        Pais pais = isPais.buscarPaisPorId(id);
        if (pais == null) {
            throw new ExcepcionGlobal("Pais no encontrado" + id);

        }
        pais.setContinente(paisObjeto.getContinente());
        pais.setId(paisObjeto.getId());
        pais.setNombre(paisObjeto.getNombre());

        Pais actualizarPais = isPais.guardarPais(pais);
        return ResponseEntity.ok(actualizarPais);

    }

    @DeleteMapping("pais/{id}")
    public ResponseEntity<Map<String, Boolean>> eleminarPais(@PathVariable Long id) {
        Pais pais = isPais.buscarPaisPorId(id);

        if (pais == null) {
            throw new ExcepcionGlobal("Id de pais no encontrado" + id);
        }

        isPais.eliminarPais(pais);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("pais eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
}
