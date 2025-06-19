package utez.edu.mx.almacenes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import utez.edu.mx.almacenes.model.Transaccion;

@Repository
public interface TransaccionRepository extends JpaRepository<Transaccion, Integer> {
}
