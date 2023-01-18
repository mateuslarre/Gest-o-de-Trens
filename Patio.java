import java.util.ArrayList;

public class Patio {
    
    private static ArrayList<Trem> trensNoPatio = new ArrayList<Trem>();

    public static ArrayList<Trem> getTrensNoPatio() {
        return trensNoPatio;
    }

    public int tamPatio(){
        return trensNoPatio.size();
    }

    public boolean tremExiste(int idTrem){
        for(int i = 0; i < tamPatio(); i ++){
            if(trensNoPatio.get(i).getIdentificadorTrem() == idTrem){
                return true;
            }
        }
        return false;
    }
    
    public static void imprimeTrensCriados(){
        for(int i = 0; i < trensNoPatio.size(); i++){
            System.out.println(trensNoPatio.get(i));
        }
    }
}
