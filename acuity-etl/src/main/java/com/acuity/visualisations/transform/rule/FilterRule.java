//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.07.30 at 02:29:23 PM MSK 
//


package com.acuity.visualisations.transform.rule;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FilterRule complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="FilterRule">
 *   &lt;complexContent>
 *     &lt;extension base="{http://visualisations.acuity.com/DataTransformation}NamedRule">
 *       &lt;attribute name="equal" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FilterRule")
public class FilterRule
        extends NamedRule {

    @XmlAttribute
    protected String equal;

    /**
     * Gets the value of the equal property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getEqual() {
        return equal;
    }

    /**
     * Sets the value of the equal property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setEqual(String value) {
        this.equal = value;
    }

}
