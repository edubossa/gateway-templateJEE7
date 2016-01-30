package br.com.ntk.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "enderecoIP",
    "nomePortadorCartao",
    "cpfPortadorCartao",
    "dataNascimentoPortadorCartao"
})
@XmlRootElement(name = "comprador")
public class Comprador {

    protected String enderecoIP;
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String nomePortadorCartao;
    protected String cpfPortadorCartao;
    protected String dataNascimentoPortadorCartao;

    /**
     * Obtém o valor da propriedade enderecoIP.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnderecoIP() {
        return enderecoIP;
    }

    /**
     * Define o valor da propriedade enderecoIP.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnderecoIP(String value) {
        this.enderecoIP = value;
    }

    /**
     * Obtém o valor da propriedade nomePortadorCartao.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomePortadorCartao() {
        return nomePortadorCartao;
    }

    /**
     * Define o valor da propriedade nomePortadorCartao.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomePortadorCartao(String value) {
        this.nomePortadorCartao = value;
    }

    /**
     * Obtém o valor da propriedade cpfPortadorCartao.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCpfPortadorCartao() {
        return cpfPortadorCartao;
    }

    /**
     * Define o valor da propriedade cpfPortadorCartao.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCpfPortadorCartao(String value) {
        this.cpfPortadorCartao = value;
    }

    /**
     * Obtém o valor da propriedade dataNascimentoPortadorCartao.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataNascimentoPortadorCartao() {
        return dataNascimentoPortadorCartao;
    }

    /**
     * Define o valor da propriedade dataNascimentoPortadorCartao.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataNascimentoPortadorCartao(String value) {
        this.dataNascimentoPortadorCartao = value;
    }

}
