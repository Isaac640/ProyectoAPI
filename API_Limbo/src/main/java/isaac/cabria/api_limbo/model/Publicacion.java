package isaac.cabria.api_limbo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.ColumnDefault;

import java.io.Serializable;

@Entity
@Table(name = "publicaciones")
public class Publicacion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_publi", nullable = false)
    private int id;

    @Column(name = "id_usu", nullable = false)
    private int idUsu;

    @Column(name = "texto", nullable = false, length = 45)
    private String texto;

    @Column(name = "adjunto_url", length = 2000)
    private String adjuntoBase64;

    @ColumnDefault("0")
    @Column(name = "me_gustas")
    private Integer meGustas;

    public int getId() {return id;}

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsu() {
        return idUsu;
    }

    public void setIdUsu(int idUsu) {
        this.idUsu = idUsu;
    }

    public @NotNull String getTexto() {
        return texto;
    }

    public void setTexto(@NotNull String texto) {
        this.texto = texto;
    }

    public String getAdjuntoBase64() {
        return adjuntoBase64;
    }

    public void setAdjuntoBase64(String adjuntoBase64) {
        this.adjuntoBase64 = adjuntoBase64;
    }

    public Integer getMeGustas() {
        return meGustas;
    }

    public void setMeGustas(Integer meGustas) {
        this.meGustas = meGustas;
    }
}
