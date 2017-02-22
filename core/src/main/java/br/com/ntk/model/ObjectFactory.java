//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2015.09.08 às 03:42:19 PM BRT 
//


package br.com.ntk.model;

import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.com.ntk.model package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _DataNascimentoPortadorCartao_QNAME = new QName("", "dataNascimentoPortadorCartao");
    private final static QName _EnderecoIP_QNAME = new QName("", "enderecoIP");
    private final static QName _TokenIntencao_QNAME = new QName("", "tokenIntencao");
    private final static QName _ParcelamentoAdm_QNAME = new QName("", "parcelamentoAdm");
    private final static QName _ValorTransacao_QNAME = new QName("", "valorTransacao");
    private final static QName _TipoOperacao_QNAME = new QName("", "tipoOperacao");
    private final static QName _CpfPortadorCartao_QNAME = new QName("", "cpfPortadorCartao");
    private final static QName _Captura_QNAME = new QName("", "captura");
    private final static QName _Token_QNAME = new QName("", "token");
    private final static QName _Moeda_QNAME = new QName("", "moeda");
    private final static QName _DescVenda_QNAME = new QName("", "desc-venda");
    private final static QName _NomePortadorCartao_QNAME = new QName("", "nomePortadorCartao");
    private final static QName _Usuario_QNAME = new QName("", "usuario");
    private final static QName _NumeroDocumento_QNAME = new QName("", "numeroDocumento");
    private final static QName _QtdeParcelas_QNAME = new QName("", "qtdeParcelas");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.com.ntk.model
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Transacao }
     * 
     */
    public Transacao createTransacao() {
        return new Transacao();
    }

    /**
     * Create an instance of {@link Cartao }
     * 
     */
    public Cartao createCartao() {
        return new Cartao();
    }

    /**
     * Create an instance of {@link Comprador }
     * 
     */
    public Comprador createComprador() {
        return new Comprador();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "dataNascimentoPortadorCartao")
    public JAXBElement<String> createDataNascimentoPortadorCartao(String value) {
        return new JAXBElement<String>(_DataNascimentoPortadorCartao_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "enderecoIP")
    public JAXBElement<String> createEnderecoIP(String value) {
        return new JAXBElement<String>(_EnderecoIP_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "tokenIntencao")
    public JAXBElement<String> createTokenIntencao(String value) {
        return new JAXBElement<String>(_TokenIntencao_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "parcelamentoAdm")
    public JAXBElement<String> createParcelamentoAdm(String value) {
        return new JAXBElement<String>(_ParcelamentoAdm_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "valorTransacao")
    public JAXBElement<Long> createValorTransacao(Long value) {
        return new JAXBElement<Long>(_ValorTransacao_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "tipoOperacao")
    public JAXBElement<BigInteger> createTipoOperacao(BigInteger value) {
        return new JAXBElement<BigInteger>(_TipoOperacao_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "cpfPortadorCartao")
    public JAXBElement<String> createCpfPortadorCartao(String value) {
        return new JAXBElement<String>(_CpfPortadorCartao_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "captura")
    public JAXBElement<String> createCaptura(String value) {
        return new JAXBElement<String>(_Captura_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "token")
    public JAXBElement<String> createToken(String value) {
        return new JAXBElement<String>(_Token_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "moeda")
    public JAXBElement<BigInteger> createMoeda(BigInteger value) {
        return new JAXBElement<BigInteger>(_Moeda_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "desc-venda")
    public JAXBElement<String> createDescVenda(String value) {
        return new JAXBElement<String>(_DescVenda_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "nomePortadorCartao")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    public JAXBElement<String> createNomePortadorCartao(String value) {
        return new JAXBElement<String>(_NomePortadorCartao_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "usuario")
    public JAXBElement<String> createUsuario(String value) {
        return new JAXBElement<String>(_Usuario_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "numeroDocumento")
    public JAXBElement<String> createNumeroDocumento(String value) {
        return new JAXBElement<String>(_NumeroDocumento_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "qtdeParcelas")
    public JAXBElement<Integer> createQtdeParcelas(Integer value) {
        return new JAXBElement<Integer>(_QtdeParcelas_QNAME, Integer.class, null, value);
    }

}
