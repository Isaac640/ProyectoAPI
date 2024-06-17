package isaac.cabria.api_limbo.controller;

import isaac.cabria.api_limbo.model.Publicacion;
import isaac.cabria.api_limbo.model.ReportesComentario;
import isaac.cabria.api_limbo.model.ReportesPublicacion;
import isaac.cabria.api_limbo.repository.ReportesPublicacionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("limbo/reportes_publicacion")
public class ReportesPublicacionController {
    private final ReportesPublicacionRepository reportesPublicacionRepository;

    public ReportesPublicacionController(ReportesPublicacionRepository reportesPublicacionRepository) {
        this.reportesPublicacionRepository = reportesPublicacionRepository;
    }

    @GetMapping
    public ResponseEntity<?> getReportesPublicaciones(){
        List<ReportesPublicacion> rpp = reportesPublicacionRepository.findAll();
        return ResponseEntity.ok(rpp);
    }

    @GetMapping("/reporte_publicacion/id/{id}")
    public ResponseEntity<ReportesPublicacion> getReportePublicacionById(@PathVariable int id) {
        ReportesPublicacion publicacion = reportesPublicacionRepository.findById(id).orElse(null);
        if (publicacion != null) {
            return ResponseEntity.ok(publicacion);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> borrarReporteComentario(@PathVariable Integer id) {
        // Buscar el usuario existente en la base de datos
        ReportesPublicacion rpp = reportesPublicacionRepository.findById(id).orElse(null);

        if (rpp != null) {
            // Eliminar el usuario
            reportesPublicacionRepository.deleteById(id);
            return ResponseEntity.ok("Reporte de comentario eliminado correctamente");
        } else {
            // Retornar un error si el usuario no se encuentra
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Reporte no encontrado");
        }
    }
}
