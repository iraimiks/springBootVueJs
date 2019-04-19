package lv.raimonds.webshopspring;


import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

@SpringBootApplication
public class WebshopspringApplication {

	static String FB_BASE_URL="https://testshop-9efd2.firebaseio.com";
	public static void main(String[] args) throws FileNotFoundException {
		SpringApplication.run(WebshopspringApplication.class, args);
		try {
			FirebaseOptions options = new FirebaseOptions.Builder()
					.setCredentials(GoogleCredentials.fromStream(new ClassPathResource("./testshop-9efd2-firebase-adminsdk-74zkd-3f9e39ced9.json").getInputStream()))
					.setDatabaseUrl(FB_BASE_URL)
					.build();
			FirebaseApp.initializeApp(options);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
