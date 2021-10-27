//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.07.02 at 08:28:42 PM MSK 
//


package com.acuity.visualisations.transform.table;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for TableRule complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="TableRule">
 *   &lt;complexContent>
 *     &lt;extension base="{http://visualisations.acuity.com/TablesDescription}TableBaseRule">
 *       &lt;sequence>
 *         &lt;element name="foreignKey" type="{http://visualisations.acuity.com/TablesDescription}ForeignKeyRule" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="uniqueFields" type="{http://visualisations.acuity.com/TablesDescription}TableFieldSetRule"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TableRule", propOrder = {
        "foreignKey",
        "uniqueFields"
})
public class TableRule
        extends TableBaseRule {

    protected List<ForeignKeyRule> foreignKey;
    @XmlElement(required = true)
    protected TableFieldSetRule uniqueFields;

    /**
     * Gets the value of the foreignKey property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the foreignKey property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getForeignKey().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link ForeignKeyRule }
     */
    public List<ForeignKeyRule> getForeignKey() {
        if (foreignKey == null) {
            foreignKey = new ArrayList<ForeignKeyRule>();
        }
        return this.foreignKey;
    }

    /**
     * Gets the value of the uniqueFields property.
     *
     * @return possible object is
     *         {@link TableFieldSetRule }
     */
    public TableFieldSetRule getUniqueFields() {
        return uniqueFields;
    }

    /**
     * Sets the value of the uniqueFields property.
     *
     * @param value allowed object is
     *              {@link TableFieldSetRule }
     */
    public void setUniqueFields(TableFieldSetRule value) {
        this.uniqueFields = value;
    }

}