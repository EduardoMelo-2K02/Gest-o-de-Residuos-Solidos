package model;

public class Entulho {
    private int id;
    private String logradouro;
    private String material;
    private String volume;

    public Entulho() {}

    public Entulho(String logradouro, String material, String volume) {
        this.logradouro = logradouro;
        this.material = material;
        this.volume = volume;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getLogradouro() { return logradouro; }
    public void setLogradouro(String logradouro) { this.logradouro = logradouro; }

    public String getMaterial() { return material; }
    public void setMaterial(String material) { this.material = material; }

    public String getVolume() { return volume; }
    public void setVolume(String volume) { this.volume = volume; }
}