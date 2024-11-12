package sistemahospitalar.business.cliente;

import sistemahospitalar.business.geral.Pessoa;
import sistemahospitalar.business.geral.Sexo;

public class Cliente extends Pessoa {
    private Plano plano;
    /*private List<Historico> historico;  // historico do paciente
    private List<Exames> examesMarcados;  // consultas pendentes*/

    public Cliente(String nome, String cpf, String dataDeNascimento, Sexo sexo, Plano plano) {
        super(nome, cpf, dataDeNascimento, sexo);
        this.plano = plano;
        /*this.historico = new ArrayList<>();
        this.examesMarcados = new ArrayList<>();*/
    }

    public Plano getPlano() {
        return plano;
    }

    public void setPlano(Plano plano) {
        this.plano = plano;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dataDeNascimento='" + dataDeNascimento + '\'' +
                ", sexo=" + sexo +
                "plano=" + plano +'}';
    }

    // fazer os métodos para mexer na lista
}
