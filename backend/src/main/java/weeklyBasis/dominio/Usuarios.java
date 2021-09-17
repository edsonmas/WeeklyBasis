package weekyBasis.dominio;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;
@Entity
@Getter
@Setter
@Table(name = "usuarios")
public class Usuarios implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long id;

    @Column(name ="nome")
    private String nome;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "email")
    private String email;

    @Column(name ="status")
    private String status;

    @Column(name = "evento_id")
    private Long evento_id;

    @Column(name = "data_nascimento")
    private String data_nascimento;

    @Column(name ="foto")
    private byte[] foto;


}