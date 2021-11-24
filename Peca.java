
/**
 * Representa uma Pe�a do jogo.
 * Possui uma casa e um tipo associado.
 * 
 * @author Alan Moraes &lt;alan@ci.ufpb.br&gt;
 * @author Leonardo Villeth &lt;lvilleth@cc.ci.ufpb.br&gt;
 */
public class Peca {

    public static final int PEDRA_BRANCA = 0;
    public static final int DAMA_BRANCA = 1;
    public static final int PEDRA_VERMELHA = 2;
    public static final int DAMA_VERMELHA = 3;

    private Casa casa;
    private int tipo;
    private int tabuleiro;
    private int x;
    private int y;

    public Peca(Casa casa, int tipo) {
        this.casa = casa;
        this.tipo = tipo;
        casa.colocarPeca(this);
        
    }
    
    public boolean podeMoverb(Casa Destino){
         int deltaX = Math.abs(casa.getX() - Destino.getX());
         int deltaY = (casa.getY() - Destino.getY());
       
         if(getTipo() == 0) {
             return ((deltaX == 1 && deltaY == -1)|| (deltaX == 2 && (deltaY == -2 || deltaY == +2)));
         } else {
             return false;
            }
        }
        
    public boolean podeMoverDAMAb(Casa Destino){
         int deltaX = Math.abs(casa.getX() - Destino.getX());
         int deltaY = (casa.getY() - Destino.getY());
       
          if (getTipo() == 1) {
            return (((((deltaX == 1) && ((-1 == deltaY) || (deltaY == 1))) ||
            ((deltaX == 2) && ((-2 == deltaY) || (deltaY == 2)))) || 
            (((deltaX == 3) && ((-3 == deltaY) || (deltaY == 3))) ||
            ((deltaX == 4) && ((-4 == deltaY) || (deltaY == 4))))) ||
            (((deltaX == 5) && ((-5 == deltaY) || (deltaY == 5))) ||
            ((deltaX == 6) && ((-6 == deltaY) || (deltaY == 6)))));} 
         else  {
             return false;
            }
    }
    
    public boolean podeMovera(Casa Destino){
        int deltaX = Math.abs(casa.getX() - Destino.getX());
        int deltaY = (casa.getY() - Destino.getY());
    
            if ((getTipo() == 2)) {
            return ((deltaX == 1 && deltaY == +1)) || (deltaX == 2 && (deltaY == -2 || deltaY == +2));
            }
            else  {
            return false;
        }
    }
    
    
    
    public boolean podeMoverDAMAa(Casa Destino){
         int deltaX = Math.abs(casa.getX() - Destino.getX());
         int deltaY = (casa.getY() - Destino.getY());
       
          if (getTipo() == 3) {
                
                return (((((deltaX == 1) && ((-1 == deltaY) || (deltaY == 1))) ||
                ((deltaX == 2) && ((-2 == deltaY) || (deltaY == 2)))) || 
                (((deltaX == 3) && ((-3 == deltaY) || (deltaY == 3))) ||
                ((deltaX == 4) && ((-4 == deltaY) || (deltaY == 4))))) ||
                (((deltaX == 5) && ((-5 == deltaY) || (deltaY == 5))) ||
                ((deltaX == 6) && ((-6 == deltaY) || (deltaY == 6)))));
            } 
         else  {
             return false;
            }
    }
    // getters e setters
    
    
    /**
     * Movimenta a peca para uma nova casa.
     * @param destino nova casa que ira conter esta peca.
     */
    public void mover(Casa destino) {
        casa.removerPeca();
        destino.colocarPeca(this);
        casa = destino;
        if ((destino.getY() == 7) && (getTipo() == 0)) {
            new Peca(destino, Peca.DAMA_BRANCA);
        } else if ((destino.getY() == 0) && (getTipo() == 2)){
            new Peca(destino, Peca.DAMA_VERMELHA);
        }
    }
    
    /**
     * Valor    Tipo
     *   0   Branca (Pedra)
     *   1   Branca (Dama)
     *   2   Vermelha (Pedra)
     *   3   Vermelha (Dama)
     * @return o tipo da peca.
     */
    public int getTipo() {
        return tipo;
    }
}
