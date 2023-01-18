import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);
    // Garagens e Patio do programa
    GaragemLocomotiva g = new GaragemLocomotiva();
    GaragemVagao gv = new GaragemVagao();
    Patio p = new Patio();

    // Locomotivas para exemplo de uso
    Locomotiva lc1 = new Locomotiva(1, 9999, 100, g);
    Locomotiva lc2 = new Locomotiva(2, 9999, 100, g);
    Locomotiva lc3 = new Locomotiva(3, 9999, 100, g);
    Locomotiva lc4 = new Locomotiva(4, 9999, 100, g);
    Locomotiva lc5 = new Locomotiva(5, 9999, 100, g);
    // Vagoes para exemplo de uso
    Vagao v1 = new Vagao(1, 100, gv);
    Vagao v2 = new Vagao(2, 100, gv);
    Vagao v3 = new Vagao(3, 100, gv);
    Vagao v4 = new Vagao(4, 100, gv);
    Vagao v5 = new Vagao(5, 100, gv);

    //Todos os valores de peso estão em toneladas
    VagaoPessoas vp1 = new VagaoPessoas(6, 14, gv);
    VagaoPessoas vp2 = new VagaoPessoas(7, 14, gv);
    VagaoPessoas vp3 = new VagaoPessoas(8, 14, gv);
    VagaoPessoas vp4 = new VagaoPessoas(9, 14, gv);
    VagaoPessoas vp5 = new VagaoPessoas(10, 14, gv);

    public void menuTrem() {
        for (;;) {
            System.out.println("Bem vindo ao menu do sistema de trens.");
            System.out.println("1. Criar trem.");
            System.out.println("2. Editar trem.");
            System.out.println("3. Listar trens criados.");
            System.out.println("4. Desfazer trem.");
            System.out.println("5. Fim.");
            System.out.print("Digite a opção desejada: ");
            int opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Para criar um trem, indique o identificador dele: ");
                    int identificadorTrem = sc.nextInt();

                    if(p.tremExiste(identificadorTrem) == true){
                        System.out.println("Já existe esse identificador de trem!!");
                        continue;
                    }
                    
                    Trem t = new Trem(identificadorTrem, "sim");
                    System.out.println("***Lista de locomotivas na garagem***");
                    g.imprimeLocomotivasNaGaragem();
                    System.out.println("Selecione a Locomotiva desejada: ");
                    int idLocomotiva = sc.nextInt();
                    t.engataLocomotiva(idLocomotiva);
                    continue;
                case 2:
                    // Editar trem
                    p.imprimeTrensCriados();
                    System.out.println("Indique o trem que deseja editar: ");
                    int identificador = sc.nextInt();
                    for (;;) {
                        System.out.println("1. inserir Locomotiva");
                        System.out.println("2. Inserir Vagao");
                        System.out.println("3. Remover último elemento do trem");
                        System.out.println("4. Listar locomotivas livres");
                        System.out.println("5. Listar Vagoes Livres");
                        System.out.println("6. Encerrar Edição do trem");

                        System.out.println("Digite a opção desejada: ");
                        int opcao1 = sc.nextInt();

                        switch (opcao1) {
                            case 1:
                                System.out.println("*******Lista de locomotivas disponíveis: ********");
                                g.imprimeLocomotivasNaGaragem();
                                System.out.println("Selecione a locomotiva desejada para engatar no: "
                                        + Trem.procuraTrem(identificador));
                                int locomotivaInsere = sc.nextInt();

                                Trem.procuraTrem(identificador).engataLocomotiva(locomotivaInsere);

                                System.out.println("Inserção concluida");
                                continue;
                            case 2:
                                System.out.println("*******Lista de Vagões disponíveis: ********");
                                gv.imprimeVagaoNaGaragem();
                                System.out.println("Selecione o vagao desejado para engatar no: " + Trem.procuraTrem(identificador));
                                int vagaoInsere = sc.nextInt();

                                Trem.procuraTrem(identificador).engataVagao(vagaoInsere);

                                System.out.println("Inserção concluida");
                                continue;
                            case 3:
                                //Remove ultimo elemento do trem
                                int tam = Trem.procuraTrem(identificador).getLista().size();
                                
                                if(tam > 1){
                                    if(Trem.procuraTrem(identificador).getLista().get(tam-1) instanceof Locomotiva){
                                        Locomotiva l = (Locomotiva) Trem.procuraTrem(identificador).getLista().remove(Trem.procuraTrem(identificador).getLista().size() - 1);
                                        g.locomotivaEntra(l);
                                        continue;
                                    }
                                    if(Trem.procuraTrem(identificador).getLista().get(tam-1) instanceof Vagao){
                                        Vagao v = (Vagao) Trem.procuraTrem(identificador).getLista().remove(Trem.procuraTrem(identificador).getLista().size() - 1);
                                        gv.vagaoEntra(v);
                                        continue;
                                    }
                                    if(Trem.procuraTrem(identificador).getLista().get(tam-1) instanceof VagaoPessoas){
                                        VagaoPessoas vp = (VagaoPessoas) Trem.procuraTrem(identificador).getLista().remove(Trem.procuraTrem(identificador).getLista().size() - 1);
                                        gv.vagaoEntra(vp);
                                        continue;
                                    }
                                }

                                System.out.println("Remoção do último elemento do trem concluída.");
                                continue;
                            case 4:

                                System.out.println("Locomotivas livres");
                                g.imprimeLocomotivasNaGaragem();
                                continue;

                            case 5:

                                System.out.println("Vagoes Livres");
                                gv.imprimeVagaoNaGaragem();
                                // gv.imprimeVagaoPessoas();
                                continue;
                            case 6:
                                System.out.println("Voltao ao menu principal...");
                                break;
                        }
                        break;
                    }
                    continue;
                case 3:
                    // Listar trens criados
                    Patio.imprimeTrensCriados();
                    continue;
                case 4:
                    // Desfazer trem
                    System.out.println("Selecione o trem a ser desfeito: ");
                    Patio.imprimeTrensCriados();
                    System.out.println("Trem desejado: ");
                    int idTrem = sc.nextInt();

                    // Após receber o trem desejado, todos seus vagões e locomotivas serão
                    // direcionados à suas garagens

                    for(int i = 0; i < Trem.procuraTrem(idTrem).getLista().size(); i++){
                        if(Trem.procuraTrem(idTrem).getLista().get(i) instanceof Locomotiva){
                            GaragemLocomotiva.getListaGarageLocomotivas().add((Locomotiva) Trem.procuraTrem(idTrem).getLista().get(i));
                        } else if(Trem.procuraTrem(idTrem).getLista().get(i) instanceof Vagao){
                            GaragemVagao.getListaGaragemVagao().add((Vagao) Trem.procuraTrem(idTrem).getLista().get(i));
                        }
                    }
                    // Por fim, remove o trem do pátio
                    Patio.getTrensNoPatio().remove(Trem.procuraTrem(idTrem));
                    System.out.println("Remoção concluida");
                    continue;
                case 5:
                    System.out.println("Saindo...");
                    break;
            }
            break;
        }
    }
}