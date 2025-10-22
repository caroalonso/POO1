package ParcialDebate;

import java.util.ArrayList;
import java.util.List;

public class Debate {
    private List<Usuario> usuarios;

    public Debate() {
        this.usuarios = new ArrayList<>();
    }

    public void agregarUsuario(Usuario usuario) {
        this.usuarios.add(usuario);
    }
}
