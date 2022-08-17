package com.li.client;

public class Client {
    private ClientServices clientServices;
    
    public Client(){
        this.clientServices = new ClientServices();
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.sendFile();
    }

    public void sendFile(){
        this.clientServices.sendFile();
    }

}
