package DTO;

import java.util.Date;

public class ManutencaoDTO {

    public ManutencaoDTO(int aInt, String string, String string1, Date date) {
    }
    private int id;
    private int maquinaId;
    private String tipo;
    private String descricao;
    private Date data;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMaquinaId() {
        return maquinaId;
    }

    public void setMaquinaId(int maquinaId) {
        this.maquinaId = maquinaId;
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
    
}
