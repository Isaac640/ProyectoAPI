package isaac.cabria.api_limbo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;

import java.io.Serializable;

@Entity
@Table(name = "grupo")
public class Grupo implements Serializable {
    @Id
    @Column(name = "id_grupo", nullable = false)
    private Integer idGrupo;


    @Column(name = "nombre_grupo", nullable = false, length = 45)
    private String nombreGrupo;

    @Column(name = "descripcion_grupo", length = 45)
    private String descripcionGrupo;


    public Integer getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Integer idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getNombreGrupo() {
        return nombreGrupo;
    }

    public void setNombreGrupo(String nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
    }

    public String getDescripcionGrupo() {
        return descripcionGrupo;
    }

    public void setDescripcionGrupo(String descripcionGrupo) {
        this.descripcionGrupo = descripcionGrupo;
    }

}