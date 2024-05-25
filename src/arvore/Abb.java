package arvore;

import entidades.*;

public class Abb {
    private NoAbb raiz;
    private int quant;

    public Abb(){
        this.raiz = null;
        this.quant = 0;
    }

    public boolean eVazia(){
        if (this.quant == 0) {
            return true;
        }
        return false;
    }

    public NoAbb pesquisa(int num){
        return pesquisa(num, this.raiz);
    }

    private NoAbb pesquisa(int num, NoAbb no){
        if (no == null) {
            return null;
        }
        if (num < no.getItem().getCodigo()) {
            return pesquisa(num, no.getEsq());
        } else if (num > no.getItem().getCodigo()) {
            return pesquisa(num, no.getDir());
        }else {
            return no;
        }
    }

}
