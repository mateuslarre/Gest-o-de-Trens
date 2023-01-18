import java.util.ArrayList;

public class Trem{

    private int identificadorTrem;
    private static ArrayList<Trem> lista = new ArrayList<Trem>();
    private int tamanhoDaLista = lista.size();
  
    //Este patio P é o pátio onde esse trem que está sendo criado irá estar
    public Trem(int identificadorTrem, String adiciona){
        this.identificadorTrem = identificadorTrem;
        adiciona.toLowerCase();
        if(adiciona.equals("sim") || adiciona.equals("s")){
            Patio.getTrensNoPatio().add(this);
        }
    }
   

    public int getIdentificadorTrem() {
        return identificadorTrem;
    }
    public void imprimeLista(){
        for(int i = 0; i < lista.size(); i++){
            System.out.print(lista.get(i));
        }
    }

    public ArrayList<Trem> getLista() {
        return lista;
    }

    public int getTamanhoDaLista() {
        return tamanhoDaLista;
    }

    public void engataLocomotiva(int idLocomotiva){
        Trem.lista.add(Locomotiva.procuraLocomotiva(idLocomotiva));
        GaragemLocomotiva.getListaGarageLocomotivas().remove(Locomotiva.procuraLocomotiva(idLocomotiva));
    }

    public int calculaNumeroMaxVagoes(){
        double max = 0;
        double fator = 1.0;


        for(int i = 0; i < lista.size(); i ++){
            if(Trem.lista.get(i) instanceof Locomotiva){
                Locomotiva loc = (Locomotiva) Trem.lista.get(i);

                max = loc.getNumMaxVagoes()*fator;
                fator = fator*0.9;
            }
        }
        return (int) max;
    }

    public double pesoVagoes(){
        double peso = 0.0;
        for(int i = 0; i <lista.size(); i ++){
            if(Trem.lista.get(i) instanceof Vagao){
                Vagao vag = (Vagao) Trem.lista.get(i); 
                peso += vag.getCapacidadeMaxCarga();
            }
        }
        return peso;
    }

    public double calculaPesoMax(){
        double max = 0.0;
        double aux = 1.0;

        for(int i = 0; i < lista.size(); i ++){
            if(Trem.lista.get(i) instanceof Locomotiva){
                Locomotiva loc = (Locomotiva) Trem.lista.get(i);
                max += loc.getPesoMAX()*aux;
                aux = aux*0.9;
            }
        }
        return max;
    }


    public static int quantidadeLocomotivas(){
        int q = 0;
        for(int  i= 0; i < lista.size(); i ++){
            if(Trem.lista.get(i) instanceof Locomotiva){
                q ++;
            }
        }
        return q;
    }

    public boolean engataVagao(int idVagao){
        if(quantidadeLocomotivas() >= calculaNumeroMaxVagoes()){
            return false;
        }

        if(pesoVagoes() >= calculaNumeroMaxVagoes()){
            return false;
        }

        Trem.lista.add(Vagao.procuraVagao(idVagao));
        GaragemVagao.getListaGaragemVagao().remove(Vagao.procuraVagao(idVagao));
        return true;
    }

    //
    public int calculaNumeroMaxVagoesPessoas(){
        double max = 0;
        double fator = 1.0;


        for(int i = 0; i < lista.size(); i ++){
            if(Trem.lista.get(i) instanceof Locomotiva){
                Locomotiva loc = (Locomotiva) Trem.lista.get(i);

                max = loc.getPesoMaxPessoas()*fator;
                fator = fator*0.9;
            }
        }
        return (int) max;
    }

    public double pesoVagoesPessoas(){
        double peso = 0.0;
        for(int i = 0; i <lista.size(); i ++){
            if(Trem.lista.get(i) instanceof VagaoPessoas){
                VagaoPessoas vag = (VagaoPessoas) Trem.lista.get(i); 
                peso += vag.getCapacidadeMaxCarga();
            }
        }
        return peso;
    }

    public double calculaPesoMaxVagaoPessoas(){
        double max = 0.0;
        double aux = 1.0;

        for(int i = 0; i < lista.size(); i ++){
            if(Trem.lista.get(i) instanceof Locomotiva){
                Locomotiva loc = (Locomotiva) Trem.lista.get(i);
                max += loc.getPesoMaxPessoas()*aux;
                aux = aux*0.9;
            }
        }
        return max;
    }

    public boolean engataVagaoPessoas(int idVagaoPessoas){
        if(quantidadeLocomotivas() >= calculaNumeroMaxVagoesPessoas()){
            return false;
        }

        if(pesoVagoesPessoas() >= calculaNumeroMaxVagoesPessoas()){
            return false;
        }

        Trem.lista.add(VagaoPessoas.procuraVagao(idVagaoPessoas));
        GaragemVagao.getListaGaragemVagao().remove(Vagao.procuraVagao(idVagaoPessoas));
        return true;
    }

    public static Trem procuraTrem(int idTrem){
        for(int i = 0; i < Patio.getTrensNoPatio().size(); i++){
            if(Patio.getTrensNoPatio().get(i).identificadorTrem == idTrem){
                return Patio.getTrensNoPatio().get(i);
            }
        }
        return null;
    }

    @Override
    public String toString() {

        String aux = " ";
        aux += "Trem: " + identificadorTrem + "\n"; 
        return aux;
    }
}