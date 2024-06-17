package isaac.cabria.api_limbo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;

@Entity
@Table(name = "comentarios")
public class Comentario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comentarios", nullable = false)
    private Integer idComentarios;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_publicacion", nullable = false, referencedColumnName = "id")
    private int idPublicacion;

    @Size(max = 45)
    @Column(name = "texto", length = 45)
    private String texto;

    @Lob
    @Column(name = "adjunto_url", length = 10000)  // Aumentar la longitud para manejar Base64
    private String adjuntoUrl;

    @ColumnDefault("0")
    @Column(name = "me_gustas")
    private Integer meGustas;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_usuario", nullable = false)
    private int idUsuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_respuesta_com")
    private Comentario idRespuestaCom;

    // Getters y setters...


    public Integer getIdComentarios() {
        return idComentarios;
    }

    public void setIdComentarios(Integer idComentarios) {
        this.idComentarios = idComentarios;
    }

    public int getIdPublicacion() {
        return idPublicacion;
    }

    public void setIdPublicacion(int idPublicacion) {
        this.idPublicacion = idPublicacion;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getAdjuntoUrl() {
        return adjuntoUrl;
    }

    public void setAdjuntoUrl(String adjuntoUrl) {
        this.adjuntoUrl = adjuntoUrl;
    }

    public Integer getMeGustas() {
        return meGustas;
    }

    public void setMeGustas(Integer meGustas) {
        this.meGustas = meGustas;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Comentario getIdRespuestaCom() {
        return idRespuestaCom;
    }

    public void setIdRespuestaCom(Comentario idRespuestaCom) {
        this.idRespuestaCom = idRespuestaCom;
    }
}
