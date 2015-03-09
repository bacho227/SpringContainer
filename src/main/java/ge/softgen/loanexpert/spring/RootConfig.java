package ge.softgen.loanexpert.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by Bacho on 2/4/15.
 */

@Configuration
@ComponentScan(basePackages = {"ge"})
@EnableJpaRepositories(basePackages = "ge.softgen.loanexpert.repository")
public class RootConfig {
}
