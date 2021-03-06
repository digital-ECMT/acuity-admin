/*
 * Copyright 2021 The University of Manchester
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.07.04 at 08:28:32 PM MSK 
//


package com.acuity.visualisations.transform.ndtrule;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NDTColumnRule complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="NDTColumnRule">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.example.org/NewDataTransformation}NDTNamedRule">
 *       &lt;attribute name="field" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="fmtname" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="fmtdefault" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="helper" type="{http://www.example.org/NewDataTransformation}NDTparserRule" default="MonthFirst" />
 *       &lt;attribute name="default" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="part" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="aggrFunction" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="radio" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NDTColumnRule")
public class NDTColumnRule
        extends NDTNamedRule {

    @XmlAttribute
    protected String field;
    @XmlAttribute
    protected String fmtname;
    @XmlAttribute
    protected String fmtdefault;
    @XmlAttribute
    protected String type;
    @XmlAttribute
    protected NDTparserRule helper;
    @XmlAttribute(name = "default")
    protected String _default;
    @XmlAttribute
    protected Boolean part;
    @XmlAttribute
    protected String aggrFunction;
    @XmlAttribute
    protected Boolean radio;

    /**
     * Gets the value of the field property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getField() {
        return field;
    }

    /**
     * Sets the value of the field property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setField(String value) {
        this.field = value;
    }

    /**
     * Gets the value of the fmtname property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getFmtname() {
        return fmtname;
    }

    /**
     * Sets the value of the fmtname property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setFmtname(String value) {
        this.fmtname = value;
    }

    /**
     * Gets the value of the fmtdefault property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getFmtdefault() {
        return fmtdefault;
    }

    /**
     * Sets the value of the fmtdefault property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setFmtdefault(String value) {
        this.fmtdefault = value;
    }

    /**
     * Gets the value of the type property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the helper property.
     *
     * @return possible object is
     *         {@link NDTparserRule }
     */
    public NDTparserRule getHelper() {
        if (helper == null) {
            return NDTparserRule.MONTH_FIRST;
        } else {
            return helper;
        }
    }

    /**
     * Sets the value of the helper property.
     *
     * @param value allowed object is
     *              {@link NDTparserRule }
     */
    public void setHelper(NDTparserRule value) {
        this.helper = value;
    }

    /**
     * Gets the value of the default property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getDefault() {
        return _default;
    }

    /**
     * Sets the value of the default property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDefault(String value) {
        this._default = value;
    }

    /**
     * Gets the value of the part property.
     *
     * @return possible object is
     *         {@link Boolean }
     */
    public Boolean isPart() {
        return part;
    }

    /**
     * Sets the value of the part property.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setPart(Boolean value) {
        this.part = value;
    }

    /**
     * Gets the value of the aggrFunction property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getAggrFunction() {
        return aggrFunction;
    }

    /**
     * Sets the value of the aggrFunction property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAggrFunction(String value) {
        this.aggrFunction = value;
    }

    /**
     * Gets the value of the radio property.
     *
     * @return possible object is
     *         {@link Boolean }
     */
    public boolean isRadio() {
        if (radio == null) {
            return false;
        } else {
            return radio;
        }
    }

    /**
     * Sets the value of the radio property.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setRadio(Boolean value) {
        this.radio = value;
    }

}
