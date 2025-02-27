package med.voll.api.medico;

public record DadosLisstagemMedico(String nome, String email, String crm, Especialidade especialidade) {

    public DadosLisstagemMedico(Medico medico) {
        this(medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
