
package com.acuity.visualisations.dal.dao;

import com.acuity.visualisations.dal.EntityDao;
import com.acuity.visualisations.dal.util.QueryBuilderUtil;
import com.acuity.visualisations.dal.util.TableField;
import com.acuity.visualisations.dal.util.TableFieldBuilder;
import com.acuity.visualisations.model.output.entities.LiverRiskFactors;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Repository;

import static com.acuity.visualisations.data.util.Util.getSQLTimestamp;

@Repository
public class LiverRiskFactorsDao extends EntityDao<LiverRiskFactors> {
    private static final String TABLE = "RESULT_LIVER_RISK_FACTORS";
    private static final String PREFIX = "lrf";
    private static final String ID = PREFIX + "_id";


    @Override
    public String getTableName() {
        return TABLE;
    }

    @Override
    public String getTablePrefix() {
        return PREFIX;
    }

    @Override
    protected String getIdColumnName() {
        return ID;
    }

    @Override
    public List<String> getSubjectsIdsByStudyName(String studyName) {
        return getJdbcTemplate().queryForList("select distinct pat_id "
                + " from " + TABLE
                + " join result_patient ON pat_id=" + PREFIX + "_pat_id "
                + " join result_study ON std_id=pat_std_id "
                + " where std_name=?", String.class, studyName);
    }

    @Override
    protected String getHashesStatement(Class<?> entityClass) {
        return " select " + PREFIX + "_unq_sha1, " + PREFIX + "_sec_hash, " + ID
                + " from " + TABLE
                + " join result_patient on pat_id=" + PREFIX + "_pat_id "
                + " where pat_std_id=?";
    }


    @Override
    protected String getInsertStatement() {
        String targetTable = TABLE;
        TableFieldBuilder fieldBuilder = new TableFieldBuilder(targetTable);

        List<TableField> fieldsToInsert = Arrays.asList(
                fieldBuilder.setField(PREFIX + "_id").build(),
                fieldBuilder.setField(PREFIX + "_unq_sha1").build(),
                fieldBuilder.setField(PREFIX + "_sec_hash").build(),
                fieldBuilder.setField(PREFIX + "_date_created").build(),
                fieldBuilder.setField(PREFIX + "_date_updated").build(),
                fieldBuilder.setField(PREFIX + "_pat_id").build(),

                fieldBuilder.setField("lrf_pot_hys_law_case_num").build(),
                fieldBuilder.setField("lrf_value").build(),
                fieldBuilder.setField("lrf_occur").build(),
                fieldBuilder.setField("lrf_ref_period").build(),
                fieldBuilder.setField("lrf_details").build(),
                fieldBuilder.setField("lrf_start_date").build(),
                fieldBuilder.setField("lrf_stop_date").build(),
                fieldBuilder.setField("lrf_comment").build()


        );

        return QueryBuilderUtil.buildInsertQuery(targetTable, fieldsToInsert);
    }


    @Override
    protected String getUpdateStatement() {
        String targetTable = TABLE;
        TableFieldBuilder fieldBuilder = new TableFieldBuilder(targetTable);
        List<TableField> fieldsToSet = Arrays.asList(
                fieldBuilder.setField(PREFIX + "_sec_hash").build(),
                fieldBuilder.setField(PREFIX + "_date_updated").build(),

                fieldBuilder.setField("lrf_pot_hys_law_case_num").build(),
                fieldBuilder.setField("lrf_value").build(),
                fieldBuilder.setField("lrf_occur").build(),
                fieldBuilder.setField("lrf_ref_period").build(),
                fieldBuilder.setField("lrf_details").build(),
                fieldBuilder.setField("lrf_start_date").build(),
                fieldBuilder.setField("lrf_stop_date").build(),
                fieldBuilder.setField("lrf_comment").build()

        );
        List<TableField> whereFields = Arrays.asList(fieldBuilder.setField(ID).build());
        return QueryBuilderUtil.buildUpdateQuery(targetTable, fieldsToSet, whereFields);
    }


    @Override
    protected void prepareStatementToInsert(PreparedStatement ps, LiverRiskFactors entity) throws SQLException {
        int paramIndex = 1;
        ps.setString(paramIndex++, entity.getId());
        ps.setString(paramIndex++, entity.getSha1ForUniqueFields());
        ps.setObject(paramIndex++, entity.getIntHashForSecondaryFields());
        ps.setTimestamp(paramIndex++, getSQLTimestamp(entity.getDateCreated()));
        ps.setTimestamp(paramIndex++, getSQLTimestamp(entity.getDateUpdated()));
        ps.setString(paramIndex++, entity.getPatientGuid());

        ps.setObject(paramIndex++, entity.getPotentialHysLawCaseNumber());
        ps.setString(paramIndex++, entity.getLiverRiskFactor());
        ps.setString(paramIndex++, entity.getOccurrence());
        ps.setString(paramIndex++, entity.getReferencePeriod());
        ps.setString(paramIndex++, entity.getDetails());
        ps.setTimestamp(paramIndex++, getSQLTimestamp(entity.getStartDate()));
        ps.setTimestamp(paramIndex++, getSQLTimestamp(entity.getStopDate()));
        ps.setString(paramIndex, entity.getComment());

    }


    @Override
    protected void prepareStatementToUpdate(PreparedStatement ps, LiverRiskFactors entity) throws SQLException {
        int paramIndex = 1;
        ps.setObject(paramIndex++, entity.getIntHashForSecondaryFields());
        ps.setTimestamp(paramIndex++, getSQLTimestamp(entity.getDateUpdated()));

        ps.setObject(paramIndex++, entity.getPotentialHysLawCaseNumber());
        ps.setString(paramIndex++, entity.getLiverRiskFactor());
        ps.setString(paramIndex++, entity.getOccurrence());
        ps.setString(paramIndex++, entity.getReferencePeriod());
        ps.setString(paramIndex++, entity.getDetails());
        ps.setTimestamp(paramIndex++, getSQLTimestamp(entity.getStartDate()));
        ps.setTimestamp(paramIndex++, getSQLTimestamp(entity.getStopDate()));
        ps.setString(paramIndex, entity.getComment());

    }
}
