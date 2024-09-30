package com.SearchEngine.Proyecto.Cotroladores;


import com.SearchEngine.Proyecto.Entidades.Barrio;
import com.SearchEngine.Proyecto.ExcepcionGlobal.ExcepcionGlobal;
import com.SearchEngine.Proyecto.InterfacesDeServicio.ISBarrio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v5")
@CrossOrigin(value = "http://localhost:4200")
public class ControladorBarrio {

    @Autowired
    private ISBarrio isBarrio;

    @GetMapping("barrios")
    public List<Barrio> listarBarrios() {
        return isBarrio.listarBarrios();
    }
    @GetMapping("barrio/{id}")
    public ResponseEntity<Barrio> buscarBarrioPorId(@PathVariable Long id) {
        Barrio barrio = isBarrio.buscarBarrioPorId(id);
        if (barrio == null) {
            throw new ExcepcionGlobal("id del barrio no encontrado" + id);

        }
        return ResponseEntity.ok(barrio);

    }
    @PostMapping("ciudad")
    public Barrio guardarBarrio(@RequestBody Barrio barrio){
        return isBarrio.guardarBarrio(barrio);

    }

    @PutMapping("barrio/{id}")
    public ResponseEntity<Barrio> buscarBarrioPorId(@PathVariable Long id, @RequestBody Barrio barrioObjeto){
        Barrio barrio = isBarrio.buscarBarrioPorId(id);
        if (barrio == null) {
            throw new ExcepcionGlobal("id del barrio no encontrado"+ id);
        }
        barrio.setCiudad(barrioObjeto.getCiudad());
        barrio.setId(barrioObjeto.getId());
        barrio.setNombre(barrioObjeto.getNombre());

        Barrio actualizarBarrio = isBarrio.guardarBarrio(barrio);
        return ResponseEntity.ok(actualizarBarrio);
    }
    @DeleteMapping("barrio/{id}")
    public ResponseEntity<Map<String,Boolean>> eliminarBarrio(@PathVariable Long id){
        Barrio barrio = isBarrio.buscarBarrioPorId(id);
        if (barrio == null) {
            throw new ExcepcionGlobal("Barrio no encotrado" + id);
        }

        isBarrio.eliminarBarrio(barrio);
        Map<String,Boolean> respuesta = new HashMap<>();
        respuesta.put("Barrio eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
}
