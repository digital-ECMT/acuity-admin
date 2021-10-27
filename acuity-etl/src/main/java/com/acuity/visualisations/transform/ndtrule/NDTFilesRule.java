//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.07.04 at 08:28:32 PM MSK 
//


package com.acuity.visualisations.transform.ndtrule;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for NDTFilesRule complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="NDTFilesRule">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.example.org/NewDataTransformation}NDTNamedRule">
 *       &lt;sequence>
 *         &lt;element name="file" type="{http://www.example.org/NewDataTransformation}NDTFileRule" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NDTFilesRule", propOrder = {
        "file"
})
public class NDTFilesRule
        extends NDTNamedRule {

    @XmlElement(required = true)
    protected List<NDTFileRule> file;

    /**
     * Gets the value of the file property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the file property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFile().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link NDTFileRule }
     */
    public List<NDTFileRule> getFile() {
        if (file == null) {
            file = new ArrayList<NDTFileRule>();
        }
        return this.file;
    }

}
