package com.SearchEngine.Proyecto.ClasesDeServicio;

import com.SearchEngine.Proyecto.Entidades.Barrio;
import com.SearchEngine.Proyecto.InterfacesDeRepositorios.IRBarrio;
import com.SearchEngine.Proyecto.InterfacesDeServicio.ISBarrio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CSBarrio implements ISBarrio {

    @Autowired
    private IRBarrio irBarrio;

    @Override
    public List<Barrio> listarBarrios() {
        return irBarrio.findAll();
    }

    @Override
    public Barrio buscarBarrioPorId(Long id) {
        return irBarrio.findById(id).orElse(null);
    }

    @Override
    public Barrio guardarBarrio(Barrio barrio) {
        return irBarrio.save(barrio);
    }

    @Override
    public void eliminarBarrio(Barrio barrio) {
        irBarrio.delete(barrio);
    }
}
