package isaac.cabria.api_limbo.controller;

import isaac.cabria.api_limbo.model.HistorialGanadores;
import isaac.cabria.api_limbo.repository.HistorialGanadoresRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("limbo/historialGanadores")
public class HistorialGanadoresController {
    private final HistorialGanadoresRepository historialGanadoresRepository;

    public HistorialGanadoresController(HistorialGanadoresRepository historialGanadoresRepository) {
        this.historialGanadoresRepository = historialGanadoresRepository;
    }

    @GetMapping("/ganadores")
    public ResponseEntity<?> getHistorialGanadores(){
        List<HistorialGanadores> participantesTorneo = historialGanadoresRepository.findAll();
        return ResponseEntity.ok(participantesTorneo);
    }
    @GetMapping("/ganador/idTorneo/{idTorneo}")
    public ResponseEntity<?> getTorneoById(@PathVariable int idTorneo) {
        HistorialGanadores torneo = historialGanadoresRepository.findByIdTorneo(idTorneo);

        if (torneo != null) {
            return ResponseEntity.ok(torneo);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se ha encontrado el torneo por su id");
        }
    }
/*
    @GetMapping("/torneo/nombre/{nombreTorneo}")
    public ResponseEntity<?> buscarPorNombre(@PathVariable String nombreTorneo) {
        HistorialGanadores torneo = historialGanadoresRepository.findByNombreTorneo(nombreTorneo);
        if (torneo == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Torneo no encontrado");
        }
        return ResponseEntity.ok(torneo);
    }*/
}
