package PilhaFila;
import entidades.*;

public class FilaItem {
    private NoItem head, tail;
    private int quant;

    public FilaItem() {
        this.head = null;
        this.tail = null;
        this.quant = 0;
    }

    public NoItem getHead() {
        return head;
    }
    
    public int size() {
        return quant;
    }
 
    public boolean isEmpty() {
        if (this.quant == 0) {
            return true;
        }
        return false;
    }

    // Enqueue: enfileirar, colocar no final
    public void enqueue(Item item) {
        NoItem novo = new NoItem(item);
        if (isEmpty()){
            head = novo;
        } else {
            tail.setProx(novo);
        }
        tail = novo;
        quant++;
    }

    public NoItem dequeue() {
        NoItem aux = head;
        if (!isEmpty()){
            head = head.getProx();
            quant--;
        }
        return aux;
    }

    @Override
    public String toString() {
        String lista = " ";
        NoItem aux = this.head;
        for (int i = 0; i < quant; i++) {
            lista += aux.getItem().toString()+"\n";
            aux = aux.getProx();
        }
        return lista;
    }
    
}