package isaac.cabria.api_limbo.repository;

import isaac.cabria.api_limbo.model.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GrupoRepository extends JpaRepository<Grupo, Integer> {
    Grupo findByNombreGrupo(String nombreGrupo);
}
