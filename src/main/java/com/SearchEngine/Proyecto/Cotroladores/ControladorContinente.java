package com.SearchEngine.Proyecto.Cotroladores;


import com.SearchEngine.Proyecto.Entidades.Continente;
import com.SearchEngine.Proyecto.ExcepcionGlobal.ExcepcionGlobal;
import com.SearchEngine.Proyecto.InterfacesDeServicio.ISContinente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/")
@CrossOrigin(value = "http://localhost:4200")
public class ControladorContinente {

    @Autowired
    private ISContinente isContinente;

    @GetMapping("continentes")
    public List<Continente> listarcontinentes() {
        return isContinente.listarContinentes();
    }
    @GetMapping("continente/{id}")
    public ResponseEntity<Continente> buscarContinentePorId(@PathVariable Long id) {
        Continente buscarContinente = isContinente.buscarContinentePorId(id);

        if (buscarContinente == null) {
            throw new ExcepcionGlobal("Id del continente  no encontrado" + id);
        }
        return ResponseEntity.ok(buscarContinente);
    }

    @PostMapping("continente")
    public Continente guardarContinente(@RequestBody Continente continente) {
        return isContinente.guardarContinente(continente);
    }
    @PutMapping("continente/{id}")
    public ResponseEntity<Continente> buscarContinentePorId(@PathVariable Long id, @RequestBody Continente continenteObjeto) {
        Continente continente = isContinente.buscarContinentePorId(id);

        if (continente == null) {
            throw new ExcepcionGlobal("Continente no encontrado" + id);
        }

        continente.setId(continenteObjeto.getId());
        continente.setNombre(continenteObjeto.getNombre());

        Continente actualizarContinente = isContinente.guardarContinente(continente);
        return ResponseEntity.ok(actualizarContinente);
    }

    @DeleteMapping("continente/{id}")
    public ResponseEntity<Map<String , Boolean>> eliminarContinente(@PathVariable Long id) {
        Continente continente = isContinente.buscarContinentePorId(id);

        if (continente == null){
            throw new ExcepcionGlobal("Id de continente no encontrado" +id);
        }
        isContinente.eliminarContinente(continente);
        Map<String,Boolean> respuesta = new HashMap<>();
        respuesta.put("Continente eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }

}
