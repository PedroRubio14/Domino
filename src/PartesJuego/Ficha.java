package PartesJuego;

public class Ficha {
    private int ladoIz;
    private int ladoDe;
    private boolean esDoble;

    public Ficha(int ladoIz, int ladoDe) {
        this.ladoIz = ladoIz;
        this.ladoDe = ladoDe;
        this.esDoble = (ladoDe == ladoIz);
    }

    public int getLadoIz() {
        return ladoIz;
    }

    public void setLadoIz(int ladoIz) {
        this.ladoIz = ladoIz;
    }

    public int getLadoDe() {
        return ladoDe;
    }

    public void setLadoDe(int ladoDe) {
        this.ladoDe = ladoDe;
    }

    public boolean isEsDoble() {
        return esDoble;
    }

    public void setEsDoble(boolean esDoble) {
        this.esDoble = esDoble;
    }

    @Override

    public String toString(){
        return "["+ladoIz+"|"+ladoDe+"]";
    }

    public void darLaVuelta(){
        int temp1 = this.ladoDe;
        int temp2 = this.ladoIz;

        setLadoDe(temp2);
        setLadoIz(temp1);
    }

}
