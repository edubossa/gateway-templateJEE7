package br.com.gateway.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.gateway.entity.Usuario;

@Stateless
public class UsuarioService {
	
	@PersistenceContext(unitName= "gatewayPU")
	private EntityManager manager;
	
	public Usuario getUsuario(String usuario, String token) {
		Usuario user = null;
		try {			
			TypedQuery<Usuario> namedQuery = manager.createNamedQuery("find.user", Usuario.class);
			namedQuery.setParameter("usuario", usuario);
			namedQuery.setParameter("token", token);
			user = namedQuery.getSingleResult();
		} catch (NoResultException e) {
			e.printStackTrace();
		}
		return user;
	}
	
}
