package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Flight;
//import ru.netology.domain.FlightByTimeAscComparator;
import ru.netology.domain.FlightByTimeAscComparator;
import ru.netology.repository.Repository;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
    Repository repository = new Repository();
    Manager manager = new Manager(repository);
    FlightByTimeAscComparator comparator = new FlightByTimeAscComparator();

    Flight ledMvn = new Flight(1, 3600, "LED", "MVN", 180);
    Flight ledDme = new Flight(2, 6751, "LED", "DME", 85);
    Flight dmeGoj = new Flight(3, 5821, "DME", "GOJ", 75);
    Flight ledDme2= new Flight(4, 1980, "LED", "DME", 90);
    Flight aerMov = new Flight(5, 1499, "AER", "MOV", 140);
    Flight ledAaq = new Flight(6, 5792, "LED", "AAQ", 180);

    @BeforeEach
    public void setUp() {
        repository.save(ledMvn);
        repository.save(ledDme);
        repository.save(dmeGoj);
        repository.save(ledDme2);
        repository.save(aerMov);
        repository.save(ledAaq);
    }

    @Test
    void shouldSearchIfFlightFind() {
        Flight[] actual = manager.searchBy("LED", "DME");
        Flight[] expected = new Flight[]{ledDme2, ledDme};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchIfFlightNotFind() {
        Flight[] actual = manager.searchBy("LED", "AER");
        Flight[] expected = new Flight[0];

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchFindAllCompar() {
        Flight[] actual = manager.findAllCompar("LED", "DME", comparator);
        Flight[] expected = new Flight[]{ledDme, ledDme2};

        assertArrayEquals(expected, actual);
    }
}