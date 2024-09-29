package com.SearchEngine.Proyecto.InterfacesDeServicio;

import com.SearchEngine.Proyecto.ClasesDeServicio.CSContinente;
import com.SearchEngine.Proyecto.Entidades.Continente;

import java.util.List;

public interface ISContinente {

    public List<Continente> listarContinentes();
    public Continente buscarContinentePorId(Long id);
    public Continente guardarContinente(Continente continente);
    //public Continente actualizarContinente(Long id , Continente continente);
    public void eliminarContinente(Continente continente);
}
