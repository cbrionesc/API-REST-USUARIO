package cl.glogal.logic.test.api.usuario.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cl.global.logic.test.api.usuario.dao.UsuarioRepository;
import cl.global.logic.test.api.usuario.entity.Usuario;

@RestController
@RequestMapping("/api/v1")
public class UsuarioController {

	private final static Logger logger = Logger.getLogger(UsuarioController.class.getName());
	
	//Se Inyecta el servicio para poder hacer uso de el
	@Autowired
	UsuarioRepository usuarioRepository;
	
	// Retorna todos los Usuarios
	@RequestMapping(path="/usuario",method=RequestMethod.GET)
	public ResponseEntity<List<Usuario>> findAll() {
		
		logger.info("Obtiene todos los usuarios");
		try {
			  List<Usuario> users = usuarioRepository.findAll();
			  return ResponseEntity.ok(users);  
			  
		 } catch (Exception e) {
			 logger.info("Error: "+e.getMessage());
			 return ResponseEntity.notFound().build();
		 }
	}
	
	
	// Retorna el Usuario con ID = usuarioId
	@RequestMapping(path="/usuario/{usuarioId}",method=RequestMethod.GET)
	public ResponseEntity<Optional<Usuario>> findById(@PathVariable long usuarioId) {
		
		logger.info("Obtiene el usuario con ID: "+usuarioId);
		
		 try {
			 
			 Optional<Usuario> usuario = usuarioRepository.findById(usuarioId);
			 return ResponseEntity.ok(usuario);  // return 200, with json body
			 
		 } catch (Exception e) {
			 logger.info("Error: "+e.getMessage());
			 return ResponseEntity.notFound().build();
		 }
	 
	}
	
	
	@RequestMapping(path="/usuario",method=RequestMethod.POST)
	public ResponseEntity<Usuario> create(@RequestBody Usuario usuario) throws URISyntaxException {
		
		logger.info("Ingresa un nuevo usuario: ");
		
		 try {
			
			 Usuario nuevo = usuarioRepository.save(usuario);
			 return ResponseEntity.created(new URI("/user/"+nuevo.getIdusuario())).build();
			 
		 } catch (Exception e) {
			 logger.info("Error: "+e.getMessage());
			 return ResponseEntity.status(HttpStatus.CONFLICT).build();
		 }
		 
	}
	
	
	@RequestMapping(path="/usuario/{usuarioId}",method=RequestMethod.PUT)
	public ResponseEntity<Void> updateExist(@Valid @RequestBody Usuario updUsuario, @PathVariable long usuarioId)  {
		 
		logger.info("Actualiza  el usuario con ID: "+usuarioId);
		
		try {
			  updUsuario.setIdusuario(usuarioId);
			  usuarioRepository.save(updUsuario);
			  return ResponseEntity.noContent().build();
			    
		 } catch (Exception e) {
			 logger.info("Error: "+e.getMessage());
			 return ResponseEntity.notFound().build();
		 }
	}
	
	
	@RequestMapping(path="/usuario/{usuarioId}",method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteUsuario(@PathVariable long usuarioId) {
		
		logger.info("Elimina el usuario con ID: "+usuarioId);
		
		 try {
			 
			 usuarioRepository.deleteById(usuarioId);
			 return ResponseEntity.ok().build();
			   
		 } catch (Exception e) {
			 logger.info("Error: "+e.getMessage());
			 return ResponseEntity.notFound().build();
		 }
	}
	

}
