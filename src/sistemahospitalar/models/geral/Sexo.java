package sistemahospitalar.models.geral;

public enum Sexo {
    MASCULINO("Masculino"),
    FEMININO("Feminino");

    private final String nome;

    Sexo(String nome) {
        this.nome = nome;
    }
}
