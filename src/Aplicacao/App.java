package Aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.DominioExecao;
import entities.Reserva;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            System.out.print("Numero do Quarto: ");
            int numero = sc.nextInt();

            System.out.print("Data de chegada: ");

            Date entrada = sdf.parse(sc.next());
            System.out.print("Data de saida: ");
            Date saida = sdf.parse(sc.next());

            Reserva reserva = new Reserva(numero, entrada, saida);
            System.out.println("Reserva: " + reserva);

            System.out.println();
            System.out.println("Digite a data de entrada atualizada: ");
            System.out.print("Data de entrada: ");
            entrada = sdf.parse(sc.next());
            System.out.print("Data de Saida: ");
            saida = sdf.parse(sc.next());

            reserva.atualizarData(entrada, saida);

            System.out.println("Reserva: " + reserva);
        } catch (ParseException e) {
            System.out.println("Formato de data Invalido !");
        } catch (DominioExecao e) {
            System.out.println("Erro na reserva: " + e.getMessage());
        }

        sc.close();
    }
}
