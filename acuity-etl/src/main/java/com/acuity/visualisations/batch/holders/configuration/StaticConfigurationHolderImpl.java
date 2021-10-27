package com.acuity.visualisations.batch.holders.configuration;

import com.acuity.visualisations.transform.entity.EntitiesRootRule;
import com.acuity.visualisations.transform.entity.EntityDescriptionRule;
import com.acuity.visualisations.transform.entitytotable.EntityTableBaseRule;
import com.acuity.visualisations.transform.entitytotable.EntityTablesRootRule;
import com.acuity.visualisations.transform.entitytotable.EntityTablesRule;
import com.acuity.visualisations.transform.table.TableRule;
import com.acuity.visualisations.transform.table.TablesRootRule;

import java.util.HashMap;
import java.util.Map;

public class StaticConfigurationHolderImpl implements StaticConfigurationHolder {

    private static final EntityDescriptionRule EMPTY_DESCRIPTION_RULE = new EntityDescriptionRule();

    private Map<String, EntityDescriptionRule> entityConf = new HashMap<String, EntityDescriptionRule>();
    private Map<String, TableRule> tableConf = new HashMap<String, TableRule>();
    private Map<String, EntityTablesRule> tableToEntityConf = new HashMap<String, EntityTablesRule>();
    private Map<String, EntityTablesRule> entityToTableConf = new HashMap<String, EntityTablesRule>();

    public EntityDescriptionRule getEntityRule(String entityName) {
        return entityConf.getOrDefault(entityName, EMPTY_DESCRIPTION_RULE);
    }

    public void setEntityConf(EntitiesRootRule entitiesRootRule) {
        for (EntityDescriptionRule entityRule : entitiesRootRule.getEntity()) {
            entityConf.put(entityRule.getName(), entityRule);
        }
    }

    public TableRule getTableRule(String tableName) {
        return tableConf.get(tableName);
    }

    public void setTableConf(TablesRootRule tablesRootRule) {
        for (TableRule tableRule : tablesRootRule.getTable()) {
            tableConf.put(tableRule.getName(), tableRule);
        }
    }

    public EntityTablesRule getEntityTablesRule(String tableName) {
        return tableToEntityConf.get(tableName);
    }

    public EntityTablesRule getEntityTablesRuleByEntityName(String entityName) {
        return entityToTableConf.get(entityName);
    }

    public void setTableToEntityConf(EntityTablesRootRule entityTablesRootRule) {
        for (EntityTablesRule entityTablesRule : entityTablesRootRule.getTable()) {
            tableToEntityConf.put(entityTablesRule.getName(), entityTablesRule);
            for (EntityTableBaseRule entityTableBaseRule : entityTablesRule.getEntity()) {
                entityToTableConf.put(entityTableBaseRule.getName(), entityTablesRule);
            }
        }
    }

    @Override
    public String getTableByEntity(String entityName) {
        for (EntityTablesRule entityTablesRule : tableToEntityConf.values()) {
            for (EntityTableBaseRule entityTableBaseRule : entityTablesRule.getEntity()) {
                if (entityName.equalsIgnoreCase(entityTableBaseRule.getName())) {
                    return entityTablesRule.getName();
                }
            }
        }
        return null;
    }
}
