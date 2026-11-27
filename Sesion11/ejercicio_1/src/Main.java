public class Main {
    public static void main(String[] args) {
        Notificacion sistema = new Notificacion();
        Usuario user1 = new Usuario("Caleb");
        Usuario user2 = new Usuario("Carlos");
        Usuario user3 = new Usuario("Yuri");
        sistema.suscribir(user1);
        sistema.suscribir(user2);
        sistema.suscribir(user3);
        System.out.println(" -----Anuncio de vida o muerte!!!!------- ");
        sistema.notificar(" Ya salio GTA 6 ");
        sistema.quitarSuscripcion(user3);
        System.out.println(" -----Anuncio de vida o muerte!!!!------- ");
        sistema.notificar(" En el macdonalds no venen donas ");
    }
}
