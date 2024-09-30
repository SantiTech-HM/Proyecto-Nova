package com.SearchEngine.Proyecto.InterfacesDeServicio;

import com.SearchEngine.Proyecto.Entidades.Persona;

import java.util.List;

public interface ISPersona {

    public List<Persona> listarPersonas();
    public Persona buscarPersonaPorId(Long id);
    public Persona guardarPersona(Persona persona);
    public void eliminarPersona(Persona persona);
}
