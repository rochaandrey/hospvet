package sistemahospitalar.business.geral;

public enum Sexo {
    MASCULINO("Masculino"),
    FEMININO("Feminino");

    private final String nome;

    Sexo(String nome) {
        this.nome = nome;
    }
}
