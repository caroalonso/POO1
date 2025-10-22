package ParcialMercadoOnlineCorregir;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Mercado {

    private List<Usuario> usuarios;
    private final static int DIEZ = 10;

    public Mercado() {
        this.usuarios = new ArrayList<>();
    }

    public Usuario agregarUsuario(String email, String locadidad) {
        Usuario usuario = new Usuario(email, locadidad);
        this.usuarios.add(usuario);
        return usuario;
    }

    public List<Publicacion> publicacionesOrdenadas(String localidadDestino) {
        return  this.usuarios.stream()
                .flatMap(u -> u.ordenar(localidadDestino).stream())
                .collect(Collectors.toList());
    }

    public List<Publicacion> diezMasCaros(String localidadDestino) {
        return this.publicacionesOrdenadas(localidadDestino).stream()
                .limit(DIEZ)
                .collect(Collectors.toList());
    }
}
