package isaac.cabria.api_limbo.repository;

import isaac.cabria.api_limbo.model.Torneo;
import isaac.cabria.api_limbo.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TorneoRepository extends JpaRepository<Torneo, Integer> {
    Torneo findByNombre(String nombre);

}
