package HexTech.Backend_lV_Fatec_Embraer.Entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name ="usr_usuario")

public class Usuario { 

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column (name = "usr_id")
private long id;

@Column (name = "usr_nome")
private String nome;

@Column (name = "usr_senha")
private String senha;


public Usuario (String nome, String senha){
    this.nome = nome;
    this.senha= senha;
}


public Usuario() {
    //Preciso de um método contrutor vazio pois alterei o padrão contrutor padrão
}

    
}



