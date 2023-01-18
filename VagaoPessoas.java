public class VagaoPessoas extends Vagao{

    private int identificadorVagao;
    private double maxPesoPessoas;

    public VagaoPessoas(int identificadorVagao, double maxPesoPessoas, Trem tremAtual) {
        super(identificadorVagao, maxPesoPessoas, tremAtual);
        this.identificadorVagao = identificadorVagao;
        this.maxPesoPessoas = maxPesoPessoas;
        tremAtual.getLista().add(this);
    }
    
    public VagaoPessoas(int identificadorVagao, double maxPesoPessoas, GaragemVagao gV) {
        super(identificadorVagao, maxPesoPessoas, gV);
        this.identificadorVagao = identificadorVagao;
        this.maxPesoPessoas = maxPesoPessoas;
    }

    public int getIdentificadorVagao() {
        return identificadorVagao;
    }

    public double getCapacidadeMaxCarga() {
        return maxPesoPessoas;
    }

    public static Vagao procuraVagaoPessoas(int idVagaoPessoas){
        for(int i = 0; i < GaragemVagao.getListaGaragemVagao().size(); i++){
            if(GaragemVagao.getListaGaragemVagao().get(i).getIdentificadorVagao() == idVagaoPessoas){
                return GaragemVagao.getListaGaragemVagao().get(i);
            }
        }
        return null;
    }
    @Override
    public String toString() {
        String aux = " ";
        aux += "Vagao Pessoa: " + getIdentificadorVagao() + "\n";
        return aux;
    }
}
