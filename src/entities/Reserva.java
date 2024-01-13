package entities;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

public class Reserva {
    private Integer numeroQuarto;
    private Date entrada;
    private Date saida;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reserva(Integer numeroQuarto, Date entrada, Date saida) throws DominioExecao {

        if (!saida.after(entrada)) {
            throw new DominioExecao(" a data de saida deve ser posterior a data de chegada");
        }
        this.numeroQuarto = numeroQuarto;
        this.entrada = entrada;
        this.saida = saida;
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

    public void atualizarData(Date entrada, Date saida) throws DominioExecao {
        Date agora = new Date();
        if (entrada.before(agora) || saida.before(agora)) {
            throw new DominioExecao(" a reserva nao pode ser inferior a data atual");
        }

        this.entrada = entrada;
        this.saida = saida;

    }

    @Override
    public String toString() {
        return "Quarto: "
                + numeroQuarto
                + "| Entrada: "
                + sdf.format(entrada)
                + "| Saida: "
                + sdf.format(saida)
                + "|"
                + duracao()
                + " Noites: ";
    }
}