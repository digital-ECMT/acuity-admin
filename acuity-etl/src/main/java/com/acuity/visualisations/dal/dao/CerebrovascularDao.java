
package com.acuity.visualisations.dal.dao;

import com.acuity.visualisations.dal.EntityDao;
import com.acuity.visualisations.dal.util.QueryBuilderUtil;
import com.acuity.visualisations.dal.util.TableField;
import com.acuity.visualisations.dal.util.TableFieldBuilder;
import com.acuity.visualisations.model.output.entities.Cerebrovascular;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Repository;

import static com.acuity.visualisations.data.util.Util.getSQLTimestamp;

@Repository
public class CerebrovascularDao extends EntityDao<Cerebrovascular> {
    private static final String TABLE = "RESULT_CEREBROVASCULAR";
    private static final String PREFIX = "cer";
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

                fieldBuilder.setField("CER_AE_NUM").build(),
                fieldBuilder.setField("CER_START_DATE").build(),
                fieldBuilder.setField("CER_TERM").build(),
                fieldBuilder.setField("CER_EVENT_TYPE").build(),
                fieldBuilder.setField("CER_PRIM_ISCHEMIC_STROKE").build(),
                fieldBuilder.setField("CER_TRAUMATIC").build(),
                fieldBuilder.setField("CER_LOC_INTRA_HEMORRHAGE").build(),
                fieldBuilder.setField("CER_LOC_INTRA_HEMORRHAGE_OTH").build(),
                fieldBuilder.setField("CER_SYMPTOMS_DURATION").build(),
                fieldBuilder.setField("CER_MRS_PRIOR_TO_STROKE").build(),
                fieldBuilder.setField("CER_MRS_STROKE_HOSPITAL").build(),
                fieldBuilder.setField("CER_MRS_CUR_VISIT_90D_AFTER").build(),
                fieldBuilder.setField("CER_COMMENT").build()
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

                fieldBuilder.setField("CER_AE_NUM").build(),
                fieldBuilder.setField("CER_START_DATE").build(),
                fieldBuilder.setField("CER_TERM").build(),
                fieldBuilder.setField("CER_EVENT_TYPE").build(),
                fieldBuilder.setField("CER_PRIM_ISCHEMIC_STROKE").build(),
                fieldBuilder.setField("CER_TRAUMATIC").build(),
                fieldBuilder.setField("CER_LOC_INTRA_HEMORRHAGE").build(),
                fieldBuilder.setField("CER_LOC_INTRA_HEMORRHAGE_OTH").build(),
                fieldBuilder.setField("CER_SYMPTOMS_DURATION").build(),
                fieldBuilder.setField("CER_MRS_PRIOR_TO_STROKE").build(),
                fieldBuilder.setField("CER_MRS_STROKE_HOSPITAL").build(),
                fieldBuilder.setField("CER_MRS_CUR_VISIT_90D_AFTER").build(),
                fieldBuilder.setField("CER_COMMENT").build()
        );

        List<TableField> whereFields = Arrays.asList(fieldBuilder.setField(ID).build());
        return QueryBuilderUtil.buildUpdateQuery(targetTable, fieldsToSet, whereFields);
    }


    @Override
    protected void prepareStatementToInsert(PreparedStatement ps, Cerebrovascular entity) throws SQLException {
        int paramIndex = 1;
        ps.setString(paramIndex++, entity.getId());
        ps.setString(paramIndex++, entity.getSha1ForUniqueFields());
        ps.setInt(paramIndex++, entity.getIntHashForSecondaryFields());
        ps.setTimestamp(paramIndex++, getSQLTimestamp(entity.getDateCreated()));
        ps.setTimestamp(paramIndex++, getSQLTimestamp(entity.getDateUpdated()));
        ps.setString(paramIndex++, entity.getPatientGuid());

        ps.setObject(paramIndex++, entity.getAeNumber());
        ps.setTimestamp(paramIndex++, getSQLTimestamp(entity.getStartDate()));
        ps.setString(paramIndex++, entity.getTerm());
        ps.setString(paramIndex++, entity.getEventType());
        ps.setString(paramIndex++, entity.getPrimaryIschemicStroke());
        ps.setString(paramIndex++, entity.getTraumatic());
        ps.setString(paramIndex++, entity.getIntracranialHemorrhageLocation());
        ps.setString(paramIndex++, entity.getIntracranialHemorrhageLocationOther());
        ps.setString(paramIndex++, entity.getSymptomsDuration());
        ps.setString(paramIndex++, entity.getMRSPriorToStroke());
        ps.setString(paramIndex++, entity.getMRSDuringStrokeHospitalisation());
        ps.setString(paramIndex++, entity.getMRSAtVisitOrAfterStroke());
        ps.setString(paramIndex, entity.getComment());

    }


    @Override
    protected void prepareStatementToUpdate(PreparedStatement ps, Cerebrovascular entity) throws SQLException {
        int paramIndex = 1;
        ps.setInt(paramIndex++, entity.getIntHashForSecondaryFields());
        ps.setTimestamp(paramIndex++, getSQLTimestamp(entity.getDateUpdated()));

        ps.setObject(paramIndex++, entity.getAeNumber());
        ps.setTimestamp(paramIndex++, getSQLTimestamp(entity.getStartDate()));
        ps.setString(paramIndex++, entity.getTerm());
        ps.setString(paramIndex++, entity.getEventType());
        ps.setString(paramIndex++, entity.getPrimaryIschemicStroke());
        ps.setString(paramIndex++, entity.getTraumatic());
        ps.setString(paramIndex++, entity.getIntracranialHemorrhageLocation());
        ps.setString(paramIndex++, entity.getIntracranialHemorrhageLocationOther());
        ps.setString(paramIndex++, entity.getSymptomsDuration());
        ps.setString(paramIndex++, entity.getMRSPriorToStroke());
        ps.setString(paramIndex++, entity.getMRSDuringStrokeHospitalisation());
        ps.setString(paramIndex++, entity.getMRSAtVisitOrAfterStroke());
        ps.setString(paramIndex, entity.getComment());
    }
}