package model;

public class NotaFiscal {

    private String name;
    private double icms;
    private double ipi;
    private double pis;
    private double cofins;
    private double total;

    public NotaFiscal(String name) {
        this.name = name;
    }

    public void setICMS(double icms){
        this.icms = icms;
    }

    public void setIPI(double ipi){
        this.ipi = ipi;
    }

    public void setPIS(double pis){
        this.pis = pis;
    }

    public void setCOFINS(double cofins){
        this.cofins = cofins;
    }

    public void setTotal(double total){
        this.total = total;
    }

    public String toString() {
        return "\nCliente: " + name
                + "\nICMS: R$" + icms
                + "\nIPI: R$" + ipi
                + "\nPIS: R$" + pis
                + "\nCOFINS: R$" + cofins
                + "\nTotal: R$" + total;
    }
}
