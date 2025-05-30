import java.time.LocalDate;
import java.time.LocalTime;

public class Consulta implements IAgendavel {
    private LocalDate data;
    private LocalTime hora;
    private TipoConsulta tipo;
    private Medico medico;
    private Paciente paciente;
    private Prontuario prontuario;

    public Consulta(LocalDate data, LocalTime hora, TipoConsulta tipo, Medico medico, Paciente paciente) {
        this.data = data;
        this.hora = hora;
        this.tipo = tipo;
        this.medico = medico;
        this.paciente = paciente;
    }

    @Override
    public void agendar() {
        System.out.println("Consulta agendada para " + data + " às " + hora);
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
        System.out.println("Consulta cancelada para " + data + " às " + hora);
    }

    public void encerrar(String detalhes, String sintomas, String examesSolicitados, String medicamentos) {
        this.prontuario = new Prontuario(detalhes, sintomas, examesSolicitados, medicamentos);
        paciente.adicionarConsulta(this);
        System.out.println("Consulta encerrada e prontuário gerado.");
    }

    @Override
    public String toString() {
        String result = "Consulta realizada na data: " + data + " às " + hora + 
                       ", do tipo: " + tipo + ", com o medico(a): " + medico.getNome();
        if (prontuario != null) {
            result += "\n" + prontuario;
        }
        return result;
    }

    // Getters e Setters
    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public TipoConsulta getTipo() {
        return tipo;
    }

    public void setTipo(TipoConsulta tipo) {
        this.tipo = tipo;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Prontuario getProntuario() {
        return prontuario;
    }

    public void setProntuario(Prontuario prontuario) {
        this.prontuario = prontuario;
    }
}