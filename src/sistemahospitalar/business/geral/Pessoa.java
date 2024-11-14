package sistemahospitalar.business.geral;

import java.time.LocalDate;

public abstract class Pessoa {
    protected String nome;
    protected final String cpf;
    protected final LocalDate dataDeNascimento;
    protected Sexo sexo;

    public Pessoa() {
        this.dataDeNascimento = LocalDate.of(1,1,1);
        this.cpf = "";
    }

    public Pessoa(String nome, String cpf, LocalDate dataDeNascimento, Sexo sexo) {
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

    public LocalDate getDataDeNascimento() {
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
