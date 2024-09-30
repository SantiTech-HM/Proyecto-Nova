package com.SearchEngine.Proyecto.InterfacesDeRepositorios;

import com.SearchEngine.Proyecto.Entidades.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRPersona extends JpaRepository<Persona, Long> {
}
