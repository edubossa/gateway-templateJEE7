package br.com.ntk.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "usuario",
    "token",
    "tokenIntencao",
    "numeroDocumento",
    "descVenda",
    "tipoOperacao",
    "valorTransacao",
    "parcelamentoAdm",
    "qtdeParcelas",
    "moeda",
    "captura",
    "cartao",
    "comprador"
})
@XmlRootElement(name = "transacao")
@Entity
@Table(name = "TB_TRANSACAO")
public class Transacao implements Serializable {
	private static final long serialVersionUID = 4631448512726083051L;

	@XmlTransient
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID_TRANSACAO")
	private Long idTransacao;
	
	@XmlTransient
	@Column(name = "ID_USUARIO")
	private Long idUsuario;
	
	@Transient
    @XmlElement(required = true)
    protected String usuario;
    
	@Transient
    @XmlElement(required = true)
    protected String token;
	
	@Column(name="TOKEN_INTENCAO", length=120)
    protected String tokenIntencao;
    
	@Column(name="NUMERO_DOCUMENTO", length=20)
    @XmlElement(required = true)
    protected String numeroDocumento;
    
	@Column(name = "DESC_VENDA", length=120)
    @XmlElement(name = "desc-venda")
    protected String descVenda;
    
	@Column(name = "VALOR_TRANSACAO")
    protected BigDecimal valorTransacao;
    
	@Column(name="TIPO_OPERACAO")
    protected int tipoOperacao;
    
	@Column(name = "PARCELAMENTO_ADM", length=1)
    protected String parcelamentoAdm;
   
	@Column(name="QTDE_PARCELAS")
	protected int qtdeParcelas;
	
	@Column(name = "MOEDA")
    @XmlElement(required = true)
    protected int moeda;
    
	@Column(name = "CAPTURA", length=1)
    protected String captura;
	
	@Transient
    @XmlElement(required = true)
    protected Cartao cartao;
    
	@Transient
	@XmlElement(required = true)
    protected Comprador comprador;
    
	@Column(name="VERSAO", length=12)
	@XmlAttribute(name = "versao")
    protected String versao;
	
	@Column(name="ID_TRANSACAO_TOKEN", length=120)
    @XmlAttribute(name = "id_transacao")
    protected String idTransacaoToken;
   
    @XmlTransient
    @Column(name="DATA_HORA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHora;
    
    public Transacao() {}

	public Long getIdTransacao() {
		return idTransacao;
	}

	public void setIdTransacao(Long idTransacao) {
		this.idTransacao = idTransacao;
	}
	
	public Date getDataHora() {
		if (dataHora == null) {
			dataHora = new Date();
		}
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	/**
     * Obtém o valor da propriedade usuario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Define o valor da propriedade usuario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsuario(String value) {
        this.usuario = value;
    }

    /**
     * Obtém o valor da propriedade token.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToken() {
        return token;
    }

    /**
     * Define o valor da propriedade token.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToken(String value) {
        this.token = value;
    }

    /**
     * Obtém o valor da propriedade tokenIntencao.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTokenIntencao() {
        return tokenIntencao;
    }

    /**
     * Define o valor da propriedade tokenIntencao.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTokenIntencao(String value) {
        this.tokenIntencao = value;
    }

    /**
     * Obtém o valor da propriedade numeroDocumento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    /**
     * Define o valor da propriedade numeroDocumento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroDocumento(String value) {
        this.numeroDocumento = value;
    }

    /**
     * Obtém o valor da propriedade descVenda.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescVenda() {
        return descVenda;
    }

    /**
     * Define o valor da propriedade descVenda.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescVenda(String value) {
        this.descVenda = value;
    }

    /**
     * Obtém o valor da propriedade valorTransacao.
     * 
     */
    public BigDecimal getValorTransacao() {
        return valorTransacao;
    }

    /**
     * Define o valor da propriedade valorTransacao.
     * 
     */
    public void setValorTransacao(BigDecimal value) {
        this.valorTransacao = value;
    }
    
	public int getTipoOperacao() {
		return tipoOperacao;
	}

	public void setTipoOperacao(int tipoOperacao) {
		this.tipoOperacao = tipoOperacao;
	}

	/**
     * Obtém o valor da propriedade parcelamentoAdm.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParcelamentoAdm() {
        return parcelamentoAdm;
    }

    /**
     * Define o valor da propriedade parcelamentoAdm.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParcelamentoAdm(String value) {
        this.parcelamentoAdm = value;
    }

    /**
     * Obtém o valor da propriedade qtdeParcelas.
     * 
     */
    public int getQtdeParcelas() {
        return qtdeParcelas;
    }

    /**
     * Define o valor da propriedade qtdeParcelas.
     * 
     */
    public void setQtdeParcelas(int value) {
        this.qtdeParcelas = value;
    }

    /**
     * Obtém o valor da propriedade moeda.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public int getMoeda() {
        return moeda;
    }

    /**
     * Define o valor da propriedade moeda.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMoeda(int value) {
        this.moeda = value;
    }

    /**
     * Obtém o valor da propriedade captura.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCaptura() {
        return captura;
    }

    /**
     * Define o valor da propriedade captura.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCaptura(String value) {
        this.captura = value;
    }

    /**
     * Obtém o valor da propriedade cartao.
     * 
     * @return
     *     possible object is
     *     {@link Cartao }
     *     
     */
    public Cartao getCartao() {
        return cartao;
    }

    /**
     * Define o valor da propriedade cartao.
     * 
     * @param value
     *     allowed object is
     *     {@link Cartao }
     *     
     */
    public void setCartao(Cartao value) {
        this.cartao = value;
    }

    /**
     * Obtém o valor da propriedade comprador.
     * 
     * @return
     *     possible object is
     *     {@link Comprador }
     *     
     */
    public Comprador getComprador() {
        return comprador;
    }

    /**
     * Define o valor da propriedade comprador.
     * 
     * @param value
     *     allowed object is
     *     {@link Comprador }
     *     
     */
    public void setComprador(Comprador value) {
        this.comprador = value;
    }

    /**
     * Obtém o valor da propriedade versao.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersao() {
        return versao;
    }

    /**
     * Define o valor da propriedade versao.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersao(String value) {
        this.versao = value;
    }

	public String getIdTransacaoToken() {
		return idTransacaoToken;
	}

	public void setIdTransacaoToken(String idTransacaoToken) {
		this.idTransacaoToken = idTransacaoToken;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
    
}