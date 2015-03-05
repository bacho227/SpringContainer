package ge.softgen.loanexpert.spring;

import static ge.softgen.loanexpert.spring.Config.getConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
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
		em.setPackagesToScan(new String[]{getConfig("entitymanager.packages.to.scan")});

		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter() {
			{
				String dialect = getConfig("hibernate.dialect");
				this.setDatabasePlatform(dialect);

				String showSql = getConfig("hibernate.show_sql");
				if (showSql != null) {
					this.setShowSql(showSql.equals("true"));
				}

				String generateDdl = getConfig("hibernate.ddl-auto");
				if (showSql != null) {
					this.setGenerateDdl(generateDdl.equals("update"));
				}
			}
		};

		em.setJpaVendorAdapter(vendorAdapter);
		return em;
	}

	@Bean
	public DataSource restDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		String driver = getConfig("db.driver");
		dataSource.setDriverClassName(driver);

		String url = getConfig("db.url");
		dataSource.setUrl(url);

		String username = getConfig("db.username");
		dataSource.setUsername(username);

		String password = getConfig("db.password");
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
