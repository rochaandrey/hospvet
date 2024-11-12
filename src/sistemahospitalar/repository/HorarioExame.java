package sistemahospitalar.repository;

import java.util.Map;
import java.util.TreeMap;

public class HorarioExame {
    private Map<Integer,Boolean> horariosExame = new TreeMap<>();

    public HorarioExame(){
        horariosExame.put(8,true);
        horariosExame.put(9,true);
        horariosExame.put(10,true);
        horariosExame.put(11,true);
        horariosExame.put(12,true);
        horariosExame.put(13,true);
        horariosExame.put(14,true);
        horariosExame.put(15,true);
        horariosExame.put(16,true);
        horariosExame.put(17,true);
    }

}
