package com.SearchEngine.Proyecto.ClasesDeServicio;

import com.SearchEngine.Proyecto.Entidades.Continente;
import com.SearchEngine.Proyecto.InterfacesDeRepositorios.IRContinente;
import com.SearchEngine.Proyecto.InterfacesDeServicio.ISContinente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CSContinente implements ISContinente {

    @Autowired
    private IRContinente irContinente;

    @Override
    public List<Continente> listarContinentes() {
        return irContinente.findAll();
    }

    @Override
    public Continente buscarContinentePorId(Long id) {
        return irContinente.findById(id).orElse(null);
    }

    @Override
    public Continente guardarContinente(Continente continente) {
        return irContinente.save(continente);
    }

    @Override
    public void eliminarContinente(Continente continente) {
        irContinente.delete(continente);
    }
}
