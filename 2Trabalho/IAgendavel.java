import java.time.LocalDate;
import java.time.LocalTime;

public interface IAgendavel {
    void agendar();
    LocalDate getData();
    LocalTime getHora();
    Paciente getPaciente();
    void cancelar();
}
