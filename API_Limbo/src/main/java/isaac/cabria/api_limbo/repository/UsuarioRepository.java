package isaac.cabria.api_limbo.repository;

import isaac.cabria.api_limbo.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    // Método para buscar un usuario por nombreUsu
    Usuario findByNombreUsu(String nombreUsu);
}
