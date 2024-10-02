package com.SearchEngine.Proyecto.Cotroladores;


import com.SearchEngine.Proyecto.Entidades.Municipio;
import com.SearchEngine.Proyecto.ExcepcionGlobal.ExcepcionGlobal;
import com.SearchEngine.Proyecto.InterfacesDeServicio.ISMunicipio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v6")
@CrossOrigin(value = "http://localhost:4200")
public class ControladorMunicipio {

    @Autowired
    private ISMunicipio isMunicipio;

    @GetMapping("municipios")
    public List<Municipio> listarMunicipios() {
        return isMunicipio.listarMunicipios();

    }
    @GetMapping("municipio/{id}")
    public ResponseEntity<Municipio> buscarMunicipioPorId(@PathVariable Long id) {
        Municipio municipio = isMunicipio.buscarMunicipioPorId(id);

        if (municipio == null){
            throw new ExcepcionGlobal("Id del municipio no encontrado" + id);
        }
        return ResponseEntity.ok(municipio);
    }
    @PostMapping("municipio")
    public Municipio guardarMunicipio(@RequestBody Municipio municipio){
        return isMunicipio.guardarMunicipio(municipio);

    }
    @PutMapping("municipio/{id}")
    public ResponseEntity<Municipio> buscarMunicipioPortaPorId(@PathVariable Long id, @RequestBody Municipio municipioObjeto){
        Municipio municipio = isMunicipio.buscarMunicipioPorId(id);
        if (municipio == null) {
            throw new ExcepcionGlobal("municipio no encontrada "+ id);

        }

        municipio.setId(municipioObjeto.getId());
        municipio.setNombre(municipioObjeto.getNombre());
        municipio.setApellido(municipioObjeto.getApellido());
        municipio.setBarrio(municipioObjeto.getBarrio());

        Municipio actualizarMunicipio = isMunicipio.guardarMunicipio(municipio);
        return  ResponseEntity.ok(actualizarMunicipio);

    }
    @DeleteMapping("municipio/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarMunicipio(@PathVariable Long id){
        Municipio municipio = isMunicipio.buscarMunicipioPorId(id);

        if (municipio == null) {
            throw new ExcepcionGlobal("municipio no encontrada con" + id);
        }

        isMunicipio.eliminarMunicipio(municipio);
        Map<String,Boolean> respuesta = new HashMap<>();
        respuesta.put("municipio eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }

}
