import ea.*;
/**
 * Diese Klasse beschreibt Clients, die alle vom Server einzeln behandelt werden.
 * 
 * @author Michael Andonie
 */
public class MeinClient
extends Client {
    /**
     * Der Name des Clients, z.B. "Herbert".
     */
    private String name;
    
    public MeinClient(String ipAdresse, String name) {
        //Verbinde dich mit der übergebenen IP-Adresse und Port 7654.
        //Port 7654 ist willkürlich gewählt. Wichtig ist,
        //  - dass die Portnummer größer als 1024 ist.
        //  - dass der Client dieselbe Portnummer hat.
        super(ipAdresse, 7654);
        this.name = name;
        
        //Warten, bis die Verbindung zum Server steht:
        //   Achtung: Wenn kein Server gefunden werden kann,
        //            friert dieser Konstruktor ein!
        warteAufVerbindung();
        
        //Gleich mal Hallo sagen.
        sendeString("Hallo, ich bin "  + name);
    }
    
    public void frageStellen() {
        sendeString("Was ist die Antwort?");
    }
    
    @Override
    public void empfangeString(String string) {
        //empfangenen String einfach an der Konsole ausgeben
        System.out.println("[Client " + name + " hat empfangen:] " +string);
    }
}
