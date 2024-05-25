package entidades;
/*
 * A classe No, contem um objeto da classe 
 * Item e o ponteiro para o proximo no, alem do construtor e os metodos 
 * gets, sets e toString.
 */
public class NoItem {
	private Item item;
	private NoItem prox;
	public NoItem(Item item) {
		this.item = item;
		this.prox = null;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public NoItem getProx() {
		return prox;
	}
	public void setProx(NoItem prox) {
		this.prox = prox;
	}
	@Override
	public String toString() {
		return "item=" + item ;
	}
	
	
	
	
	

}
