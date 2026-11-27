package command;

public class Tv {
    public void encender(){
        System.out.println("Tv prendida");
    }
    public void apagar(){
        System.out.println("Tv apagada");
    }
    public void subirVolumen(){
        System.out.println("Volumen aumentado");
    }
    public void bajarVolumen(){
        System.out.println("Volumen bajado");
    }
    public void cambiarCanal(int canal)
    {
        System.out.println("Canal cambiado a " + canal);
    }
} 

