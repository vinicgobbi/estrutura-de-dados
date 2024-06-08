package lista;

import entidades.Item;
import entidades.NoItem;

public class LSEItem {
	private NoItem prim, ult;
	private int quant;

	public LSEItem() {
		this.prim = null;
		this.ult = null;
		this.quant = 0;
	}

	public NoItem getPrim() {
		return prim;
	}

	public NoItem getUlt() {
		return ult;
	}

	public int getQuant() {
		return quant;
	}
	/*
	 * eVazia() => retorna verdadeiro se a lista estiver vazia e 
	 * falso caso contrário.
	 */
	public boolean eVazia() {
		if (this.quant==0) {
			return true;
		}
		return false;
	}
	/*
	 * getItem (posição) => retorna o elemento que está na posição (parâmetro). 
	 * Caso a posição não seja válida, retorna null.
	 */
	public Item getItem (int pos) {
		NoItem aux;
		int count;
		if (pos<0 || pos>=this.quant) {
			return null;
		}
		aux = this.prim;
		count = 0;
		while (count != pos) {
			aux = aux.getProx();
			count++;
		}
		return aux.getItem();
	}
	public NoItem getNo (int pos) {
		NoItem aux;
		int count;
		if (pos<0 || pos>=this.quant) {
			return null;
		}
		aux = this.prim;
		count = 0;
		while (count != pos) {
			aux = aux.getProx();
			count++;
		}
		return aux;
	}

	/*
	 * pesquisa (cod) => deve fazer uma pesquisa sequencial até encontrar 
	 * o nó que tem código igual a cod, retornando o nó. Se ele não existir, 
	 * deve retornar null.
	 */
	public NoItem pesquisa (int cod) {
		NoItem aux = this.prim;

		while (aux!=null) {
			if (aux.getItem().getCodigo()==cod) {
				return aux;
			}
			aux = aux.getProx();
		}
		return null;
	}

	/*
	 * insereInicio (Item) => insere um Item no início da lista.
	 */

	public void insereInicio(Item item) {
		NoItem novo = new NoItem(item);
		novo.setProx(this.prim);
		this.prim = novo;
		if (eVazia()) {
			this.ult = novo;
		}
		this.quant++;
	}
	public void insereFinal (Item item) {
		NoItem novo = new NoItem(item);
		if (eVazia()) {
			this.prim = novo;
		}else {
			this.ult.setProx(novo);
		}
		this.ult = novo;
		this.quant++;
	}
	
	public boolean insere (Item elem, int pos) {
		NoItem novo, aux;
		if (pos<0 || pos > this.quant) {
			return false;
		}
		if (pos==0) {
			insereInicio(elem);
		}else if (pos == this.quant){
			insereFinal(elem);
		} else {
			novo = new NoItem(elem);
			aux = this.prim;
			for (int i=1; i<pos; i++) {
				aux = aux.getProx();
			}
			novo.setProx(aux.getProx());
			aux.setProx(novo);
			this.quant++;
		}
		return true;
	}

	public NoItem removePos (int pos) {
		NoItem atual, ant;
		// testar se a posicao e valida
		if (pos<0 || pos >= quant) {
			return null;
		}
		// remove o primeiro
		if (pos==0) {
			atual = this.prim;
			this.prim = this.prim.getProx();
			if (quant==1) {
				this.ult = null;
			}
			quant--;
			return atual;
		}
		//remove outro no
		ant = this.prim;
		for (int i=0; i<pos-1; i++) {
			ant = ant.getProx();
		}
		atual = ant.getProx();
		ant.setProx(atual.getProx());
		quant--;
		// se for o ultimo
		if (pos==this.quant-1) {
			this.ult = ant;
		}
		return atual;
	}

	public NoItem remove (int cod) {
		NoItem atual, ant;
		if (eVazia()) {
			return null;
		}
		if (quant==1) {
			if (cod==this.prim.getItem().getCodigo()) {
				atual = this.prim;
				this.prim = null;
				this.ult = null;
				quant--;
				return atual;
			} else {
				return null;
			}
		} else {
			atual = this.prim;
			ant = this.prim;
			// remover o primeiro se tiver mais de 1 Item
			if (this.prim.getItem().getCodigo()==cod) {
				prim = prim.getProx();
				quant--;
				return ant;
			}
			while (atual!=null) {
				if (atual.getItem().getCodigo()==cod) {
					ant.setProx(atual.getProx());
					quant--;
					return atual;
				}
				ant = atual;
				atual = atual.getProx();
			}
			return null;
		}
	}
	public String toString () {
		String temp="";
		NoItem aux= this.prim;

		while (aux!=null) {
			temp += aux.getItem().toString()+"\n";
			aux = aux.getProx();
		}
		return temp;
	}


}
