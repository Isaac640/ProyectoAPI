package isaac.cabria.api_limbo.controller;

import isaac.cabria.api_limbo.model.Grupo;
import isaac.cabria.api_limbo.model.Usuario;
import isaac.cabria.api_limbo.repository.GrupoRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("limbo/grupos")
public class GrupoController {
    private final GrupoRepository grupoRepository;

    public GrupoController(GrupoRepository grupoRepository) {
        this.grupoRepository = grupoRepository;
    }

    @GetMapping
    public ResponseEntity<?> getGrupos(){
        List<Grupo> grupos = grupoRepository.findAll();
        return ResponseEntity.ok(grupos);
    }

    @GetMapping("/grupo/id/{idGrupo}")
    public ResponseEntity<?> getGruposById(@PathVariable int idGrupo){
        Grupo grupo = grupoRepository.findById(idGrupo).orElse(null);
        return ResponseEntity.ok(grupo);
    }

    @GetMapping("/grupo/nombre/{nombreGrupo}")
    public ResponseEntity<Grupo> buscarPorNombreGrupo(@PathVariable String nombreGrupo) {
        Grupo grupo = grupoRepository.findByNombreGrupo(nombreGrupo);
        if (grupo != null) {
            return ResponseEntity.ok(grupo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<?> crearGrupo() {
        Grupo grupo = new Grupo();
        Grupo nuevoGrupo = grupoRepository.save(grupo);
        return new ResponseEntity<>(nuevoGrupo, HttpStatus.CREATED);
    }

    @PutMapping("/modificar/{id}")
    public ResponseEntity<?> modificarGrupo(@PathVariable Integer id, @Valid @RequestBody Grupo grupoDetalles) {
        // Buscar el usuario existente en la base de datos
        Grupo grupoOriginal = grupoRepository.findById(id).orElse(null);
        if (grupoOriginal != null) {

            if (grupoOriginal.getIdGrupo().equals(grupoDetalles.getIdGrupo())) {

                // Actualizar los campos del usuario existente con los nuevos valores
                grupoOriginal.setNombreGrupo(grupoDetalles.getNombreGrupo());
                grupoOriginal.setDescripcionGrupo(grupoDetalles.getDescripcionGrupo());

                // Guardar los cambios en la base de datos
                Grupo grupoActualizado = grupoRepository.save(grupoOriginal);
                return ResponseEntity.ok(grupoActualizado);
            }else{
                return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body("El grupo no se puede modificar"); // los usuarios no son los mismos
            }
        } else {
            // Retornar un error si el usuario no se encuentra
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Grupo no encontrado");
        }
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> borrarGrupo(@PathVariable Integer id) {
        // Buscar el usuario existente en la base de datos
        Grupo grupo = grupoRepository.findById(id).orElse(null);

        if (grupo != null) {
            // Eliminar el usuario
            grupoRepository.deleteById(id);
            return ResponseEntity.ok("Grupo eliminado correctamente");
        } else {
            // Retornar un error si el usuario no se encuentra
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Grupo no encontrado");
        }
    }
}
