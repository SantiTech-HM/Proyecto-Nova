package com.SearchEngine.Proyecto.Cotroladores;


import com.SearchEngine.Proyecto.Entidades.Persona;
import com.SearchEngine.Proyecto.ExcepcionGlobal.ExcepcionGlobal;
import com.SearchEngine.Proyecto.InterfacesDeServicio.ISPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v6")
@CrossOrigin(value = "http://localhost:4200")
public class ControladorPersona {

    @Autowired
    private ISPersona isPersona;

    @GetMapping("personas")
    public List<Persona> listarPersonas() {
        return isPersona.listarPersonas();

    }
    @GetMapping("persona/{id}")
    public ResponseEntity<Persona> buscarPersonaPorId(@PathVariable Long id) {
        Persona persona = isPersona.buscarPersonaPorId(id);

        if (persona == null){
            throw new ExcepcionGlobal("Id de la persona no encontrado" + id);
        }
        return ResponseEntity.ok(persona);
    }
    @PostMapping("persona")
    public Persona guardarPersona(@RequestBody Persona persona){
        return isPersona.guardarPersona(persona);

    }
    @PutMapping("persona/{id}")
    public ResponseEntity<Persona> buscarPersonaPortaPorId(@PathVariable Long id, @RequestBody Persona personaObjeto){
        Persona persona = isPersona.buscarPersonaPorId(id);
        if (persona == null) {
            throw new ExcepcionGlobal("persona no encontrada "+ id);

        }

        persona.setId(personaObjeto.getId());
        persona.setNombre(personaObjeto.getNombre());
        persona.setApellido(personaObjeto.getApellido());
        persona.setBarrio(personaObjeto.getBarrio());

        Persona actualizarPersona = isPersona.guardarPersona(persona);
        return  ResponseEntity.ok(actualizarPersona);

    }
    @DeleteMapping("persona/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarPersona(@PathVariable Long id){
        Persona persona = isPersona.buscarPersonaPorId(id);

        if (persona == null) {
            throw new ExcepcionGlobal("persona no encontrada con" + id);
        }

        isPersona.eliminarPersona(persona);
        Map<String,Boolean> respuesta = new HashMap<>();
        respuesta.put("persona", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }


}
