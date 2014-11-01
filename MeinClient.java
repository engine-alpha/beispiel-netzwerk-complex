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
        
    }
    
    public void vorstellen() {
        sendeString("Hallo, ich bin "  + name);
    }
    
    public void frageStellen() {
        sendeString("Was ist die Antwort?");
    }
    
    @Override
    public void empfangeString(String string) {
        System.out.println(string);
    }
}
