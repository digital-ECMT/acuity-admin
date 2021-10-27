package com.acuity.visualisations.mapping.dao.impl;

import com.acuity.visualisations.dal.ACUITYDaoSupport;
import com.acuity.visualisations.mapping.dao.IClinicalStudyDao;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ClinicalStudyDao extends ACUITYDaoSupport implements IClinicalStudyDao {

    private static final String MERGE_SQL = "with t_dual as (SELECT ? as id, ? as name, ? as project), "
            + "upd as ( "
            + "update map_clinical_study as mc "
            + "set mcs_study_name = t.name "
            + "from t_dual as t "
            + "where mc.mcs_study_id = t.id "
            + "and "
            + "mc.mcs_mpr_id = t.project "
            + "returning * ) "
            + "insert into map_clinical_study (mcs_study_id, mcs_study_name, mcs_mpr_id) "
            + "select d.id, d.name, d.project "
            + "from t_dual as d "
            + "where not exists (select * from upd as u where u.mcs_study_id = d.id and u.mcs_mpr_id = d.project)";

    @Override
    @Transactional
    public void insertOrUpdateClinicalStudy(Long projectId, String id, String name) {
        if (projectId == null) {
            throw new IllegalArgumentException("Project ID cannot be empty");
        }
        if (!StringUtils.isEmpty(id)) {
            getJdbcTemplate().update(MERGE_SQL, id, name, projectId);
        }
    }
}
