package isaac.cabria.api_limbo.controller;

import isaac.cabria.api_limbo.model.Comentario;
import isaac.cabria.api_limbo.model.Usuario;
import isaac.cabria.api_limbo.repository.ComentarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("limbo/comentarios")
public class ComentarioController {
    private final ComentarioRepository comentarioRepository;

    public ComentarioController(ComentarioRepository comentarioRepository) {
        this.comentarioRepository = comentarioRepository;
    }

    @GetMapping
    public ResponseEntity<?> getComentarios() {
        List<Comentario> comentarios = comentarioRepository.findAll();

        if (comentarios.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se han encontrado comentarios");
        }
        return ResponseEntity.ok(comentarios);
    }

    @GetMapping("/comentario/id/{id}")
    public ResponseEntity<Comentario> getUsuariosById(@PathVariable int id) {
        Comentario comentario = comentarioRepository.findById(id).orElse(null);
        if (comentario != null) {
            return ResponseEntity.ok(comentario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/publicacion/{idPublicacion}")
    public ResponseEntity<?> getComentariosByIdPublicacion(@PathVariable int idPublicacion) {
        List<Comentario> comentarios = comentarioRepository.findByIdPublicacion(idPublicacion);
        if (comentarios.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se han encontrado comentarios para esta publicacion");
        }
        return ResponseEntity.ok(comentarios);
    }

    @PostMapping("/crear")
    public ResponseEntity<?> crearComentario(@RequestBody Comentario comentario) {
        Comentario nuevoComentario = comentarioRepository.save(comentario);
        return new ResponseEntity<>(nuevoComentario, HttpStatus.CREATED);
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> borrarComentario(@PathVariable Integer id) {
        Comentario comentario = comentarioRepository.findById(id).orElse(null);

        if (comentario != null) {
            comentarioRepository.deleteById(id);
            return ResponseEntity.ok("Comentario eliminado correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Comentario no encontrado");
        }
    }
}
