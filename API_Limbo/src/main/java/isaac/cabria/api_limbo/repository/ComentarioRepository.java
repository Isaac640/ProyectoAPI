package isaac.cabria.api_limbo.repository;

import isaac.cabria.api_limbo.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComentarioRepository extends JpaRepository<Comentario, Integer> {
    List<Comentario> findByIdPublicacion(int idPublicacion);
}
