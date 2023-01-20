package mathpar.web.learning.tasks.services;

import mathpar.web.learning.tasks.utils.MathparProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class AccountService {
    private final String prefix;
    private final static RestTemplate restTemplate = new RestTemplate();

    public AccountService(MathparProperties properties) {
        this.prefix = properties.getAccountModulePrefix();
    }

    public boolean isTokenValid(String token){
        try {
            return Optional.ofNullable(restTemplate.getForObject(prefix + "/isTokenValid?token={token}", Boolean.class, token)).orElse(false);
        } catch (HttpClientErrorException.Forbidden e){
            return false;
        }
    }
}
