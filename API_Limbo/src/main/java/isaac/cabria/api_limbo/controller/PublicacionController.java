package isaac.cabria.api_limbo.controller;

import isaac.cabria.api_limbo.model.Publicacion;
import isaac.cabria.api_limbo.model.Usuario;
import isaac.cabria.api_limbo.repository.PublicacionRepository;
import isaac.cabria.api_limbo.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("limbo/publicaciones")
public class PublicacionController {
    private final PublicacionRepository publicacionRepository;
    private final UsuarioRepository usuarioRepository;

    public PublicacionController(PublicacionRepository publicacionRepository, UsuarioRepository usuarioRepository) {
        this.publicacionRepository = publicacionRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping
    public ResponseEntity<?> getPublicaciones(){
        List<Publicacion> publicaciones = publicacionRepository.findAll();

        if(publicaciones.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se han encontrado publicaciones");
        }

        return ResponseEntity.ok(publicaciones);
    }

    @GetMapping("/publicacion/id/{id}")
    public ResponseEntity<Publicacion> getPublicacionById(@PathVariable int id) {
        Publicacion publicacion = publicacionRepository.findById(id).orElse(null);
        if (publicacion != null) {
            return ResponseEntity.ok(publicacion);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/publicacion/usuario/{idUsuario}")
    public ResponseEntity<?> getPublicacionesByIdUsuario(@PathVariable int idUsuario){
        Publicacion publicaciones = publicacionRepository.findByIdUsu(idUsuario);
        return ResponseEntity.ok(publicaciones);
    }

    @PostMapping("/crear")
    public ResponseEntity<?> crearPublicacion(@RequestBody Publicacion publicacion) {
        Publicacion nuevaPublicacion = publicacionRepository.save(publicacion);
        return new ResponseEntity<>(nuevaPublicacion, HttpStatus.CREATED);
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> borrarPublicacion(@PathVariable Integer id) {
        Publicacion publicacion = publicacionRepository.findById(id).orElse(null);

        if (publicacion != null) {
            publicacionRepository.deleteById(id);
            return ResponseEntity.ok("Publicacion eliminada correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Publicacion no encontrada");
        }
    }
    @PutMapping("/ban/{id}")
    public ResponseEntity<?> banearUsuario(@PathVariable Integer id) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);

        if (usuario != null) {
            usuario.setBan((byte) 1);
            usuarioRepository.save(usuario);
            return ResponseEntity.ok("Usuario baneado correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
        }
    }
}
