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
// Generated on: 2013.07.30 at 02:29:23 PM MSK 
//

package com.acuity.visualisations.transform.rule;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * This object contains factory methods for each Java content interface and Java element interface generated in the
 * com.acuity.visualisations.transform.rule package.
 * <p/>
 * An ObjectFactory allows you to programatically construct new instances of the Java representation for XML content. The Java
 * representation of XML content can consist of schema derived interfaces and classes representing the binding of schema type definitions,
 * element declarations and model groups. Factory methods for each of these are provided in this class.
 */
@XmlRegistry
public class ObjectFactory {

    private static final QName ROOT_QNAME = new QName("http://visualisations.acuity.com/DataTransformation", "root");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package:
     * com.acuity.visualisations.transform.rule
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Mapper }
     */
    public Mapper createMapper() {
        return new Mapper();
    }

    /**
     * Create an instance of {@link EntityRule }
     */
    public EntityRule createEntityRule() {
        return new EntityRule();
    }

    /**
     * Create an instance of {@link FilterRule }
     */
    public FilterRule createFilterRule() {
        return new FilterRule();
    }

    /**
     * Create an instance of {@link ValueRule }
     */
    public ValueRule createValueRule() {
        return new ValueRule();
    }

    /**
     * Create an instance of {@link RootRule }
     */
    public RootRule createRootRule() {
        return new RootRule();
    }

    /**
     * Create an instance of {@link DataFileRule }
     */
    public DataFileRule createDataFileRule() {
        return new DataFileRule();
    }

    /**
     * Create an instance of {@link NamedRule }
     */
    public NamedRule createNamedRule() {
        return new NamedRule();
    }

    /**
     * Create an instance of {@link ProjectRule }
     */
    public ProjectRule createProjectRule() {
        return new ProjectRule();
    }

    /**
     * Create an instance of {@link ColumnRule }
     */

    public ColumnRule createColumnRule() {
        return new ColumnRule();
    }

    /**
     * Create an instance of {@link StudyRule }
     */
    public StudyRule createStudyRule() {
        return new StudyRule();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RootRule }{@code >}
     */
    @XmlElementDecl(namespace = "http://visualisations.acuity.com/DataTransformation", name = "root")
    public JAXBElement<RootRule> createRoot(RootRule value) {
        return new JAXBElement<RootRule>(ROOT_QNAME, RootRule.class, null, value);
    }

}
