package cl.global.logic.test.api.usuario;

import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import cl.glogal.logic.test.api.usuario.controller.UsuarioController;

@SpringBootApplication
@ComponentScan(basePackageClasses = UsuarioController.class)
@EnableJpaAuditing
@EntityScan("cl.global.logic.test.api.usuario.entity")
@EnableJpaRepositories("cl.global.logic.test.api.usuario.dao") 
public class UsuarioApplication {
	
	private final static Logger logger = Logger.getLogger(UsuarioApplication.class.getName());

	public static void main(String[] args) {
		logger.info("iniciando app..");
		SpringApplication.run(UsuarioApplication.class, args);
		
	}
	
}
