package sistemahospitalar.models.medico;

public enum Especialidade {
    PEDIATRA("Pediatra"),
    CLINICO_GERAL("Clínico Geral"),
    ORTOPEDISTA("Ortopedista"),
    OTORRINO("Otirrinolaringologista"),
    CARDIOLOGISTA("Cardiologista");

    private String nome;

    Especialidade(String nome) {
        this.nome = nome;
    }
}
