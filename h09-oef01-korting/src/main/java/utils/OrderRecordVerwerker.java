package utils;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

public class OrderRecordVerwerker {
    private static final String INNAAM = "order.txt";
    private static final String UITNAAM = "korting.txt";

    public static void genereerOverzichtKortingen() {
        // TODO
    }

    // INPUT: Moet een bestaand bestand in target zijn
    private Path geefInputPad(String bestandsnaam) {
        URL url = OrderRecordVerwerker.class.getResource("/bestanden/" + bestandsnaam);
        if (url == null) {
            exitApplication("Bestand niet gevonden: bestanden/" + bestandsnaam);
        }
        try {
            return Path.of(url.toURI());
        } catch (Exception e) {
            exitApplication("Kan bestand niet openen: " + bestandsnaam);
            throw new IllegalStateException(e);
        }
    }

    // OUTPUT: Schrijven naar een bestand in target (mag nieuw zijn)
    private Path geefOutputPad(String bestandsnaam) {
        Path pad = Path.of("target", "classes", "bestanden", bestandsnaam);
        try {
            Files.createDirectories(pad.getParent());
            return pad;
        } catch (IOException e) {
            exitApplication("Kan map niet maken voor: " + bestandsnaam);
            throw new IllegalStateException(e);
        }
    }

    private static void exitApplication(String message) {
        System.err.println(message);
        System.exit(1);
    }
}