package com.SearchEngine.Proyecto.Cotroladores;

import com.SearchEngine.Proyecto.Entidades.Ciudad;
import com.SearchEngine.Proyecto.ExcepcionGlobal.ExcepcionGlobal;
import com.SearchEngine.Proyecto.InterfacesDeServicio.ISCiudad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<Ciudad> buscarCiudad(@PathVariable Long id) {
        Ciudad ciudad = isCiudad.buscarCiudadPorId(id);
        if (ciudad == null){
            throw new ExcepcionGlobal("ID de la ciudad no encontrado" + id);
        }
        return ResponseEntity.ok(ciudad);
    }

    @PostMapping("ciudad")
    public Ciudad guardarCiudad (@RequestBody Ciudad ciudad){
        return isCiudad.guardarCliudad(ciudad);
    }

    @PutMapping("ciudad/{id}")
    
}
