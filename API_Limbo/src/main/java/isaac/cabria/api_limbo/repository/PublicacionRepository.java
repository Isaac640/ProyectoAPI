package isaac.cabria.api_limbo.repository;

import isaac.cabria.api_limbo.model.Publicacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicacionRepository extends JpaRepository<Publicacion, Integer> {
    Publicacion findByIdUsu(int idUsu);
    //Publicacion findById(String id_publi);
}
