package sistemahospitalar.business.cliente;

import sistemahospitalar.business.geral.Pessoa;
import sistemahospitalar.business.geral.Sexo;

import java.time.LocalDate;

public class Cliente extends Pessoa {
    private Plano plano;

    public Cliente(String nome, String cpf, LocalDate dataDeNascimento, Sexo sexo, Plano plano) {
        super(nome, cpf, dataDeNascimento, sexo);
        this.plano = plano;
    }

    public Plano getPlano() {
        return plano;
    }

    public void setPlano(Plano plano) {
        this.plano = plano;
    }

    @Override
    public String toString() {
        return nome+" - "+cpf+
                "\nDATA DE NASCIMENTO: "+dataDeNascimento+
                " | SEXO: "+sexo+
                "\nPLANO: "+plano;
    }

    // fazer os métodos para mexer na lista
}
