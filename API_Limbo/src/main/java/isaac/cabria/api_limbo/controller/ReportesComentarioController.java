package isaac.cabria.api_limbo.controller;

import isaac.cabria.api_limbo.model.Grupo;
import isaac.cabria.api_limbo.model.ReportesComentario;
import isaac.cabria.api_limbo.model.ReportesPublicacion;
import isaac.cabria.api_limbo.model.Torneo;
import isaac.cabria.api_limbo.repository.ReportesComentarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("limbo/reportes_comentario")
public class ReportesComentarioController {
    private final ReportesComentarioRepository reportesComentarioRepository;

    public ReportesComentarioController(ReportesComentarioRepository reportesComentarioRepository) {
        this.reportesComentarioRepository = reportesComentarioRepository;
    }

    @GetMapping
    public ResponseEntity<?> getReportesComentarios(){
        List<ReportesComentario> rpc = reportesComentarioRepository.findAll();
        return ResponseEntity.ok(rpc);
    }

    @GetMapping("/reporte_comentario/id/{id}")
    public ResponseEntity<ReportesComentario> getReporteComentarioById(@PathVariable int id) {
        ReportesComentario comentario = reportesComentarioRepository.findById(id).orElse(null);
        if (comentario != null) {
            return ResponseEntity.ok(comentario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> borrarReporteComentario(@PathVariable Integer id) {
        // Buscar el usuario existente en la base de datos
        ReportesComentario rpc = reportesComentarioRepository.findById(id).orElse(null);

        if (rpc != null) {
            // Eliminar el usuario
            reportesComentarioRepository.deleteById(id);
            return ResponseEntity.ok("Reporte de comentario eliminado correctamente");
        } else {
            // Retornar un error si el usuario no se encuentra
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Reporte no encontrado");
        }
    }
}
