package controller;

public class CalculoImpostos {

    public CalculoImpostos () {}

    //quantidade * (4.5 * 0.18)
    public double calculaICMS(int quantidade) {
        return quantidade * 0.81;
    }

    //quantidade * (4.5 * 0.04)
    public double calculaIPI(int quantidade) {
        return quantidade * 0.18;
    }

    //quantidade * (4.5 * 0.0186)
    public double calculaPIS(int quantidade) {
        return quantidade * 0.0837;
    }

    //quantidade * (4.5 * 0.0854)
    public double calculaCOFINS(int quantidade) {
        return quantidade * 0.3843;
    }
}
