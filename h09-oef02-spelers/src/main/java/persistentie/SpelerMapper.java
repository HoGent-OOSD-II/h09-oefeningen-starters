package persistentie;

import domein.Speler;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;

public class SpelerMapper {

    public void serialiseerObjectPerObject(Collection<Speler> spelerslijst, String naamBestand) {
        // TODO
    }

    public void serialiseerVolledigeLijst(Collection<Speler> spelerslijst, String naamBestand) {
        // TODO
    }

    public Collection<Speler> deSerialiseerObjectPerObject(String naamBestand) {
        // TODO
        return null;
    }

    public Collection<Speler> deSerialiseerVolledigeLijst(String naamBestand) {
        // TODO
        return null;
    }

    public void schrijfNaarTekstBestand(Collection<Speler> spelerslijst, String naamBestand) {
        // TODO
    }

    public Collection<Speler> leesTekstBestand(String naamBestand) {
        // TODO
        return null;
    }

    private Path geefInputPad(String bestandsnaam) {
        URL url = SpelerMapper.class.getResource("/bestanden/" + bestandsnaam);
        if (url == null) {
            exitApplication("Input bestand mist: bestanden/" + bestandsnaam);
        }
        try {
            return Path.of(url.toURI());
        } catch (Exception e) {
            exitApplication("Fout bij laden input: " + bestandsnaam);
            return null;
        }
    }

    // OUTPUT: Schrijven naar target (mag nieuw zijn)
    private Path geefOutputPad(String bestandsnaam) {
        Path pad = Path.of("target", "classes", "bestanden", bestandsnaam);
        try {
            Files.createDirectories(pad.getParent());
            return pad;
        } catch (IOException e) {
            exitApplication("Kan output map niet maken: " + bestandsnaam);
            return null;
        }
    }

    private void exitApplication(String message) {
        System.err.println(message);
        System.exit(1);
    }
}