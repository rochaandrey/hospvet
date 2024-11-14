package sistemahospitalar.business.cliente;

public enum Plano {
    SUS("SUS",1),
    PARTICULAR("Particular",2),
    PRATA("Prata",3),
    GOLD("Gold",4),
    PLATINUM("Platinum",5);

    private final String nome;
    private final int id;

    Plano(String nome, int id) {
        this.nome = nome;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public static Plano planByID(int id){
        for(Plano plano : Plano.values()){
            if(plano.getId() == id){
                return plano;
            }
        }
        return null;
    }
}
