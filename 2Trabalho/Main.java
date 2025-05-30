import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try {
            // Criar profissionais
            Medico medico = new Medico("Dra. Elisa", "111.111.111-11", "elisareis@gmail.com", "99133-3899",
                    "CRM1234", Arrays.asList("Pediatria", "Clínica Geral"));

            Tecnico tecnico = new Tecnico("Fulano", "222.222.222-22", "Fulano@gmail.com", "99188-6655");

            // Criar paciente
            Paciente paciente = new Paciente("Ciclano", "333.333.333-33", "Ciclano@gmail.com", "97168-6791",
                    LocalDate.of(1998, 5, 30), Sexo.MASCULINO, TipoSanguineo.A_POS);

            // Exibir dados dos profissionais e paciente
            System.out.println(medico);
            System.out.println("\n" + tecnico);
            System.out.println("\n" + paciente);
            System.out.println("\n" + "=".repeat(50) + "\n");

            // Disponibilizar agenda
            LocalDate dataConsulta = LocalDate.of(2025, 5, 30);
            medico.abrirAgenda(dataConsulta);

            // Fazer agendamento de consulta
            LocalTime horario = LocalTime.of(9, 0);
            medico.removerHorario(dataConsulta, horario);

            Consulta consulta = new Consulta(dataConsulta, horario, TipoConsulta.PRIMEIRA_CONSULTA, medico, paciente);
            consulta.agendar();

            // Encerrar consulta
            consulta.encerrar("Consulta realizada com sucesso", "Tosse seca",
                    "Exame de sangue", "Desloratadina");
            
            // Marcar exame com técnico como responsável
            LocalDate dataExame1 = LocalDate.of(2025, 5, 30);
            LocalTime horaExame1 = LocalTime.of(10, 0);
            Exame exame = new Exame("Exame de Sangue", dataExame1, horaExame1, tecnico);
            exame.agendar();
            exame.encerrar("Hemograma dentro dos parâmetros normais");

            // Adicionar exame no histórico
            paciente.adicionarExame(exame);

            // Marcar outro exame com médico como responsável
            LocalDate dataExame2 = LocalDate.of(2025, 6, 1);
            LocalTime horaExame2 = LocalTime.of(14, 30);
            Exame exame2 = new Exame("Raio-X Tórax", dataExame2, horaExame2, medico);
            exame2.agendar();
            exame2.encerrar("Pulmões limpos, sem alterações");
            paciente.adicionarExame(exame2);

            System.out.println("\n" + "=".repeat(50));
            System.out.println("HISTÓRICO DO PACIENTE");
            System.out.println("=".repeat(50));
            // Visualizar histórico do paciente
            paciente.visualizarHistorico();

        } catch (AgendaNaoDisponivelException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}