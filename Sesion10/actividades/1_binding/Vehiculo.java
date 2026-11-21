public class Vehiculo {
    private String placa;
    private String marca;
    private int anio;
    private int kilometraje;

    public Vehiculo(String placa, String marca, int anio, int kilometraje) {
        this.placa = placa;
        this.marca = marca;
        this.anio = anio;
        this.kilometraje = kilometraje;
    }

    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public int getAnio() { return anio; }
    public void setAnio(int anio) { this.anio = anio; }

    public int getKilometraje() { return kilometraje; }
    public void setKilometraje(int kilometraje) { this.kilometraje = kilometraje; }
}
