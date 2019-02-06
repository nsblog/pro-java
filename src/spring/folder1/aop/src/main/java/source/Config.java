package source;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Serzh Nosov created on 06.02.2019.
 */
@Configuration
public class Config {

    @Bean
    public HelloAspect firstAspect() {
        return new HelloAspect();
    }
}
