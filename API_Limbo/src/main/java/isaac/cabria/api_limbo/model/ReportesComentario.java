package isaac.cabria.api_limbo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

@Entity
@Table(name = "reportes_comentario")
public class ReportesComentario implements Serializable {
    @Id
    @Column(name = "id_reportes_com", nullable = false)
    private Integer idReportesComentario;


    //@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_comentario", nullable = false)
    private int idComentario;

    //@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_usuario", nullable = false)
    private int idUsuario;

    @Column(name = "tipo", nullable = false, length = 45)
    private String tipo;


    @Column(name = "razon", nullable = false)
    private String razon;

    public Integer getIdReportesComentario() {
        return idReportesComentario;
    }

    public void setIdReportesComentario(Integer idReportesComentario) {
        this.idReportesComentario = idReportesComentario;
    }

    public int getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(int idComentario) {
        this.idComentario = idComentario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }
}