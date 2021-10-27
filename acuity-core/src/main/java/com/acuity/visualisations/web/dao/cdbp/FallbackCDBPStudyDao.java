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

package com.acuity.visualisations.web.dao.cdbp;

import com.acuity.visualisations.mapping.dao.QuerySearchWorker;
import com.acuity.visualisations.mapping.entity.StudyRule;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Profile("!cdbp")
@Repository
public class FallbackCDBPStudyDao implements CDBPStudyDao {

    @Override
    public void fillSearchQueryWorker(String query, QuerySearchWorker<StudyRule> worker) {
        // implementation ignore
    }

    @Override
    public List<StudyRule> searchExactStudy(String query) {
        return new ArrayList<>();
    }

    @Override
    public List<String> getStudyCodes() {
        return new ArrayList<>();
    }
}
