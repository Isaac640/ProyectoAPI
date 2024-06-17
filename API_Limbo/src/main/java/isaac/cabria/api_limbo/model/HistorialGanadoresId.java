package isaac.cabria.api_limbo.model;

import java.io.Serializable;
import java.util.Objects;

public class HistorialGanadoresId implements Serializable {
    private int idParticipante;
    private int idTorneo;

    // Default constructor
    public HistorialGanadoresId() {
    }

    public HistorialGanadoresId(int idParticipante, int idTorneo) {
        this.idParticipante = idParticipante;
        this.idTorneo = idTorneo;
    }

    // Getters, setters, equals y hashCode
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HistorialGanadoresId that = (HistorialGanadoresId) o;
        return idParticipante == that.idParticipante && idTorneo == that.idTorneo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idParticipante, idTorneo);
    }

}
