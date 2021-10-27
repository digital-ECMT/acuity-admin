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

package com.acuity.visualisations.web.service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Map;

/**
 * Gets the help text for UI elements from HelpRepository
 */
public interface IHelpService {

    /**
     * Gets the help text from {@link com.acuity.visualisations.web.dao.HelpDao}
     *
     * @return The help text from {@link com.acuity.visualisations.web.dao.HelpDao}
     *         as a HashMap with the JSP page as the key and a value containing a map
     *         of HTML element and help text as the value.
     * @throws IOException   Thrown when loading the help.xml file
     * @throws JAXBException Thrown when parsing the help.xml file
     */
    Map<String, Map<String, String>> getHelp() throws JAXBException, IOException;
}
