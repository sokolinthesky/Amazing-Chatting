package ua.yurkov.ammazingchatting.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * TODO: Change class description
 *
 * @author yevhenii.yurkov (yyurkov)
 * @since 0.10.0
 */
@Configuration
public class ExternalBeanConfig {

    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }
}
