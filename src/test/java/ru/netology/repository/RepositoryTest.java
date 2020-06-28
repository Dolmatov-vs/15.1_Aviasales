package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Flight;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;


class RepositoryTest {
    Repository repository = new Repository();
    Flight ledMvn = new Flight(1, 3600, "LED", "MVN", 180);
    Flight ledDme = new Flight(2, 6751, "LED", "DME", 90);
    Flight dmeGoj = new Flight(3, 5821, "DME", "GOJ", 75);
    Flight ledDme2= new Flight(4, 1980, "LED", "DME", 95);
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
    public void shouldFindAll() {
        Flight[] actual = repository.findAll();
        Flight[] expected = new Flight[]{aerMov, ledDme2, ledMvn, ledAaq, dmeGoj, ledDme};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        int idToRemove = 3;
        repository.removeById(idToRemove);
        Flight[] actual = repository.findAll();
        Flight[] expected = new Flight[]{aerMov, ledDme2, ledMvn, ledAaq, ledDme};

        assertArrayEquals(expected, actual);
    }
}