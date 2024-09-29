package com.SearchEngine.Proyecto.Cotroladores;

import com.SearchEngine.Proyecto.Entidades.Ciudad;
import com.SearchEngine.Proyecto.ExcepcionGlobal.ExcepcionGlobal;
import com.SearchEngine.Proyecto.InterfacesDeServicio.ISCiudad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("api/v4/")
@RestController
@CrossOrigin(value = "http://localhost:4200")
public class ControladorCiudad {

    @Autowired
    private ISCiudad isCiudad;

    @GetMapping("ciudades")
    public List<Ciudad> listarEstados() {
        return isCiudad.listarCiudad();
    }
    @GetMapping("ciudad/{id}")
    public ResponseEntity<Ciudad> buscarCiudadPorId(@PathVariable Long id) {
        Ciudad ciudad = isCiudad.buscarCiudadPorId(id);
        if (ciudad == null){
            throw new ExcepcionGlobal("ID de la ciudad no encontrado" + id);
        }
        return ResponseEntity.ok(ciudad);
    }

    @PostMapping("ciudad")
    public Ciudad guardarCiudad(@RequestBody Ciudad ciudad){
        return isCiudad.guardarCliudad(ciudad);
    }

    @PutMapping("ciudad/{id}")
    public ResponseEntity<Ciudad> buscarCiudadPorId(@PathVariable Long id, @RequestBody Ciudad ciudadObjeto) {
        Ciudad ciudad = isCiudad.buscarCiudadPorId(id);
        if (ciudad == null){
            throw new ExcepcionGlobal("Ciudad no encontrada");
        }
        ciudad.setCiudad(ciudadObjeto.getCiudad());
        ciudad.setId(ciudadObjeto.getId());
        ciudad.setNombre(ciudad.getNombre());

        Ciudad actualizarCiudad = isCiudad.guardarCliudad(ciudad);
        return ResponseEntity.ok(actualizarCiudad);
    }
    @DeleteMapping("ciudad/{id}")
    public ResponseEntity<Map<String,Boolean>> eliminarCiudad(@PathVariable Long id) {
        Ciudad ciudad = isCiudad.buscarCiudadPorId(id);
        if (ciudad == null) {
            throw new ExcepcionGlobal("id de continente no encontrado" + id);

        }
        isCiudad.eliminnarCiudad(ciudad);
        Map<String,Boolean> respuesta = new HashMap<>();
        respuesta.put("Ciudad eliminada", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }

}
