package isaac.cabria.api_limbo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;

import java.io.Serializable;

@Entity
@Table(name = "torneo")
public class Torneo implements Serializable {
    @Id
    @Column(name = "id_torneo", nullable = false)
    private Integer id;

    @Size(max = 45)
    @NotNull
    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;

    @Lob
    @Column(name = "descripcion")
    private String descripcion;

    @NotNull
    @JoinColumn(name = "id_grupo", nullable = false)
    private Integer idGrupo;

    @ColumnDefault("0")
    @Column(name = "participantes")
    private Integer participantes;

    @Lob
    @Column(name = "premios")
    private String premios;

    @Column(name = "puntos_rep")
    private Integer puntosRep;

    @Size(max = 200)
    @Column(name = "adjunto_imagen", length = 200)
    private String adjuntoImagen;

    @Size(max = 200)
    @Column(name = "adjunto_condiciones", length = 200)
    private String adjuntoCondiciones;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Integer idGrupo) {
        this.idGrupo = idGrupo;
    }

    public Integer getParticipantes() {
        return participantes;
    }

    public void setParticipantes(Integer participantes) {
        this.participantes = participantes;
    }

    public String getPremios() {
        return premios;
    }

    public void setPremios(String premios) {
        this.premios = premios;
    }

    public Integer getPuntosRep() {
        return puntosRep;
    }

    public void setPuntosRep(Integer puntosRep) {
        this.puntosRep = puntosRep;
    }

    public String getAdjuntoImagen() {
        return adjuntoImagen;
    }

    public void setAdjuntoImagen(String adjuntoImagen) {
        this.adjuntoImagen = adjuntoImagen;
    }

    public String getAdjuntoCondiciones() {
        return adjuntoCondiciones;
    }

    public void setAdjuntoCondiciones(String adjuntoCondiciones) {
        this.adjuntoCondiciones = adjuntoCondiciones;
    }

}