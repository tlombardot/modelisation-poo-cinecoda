package cine;

import java.util.logging.Logger;

public class Main {
    private static Logger log;

    public static void main(String[] args) {
        log = ConsoleLogger.create("cine.scenario");

        // Rejouez ici le scénario de l'énoncé, en affichant chaque étape avec log.info(...)
        Cinema cinema = new Cinema("CinéCoda");
        log.info("=== 1. Création du cinéma CinéCoda ===");
        ProjectorDigital projectorDigital = new ProjectorDigital("DSQD245SQ");
        Projector35mm projector35mm = new Projector35mm("35MM12345");
        Room room1 = new Room(1, "Salle 1", 100, projectorDigital);
        Room room2 = new Room(2, "Salle 2", 3, projector35mm);
        cinema.addRoom(room1);
        room1.printRoomInfo();
        cinema.addRoom(room2);
        room2.printRoomInfo();

    }  
}
