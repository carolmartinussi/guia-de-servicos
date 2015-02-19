//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.02.06 at 04:52:01 PM BRST 
//


package br.gov.servicos.legado;

import br.gov.servicos.dominio.Orgao;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * <p>Java class for servicoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="servicoType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="titulo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="descricao" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="requisitos">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="requisito" type="{}requisitoType" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="etapas" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="canaisPrestacaoServico" type="{}canaisPrestacaoServicoType"/>
 *         &lt;element name="taxa" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="informacoesUteis">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="informacaoUtil" type="{}informacaoUtilType" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="compromissosAtendimento" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="legislacoes" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="palavrasChave" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="orgaoResponsavel" type="{}orgaoResponsavelType"/>
 *         &lt;element name="orgaoPrestador" type="{}orgaoPrestadorType"/>
 *         &lt;element name="publicosAlvo" type="{}publicosAlvoType"/>
 *         &lt;element name="areasInteresse" type="{}areasInteresseType" minOccurs="0"/>
 *         &lt;element name="errosAcesso" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="quantidadeAcessosServico" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "servicoType", propOrder = {
    "titulo",
    "descricao",
    "requisitos",
    "etapas",
    "canaisPrestacaoServico",
    "taxa",
    "informacoesUteis",
    "compromissosAtendimento",
    "legislacoes",
    "palavrasChave",
    "orgaoResponsavel",
    "orgaoPrestador",
    "publicosAlvo",
    "areasInteresse",
    "errosAcesso",
    "quantidadeAcessosServico"
})
public class ServicoType {

    public List<String> getAreasDeInteresse() {
        AreasInteresseType areasInteresseType = this.getAreasInteresse();
        if(areasInteresseType == null) {
            return Arrays.asList();
        }

        return areasInteresseType.getArea().stream().map(AreaType::getTitulo).collect(Collectors.toList());
    }

    public String getUrl() {
        String url = null;

        if (this.getCanaisPrestacaoServico() == null || this.getCanaisPrestacaoServico().getCanalPrestacaoServico() == null) {
            return null;
        }

        for (CanalPrestacaoServicoType canal : this.getCanaisPrestacaoServico().getCanalPrestacaoServico()) {
            if(canal.getUrl() != null) {
                return canal.getUrl();
            }
        }
        
        return null;
    }

    public Orgao getOrgaoPrestador2() {
        OrgaoPrestadorType prestador = this.getOrgaoPrestador();
        String nome = prestador == null ? null : prestador.getTitulo();
        String telefone = prestador == null ? null : prestador.getTelefone();

        return new Orgao(nome, telefone);
    }

    public Orgao getOrgaoResponsavel2() {
        OrgaoResponsavelType responsavel = this.getOrgaoResponsavel();
        return responsavel == null ? null : new Orgao(responsavel.getTitulo(), null);
    }

    public List<String> getLinhasDaVida() {
        PublicosAlvoType publicosAlvoType = this.getPublicosAlvo();
        if (publicosAlvoType == null) return Arrays.asList();

        List<Serializable> publicosAlvo = publicosAlvoType.getContent();
        if (publicosAlvo == null || publicosAlvo.isEmpty()) return Arrays.asList();

        JAXBElement element = (JAXBElement) publicosAlvo.get(0);
        if (element == null) return Arrays.asList();

        PublicoAlvoType publicoAlvo = (PublicoAlvoType) element.getValue();
        if (publicoAlvo == null) return Arrays.asList();

        LinhasDaVivaType linhasDaViva = publicoAlvo.getLinhasDaViva();
        if (linhasDaViva == null) return Arrays.asList();

        List<LinhaDaVidaType> linhaDaVida = linhasDaViva.getLinhaDaVida();
        if(linhaDaVida == null) return Arrays.asList();

        return linhaDaVida.stream()
                .map(LinhaDaVidaType::getTitulo)
                .collect(Collectors.toList());
    }
    
