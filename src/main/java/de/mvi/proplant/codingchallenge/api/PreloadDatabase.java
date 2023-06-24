package de.mvi.proplant.codingchallenge.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import de.mvi.proplant.codingchallenge.api.model.User;
import de.mvi.proplant.codingchallenge.api.repository.UserRepository;

@Configuration
public class PreloadDatabase {

    private static final Logger log = LoggerFactory.getLogger(PreloadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository) {
        
        User user1 = new User("Ralph", "Kaufmann", "ralph.kaufmann@example.com");
        userRepository.save(user1);

        User user2 = new User("Sabine", "Freitag", "sabine.freitag@example.org");
        userRepository.save(user2);

        User user3 = new User("Claudia", "Müller", "claudia.müller@example.org");
        userRepository.save(user3);

        User user4 = new User("Markus", "Braun", "markus.braun@example.org");
        userRepository.save(user4);

        User user5 = new User("Antje", "Brandt", "antje.brandt@example.com");
        userRepository.save(user5);

        User user6 = new User("Philipp", "Weiss", "philipp.weiss@example.org");
        userRepository.save(user6);

        User user7 = new User("Anna", "Schulz", "anna.schulz@example.org");
        userRepository.save(user7);

        User user8 = new User("Stefanie", "Zimmer", "stefanie.zimmer@example.com");
        userRepository.save(user8);

        User user9 = new User("Kristian", "Kohler", "kristian.kohler@example.org");
        userRepository.save(user9);

        User user10 = new User("Daniel", "Eberhart", "daniel.eberhart@example.com");
        userRepository.save(user10);

        log.info("Test Data:");
        log.info(user1.toString());
        log.info(user2.toString());
        log.info(user3.toString());
        log.info(user4.toString());
        log.info(user5.toString());
        log.info(user6.toString());
        log.info(user7.toString());
        log.info(user8.toString());
        log.info(user9.toString());
        log.info(user10.toString());
        
        return args -> {
            log.info("Data created.");
        };
    }
    
}
