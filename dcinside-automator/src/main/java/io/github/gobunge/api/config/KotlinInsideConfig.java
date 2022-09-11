package io.github.gobunge.api.config;


import be.zvz.kotlininside.KotlinInside;
import be.zvz.kotlininside.http.DefaultHttpClient;
import be.zvz.kotlininside.session.user.Anonymous;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KotlinInsideConfig {
    private final KotlinInside kotlinInside;

    public KotlinInsideConfig(
        @Value("${dcinside.author-name}") String authorName
        , @Value("${dcinside.author-pass}") String authorPass) {
        initialize(authorName, authorPass);
        this.kotlinInside = KotlinInside.getInstance();
    }

    private void initialize(String authorName, String authorPass) {
        KotlinInside.createInstance(
            new Anonymous(authorName, authorPass),
            new DefaultHttpClient()
        );
    }

    @Bean
    public KotlinInside getMetadata()
    {
        return this.kotlinInside;
    }
}
