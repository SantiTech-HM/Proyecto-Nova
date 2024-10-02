package com.SearchEngine.Proyecto.InterfacesDeServicio;

import com.SearchEngine.Proyecto.Entidades.Municipio;

import java.util.List;

public interface ISMunicipio {

    public List<Municipio> listarMunicipios();
    public Municipio buscarMunicipioPorId(Long id);
    public Municipio guardarMunicipio(Municipio municipio);
    public void eliminarMunicipio(Municipio municipio);
}
