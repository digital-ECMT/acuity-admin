package com.acuity.visualisations.dal.dao.aml;

import com.acuity.visualisations.dal.ACUITYDaoSupport;
import com.acuity.visualisations.model.aml.AdverseEvent;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static java.util.Collections.emptyList;

@Repository("amlAdverseEventDao")
public class AdverseEventDao extends ACUITYDaoSupport {

    @Transactional(readOnly = true)
    public List<AdverseEvent> getByStudyId(String studyId) {
        String query = " SELECT DISTINCT "
                + "AE_ID, PAT_ID, AES_START_DATE, AES_END_DATE, "
                + "CASE WHEN (UPPER(EVT_PT) = 'DIARRHOEA') THEN 1  ELSE 0 END AS DIARRHOEA "
                + "FROM result_ae ae "
                + "INNER JOIN result_ae_severity aes "
                + "ON (aes_ae_id = ae_id) "
                + "INNER JOIN result_event_type evt "
                + "ON (ae_evt_id = evt_id) "
                + "INNER JOIN result_patient pat "
                + "ON (ae_pat_id = pat_id) "
                + "INNER JOIN result_study std "
                + "ON (pat_std_id = std_id) "
                + "WHERE pat_ip_dose_first_date IS NOT NULL AND std_name = ?";
        return Optional.ofNullable(getJdbcTemplate()
                .query(query,
                        (rs, i) -> AdverseEvent.builder()
                                .id(rs.getString("AE_ID"))
                                .studyId(studyId)
                                .subject(rs.getString("PAT_ID"))
                                .diarrhoea(rs.getBoolean("DIARRHOEA"))
                                .startDate(rs.getDate("AES_START_DATE"))
                                .endDate(rs.getDate("AES_END_DATE"))
                                .build(),
                        studyId))
                .orElse(emptyList());
    }

}
