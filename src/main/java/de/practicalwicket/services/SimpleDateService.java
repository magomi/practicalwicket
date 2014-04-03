package de.practicalwicket.services;

import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Implemetation of the {@link de.practicalwicket.services.DateService}.
 */
@Service
public class SimpleDateService implements DateService {
    @Override
    public Date getDate() {
        return new Date();
    }
}
