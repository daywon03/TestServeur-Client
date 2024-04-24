import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(1024);
        System.out.println("Ent attente d'une connection d'un client");
        Socket s = ss.accept();
        System.out.println("Connection établie");
        //On récupère le nom du Client qui c'est connécter
        DataInputStream in = new DataInputStream(s.getInputStream());
        String nomClient = in.readUTF();
        String s1 = "Le client "+ nomClient + ",  est bien connecter";
        //Envoie de la donnée au client
        DataOutputStream out = new DataOutputStream(s.getOutputStream()); // crée un Flux de sortie via la Socket
        out.writeUTF(s1); //Permet d'envoyer la chaine de caractère

    }
}
