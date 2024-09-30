package com.SearchEngine.Proyecto.ClasesDeServicio;

import com.SearchEngine.Proyecto.Entidades.Persona;
import com.SearchEngine.Proyecto.InterfacesDeRepositorios.IRPersona;
import com.SearchEngine.Proyecto.InterfacesDeServicio.ISPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CSPersona implements ISPersona {

    @Autowired
    private IRPersona irPersona;

    @Override
    public List<Persona> listarPersonas() {
        return irPersona.findAll();
    }

    @Override
    public Persona buscarPersonaPorId(Long id) {
        return irPersona.findById(id).orElse(null);
    }

    @Override
    public Persona guardarPersona(Persona persona) {
        return irPersona.save(persona);
    }

    @Override
    public void eliminarPersona(Persona persona) {
            irPersona.delete(persona);
    }
}
