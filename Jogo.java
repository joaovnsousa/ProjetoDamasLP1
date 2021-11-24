
/**
 * Armazena o tabuleiro e responsavel por posicionar as pecas.
 * 
 * @author Alan Moraes &lt;alan@ci.ufpb.br&gt;
 * @author Leonardo Villeth &lt;lvilleth@cc.ci.ufpb.br&gt;
 */
public class Jogo {

    private Tabuleiro tabuleiro;
    private int w;
    private int tipo;
    private int x;
    private int y;

    public Jogo() {
        tabuleiro = new Tabuleiro();
        criarPecas();
    }
    
    /**
     * Posiciona pe�as no tabuleiro.
     * Utilizado na inicializa�ao do jogo.
     */
      private void criarPecas() {
      for (int x = 0; x < 8; x++){
          for (int y = 0; y < 3; y++){
              if ((x % 2 == 0) && (y % 2 == 0)){
                  Casa casa1 = tabuleiro.getCasa(x, y);
                  Peca peca1 = new Peca(casa1, Peca.PEDRA_BRANCA);
                  } else if ((x % 2 != 0) && (y % 2 != 0)){
                      Casa casa1 = tabuleiro.getCasa(x, y);
                      Peca peca1 = new Peca(casa1, Peca.PEDRA_BRANCA);
                      
                    }
              } 
          }
          
        for (int x = 0; x < 8; x++){
            for (int y = 5; y < 8; y++){
                if ((x % 2 == 0) && (y % 2 == 0)){
                    Casa casa1 = tabuleiro.getCasa(x, y);
                    Peca peca1 = new Peca(casa1, Peca.PEDRA_VERMELHA);
                    
                } else if ((x % 2 != 0) && (y % 2 != 0)){
                      Casa casa1 = tabuleiro.getCasa(x, y);
                      Peca peca1 = new Peca(casa1, Peca.PEDRA_VERMELHA);
                      
                    }
            }
        }
    }
    
        public void capturarMoverPeca (int origemX, int origemY, int destinoX, int destinoY, boolean capturar) {
        Casa origem = tabuleiro.getCasa(origemX, origemY);
        Casa destino = tabuleiro.getCasa(destinoX, destinoY);
        Peca peca = origem.getPeca();

        if (capturar) {
            int incrementX = origemX < destinoX ? 1 : -1;
            int incrementY = origemY < destinoY ? 1 : -1;

            // remove as peças nas casas entre a origem e destino
            for (int i = origemX, j = origemY; i - destinoX != 0; i += incrementX, j += incrementY) {
                Casa possivelPeca = tabuleiro.getCasa(i, j);
                if (possivelPeca.possuiPeca()) {
                    possivelPeca.removerPeca();
                
                }
            }
        }
        
        peca.mover(destino);
    }
    
