package isaac.cabria.api_limbo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;

import java.io.Serializable;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {
    @Id
    @Column(name = "id_usuario", nullable = false)
    private Integer id;


    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;


    @Column(name = "apellidos", nullable = false, length = 50)
    private String apellidos;


    @Column(name = "nombre_usu", nullable = false, length = 30)
    private String nombreUsu;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "contrasenia", nullable = false, length = 32)
    private String contrasenia;

    @ColumnDefault("'usuario'")
    @Column(name = "tipo", nullable = false)
    private String tipo;

    //@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "grupo", referencedColumnName = "id_grupo")
    private Integer grupo;


    @ColumnDefault("0")
    @Column(name = "puntos_reputacion")
    private Integer puntosReputacion;

    @Column(name = "ban")
    private Byte ban;


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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombreUsu() {
        return nombreUsu;
    }

    public void setNombreUsu(String nombreUsu) {
        this.nombreUsu = nombreUsu;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getGrupo() {
        return grupo;
    }

    public void setGrupo(Integer grupo) {
        this.grupo = grupo;
    }

    public Integer getPuntosReputacion() {
        return puntosReputacion;
    }

    public void setPuntosReputacion(Integer puntosReputacion) {
        this.puntosReputacion = puntosReputacion;
    }

    public Byte getBan() {
        return ban;
    }

    public void setBan(Byte ban) {
        this.ban = ban;
    }
}