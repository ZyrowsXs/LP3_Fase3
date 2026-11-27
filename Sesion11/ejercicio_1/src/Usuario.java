class Usuario implements Observer {
    private String name;
    public Usuario (String name ){
        this.name=name;
    }
    public void update(String message){
        System.out.println(name + " Recibio un " + message);
    }
}