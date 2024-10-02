package com.SearchEngine.Proyecto.InterfacesDeRepositorios;

import com.SearchEngine.Proyecto.Entidades.Municipio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRMunicipio extends JpaRepository<Municipio, Long> {
}
