package DTO;


public class ManutencaoDTO {

    private static int id;
    private String TecnicoNome;
    private String maquinaNome;
    private String tipo;
    private String descricao;

    public String getTecnicoNome() {
        return TecnicoNome;
    }

    public void setTecnicoNome(String TecnicoNome) {
        this.TecnicoNome = TecnicoNome;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        ManutencaoDTO.id = id;
    }


    public String getMaquinaNome() {
        return maquinaNome;
    }

    public void setMaquinaNome(String maquinaNome) {
        this.maquinaNome = maquinaNome;
    }


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }   
}
