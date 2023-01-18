public class Locomotiva extends Trem{
    
    private int identificadorLocomotiva;
    private double pesoMAX;
    private double pesoMaxPessoas;
    private int numMaxVagoes;

    //Dois construtores, 1 para adicionar a locomotiva diretamente para o trem desejado, outro para criar a locomotiva e envia-la para a garagem de locomotivas.
    public Locomotiva(int identificadorLocomotiva, double pesoMAX, int numMaxVagoes, Trem tremAtual) {
        super(identificadorLocomotiva, "não");
        this.identificadorLocomotiva = identificadorLocomotiva;
        this.pesoMAX = pesoMAX;
        this.numMaxVagoes = numMaxVagoes;
        tremAtual.getLista().add(this);
    }
    
    public Locomotiva(int identificadorLocomotiva, double pesoMAX, int numMaxVagoes, GaragemLocomotiva g){
        super(identificadorLocomotiva, "não");
        this.identificadorLocomotiva = identificadorLocomotiva;
        this.pesoMAX = pesoMAX;
        this.numMaxVagoes = numMaxVagoes;
        GaragemLocomotiva.getListaGarageLocomotivas().add(this);
    }

    public int getIdentificadorLocomotiva() {
        return identificadorLocomotiva;
    }
    
    public double getPesoMAX() {
        return pesoMAX;
    }

    public double getPesoMaxPessoas(){
        return pesoMaxPessoas;
    }

    public int getNumMaxVagoes() {
        return numMaxVagoes;
    }

    public static Locomotiva procuraLocomotiva(int idLocomotiva){
        for(int i = 0; i < GaragemLocomotiva.getListaGarageLocomotivas().size(); i++){
            if(GaragemLocomotiva.getListaGarageLocomotivas().get(i).identificadorLocomotiva == idLocomotiva){
                return GaragemLocomotiva.getListaGarageLocomotivas().get(i);
            }
        }
        return null;
    }
    @Override
    public String toString() {
        String aux = " ";
        aux += "Locomotiva: " + getIdentificadorLocomotiva() + "\n";
        return aux;
    }
}