    /**
     * Comanda uma Pe�a na posicao (origemX, origemY) fazer um movimento 
     * para (destinoX, destinoY). u > u
     * 
     * @param origemX linha da Casa de origem.
     * @param origemY coluna da Casa de origem.
     * @param destinoX linha da Casa de destino.
     * @param destinoY coluna da Casa de destino.
     */
    public void moverPeca(int origemX, int origemY, int destinoX, int destinoY) {
        Casa origem = tabuleiro.getCasa(origemX, origemY);
        Casa destino = tabuleiro.getCasa(destinoX, destinoY);
        Peca peca = origem.getPeca();
        
        boolean turno = true;
        boolean capturar = false;
        
        if((destinoX>1 && destinoX<6) && ((destinoY>1 && destinoY<6))) {
    Casa adj1 = tabuleiro.getCasa(destinoX-1, destinoY-1);
    Casa adj2 = tabuleiro.getCasa(destinoX+1, destinoY-1);
    Casa adj3 = tabuleiro.getCasa(destinoX-1, destinoY+1);
    Casa adj4 = tabuleiro.getCasa(destinoX+1, destinoY+1);
    Casa vazio1 = tabuleiro.getCasa(destinoX-2, destinoY-2);
    Casa vazio2 = tabuleiro.getCasa(destinoX+2, destinoY-2);
    Casa vazio3 = tabuleiro.getCasa(destinoX-2, destinoY+2);
    Casa vazio4 = tabuleiro.getCasa(destinoX+2, destinoY+2);
    
    if(((adj1.possuiPeca() && vazio1.npossuiPeca()) || (adj2.possuiPeca() && vazio2.npossuiPeca())) || 
    ((adj3.possuiPeca() && vazio3.npossuiPeca()) || (adj4.possuiPeca() && vazio4.npossuiPeca()))) { capturar = true;} 
    
    }
    else if((destinoX<6) && ((destinoY<6))) {
      
    Casa adj = tabuleiro.getCasa(destinoX+1, destinoY+1);  
    Casa vazio = tabuleiro.getCasa(destinoX+2, destinoY+2);
    
    if (adj.possuiPeca() && vazio.npossuiPeca()) { capturar = true;} 
    
    }
    else if((destinoX<6) && ((destinoY>1))) {
      
    Casa adj = tabuleiro.getCasa(destinoX+1, destinoY-1);  
    Casa vazio = tabuleiro.getCasa(destinoX+2, destinoY-2);
    
    if (adj.possuiPeca() && vazio.npossuiPeca()) { capturar = true;} 
    
    }
    else if((destinoX>1) && ((destinoY<6))) {
      
    Casa adj = tabuleiro.getCasa(destinoX-1, destinoY+1);  
    Casa vazio = tabuleiro.getCasa(destinoX-2, destinoY+2);
    
    if (adj.possuiPeca() && vazio.npossuiPeca()) { capturar = true;} 
    
    }
    else if((destinoX>1) && ((destinoY>1))) {
      
    Casa adj = tabuleiro.getCasa(destinoX-1, destinoY-1);  
    Casa vazio = tabuleiro.getCasa(destinoX-2, destinoY-2);
    
    if (adj.possuiPeca() && vazio.npossuiPeca()) { capturar = true;} 
    
    }
        
        if (w % 2 == 1 ){
            turno = false;
            } 
            else{
                turno = true;
            }
            
        if(turno) {
            if (destino.possuiPeca()){}
                else{
                        
                    if (peca.podeMoverb(destino)){
                        int incrementX = origemX < destinoX ? 1 : -1;
                        int incrementY = origemY < destinoY ? 1 : -1;
                        int r = 0;
                        
                        

                        // remove as peças nas casas entre a origem e destino
                    for (int i = origemX, j = origemY; i - destinoX != 0; i += incrementX, j += incrementY) {
                        Casa possivelPeca = tabuleiro.getCasa(i, j);
                        
                        if (possivelPeca.possuiPeca()) {

                            possivelPeca.removerPeca();
                            r = r+1;
                
                        }
                    }   if (r > 1){
                        
                        if(capturar){
                            w=w+1;
                        
                        }
                    
                        
                    }
                    peca.mover(destino); 
                    w = w+1;
                    } else if(peca.podeMoverDAMAb(destino)){
                        int incrementX = origemX < destinoX ? 1 : -1;
                        int incrementY = origemY < destinoY ? 1 : -1;
                        int r = 0;
                        
                        

                        // remove as peças nas casas entre a origem e destino
                    for (int i = origemX, j = origemY; i - destinoX != 0; i += incrementX, j += incrementY) {
                        Casa possivelPeca = tabuleiro.getCasa(i, j);
                        if (possivelPeca.possuiPeca()) {
                            possivelPeca.removerPeca();
                            r = r+1;
                
                        }
                    }   if (r > 1){
                        
                        if(capturar){
                            w=w+1;
                        
                        }
                    
                        
                    }
                    peca.mover(destino); 
                    w = w+1;
                    }
                }
                }
            
            
                else {
                if (peca.podeMovera(destino)){
                    int incrementX = origemX < destinoX ? 1 : -1;
                    int incrementY = origemY < destinoY ? 1 : -1;
                    int r = 0;
                    
                    for (int i = origemX, j = origemY; i - destinoX != 0; i += incrementX, j += incrementY) {
                        Casa possivelPeca = tabuleiro.getCasa(i, j);
                        if (possivelPeca.possuiPeca()){
                            possivelPeca.removerPeca();
                            r = r+1;
                            }
                        } if (r > 1){
                        
                        if(capturar){
                            w=w+1;
                        
                        }
                    
                        
                    }
                    peca.mover(destino); 
                    w = w+1;
                    }
                     else if(peca.podeMoverDAMAa(destino)){
                    int incrementX = origemX < destinoX ? 1 : -1;
                    int incrementY = origemY < destinoY ? 1 : -1;
                    int r = 0;
                    
                    for (int i = origemX, j = origemY; i - destinoX != 0; i += incrementX, j += incrementY) {
                        Casa possivelPeca = tabuleiro.getCasa(i, j);
                        if (possivelPeca.possuiPeca()){
                            possivelPeca.removerPeca();
                            r = r+1;
                            }
                        } if (r > 1){
                        
                        if(capturar){
                            w=w+1;
                        
                        }
                    
                        
                    }
                    peca.mover(destino); 
                    w = w+1;
                    }
                }  
        }
    
        
    public int getTipo(){
        return tipo;
    }
    
    /**
     * @return o Tabuleiro em jogo.
     */
    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }
}
