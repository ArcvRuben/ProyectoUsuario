package ista.cursoM4A.services;

import java.util.List;

import ista.cursoM4A.entity.Usuario;

public interface IUsuarioService {

	public List<Usuario> findAll();
	public Usuario save(Usuario usuario);
	public Usuario findById(Long id);
	public void delete(Long id);
}
