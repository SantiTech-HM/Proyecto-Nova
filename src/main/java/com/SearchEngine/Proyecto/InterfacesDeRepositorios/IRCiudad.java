package com.SearchEngine.Proyecto.InterfacesDeRepositorios;

import com.SearchEngine.Proyecto.Entidades.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRCiudad extends JpaRepository<Ciudad, Long> {
}
