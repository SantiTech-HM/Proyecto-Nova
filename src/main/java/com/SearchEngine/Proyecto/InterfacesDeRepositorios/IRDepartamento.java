package com.SearchEngine.Proyecto.InterfacesDeRepositorios;

import com.SearchEngine.Proyecto.Entidades.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRDepartamento extends JpaRepository<Departamento, Long> {
}
