package br.com.luizgarcia.moip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * App de inicialização.
 *
 */
@EnableAutoConfiguration
@SpringBootApplication
public class App   
{
    public static void main( String[] args ){
    	 SpringApplication.run(App.class, args);
    }
}
