package sistemahospitalar.business.medico;

import sistemahospitalar.business.geral.Pessoa;
import sistemahospitalar.business.geral.Sexo;

public class Medico extends Pessoa {
    private Especialidade especialidade;
    private final String CRM;


    public Medico(String nome, String cpf, String dataDeNascimento, Sexo sexo, String CRM, Especialidade especialidade) {
        super(nome, cpf, dataDeNascimento, sexo);
        this.CRM = CRM;
        this.especialidade = especialidade;

    }


}
