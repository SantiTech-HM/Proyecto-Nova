package com.SearchEngine.Proyecto.ClasesDeServicio;

import com.SearchEngine.Proyecto.Entidades.Ciudad;
import com.SearchEngine.Proyecto.InterfacesDeRepositorios.IRCiudad;
import com.SearchEngine.Proyecto.InterfacesDeServicio.ISCiudad;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CSCiudad implements ISCiudad {


    @Autowired
    private IRCiudad irCiudad;

    @Override
    public List<Ciudad> listarCiudad() {
        return irCiudad.findAll();
    }

    @Override
    public Ciudad buscarCiudadPorId(Long id) {
        return irCiudad.findById(id).orElse(null);
    }

    @Override
    public Ciudad guardarCliudad(Ciudad ciudad) {
        return irCiudad.save(ciudad);
    }

    @Override
    public void eliminnarCiudad(Ciudad ciudad) {
        irCiudad.delete(ciudad);
    }
}
