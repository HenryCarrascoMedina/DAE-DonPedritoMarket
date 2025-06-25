package isil.edu.pe.proyectodonpedritomarket.servicios;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import org.springframework.security.core.userdetails.User;
import isil.edu.pe.proyectodonpedritomarket.modelo.Usuario;

import isil.edu.pe.proyectodonpedritomarket.repositorios.UsuarioRepositorio;

@Service
public class UsuarioServicio implements UserDetailsService{
    
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Override
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepositorio.findByCorreo(correo);

        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario no encontrado con correo: " + correo);
        }

        // Aquí usamos el correo como nombre de usuario y el rol como autoridad
        return new User(
            usuario.getCorreo(),
            usuario.getPassword(),
            Collections.singleton(new SimpleGrantedAuthority("ROLE_" + usuario.getRol()))
        );
    }
    
}
