package sistemahospitalar.business.geral;

import java.time.LocalDate;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(cpf, pessoa.cpf);
    }
}
