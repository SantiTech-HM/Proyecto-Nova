package com.SearchEngine.Proyecto.ClasesDeServicio;

import com.SearchEngine.Proyecto.Entidades.Pais;
import com.SearchEngine.Proyecto.InterfacesDeRepositorios.IRPais;
import com.SearchEngine.Proyecto.InterfacesDeServicio.ISPais;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CSPais implements ISPais {

    @Autowired
    private IRPais irPais;

    @Override
    public List<Pais> listarPaises() {
        return irPais.findAll();
    }

    @Override
    public Pais buscarPaisPorId(Long id) {
        return irPais.findById(id).orElse(null);
    }

    @Override
    public Pais guardarPais(Pais pais) {
        return irPais.save(pais);
    }

    @Override
    public void eliminarPais(Pais pais) {
        irPais.delete(pais);
    }
}
