package web.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("web")
public class WebConfig implements WebMvcConfigurer {
// СМ уроки алишева 16.СпрингМВС,8:00 - для использования шаблонизатора ТаймЛиф,
    private final ApplicationContext applicationContext;
    //Внедрение апликайшинКонтекст
    public WebConfig(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }
    // Используем апл.Контекст для настройки TimeLive/ SetPrefix задаем указываем папку где будут наши представления SetSuffix задаем расширение наших представлений
    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(applicationContext);
        templateResolver.setPrefix("/WEB-INF/pages/");
        templateResolver.setSuffix(".html");
        //для кадировки добавим
        templateResolver.setCharacterEncoding("UTF-8");
        return templateResolver;
    }
    // Бин ТемплейтЭнджин позволяет конфигурацию представлений
    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        templateEngine.setEnableSpringELCompiler(true);
        return templateEngine;
    }
    // Вместо того, чтобы использовать TimeLive, вместо стандартного шаблонизатора метод configureViewResolvers передает в спринг, что хотим использовать шаблонизатор Timelive
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine());
        registry.viewResolver(resolver);
        // добавим кодировку в TimeLive шаблонизатор
        resolver.setCharacterEncoding("UTF-8");
        resolver.setContentType("text/html; charset=UTF-8");
    }
}