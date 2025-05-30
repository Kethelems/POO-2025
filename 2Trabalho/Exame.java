import java.time.LocalDate;
import java.time.LocalTime;

public class Exame implements IAgendavel {
    private String nome;
    private LocalDate data;
    private LocalTime hora;
    private IResponsavelExame responsavel;
    private String laudo;

    public Exame(String nome, LocalDate data, LocalTime hora, IResponsavelExame responsavel) {
        this.nome = nome;
        this.data = data;
        this.hora = hora;
        this.responsavel = responsavel;
    }

    @Override
    public void agendar() {
        System.out.println("Exame '" + nome + "' agendado para " + data + " às " + hora);
    }

    @Override
    public LocalDate getData() {
        return data;
    }

    @Override
    public LocalTime getHora() {
        return hora;
    }

    @Override
    public void cancelar() {
        System.out.println("Exame '" + nome + "' cancelado para " + data + " às " + hora);
    }

    public void encerrar(String resultadoLaudo) {
        this.laudo = responsavel.gerarLaudo(this) + " - " + resultadoLaudo;
        System.out.println("Exame encerrado e laudo gerado.");
    }

    @Override
    public String toString() {
        String responsavelNome = "";
        if (responsavel instanceof Pessoa) {
            responsavelNome = ((Pessoa) responsavel).getNome();
        }
        
        String result = "Exame: " + nome + " realizado em " + data + " às " + hora + 
                       " - Responsável: " + responsavelNome;
        if (laudo != null) {
            result += "\nLaudo: " + laudo;
        }
        return result;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public IResponsavelExame getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(IResponsavelExame responsavel) {
        this.responsavel = responsavel;
    }

    public String getLaudo() {
        return laudo;
    }

    public void setLaudo(String laudo) {
        this.laudo = laudo;
    }
}