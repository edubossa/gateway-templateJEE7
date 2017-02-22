package br.com.ntk.model;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "numeroCartao",
    "mesValidade",
    "anoValidade",
    "codigoSeguranca",
    "bandeira"
})
@XmlRootElement(name = "cartao")
public class Cartao {

    @XmlElement(required = true)
    protected String numeroCartao;
    protected String mesValidade;
    protected String anoValidade;
    @XmlElement(required = true)
    protected String codigoSeguranca;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String bandeira;

    /**
     * Obtém o valor da propriedade numeroCartao.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroCartao() {
        return numeroCartao;
    }

    /**
     * Define o valor da propriedade numeroCartao.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroCartao(String value) {
        this.numeroCartao = value;
    }

    /**
     * Obtém o valor da propriedade mesValidade.
     * 
     */
    public String getMesValidade() {
        return mesValidade;
    }

    /**
     * Define o valor da propriedade mesValidade.
     * 
     */
    public void setMesValidade(String value) {
        this.mesValidade = value;
    }

    /**
     * Obtém o valor da propriedade anoValidade.
     * 
     */
    public String getAnoValidade() {
        return anoValidade;
    }

    /**
     * Define o valor da propriedade anoValidade.
     * 
     */
    public void setAnoValidade(String value) {
        this.anoValidade = value;
    }

    /**
     * Obtém o valor da propriedade codigoSeguranca.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public String getCodigoSeguranca() {
        return codigoSeguranca;
    }

    /**
     * Define o valor da propriedade codigoSeguranca.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCodigoSeguranca(String value) {
        this.codigoSeguranca = value;
    }

    /**
     * Obtém o valor da propriedade bandeira.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBandeira() {
        return bandeira;
    }

    /**
     * Define o valor da propriedade bandeira.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBandeira(String value) {
        this.bandeira = value;
    }

}
