package cine;

import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.time.LocalDate;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
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
        Session sessionDune3 = new Session(room1, dcpDune3, LocalDate.of(2026, 10, 15));
        cinema.scheduleSession(sessionDune3);
        sessionDune3.sellTicket(new FullPrice(10.00));
        sessionDune3.sellTicket(new FullPrice(10.00));
        sessionDune3.sellTicket(new Student(10.00));
        sessionDune3.sellTicket(new Child(10.00));
        sessionDune3.printSelling();
        sessionDune3.printSeatRemaining();
        sessionDune3.printOccupancyRate();
        sessionDune3.printRevenue();
        log.info("");

        // Démarrage de la séance Avengers: Doomsday
        log.info("=== 4. Avengers: Doomsday en Salle 1 le 15/10/2026 (tarif de base 10,00 €) ===");
        Session sessionAvengers = new Session(room1, dcpAvengers, LocalDate.of(2026, 10, 15));
        cinema.scheduleSession(sessionAvengers);
        try {
            cinema.startSession(sessionAvengers);
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        log.info("");

        // Démarrage de la séance I Play Rocky
        log.info("=== 5. I Play Rocky en Salle 1 le 15/10/2026 (tarif de base 10,00 €) ===");

        Session sessionIPlayRocky = new Session(room1, iPlayRocky, LocalDate.of(2026, 10, 15));
        cinema.scheduleSession(sessionIPlayRocky);
        try {
            cinema.startSession(sessionIPlayRocky);
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        if (room1.getState() == RoomState.READY) {
            log.info("État de la "+ room1.getName() +" : LIBRE");
        }
        log.info("");

        // Démarrage de la séance I Play Rocky en Salle 2
        log.info("=== 6. I Play Rocky en Salle 2 le 15/10/2026 (tarif de base 8,00 €) ===");
        Session sessionIPlayRockySalle2 = new Session(room2, iPlayRocky, LocalDate.of(2026, 10, 15));
        cinema.scheduleSession(sessionIPlayRockySalle2);
        cinema.sellTicket(sessionIPlayRockySalle2, new Student(8.00));
        cinema.sellTicket(sessionIPlayRockySalle2, new Student(8.00));
        cinema.sellTicket(sessionIPlayRockySalle2, new Student(8.00));
        sessionIPlayRockySalle2.printSelling();
        try {
            cinema.sellTicket(sessionIPlayRockySalle2, new Student(8.00));
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        sessionIPlayRockySalle2.printSeatRemaining();
        sessionIPlayRockySalle2.printOccupancyRate();
        cinema.startSession(sessionIPlayRockySalle2);
        log.info("Séance démarrée");
        cinema.endSession(sessionIPlayRockySalle2);
        log.info("Séance terminée");
        if (room2.getState() == RoomState.IN_CLEANING) {
            log.info("État de la "+ room2.getName() +" : NETTOYAGE");
        }
        log.info(() -> "Salles libres : " + cinema.getReadyRooms().stream()
            .map(Room::getName)
            .collect(Collectors.joining(", ")));
        log.info("Projections de la copie de « I Play Rocky » : " + iPlayRocky.getNumberOfProjections());
        log.info("");

        // Démarrage de la séance I Play Rocky en Salle 2
        log.info("=== 7. I Play Rocky en Salle 2 le 15/10/2026 (tarif de base 8,00 €) ===");
        Session sessionIPlayRockySalle2Again = new Session(room2, iPlayRocky, LocalDate.of(2026, 10, 15));
        cinema.scheduleSession(sessionIPlayRockySalle2Again);
        try {
            cinema.startSession(sessionIPlayRockySalle2Again);
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        cinema.cleanRoom(room2);
        if (room2.getState() == RoomState.READY) {
            log.info("Nettoyage de la Salle 2 terminé");
        }
        try {
            cinema.startSession(sessionIPlayRockySalle2Again);
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        log.info("");

        // Programmation en Salle 3
        log.info("=== 8. Programmation en Salle 3 ===");
        Room room3 = new Room(3, "Salle 3", 3, projector35mm);
        Session sessionSalle3 = new Session(room3, iPlayRocky, LocalDate.of(2026, 10, 15));
        try {
            cinema.scheduleSession(sessionSalle3);
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        log.info("");

        // Bilan du 15/10/2026
        log.info("=== 9. Bilan du 15/10/2026 ===");
        double dailyRevenue = 0.0;
        for (Session session : cinema.getSessions()) {
            double revenue = session.getRevenue();
            dailyRevenue += revenue;
            log.info(() -> String.format(Locale.FRANCE,
                "%s, %s : %d billet(s), recette %.2f €",
                session.getMedia().getMovie().getTitle(),
                session.getRoom().getName(),
                session.getTickets().size(),
                revenue));
        }
        double finalDailyRevenue = dailyRevenue;
        log.info(() -> String.format(Locale.FRANCE, "Recette du jour : %.2f €", finalDailyRevenue));

    }   
        
}
