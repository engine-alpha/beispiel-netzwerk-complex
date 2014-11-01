import ea.*;
import java.util.*;

/**
 * Dieser Server behandelt jeden Client, der sich an ihm anmeldet, einzeln.
 * 
 * @author Michael Andonie
 */
public class MeinDedizierterServer
//Dieser Server lässt einen eigenen Thread laufen, um dauerhaft neue Clients abfangen zu können.
// Dafür wird das Runnable-Interface implementiert
implements Runnable{
    /**
     * Der Kern-Server aus der Engine. Kümmert sich um 
     * die Netzwerk-Kommunikation.
     */
    private Server server;
    
    private ArrayList<ClientHandler> handlers = new ArrayList<ClientHandler>();
    
    /**
     * Erstellt einen neuen dedizierten Server am Port 87654.
     */
    public MeinDedizierterServer() {
        //Port 7654 ist willkürlich gewählt. Wichtig ist,
        //  - dass die Portnummer größer als 1024 ist.
        //  - dass der Client dieselbe Portnummer hat.
        server = new Server(7654);
        
        new Thread(this).start();
    }
    
    public void shoot() {
        server.sendeString("sss");
    }
    
    @Override
    public void run() {
        //Dauerschleife
        while(!Thread.interrupted()) {
            //Gib mir die nächste Verbindung
            //   (warte ggf. solange, bis eine neue Verbindung zustandekommt)
            NetzwerkVerbindung verbindung = server.naechsteVerbindungAusgeben();
            
            handlers.add(new ClientHandler(verbindung));
        }
    }
}
