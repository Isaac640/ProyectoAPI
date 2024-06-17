package isaac.cabria.api_limbo.repository;

import isaac.cabria.api_limbo.model.HistorialGanadores;
import isaac.cabria.api_limbo.model.HistorialGanadoresId;
import isaac.cabria.api_limbo.model.Torneo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistorialGanadoresRepository extends JpaRepository<HistorialGanadores, HistorialGanadoresId> {
        HistorialGanadores findByIdParticipante(int idParticipante);
        HistorialGanadores findByIdTorneo(int idTorneo);
        List<HistorialGanadores> findByIdParticipanteAndIdTorneo(int idParticipante, int idTorneo);
}
