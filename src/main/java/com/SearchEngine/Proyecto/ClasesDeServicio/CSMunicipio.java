package com.SearchEngine.Proyecto.ClasesDeServicio;

import com.SearchEngine.Proyecto.Entidades.Municipio;
import com.SearchEngine.Proyecto.InterfacesDeRepositorios.IRMunicipio;
import com.SearchEngine.Proyecto.InterfacesDeServicio.ISMunicipio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CSMunicipio implements ISMunicipio {

    @Autowired
    private IRMunicipio irMunicipio;

    @Override
    public List<Municipio> listarMunicipios() {
        return irMunicipio.findAll();
    }

    @Override
    public Municipio buscarMunicipioPorId(Long id) {
        return irMunicipio.findById(id).orElse(null);
    }

    @Override
    public Municipio guardarMunicipio(Municipio municipio) {
        return irMunicipio.save(municipio);
    }

    @Override
    public void eliminarMunicipio(Municipio municipio) {
            irMunicipio.delete(municipio);
    }
}
