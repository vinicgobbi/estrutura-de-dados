package PilhaFila;
import entidades.*;

public class PilhaItem {
    private NoItem top;
    private int quant;

    public PilhaItem() {
        this.top = null;
        this.quant = 0;
    }

    public NoItem getTop() {
        return top;
    }

    public boolean isEmpty() {
        if (this.quant == 0) {
            return true;
        }
        return false;
    }

    public int sized() {
        return this.quant;
    }

    // Empilhar: colocar um elemento no inicio
    public void push (Item item){
        NoItem novo = new NoItem (item);
        if (!isEmpty()){
            novo.setProx(top);
        }
        top = novo;
        quant++;
    } 

    // Desempilhar: Remover o elemento do topo da pilha
    public NoItem pop (){
        NoItem aux = top;
        if (!isEmpty()){
            top = top.getProx();
            quant--;            
        }
        return aux;
    }
    
    @Override
    public String toString() {
        String lista = " ";
        NoItem aux = this.top;
        for (int i = 0; i < quant; i++) {
            lista += aux.getItem().toString()+"\n";
            aux = aux.getProx();
        }
        return lista;
    }
    
}
