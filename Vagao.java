public class Vagao extends Trem{

    private int identificadorVagao;
    private double capacidadeMaxCarga;

    public Vagao(int identificadorVagao, double capacidadeMaxCarga, Trem tremAtual) {
        super(identificadorVagao, "Não");
        this.identificadorVagao = identificadorVagao;
        this.capacidadeMaxCarga = capacidadeMaxCarga;
        tremAtual.getLista().add(this);
    }
    
    public Vagao(int identificadorVagao, double capacidadeMaxCarga, GaragemVagao gV) {
        super(identificadorVagao, "Não");
        this.identificadorVagao = identificadorVagao;
        this.capacidadeMaxCarga = capacidadeMaxCarga;
        GaragemVagao.getListaGaragemVagao().add(this);
    }

    public int getIdentificadorVagao() {
        return identificadorVagao;
    }

    public double getCapacidadeMaxCarga() {
        return capacidadeMaxCarga;
    }

    public static Vagao procuraVagao(int idVagao){
        for(int i = 0; i < GaragemVagao.getListaGaragemVagao().size(); i++){
            if(GaragemVagao.getListaGaragemVagao().get(i).getIdentificadorVagao() == idVagao){
                return GaragemVagao.getListaGaragemVagao().get(i);
            }
        }
        return null;
    }
    @Override
    public String toString() {
        String aux = " ";
        aux += "Vagao: " + getIdentificadorVagao() + "\n";
        return aux;
    }
}
