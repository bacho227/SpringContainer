package ge.emis.teachers.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by Bacho on 2/4/15.
 */

@Configuration
@ComponentScan(basePackages = {"ge"})
@EnableJpaRepositories(basePackages = "ge.emis.teachers.repository")
public class RootConfig {
}