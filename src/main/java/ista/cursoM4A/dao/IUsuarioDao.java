package ista.cursoM4A.dao;

import org.springframework.data.repository.CrudRepository;

import ista.cursoM4A.entity.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Long>{

}
