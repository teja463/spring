package com.example.springboooth2jpaexample;

import com.example.springboooth2jpaexample.domain.Item;
import com.example.springboooth2jpaexample.domain.User;
import com.example.springboooth2jpaexample.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.oidc.IdTokenClaimNames;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@SpringBootApplication
@RestController
public class SpringBoootH2JpaExampleApplication {

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringBoootH2JpaExampleApplication.class, args);
    }

    @GetMapping("/user")
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
        return Collections.singletonMap("name", principal.getAttribute("name"));
    }

    // Java based custom oauth client registration

    /*@Bean
    public ClientRegistrationRepository clientRegistrationRepository() {
        return new InMemoryClientRegistrationRepository(this.googleClientRegistration());
    }

    private ClientRegistration googleClientRegistration() {
        return ClientRegistration.withRegistrationId("ping")
                .clientId("MROLife-dev")
                .clientSecret("hYrojUdgC5RFe9MI8YFXaOff2GlAoOUmhF8a4BfvheR9nDxEQfHV8Vzlf2wRPY0M")
                .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .redirectUri("http://localhost:8080/login/oauth2/code/ping")
                .scope("openid")
                .authorizationUri("https://logindev.rockwellcollins.com/as/authorization.oauth2")
                .tokenUri("https://logindev.rockwellcollins.com:443/as/token.oauth2")
                .userInfoUri("https://logindev.rockwellcollins.com/idp/userinfo.openid")
                .userNameAttributeName(IdTokenClaimNames.SUB)
                .jwkSetUri("https://logindev.rockwellcollins.com/pf/JWKS")
                .clientName("ping")
                .build();
    }
*/

    @Bean
    public CommandLineRunner bootstrapData() {
        return (d) -> {

            Item apple = new Item("Apple");
            Item sapota = new Item("Sapota");
            User teja = new User("Teja");
            teja.addItem(apple);
            teja.addItem(sapota);
            userRepository.save(teja);
            userRepository.save(new User("Ramya"));
            userRepository.save(new User("Havish"));
        };
    }

}
