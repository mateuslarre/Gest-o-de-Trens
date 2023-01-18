import java.util.ArrayList;

public class GaragemLocomotiva{

    private static ArrayList<Locomotiva> listaGarageLocomotivas = new ArrayList<Locomotiva>();

    public static ArrayList<Locomotiva> getListaGarageLocomotivas() {
        return listaGarageLocomotivas;
    }
    
    public boolean locomotivaEntra(Locomotiva l){
        listaGarageLocomotivas.add(l);
        return true;
    }

    public void imprimeLocomotivasNaGaragem(){
        for(int i = 0; i < listaGarageLocomotivas.size(); i++){
            System.out.println(listaGarageLocomotivas.get(i));
        }
    }
}
