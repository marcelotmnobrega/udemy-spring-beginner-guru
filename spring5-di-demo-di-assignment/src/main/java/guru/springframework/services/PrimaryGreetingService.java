package guru.springframework.services;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * Created by jt on 5/24/17.
 */
@Service
@Primary
@Profile({"en", "default"})
@RequiredArgsConstructor
public class PrimaryGreetingService implements GreetingService {

    private final GreetingRepository greetingRepository;

    @Override
    public String sayGreeting() {
        return greetingRepository.getEnglishGreeting();
    }
}
