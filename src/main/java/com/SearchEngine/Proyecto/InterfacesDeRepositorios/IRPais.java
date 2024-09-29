package com.SearchEngine.Proyecto.InterfacesDeRepositorios;

import com.SearchEngine.Proyecto.Entidades.Pais;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRPais extends JpaRepository<Pais, Long> {
}
