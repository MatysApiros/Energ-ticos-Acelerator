package main;

import controller.CalculoImpostos;
import model.NotaFiscal;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    ArrayList<NotaFiscal> notasFiscais = new ArrayList<NotaFiscal>();
    CalculoImpostos calculoImpostos = new CalculoImpostos();

    private double totalImpostos;
    private double totalMercadorias;
    private double totalGeral;

    public Menu () {
        this.totalImpostos = 0;
        this.totalMercadorias =0;
        this.totalGeral = 0;
    }

    public void menuPrincipal(){
        System.out.println("\n==============Energéticos Acelerator==============");
        System.out.println("==================Menu==================");
        System.out.println("0 - Exit Application;");
        System.out.println("1 - Notas Fiscais;\n");
        Scanner keyboard = new Scanner(System.in);
        switch (keyboard.nextInt()){
            case 1:
                managementMenu();
                return;
            case 0:
                System.exit(0);
            default:
                System.out.println("\n");
                menuPrincipal();
                break;
        }
    }

    public void managementMenu(){

        System.out.println("\n==============Energéticos Acelerator==============");
        System.out.println("==================Notas Fiscais==================");
        System.out.println("\nSelecione a funcionalidade que deseja utilizar!\n");
        System.out.println("0 - Retornar ao menu anterior;");
        System.out.println("1 - Adicionar nova Nota;");
        System.out.println("2 - Listar lista Notas;\n");

        Scanner keyboard = new Scanner(System.in);

        switch (keyboard.nextInt()) {
            case 1:

                Scanner teclado = new Scanner(System.in);

                System.out.println("\nEntre Nome:");
                String nome = teclado.nextLine();

                System.out.println("Entre Quantidade:");
                int quantidade = teclado.nextInt();

                NotaFiscal notaFiscal = new NotaFiscal(nome);

                double impostos = 0;

                double icms = calculoImpostos.calculaICMS(quantidade);
                notaFiscal.setICMS(icms);
                impostos += icms;

                double ipi = calculoImpostos.calculaIPI(quantidade);
                notaFiscal.setIPI(ipi);
                impostos += ipi;

                double pis = calculoImpostos.calculaPIS(quantidade);
                notaFiscal.setPIS(pis);
                impostos += pis;

                double cofins = calculoImpostos.calculaCOFINS(quantidade);
                notaFiscal.setCOFINS(cofins);
                impostos += cofins;

                double total = (quantidade * 4.5) + impostos;
                notaFiscal.setTotal(total);

                this.totalImpostos += impostos;
                this.totalMercadorias += (quantidade * 4.5);
                this.totalGeral += total;

                System.out.println(notaFiscal.toString());
                notasFiscais.add(notaFiscal);
                managementMenu();
            case 2:
                System.out.println(toString());
                System.out.println("\nTotal Impostos: R$" + totalImpostos);
                System.out.println("Total Mercadorias: R$" + totalMercadorias);
                System.out.println("Total Geral: R$" + totalGeral + "\n");
                managementMenu();
            case 0:
                menuPrincipal();
            default:
                System.out.println("\n");
                managementMenu();
                break;
        }
    }

    public String toString() {
        String result = "";
        for (NotaFiscal n: notasFiscais) {
            result += "\n" +  n.toString();
        }
        return result;
    }
}
