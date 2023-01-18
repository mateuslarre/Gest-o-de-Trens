public class App {
    public static void main(String[] args) throws Exception {
        Menu m = new Menu();
        m.menuTrem();
    }
}

/* As locomotivas devem ser as primeiras a serem selecionadas. Não é possível “engatar” uma locomotiva após um vagão.

· O total de vagões que podem ser engatados devem respeitar as limitações do conjunto de locomotivas
  (peso máximo que conseguem puxar e número máximo de vagões que conseguem tracionar).
  Para o cálculo do peso máximo considerar o peso do vagão com carga máxima.
  Observação: a partir da segunda locomotiva engatada a capacidade total do conjunto de locomotivas deve ser reduzida em 10% a cada 
  nova locomotiva engatada. Exemplo: suponha que todas as locomotivas tenham capacidade para tracionar 50 vagões. 
  Uma composição com uma locomotiva consegue tracionar 50 vagões, com duas locomotivas 90 vagões e com 3 locomotivas 120 vagões.

· Só é possível engatar uma locomotiva ou vagão por vez e sempre no final do trem. A locomotiva ou vagão engatados deixam de estar 
  “livres” para serem usados em outro trem.

· Só é possível desengatar uma locomotiva ou vagão por vez e sempre do final do trem. A locomotiva ou vagão desengatado ficam livres 
  para serem usados em outro trem. */