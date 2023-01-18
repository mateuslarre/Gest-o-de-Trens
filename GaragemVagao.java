import java.util.ArrayList;

public class GaragemVagao{

    private static ArrayList<Vagao> listaGaragemVagao = new ArrayList<Vagao>();

    public static ArrayList<Vagao> getListaGaragemVagao(){
        return listaGaragemVagao;
    }

    public boolean vagaoEntra(Vagao v){
        listaGaragemVagao.add(v);
        return true;
    }

    public void imprimeVagaoNaGaragem(){
        for(int i = 0; i < listaGaragemVagao.size(); i++){
            if(listaGaragemVagao.get(i) instanceof Vagao){
                System.out.println(listaGaragemVagao.get(i));
            }
        }
    }

    public void imprimeVagaoPessoas(){
        for(int i = 0; i < listaGaragemVagao.size(); i++){
            if(listaGaragemVagao.get(i) instanceof VagaoPessoas){
                System.out.println(listaGaragemVagao.get(i));
            }
        }
    }

}
