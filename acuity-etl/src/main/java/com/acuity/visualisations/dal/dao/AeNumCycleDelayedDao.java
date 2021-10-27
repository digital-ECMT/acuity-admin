package com.acuity.visualisations.dal.dao;

import com.acuity.visualisations.dal.EntityDao;
import com.acuity.visualisations.dal.util.JoinDeclaration;
import com.acuity.visualisations.dal.util.JoinDeclarationBuilder;
import com.acuity.visualisations.dal.util.QueryBuilderUtil;
import com.acuity.visualisations.dal.util.TableField;
import com.acuity.visualisations.dal.util.TableFieldBuilder;
import com.acuity.visualisations.model.output.entities.AeNumCycleDelayed;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class AeNumCycleDelayedDao extends EntityDao<AeNumCycleDelayed> {
    private static final String AEND_ID = "AEND_ID";
    private static final String RESULT_AE_NUM_DEL = "RESULT_AE_NUM_DEL";

    @Override
    protected String getInsertStatement() {
        List<TableField> fieldsToInsert = new ArrayList<>();
        TableFieldBuilder fieldBuilder = new TableFieldBuilder(getTableName());
        fieldsToInsert.add(fieldBuilder.setField(AEND_ID).build());
        fieldsToInsert.add(fieldBuilder.setField("AEND_UNQ_SHA1").build());
        fieldsToInsert.add(fieldBuilder.setField(getSecondaryHashColumnName()).build());
        fieldsToInsert.add(fieldBuilder.setField("AEND_MDS_ID").build());
        fieldsToInsert.add(fieldBuilder.setField("AEND_PAT_ID").build());

        fieldsToInsert.add(fieldBuilder.setField("AEND_NUM_CYCLE_DEL").build());
        return QueryBuilderUtil.buildInsertQuery(getTableName(), fieldsToInsert);
    }

    @Override
    protected String getUpdateStatement() {
        List<TableField> fieldsToSet = new ArrayList<>();
        TableFieldBuilder fieldBuilder = new TableFieldBuilder(getTableName());
        fieldsToSet.add(fieldBuilder.setField(getSecondaryHashColumnName()).build());
        fieldsToSet.add(fieldBuilder.setField("AEND_NUM_CYCLE_DEL").build());
        List<TableField> whereFields = new ArrayList<>();
        whereFields.add(fieldBuilder.setField(AEND_ID).build());
        String sql = QueryBuilderUtil.buildUpdateQuery(getTableName(), fieldsToSet, whereFields);
        return sql;
    }

    @Override
    protected void prepareStatementToInsert(PreparedStatement ps, AeNumCycleDelayed entity) throws SQLException {
        int paramIndex = 1;
        ps.setString(paramIndex++, entity.getId());
        ps.setString(paramIndex++, entity.getSha1ForUniqueFields());
        ps.setObject(paramIndex++, entity.getIntHashForSecondaryFields());

        ps.setString(paramIndex++, entity.getDoseGuid());
        ps.setObject(paramIndex++, entity.getPatientGuid());
        ps.setObject(paramIndex, entity.getNumCycleDelayed());
    }

    @Override
    protected void prepareStatementToUpdate(PreparedStatement ps, AeNumCycleDelayed entity) throws SQLException {
        int paramIndex = 1;
        ps.setObject(paramIndex++, entity.getIntHashForSecondaryFields());
        ps.setObject(paramIndex++, entity.getId());
        ps.setObject(paramIndex, entity.getNumCycleDelayed());
    }

    @Override
    protected String getIdColumnName() {
        return AEND_ID;
    }

    @Override
    public String getTableName() {
        return RESULT_AE_NUM_DEL;
    }

    @Override
    protected String getTablePrefix() {
        return "AEND";
    }

    @Override
    protected String getHashesStatement(Class<?> entityClass) {
        List<JoinDeclaration> joinChain = new ArrayList<JoinDeclaration>();
        JoinDeclarationBuilder builder = new JoinDeclarationBuilder();
        joinChain
                .add(builder.setSourceEntity(RESULT_AE_NUM_DEL).setTargetEntity("RESULT_PATIENT").addColumnToJoin("AEND_PAT_ID", "PAT_ID").build());
        List<TableField> fieldValues = new ArrayList<TableField>();
        fieldValues.add(new TableField("RESULT_PATIENT", "PAT_STD_ID"));
        List<String> hashColumnNames = new ArrayList<String>();
        hashColumnNames.add("AEND_UNQ_SHA1");
        hashColumnNames.add(getSecondaryHashColumnName());
        hashColumnNames.add(getIdColumnName());
        String sql = QueryBuilderUtil.buildSelectHashesQuery(RESULT_AE_NUM_DEL, hashColumnNames, joinChain, fieldValues);
        return sql;
    }

    @Override
    public List<String> getSubjectsIdsByStudyName(String studyName) {
        return Collections.emptyList();
    }
}