package isaac.cabria.api_limbo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

@Entity
@Table(name = "historial_ganadores")
@IdClass(HistorialGanadoresId.class)
public class HistorialGanadores implements Serializable {


    @Id
    //@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_participante", nullable = false)
    private int idParticipante;

    @Id
    //@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_torneo", nullable = false)
    private int idTorneo;

    @Column(name = "puntos_rep_ganados")
    private Integer puntosRepGanados;

    @Column(name = "premio_ganado", length = 200)
    private String premioGanado;


    public int getIdParticipante() {
        return idParticipante;
    }

    public void setIdParticipante(int idParticipante) {
        this.idParticipante = idParticipante;
    }

    public int getIdTorneo() {
        return idTorneo;
    }

    public void setIdTorneo(int idTorneo) {
        this.idTorneo = idTorneo;
    }

    public Integer getPuntosRepGanados() {
        return puntosRepGanados;
    }

    public void setPuntosRepGanados(Integer puntosRepGanados) {
        this.puntosRepGanados = puntosRepGanados;
    }

    public String getPremioGanado() {
        return premioGanado;
    }

    public void setPremioGanado(String premioGanado) {
        this.premioGanado = premioGanado;
    }
}