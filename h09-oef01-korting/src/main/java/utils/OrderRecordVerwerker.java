package utils;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;

public class OrderRecordVerwerker {
    private static final String INNAAM = "order.txt";
    private static final String UITNAAM = "korting.txt";

    public static void genereerOverzichtKortingen() {
        // TODO
    }

    // Voor INPUT (moet bestaan)
    private static Path geefInputPad(String bestandsnaam) {
        URL url = OrderRecordVerwerker.class.getResource("/bestanden/" + bestandsnaam);
        if (url == null) exitApplication("Input mist: " + bestandsnaam);
        try {
            return Path.of(url.toURI());
        } catch (URISyntaxException e) {
            exitApplication(String.format("Kan bestand %s niet maken", bestandsnaam));
        }
        return null;
    }

    // Voor OUTPUT (mag nieuw zijn)
    private static Path geefOutputPad(String bestandsnaam) {
        Path pad = Path.of("target", "classes", "bestanden", bestandsnaam);
        return pad;
    }

    private static void exitApplication(String message) {
        System.err.println(message);
        System.exit(1);
    }
}