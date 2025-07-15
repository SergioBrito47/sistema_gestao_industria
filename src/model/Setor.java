package model;

public class Setor {

    private Integer idSetor;
    private String nome;
    private String responsavel;

    public Setor(Integer idSetor, String nome, String responsavel) {
        this.idSetor = idSetor;
        this.nome = nome;
        this.responsavel = responsavel;
    }

    public Setor() {

    }

    public Integer getIdSetor() {
        return idSetor;
    }

    public void setIdSetor(Integer idSetor) {
        this.idSetor = idSetor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    @Override
    public String toString() {
        return String.format("| %-8s | %-20s | %-20s |",
                 idSetor, nome, responsavel);
    }
}
