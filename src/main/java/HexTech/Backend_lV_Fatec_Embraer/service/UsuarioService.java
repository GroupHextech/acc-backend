package HexTech.Backend_lV_Fatec_Embraer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HexTech.Backend_lV_Fatec_Embraer.entity.Usuario;
import HexTech.Backend_lV_Fatec_Embraer.repository.UsuarioRepository;




@Service
public class UsuarioService {

@Autowired
private UsuarioRepository usuarioRepo;

public Usuario buscarPorId(Long id){

    Optional<Usuario> usuarioOp = usuarioRepo.findById(id);
    if (usuarioOp.isPresent()){
         return usuarioOp.get();
    }
     throw new IllegalArgumentException("Deu ruimn para o ID");


}


public Usuario novoUsuario(Usuario usuario){

    if (usuario ==null || usuario.getNome() == null|| usuario.getSenha() == null){

        throw new IllegalArgumentException("Tente outra vez, essa Senha está errada ");
    }
    return usuarioRepo.save(usuario);


}

    
}
