package pe.edu.cibertec.Practica.Repository;

import org.springframework.data.repository.CrudRepository;
import pe.edu.cibertec.Practica.Entity.Empleado;

public interface RepositoryInterface extends CrudRepository<Empleado,Integer> {
}
