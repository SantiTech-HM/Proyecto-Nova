package com.SearchEngine.Proyecto.InterfacesDeServicio;

import com.SearchEngine.Proyecto.Entidades.Estado;

import java.util.List;

public interface ISEstado {

    public List<Estado> listarEstados();
    public Estado buscarEstadoPorId(Long id);
    public Estado guardarEstado(Estado estado);
    public void eliminarEstado(Estado estado);
}
