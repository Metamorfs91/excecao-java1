package Aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Reserva;

public class App {
    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Numero do Quarto: ");
        int numero = sc.nextInt();

        System.out.print("Data de chegada: ");

        Date entrada = sdf.parse(sc.next());
        System.out.print("Data de saida: ");
        Date saida = sdf.parse(sc.next());

        if (!saida.after(entrada)) {
            System.out.println("Erro de reserva, a data de saida deve ser posterior a data de chegada");
        } else {
            Reserva reserva = new Reserva(numero, entrada, saida);
            System.out.println("Reserva: " + reserva);

            System.out.println();
            System.out.println("Digite a data de entrada atualizada: ");
            System.out.print("Data de entrada: ");
            entrada = sdf.parse(sc.next());
            System.out.print("Data de Saida: ");
            saida = sdf.parse(sc.next());

            Date agora = new Date();
            if (entrada.before(agora) || saida.before(agora)) {
                System.out.println("Erro na reserva, a reserva nao pode ser inferior a data atual");
            } else if (!saida.after(entrada)) {
                System.out.println("Erro de reserva, a data de saida deve ser posterior a data de chegada");
            } else {
                reserva.atualizarData(entrada, saida);
                System.out.println("Reserva: " + reserva);
            }

        }
        sc.close();
    }
}