package br.com.gateway.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_USUARIO")
@NamedQueries(value = {
		@NamedQuery(name = "find.user", query="SELECT user FROM Usuario user WHERE user.usuario =:usuario AND user.token =:token ")
})
public class Usuario implements Serializable {
	private static final long serialVersionUID = -562182303491519835L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "USUARIO", length = 20)
	private String usuario;

	@Column(name = "TOKEN", length = 60)
	private String token;
	
	@OneToOne(mappedBy = "usuario", fetch=FetchType.EAGER, orphanRemoval=true, optional=true)
	private Configuracao configuracao;
	
	public Usuario() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Configuracao getConfiguracao() {
		return configuracao;
	}

	public void setConfiguracao(Configuracao configuracao) {
		this.configuracao = configuracao;
	}

}
