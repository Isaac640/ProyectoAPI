package isaac.cabria.api_limbo.controller;

import isaac.cabria.api_limbo.model.Torneo;
import isaac.cabria.api_limbo.model.Usuario;
import isaac.cabria.api_limbo.repository.TorneoRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("limbo/torneos/")
public class TorneoController {
    private final TorneoRepository torneoRepository;

    public TorneoController(TorneoRepository publicacionRepository) {
        this.torneoRepository = publicacionRepository;
    }

    @GetMapping()
    public ResponseEntity<?> getTorneos() {
        List<Torneo> torneos = torneoRepository.findAll();

        if (torneos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se han encontrado torneos");
        }

        return ResponseEntity.ok(torneos);
    }

    @GetMapping("/torneo/id/{id}")
    public ResponseEntity<Torneo> getTorneoById(@PathVariable int id) {
        Torneo torneo = torneoRepository.findById(id).orElse(null);
        if (torneo != null) {
            return ResponseEntity.ok(torneo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/torneo/nombre/{nombreTorneo}")
    public ResponseEntity<?> buscarPorNombre(@PathVariable String nombreTorneo) {
        Torneo torneo = torneoRepository.findByNombre(nombreTorneo);
        if (torneo == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Torneo no encontrado");
        }
        return ResponseEntity.ok(torneo);
    }

    @PostMapping("/crear")
    public ResponseEntity<?> crearTorneo(@Valid @RequestBody Torneo torneo) {
        Torneo nuevoTorneo = torneoRepository.save(torneo);
        return new ResponseEntity<>(nuevoTorneo, HttpStatus.CREATED);
    }

    @PutMapping("/modificar/{id}")
    public ResponseEntity<?> modificarTorneo(@PathVariable Integer id, @Valid @RequestBody Torneo torneoDetalles) {
        Torneo torneoOriginal = torneoRepository.findById(id).orElse(null);
        if (torneoOriginal == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Torneo no encontrado");
        }

        // Actualizar los campos del torneo existente con los nuevos valores
        torneoOriginal.setNombre(torneoDetalles.getNombre());
        torneoOriginal.setDescripcion(torneoDetalles.getDescripcion());
        // Otros campos a actualizar...

        Torneo torneoActualizado = torneoRepository.save(torneoOriginal);
        return ResponseEntity.ok(torneoActualizado);
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> borrarTorneo(@PathVariable Integer id) {
        Torneo torneo = torneoRepository.findById(id).orElse(null);
        if (torneo == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Torneo no encontrado");
        }

        torneoRepository.deleteById(id);
        return ResponseEntity.ok("Torneo eliminado correctamente");
    }
}
