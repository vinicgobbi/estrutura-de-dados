package entidades;

public class NoAbb {
    private Item item;
    private NoAbb esq, dir;

    public NoAbb getDir() {
        return dir;
    }

    public NoAbb getEsq() {
        return esq;
    }

    public void setDir(NoAbb dir) {
        this.dir = dir;
    }

    public void setEsq(NoAbb esq) {
        this.esq = esq;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "NoAbb{" +
                "item=" + item +
                '}';
    }
}
