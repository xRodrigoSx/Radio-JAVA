package radio;

import java.util.Scanner;

public class Radio {

    public static void main(String[] args) {
        Rd rádio1 = new Rd(0, false);
        Rd rádio2 = new Rd(0, false);
        Rd rádio3 = new Rd(0, false);
        int menu = 9;
        Scanner reader = new Scanner(System.in);
        while (menu != 0) {
            System.out.println("""
                               Escollha um comando:
                               1 = Play
                               2 = Pause
                               3 = Estado
                               4 = Aumentar Esta\u00e7\u00e3o
                               5 = Diminuir Esta\u00e7\u00e3o
                               6 = Aumentar Volume
                               7 = Diminuir Volume
                               8 = Trocar Faixa
                               0 = Voltar""");
            menu = reader.nextInt();
            switch (menu) {
                case 1 -> rádio1.play();
                case 2 -> rádio1.pause();
                case 3 -> rádio1.estado();
                case 4 -> rádio1.dislAumenta();
                case 5 -> rádio1.dislDiminui();
                case 6 -> rádio1.volumeAumenta();
                case 7 -> rádio1.volumeDiminui();
                case 8 -> rádio1.faixaSintonia();
                case 0 -> {
                }
                }
            }
        }
    }
