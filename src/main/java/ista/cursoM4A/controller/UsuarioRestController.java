package ista.cursoM4A.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ista.cursoM4A.entity.Usuario;
import ista.cursoM4A.services.IUsuarioService;

@RestController
@CrossOrigin(origins= "http://localhost:4200")
@RequestMapping("/api")
public class UsuarioRestController {
	
	@Autowired
	private IUsuarioService usuarioService;
	
	    //Listar Todos los Usuario
		@GetMapping("/usuario")
		public List<Usuario> index(){
			return usuarioService.findAll();
		}
		
		//Buscar todos los Usuario
		@GetMapping("/usuario/{id}")
		public Usuario show(@PathVariable Long id) {
			return usuarioService.findById(id);
		}

		//Guardar un Usuario
		@PostMapping("/usuario")
		@ResponseStatus(HttpStatus.CREATED)
		public Usuario create(@RequestBody Usuario usuario) {
			return usuarioService.save(usuario);
		}
		
		//editar un Usuario
		@PutMapping("/usuario/{id}")
		@ResponseStatus(HttpStatus.CREATED)
		public Usuario update(@RequestBody Usuario usuario, @PathVariable Long id) {
			Usuario usuarioActual = usuarioService.findById(id);
			usuarioActual.setNombre(usuario.getNombre());
			usuarioActual.setClave(usuario.getClave());
			usuarioActual.setEmail(usuario.getEmail());
			usuarioActual.setEstado(usuario.getEstado());
			return usuarioService.save(usuarioActual);
		}
		
		//eliminar un Usuario
		@DeleteMapping("/usuario/{id}")
		@ResponseStatus(HttpStatus.NO_CONTENT)
		public void delete(@PathVariable Long id) {
			usuarioService.delete(id);
		}

}
