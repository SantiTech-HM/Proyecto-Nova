package com.SearchEngine.Proyecto.InterfacesDeServicio;

import com.SearchEngine.Proyecto.Entidades.Departamento;

import java.util.List;

public interface ISDepartamento {

    public List<Departamento> listarDepartamentos();
    public Departamento buscarDepartamentoPorId(Long id);
    public Departamento guardarDepartamento(Departamento departamento);
    public void eliminarDepartamento(Departamento departamento);
}
