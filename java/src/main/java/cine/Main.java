package cine;

import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.time.LocalDate;

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
        log.info(() -> "Salles libres : " + cinema.getReadyRooms().stream()
            .map(Room::getName)
            .collect(Collectors.joining(", ")));
        log.info("");
        log.info("=== 2. Films et supports ===");
        Movie dune3 = new Movie("Dune 3", 166);
        DCP dcpDune3 = new DCP(dune3, LocalDate.of(2026, 10, 30));
        dcpDune3.printMediaInfo();
        Movie avengersDoomsDay = new Movie("Avengers: Doomsday", 119);
        DCP dcpAvengers = new DCP(avengersDoomsDay, LocalDate.of(2026, 10, 14));
        dcpAvengers.printMediaInfo();
    }
        
}
