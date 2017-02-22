package br.com.gateway.ejb;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.ntk.model.Transacao;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class TransacaoService {
	
	@PersistenceContext(unitName= "gatewayPU")
	private EntityManager manager;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void salvar(Transacao transacao) {
		manager.persist(transacao);
	}
	
}
