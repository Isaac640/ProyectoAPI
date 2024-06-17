package isaac.cabria.api_limbo.controller;

import isaac.cabria.api_limbo.model.ParticipantesTorneo;
import isaac.cabria.api_limbo.repository.ParticipantesTorneoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("limbo/participantes_torneo")
public class ParticipantesTorneoController {
    private final ParticipantesTorneoRepository participantesTorneoRepository;

    public ParticipantesTorneoController(ParticipantesTorneoRepository participantesTorneoRepository) {
        this.participantesTorneoRepository = participantesTorneoRepository;
    }

    // Obtener todos los participantes
    @GetMapping("/participantes")
    public ResponseEntity<List<ParticipantesTorneo>> obtenerParticipantes() {
        List<ParticipantesTorneo> participantes = participantesTorneoRepository.findAll();
        return ResponseEntity.ok(participantes);
    }

    // Obtener un torneo por ID
    @GetMapping("/torneo/{id}")
    public ResponseEntity<ParticipantesTorneo> obtenerTorneo(@PathVariable int idTorneo) {
        ParticipantesTorneo participanteTorneo = participantesTorneoRepository.findById(idTorneo).orElse(null);
        return ResponseEntity.ok(participanteTorneo);
    }

    // Agregar un usuario al torneo
    @PostMapping("/agregar")
    public ResponseEntity<ParticipantesTorneo> agregarUsuario(@RequestBody ParticipantesTorneo participante) {
        ParticipantesTorneo nuevoParticipante = participantesTorneoRepository.save(participante);
        return ResponseEntity.status(201).body(nuevoParticipante);
    }
}
