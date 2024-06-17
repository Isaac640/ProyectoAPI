package isaac.cabria.api_limbo.controller;

import isaac.cabria.api_limbo.model.Usuario;
import isaac.cabria.api_limbo.repository.GrupoRepository;
import isaac.cabria.api_limbo.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("limbo/usuarios")
public class UsuarioController {
    private final UsuarioRepository usuarioRepository;
    private final GrupoRepository grupoRepository;

    public UsuarioController(UsuarioRepository usuarioRepository, GrupoRepository grupoRepository) {
        this.usuarioRepository = usuarioRepository;
        this.grupoRepository = grupoRepository;
    }

    @GetMapping
    public ResponseEntity<?> getUsuarios(){
        List<Usuario> usuarios = usuarioRepository.findAll();

        if(usuarios.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se han encontrado usuarios");
        }

        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/usuario/id/{id}")
    public ResponseEntity<Usuario> getUsuariosById(@PathVariable int id) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/usuario/{nombreUsu}")
    public ResponseEntity<Usuario> buscarPorNombreUsu(@PathVariable String nombreUsu) {
        Usuario usuario = usuarioRepository.findByNombreUsu(nombreUsu);
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<?> crearUsuario( @RequestBody Usuario usuario) {
        // Verifica si el grupo es nulo y asigna un valor por defecto si es necesario
            usuario.setBan(Byte.parseByte("0"));
            usuario.setTipo("usuario");
            usuario.setGrupo(null); // Por ejemplo, asignarle 0 como valor de grupo nulo

        Usuario nuevoUsuario = usuarioRepository.save(usuario);
        return new ResponseEntity<>(nuevoUsuario, HttpStatus.CREATED);
    }

    @PutMapping("/modificar/{id}")
    public ResponseEntity<?> modificarUsuario(@PathVariable Integer id, @Valid @RequestBody Usuario usuarioDetalles) {
        // Buscar el usuario existente en la base de datos
        Usuario usuarioOriginal = usuarioRepository.findById(id).orElse(null);


        if (usuarioOriginal != null) {

            if (usuarioOriginal.getId().equals(usuarioDetalles.getId())) {

                // Actualizar los campos del usuario existente con los nuevos valores
                usuarioOriginal.setNombre(usuarioDetalles.getNombre());
                usuarioOriginal.setApellidos(usuarioDetalles.getApellidos());
                usuarioOriginal.setNombreUsu(usuarioDetalles.getNombreUsu());
                usuarioOriginal.setDescripcion(usuarioDetalles.getDescripcion());
                usuarioOriginal.setContrasenia(usuarioDetalles.getContrasenia());
                usuarioOriginal.setTipo(usuarioDetalles.getTipo() != null ? usuarioDetalles.getTipo() : usuarioOriginal.getTipo());
                usuarioOriginal.setGrupo(usuarioDetalles.getGrupo()); // Permitir nulo
                usuarioOriginal.setPuntosReputacion(usuarioDetalles.getPuntosReputacion());
                usuarioOriginal.setBan(usuarioDetalles.getBan());

                // Guardar los cambios en la base de datos
                Usuario usuarioActualizado = usuarioRepository.save(usuarioOriginal);
                return ResponseEntity.ok(usuarioActualizado);
            }else{
                return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body("El usuario no se puede modificar"); // los usuarios no son los mismos
            }
        } else {
            // Retornar un error si el usuario no se encuentra
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
        }
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> borrarUsuario(@PathVariable Integer id) {
        // Buscar el usuario existente en la base de datos
        Usuario usuario = usuarioRepository.findById(id).orElse(null);

        if (usuario != null) {
            // Eliminar el usuario
            usuarioRepository.deleteById(id);
            return ResponseEntity.ok("Usuario eliminado correctamente");
        } else {
            // Retornar un error si el usuario no se encuentra
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
        }
    }

}