    @XmlElement(required = true)
    protected String titulo;
    @XmlElement(required = true)
    protected String descricao;
    @XmlElement(required = true)
    protected Requisitos requisitos;
    @XmlElement(required = true)
    protected String etapas;
    @XmlElement(required = true)
    protected CanaisPrestacaoServicoType canaisPrestacaoServico;
    @XmlElement(required = true)
    protected String taxa;
    @XmlElement(required = true)
    protected InformacoesUteis informacoesUteis;
    @XmlElement(required = true)
    protected String compromissosAtendimento;
    @XmlElement(required = true)
    protected String legislacoes;
    @XmlElement(required = true)
    protected String palavrasChave;
    @XmlElement(required = true)
    protected OrgaoResponsavelType orgaoResponsavel;
    @XmlElement(required = true)
    protected OrgaoPrestadorType orgaoPrestador;
    @XmlElement(required = true)
    protected PublicosAlvoType publicosAlvo;
    protected AreasInteresseType areasInteresse;
    @XmlElement(required = true)
    protected String errosAcesso;
    @XmlElement(required = true)
    protected String quantidadeAcessosServico;

    /**
     * Gets the value of the titulo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Sets the value of the titulo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitulo(String value) {
        this.titulo = value;
    }

    /**
     * Gets the value of the descricao property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Sets the value of the descricao property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescricao(String value) {
        this.descricao = value;
    }

    /**
     * Gets the value of the requisitos property.
     * 
     * @return
     *     possible object is
     *     {@link ServicoType.Requisitos }
     *     
     */
    public Requisitos getRequisitos() {
        return requisitos;
    }

    /**
     * Sets the value of the requisitos property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServicoType.Requisitos }
     *     
     */
    public void setRequisitos(Requisitos value) {
        this.requisitos = value;
    }

    /**
     * Gets the value of the etapas property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEtapas() {
        return etapas;
    }

    /**
     * Sets the value of the etapas property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEtapas(String value) {
        this.etapas = value;
    }

    /**
     * Gets the value of the canaisPrestacaoServico property.
     * 
     * @return
     *     possible object is
     *     {@link CanaisPrestacaoServicoType }
     *     
     */
    public CanaisPrestacaoServicoType getCanaisPrestacaoServico() {
        return canaisPrestacaoServico;
    }

    /**
     * Sets the value of the canaisPrestacaoServico property.
     * 
     * @param value
     *     allowed object is
     *     {@link CanaisPrestacaoServicoType }
     *     
     */
    public void setCanaisPrestacaoServico(CanaisPrestacaoServicoType value) {
        this.canaisPrestacaoServico = value;
    }

    /**
     * Gets the value of the taxa property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaxa() {
        return taxa;
    }

    /**
     * Sets the value of the taxa property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaxa(String value) {
        this.taxa = value;
    }

    /**
     * Gets the value of the informacoesUteis property.
     * 
     * @return
     *     possible object is
     *     {@link ServicoType.InformacoesUteis }
     *     
     */
    public InformacoesUteis getInformacoesUteis() {
        return informacoesUteis;
    }

    /**
     * Sets the value of the informacoesUteis property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServicoType.InformacoesUteis }
     *     
     */
    public void setInformacoesUteis(InformacoesUteis value) {
        this.informacoesUteis = value;
    }

    /**
     * Gets the value of the compromissosAtendimento property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompromissosAtendimento() {
        return compromissosAtendimento;
    }

    /**
     * Sets the value of the compromissosAtendimento property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompromissosAtendimento(String value) {
        this.compromissosAtendimento = value;
    }

    /**
     * Gets the value of the legislacoes property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLegislacoes() {
        return legislacoes;
    }

    /**
     * Sets the value of the legislacoes property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLegislacoes(String value) {
        this.legislacoes = value;
    }

    /**
     * Gets the value of the palavrasChave property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPalavrasChave() {
        return palavrasChave;
    }

    /**
     * Sets the value of the palavrasChave property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPalavrasChave(String value) {
        this.palavrasChave = value;
    }

    /**
     * Gets the value of the orgaoResponsavel property.
     * 
     * @return
     *     possible object is
     *     {@link OrgaoResponsavelType }
     *     
     */
    public OrgaoResponsavelType getOrgaoResponsavel() {
        return orgaoResponsavel;
    }

