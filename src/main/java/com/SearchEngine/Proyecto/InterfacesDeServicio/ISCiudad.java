package com.SearchEngine.Proyecto.InterfacesDeServicio;

import com.SearchEngine.Proyecto.Entidades.Ciudad;

import java.util.List;

public interface ISCiudad {

    public List<Ciudad> listarCiudad();
    public Ciudad buscarCiudadPorId(Long id);
    public Ciudad guardarCliudad(Ciudad  ciudad);
    public void eliminnarCiudad(Ciudad ciudad);
}
