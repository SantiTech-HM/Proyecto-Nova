package com.SearchEngine.Proyecto.InterfacesDeServicio;

import com.SearchEngine.Proyecto.Entidades.Pais;

import java.util.List;

public interface ISPais {

    public List<Pais> listarPaises();
    public Pais buscarPaisPorId(Long id);
    public Pais guardarPais(Pais pais);
    public  void eliminarPais(Pais pais);
}
