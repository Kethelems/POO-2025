public class Tecnico extends Pessoa implements IResponsavelExame {
    
    public Tecnico(String nome, String cpf, String email, String telefone) {
        super(nome, cpf, email, telefone);
    }

    @Override
    public String gerarLaudo(Exame exame) {
        return "Laudo técnico gerado pelo técnico " + this.nome + " para o exame: " + exame.getNome();
    }

    @Override
    public String toString() {
        return "---DADOS DO TÉCNICO---\n" + super.toString();
    }
}

