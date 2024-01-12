package entities;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

public class Reserva {
    private Integer numeroQuarto;
    private Date entrada;
    private Date saida;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reserva(Integer numeroQuarto, Date entrada, Date saida) {
        this.numeroQuarto = numeroQuarto;
        this.entrada = entrada;
        this.saida = saida;
    }

    public Reserva() {

    }

    public Integer getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(Integer numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    public Date getEntrada() {
        return entrada;
    }

    public Date getSaida() {
        return saida;
    }

    public long duracao() {
        long dif = saida.getTime() - entrada.getTime();
        return TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS);
    }

    public void atualizarData(Date entrada, Date saida) {
        this.entrada = entrada;
        this.saida = saida;
    }

    @Override
    public String toString() {
        return "Quarto: "
                + numeroQuarto
                + ", Entrada: "
                + sdf.format(entrada)
                + ", Saida: "
                + sdf.format(saida)
                + ","
                + duracao()
                + " Noites: ";
    }
}