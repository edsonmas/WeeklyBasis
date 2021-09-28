package weeklyBasis.dominios.enums;

import lombok.Getter;

@Getter
public enum SituacaoFila {

    EM_ESPERA(1,"Em espera"),
    REALIZADO(2,"Realizado"),
    CANCELADO(3,"Cancelado"),
    ADIADO(3,"Adiado");

    private final Integer cod;
    private final String descricao;

    SituacaoFila(Integer cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public static SituacaoFila toEnum(Integer cod){
        if (cod== null){
            return null;
        }
        for (SituacaoFila x : SituacaoFila.values()){
            if (cod.equals(x.getCod())){
                return x;
            }
        }

        throw new IllegalArgumentException("Id invalido" + cod);
    }
}
