package isaac.cabria.api_limbo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

@Entity
@Table(name = "reportes_publicacion")
public class ReportesPublicacion implements Serializable {
    @Id
    @Column(name = "id_reporte_publi", nullable = false)
    private Integer idReportePublicacion;

    @NotNull
    @Column(name = "id_publicacion", nullable = false)
    private Integer idPublicacion;

    @JoinColumn(name = "id_usuario", nullable = false)
    private int idUsuario;

    @Column(name = "tipo", nullable = false, length = 45)
    private String tipo;

    @Column(name = "razon", nullable = false)
    private String razon;

    public Integer getIdReportePublicacion() {
        return idReportePublicacion;
    }

    public void setIdReportePublicacion(Integer idReportePublicacion) {
        this.idReportePublicacion = idReportePublicacion;
    }

    public Integer getIdPublicacion() {
        return idPublicacion;
    }

    public void setIdPublicacion(Integer idPublicacion) {
        this.idPublicacion = idPublicacion;
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