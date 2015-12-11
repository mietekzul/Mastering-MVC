package masterSpringMvc.config;

import java.time.LocalDate;

import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.format.FormatterRegistry;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.util.UrlPathHelper;

import masterSpringMvc.date.USLocalDateFormatter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.sql.DataSource;

@Configuration
@EnableSwagger2
public class WebConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatterForFieldType(LocalDate.class, new USLocalDateFormatter());
    }

    @Bean
    public LocaleResolver localeResolver() {
        return new SessionLocaleResolver();
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("lang");
        return localeChangeInterceptor;
    }

    @Bean
    public EmbeddedServletContainerCustomizer containetCustomizer() {
        // EmbeddedServletContainerCustomizer embeddedServletContainerCustomizer
        // = new EmbeddedServletContainerCustomizer() {
        //
        // @Override
        // public void customize(ConfigurableEmbeddedServletContainer container)
        // {
        // container.addErrorPages(new ErrorPage(MultipartException.class,
        // "/uploadError"));
        // }
        // };
        // return embeddedServletContainerCustomizer;

        // return Container -> Container.addErrorPages(new
        // ErrorPage(MultipartException.class, "/uploadError"));
        return container -> container.addErrorPages(new ErrorPage(MultipartException.class, "/uploadError"));
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        UrlPathHelper urlPathHelper = new UrlPathHelper();
        urlPathHelper.setRemoveSemicolonContent(false);
        configurer.setUrlPathHelper(urlPathHelper);
        configurer.setUseRegisteredSuffixPatternMatch(true);
    }

    @Bean
    public Docket userApi() {
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .paths(path -> path.startsWith("/api"))
            .build();
    }

//    @Bean
//    @Primary
//    public UsersConnectionRepository getUsersConnectionRepository(DataSource dataSource, ConnectionFactoryLocator connectionFactoryLocator){
//        return new JdbcUsersConnectionRepository(dataSource, connectionFactoryLocator, Encryptors.noOpText());
//    }

}
