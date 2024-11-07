package DTO;

public class MaquinaDTO {

    private int id;
    private String Nome;
    private String laboratorio_id;
    private String cpu;
    private String ram;
    private String armazenamento;
    private String Status;

    public String getLaboratorio_id() {
        return laboratorio_id;
    }

    public void setLaboratorio_id(String laboratorio_id) {
        this.laboratorio_id = laboratorio_id;
    }
    
    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getArmazenamento() {
        return armazenamento;
    }

    public void setArmazenamento(String armazenamento) {
        this.armazenamento = armazenamento;
    }
}
