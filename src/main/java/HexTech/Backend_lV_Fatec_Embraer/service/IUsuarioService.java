package HexTech.Backend_lV_Fatec_Embraer.service;

import java.util.List;

import HexTech.Backend_lV_Fatec_Embraer.entity.Usuario;

public interface IUsuarioService {

    public Usuario buscarPorId(Long id);

    public Usuario novoUsuario (Usuario usuario);

    public List<Usuario> buscarTodos();


    
}
