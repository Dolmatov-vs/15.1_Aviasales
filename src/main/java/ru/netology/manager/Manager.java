package ru.netology.manager;

import ru.netology.domain.Flight;
import ru.netology.repository.Repository;

public class Manager {
    private Repository repository;
    public Manager(Repository repository) {
        this.repository = repository;
    }

    public Flight[] searchBy(String from, String to) {
        Flight[] result = new Flight[0];
        for (Flight flight: repository.findAll()) {
            if (flight.matches(from, to)) {
                Flight[] tmp = new Flight[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = flight;
                result = tmp;
            }
        }
        return result;
    }
}
