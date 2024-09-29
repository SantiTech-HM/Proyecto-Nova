package com.SearchEngine.Proyecto.ClasesDeServicio;

import com.SearchEngine.Proyecto.Entidades.Estado;
import com.SearchEngine.Proyecto.InterfacesDeRepositorios.IREstado;
import com.SearchEngine.Proyecto.InterfacesDeServicio.ISEstado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ISEstados implements ISEstado {

    @Autowired
    private IREstado irEstado;

    @Override
    public List<Estado> listarEstados() {
        return irEstado.findAll();
    }

    @Override
    public Estado buscarEstadoPorId(Long id) {
        return irEstado.findById(id).orElse(null);
    }

    @Override
    public Estado guardarEstado(Estado estado) {
        return irEstado.save(estado);
    }

    @Override
    public void eliminarEstado(Estado estado) {
        irEstado.delete(estado);
    }
}
