package sistemahospitalar.business.geral;

public abstract class Pessoa {
    protected String nome;
    protected final String cpf;
    protected final String dataDeNascimento;
    protected Sexo sexo;

    public Pessoa() {
        this.dataDeNascimento = "";
        this.cpf = "";
    }

    public Pessoa(String nome, String cpf, String dataDeNascimento, Sexo sexo) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataDeNascimento = dataDeNascimento;
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

}
