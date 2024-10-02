package com.SearchEngine.Proyecto.ClasesDeServicio;

import com.SearchEngine.Proyecto.Entidades.Departamento;
import com.SearchEngine.Proyecto.InterfacesDeRepositorios.IRDepartamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ISDepartamento implements com.SearchEngine.Proyecto.InterfacesDeServicio.ISDepartamento {

    @Autowired
    private IRDepartamento irDepartamento;

    @Override
    public List<Departamento> listarDepartamentos() {
        return irDepartamento.findAll();
    }

    @Override
    public Departamento buscarDepartamentoPorId(Long id) {
        return irDepartamento.findById(id).orElse(null);
    }

    @Override
    public Departamento guardarDepartamento(Departamento departamento) {
        return irDepartamento.save(departamento);
    }

    @Override
    public void eliminarDepartamento(Departamento departamento) {
        irDepartamento.delete(departamento);
    }
}
