public class Prontuario {
    private String detalhes;
    private String sintomas;
    private String examesSolicitados;
    private String medicamentos;

    public Prontuario(String detalhes, String sintomas, String examesSolicitados, String medicamentos) {
        this.detalhes = detalhes;
        this.sintomas = sintomas;
        this.examesSolicitados = examesSolicitados;
        this.medicamentos = medicamentos;
    }

    @Override
    public String toString() {
        return "---PRONTUÁRIO DO PACIENTE---\nDetalhes: " + detalhes + 
               "\nSintomas: " + sintomas + "\nExames solicitados: " + examesSolicitados + 
               "\nMedicamentos receitados: " + medicamentos;
    }

    // Getters e Setters
    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public String getExamesSolicitados() {
        return examesSolicitados;
    }

    public void setExamesSolicitados(String examesSolicitados) {
        this.examesSolicitados = examesSolicitados;
    }

    public String getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(String medicamentos) {
        this.medicamentos = medicamentos;
    }
}
