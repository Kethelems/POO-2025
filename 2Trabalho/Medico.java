import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class Medico extends Pessoa implements IResponsavelExame {
    private String crm;
    private List<String> especialidades;
    private Map<LocalDate, List<LocalTime>> agendaDisponibilidade;
    private List<Consulta> consultas;

    public Medico(String nome, String cpf, String email, String telefone, String crm, List<String> especialidades) {
        super(nome, cpf, email, telefone);
        this.crm = crm;
        this.especialidades = especialidades;
        this.agendaDisponibilidade = new HashMap<>();
        this.consultas = new ArrayList<>();
    }

    public void abrirAgenda(LocalDate data) {
        List<LocalTime> horarios = new ArrayList<>();
        for (int hora = 9; hora <= 17; hora++) {
            horarios.add(LocalTime.of(hora, 0));
        }
        agendaDisponibilidade.put(data, horarios);
    }

    public void removerHorario(LocalDate data, LocalTime hora) throws AgendaNaoDisponivelException {
        List<LocalTime> horarios = agendaDisponibilidade.get(data);
        if (horarios != null && horarios.contains(hora)) {
            horarios.remove(hora);
        } else {
            throw new AgendaNaoDisponivelException("Horário não disponível para a data " + data);
        }
    }

    @Override
    public String gerarLaudo(Exame exame) {
        return "Laudo médico gerado pelo Dr(a). " + this.nome + " para o exame: " + exame.getNome();
    }

    @Override
    public String toString() {
        return "---DADOS DO MÉDICO---\n" + super.toString() + "\nCRM: " + crm + "\nEspecialidades: " + String.join(", ", especialidades);
    }

    // Getters e Setters
    public Map<LocalDate, List<LocalTime>> getAgendaDisponibilidade() {
        return agendaDisponibilidade;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public List<String> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(List<String> especialidades) {
        this.especialidades = especialidades;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }
}
