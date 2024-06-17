package isaac.cabria.api_limbo.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "participantes_torneo")
public class ParticipantesTorneo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @MapsId("idUsuarioPar")
    //@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_usuario_par", nullable = false)
    private int idUsuarioPar;

    @MapsId("idTorneoPar")
    //@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_torneo_par", nullable = false)
    private int idTorneoPar;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuarioPar() {
        return idUsuarioPar;
    }

    public void setIdUsuarioPar(int idUsuarioPar) {
        this.idUsuarioPar = idUsuarioPar;
    }

    public int getIdTorneoPar() {
        return idTorneoPar;
    }

    public void setIdTorneoPar(int idTorneoPar) {
        this.idTorneoPar = idTorneoPar;
    }
}