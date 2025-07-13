package isil.edu.pe.proyectodonpedritomarket.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import isil.edu.pe.proyectodonpedritomarket.modelo.Sucursal;

@Repository
public interface SucursalRepositorio extends JpaRepository<Sucursal, Integer> {
    
    //Aqui debo colocar metodos extras que no vengan por
    //defecto con la extension JpaRepository
    //buscar por nombre ya tiene un metodo
}