    /**
     * Sets the value of the orgaoResponsavel property.
     * 
     * @param value
     *     allowed object is
     *     {@link OrgaoResponsavelType }
     *     
     */
    public void setOrgaoResponsavel(OrgaoResponsavelType value) {
        this.orgaoResponsavel = value;
    }

    /**
     * Gets the value of the orgaoPrestador property.
     * 
     * @return
     *     possible object is
     *     {@link OrgaoPrestadorType }
     *     
     */
    public OrgaoPrestadorType getOrgaoPrestador() {
        return orgaoPrestador;
    }

    /**
     * Sets the value of the orgaoPrestador property.
     * 
     * @param value
     *     allowed object is
     *     {@link OrgaoPrestadorType }
     *     
     */
    public void setOrgaoPrestador(OrgaoPrestadorType value) {
        this.orgaoPrestador = value;
    }

    /**
     * Gets the value of the publicosAlvo property.
     * 
     * @return
     *     possible object is
     *     {@link PublicosAlvoType }
     *     
     */
    public PublicosAlvoType getPublicosAlvo() {
        return publicosAlvo;
    }

    /**
     * Sets the value of the publicosAlvo property.
     * 
     * @param value
     *     allowed object is
     *     {@link PublicosAlvoType }
     *     
     */
    public void setPublicosAlvo(PublicosAlvoType value) {
        this.publicosAlvo = value;
    }

    /**
     * Gets the value of the areasInteresse property.
     * 
     * @return
     *     possible object is
     *     {@link AreasInteresseType }
     *     
     */
    public AreasInteresseType getAreasInteresse() {
        return areasInteresse;
    }

    /**
     * Sets the value of the areasInteresse property.
     * 
     * @param value
     *     allowed object is
     *     {@link AreasInteresseType }
     *     
     */
    public void setAreasInteresse(AreasInteresseType value) {
        this.areasInteresse = value;
    }

    /**
     * Gets the value of the errosAcesso property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrosAcesso() {
        return errosAcesso;
    }

    /**
     * Sets the value of the errosAcesso property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrosAcesso(String value) {
        this.errosAcesso = value;
    }

    /**
     * Gets the value of the quantidadeAcessosServico property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQuantidadeAcessosServico() {
        return quantidadeAcessosServico;
    }

    /**
     * Sets the value of the quantidadeAcessosServico property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQuantidadeAcessosServico(String value) {
        this.quantidadeAcessosServico = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="informacaoUtil" type="{}informacaoUtilType" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "content"
    })
    public static class InformacoesUteis {

        @XmlElementRef(name = "informacaoUtil", type = JAXBElement.class, required = false)
        @XmlMixed
        protected List<Serializable> content;

        /**
         * Gets the value of the content property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the content property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getContent().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * {@link JAXBElement }{@code <}{@link InformacaoUtilType }{@code >}
         * 
         * 
         */
        public List<Serializable> getContent() {
            if (content == null) {
                content = new ArrayList<Serializable>();
            }
            return this.content;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="requisito" type="{}requisitoType" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "content"
    })
    public static class Requisitos {

        @XmlElementRef(name = "requisito", type = JAXBElement.class, required = false)
        @XmlMixed
        protected List<Serializable> content;

        /**
         * Gets the value of the content property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the content property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getContent().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link JAXBElement }{@code <}{@link RequisitoType }{@code >}
         * {@link String }
         * 
         * 
         */
        public List<Serializable> getContent() {
            if (content == null) {
                content = new ArrayList<Serializable>();
            }
            return this.content;
        }

    }

}
