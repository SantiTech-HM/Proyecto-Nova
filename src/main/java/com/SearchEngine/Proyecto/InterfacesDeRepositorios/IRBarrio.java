package com.SearchEngine.Proyecto.InterfacesDeRepositorios;

import com.SearchEngine.Proyecto.Entidades.Barrio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRBarrio extends JpaRepository<Barrio, Long> {
}
