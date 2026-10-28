package cine;

import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.time.LocalDate;

public class Main {
    public static void main() {
        Logger log = ConsoleLogger.create("cine.scenario");

        // Création du cinéma
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

        // Création des films et supports
        log.info("=== 2. Films et supports ===");
        Movie dune3 = new Movie("Dune 3", 166);
        DCP dcpDune3 = new DCP(dune3, LocalDate.of(2026, 10, 30));
        dcpDune3.printMediaInfo();
        Movie avengersDoomsDay = new Movie("Avengers: Doomsday", 119);
        DCP dcpAvengers = new DCP(avengersDoomsDay, LocalDate.of(2026, 10, 14));
        dcpAvengers.printMediaInfo();
        Movie iPlayRockyMovie = new Movie("I Play Rocky", 103);
        Film35mm iPlayRocky = new Film35mm(iPlayRockyMovie, 49);
        iPlayRocky.printMediaInfo();
        log.info("");

        // Programmation d'une séance
        log.info("=== 3. Dune 3 en Salle 1 le 15/10/2026 (tarif de base 10,00 €) ===");
        Session sessionDune3 = new Session(room1, dcpDune3, LocalDate.of(2026, 10, 15), 10.00);
        cinema.scheduleSession(sessionDune3);
        sessionDune3.sellTicket(new FullPrice(10.00));
        sessionDune3.sellTicket(new Student(10.00));
        sessionDune3.sellTicket(new Child(10.00));

    }   
        
}
