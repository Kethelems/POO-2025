import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Paciente extends Pessoa {
    private LocalDate dataNascimento;
    private Sexo sexo;
    private TipoSanguineo tipoSanguineo;
    private List<Consulta> historicoConsultas;
    private List<Exame> historicoExames;

    public Paciente(String nome, String cpf, String email, String telefone, LocalDate dataNascimento, Sexo sexo, TipoSanguineo tipoSanguineo) {
        super(nome, cpf, email, telefone);
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.tipoSanguineo = tipoSanguineo;
        this.historicoConsultas = new ArrayList<>();
        this.historicoExames = new ArrayList<>();
    }

    public void adicionarConsulta(Consulta consulta) {
        historicoConsultas.add(consulta);
    }

    public void adicionarExame(Exame exame) {
        historicoExames.add(exame);
    }

    public void visualizarHistorico() {
        System.out.println("---HISTÓRICO DE CONSULTAS DE " + nome + "---");
        for (Consulta cons : historicoConsultas) {
            System.out.println(cons);
        }

        System.out.println("\n---HISTÓRICO DE EXAMES DE " + nome + "---");
        for (Exame exam : historicoExames) {
            System.out.println(exam);
        }
    }

    @Override
    public String toString() {
        return "---DADOS DO PACIENTE---\n" + super.toString() + "\nData de Nascimento: " + dataNascimento + 
               "\nSexo: " + sexo + "\nTipo Sanguíneo: " + tipoSanguineo;
    }

    // Getters e Setters
    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public TipoSanguineo getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(TipoSanguineo tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public List<Consulta> getHistoricoConsultas() {
        return historicoConsultas;
    }

    public List<Exame> getHistoricoExames() {
        return historicoExames;
    }
}