package weeklyBasis.dominio;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class MotivoEvento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "descrição")
    private String descricao;

    @Column(name = "título")
    private String titulo;

    @Column(name = "descrição")
    private String descriçao;


}
