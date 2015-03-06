package ge.softgen.loanexpert.spring;

import static ge.softgen.loanexpert.spring.ApplicationConfig.getConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.*;

import javax.sql.DataSource;
import java.util.List;

@Configuration
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	@Autowired
	private AccessInterceptor accessInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(accessInterceptor);
	}


	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		argumentResolvers.add(new UserArgumentResolver());
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(this.restDataSource());
		em.setPackagesToScan(new String[]{getConfig("entityManager.packages.to.scan")});
		em.setJpaVendorAdapter(new HibernateJpaVendorAdapter() {
			{
				this.setDatabasePlatform(getConfig("spring.jpa.database-platform"));
				String showSql = getConfig("spring.jpa.show-sql");
				if (showSql != null) {
					this.setShowSql(showSql.equals("true"));
				}
			}
		});
		return em;
	}

	@Bean
	public DataSource restDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		String driver = getConfig("spring.datasource.driver-class-name");
		dataSource.setDriverClassName(driver);

		String url = getConfig("spring.datasource.url");
		dataSource.setUrl(url);

		String username = getConfig("spring.datasource.username");
		dataSource.setUsername(username);

		String password = getConfig("spring.datasource.password");
		dataSource.setPassword(password);

		return dataSource;
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(this.entityManagerFactoryBean().getObject());
		return transactionManager;
	}

}
