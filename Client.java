import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.StandardSocketOptions;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("127.0.0.1", 1024);
        System.out.println("Nom client"); // Permet de récuperer le nom du client via la console
        Scanner sc = new Scanner(System.in);
        String nomClient = sc.next();
        // On envoit la donnée au serveur
        DataOutputStream out = new DataOutputStream(client.getOutputStream()); //Flux de sortie
        out.writeUTF(nomClient); //Si donnée envoyez au serveur, serveur va renvoyé au client une donnée donc il faut  recup donnée au serveur
        //Récuperer donnée envoyée par le serveur
        DataInputStream in = new DataInputStream(client.getInputStream());
        String s1 = in.readUTF(); //Récuperer la chaine de caractere envoyé par le serveur
        System.out.println(s1);// Affiche la chaîne de caractère envoyé oar le serveur
    }

}
