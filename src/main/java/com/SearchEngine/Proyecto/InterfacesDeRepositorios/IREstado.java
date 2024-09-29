package com.SearchEngine.Proyecto.InterfacesDeRepositorios;

import com.SearchEngine.Proyecto.Entidades.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IREstado extends JpaRepository<Estado, Long> {
}
