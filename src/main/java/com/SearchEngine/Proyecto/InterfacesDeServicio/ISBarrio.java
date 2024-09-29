package com.SearchEngine.Proyecto.InterfacesDeServicio;

import com.SearchEngine.Proyecto.Entidades.Barrio;
import com.SearchEngine.Proyecto.InterfacesDeRepositorios.IRBarrio;

import java.util.List;

public interface ISBarrio {

    public List<Barrio> listarBarrios();
    public Barrio buscarBarrioPorId(Long id);
    public Barrio guardarBarrio(Barrio barrio);
    public void  eliminarBarrio(Barrio barrio);
}
