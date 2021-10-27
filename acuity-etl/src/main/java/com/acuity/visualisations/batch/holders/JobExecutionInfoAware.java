package com.acuity.visualisations.batch.holders;

import com.acuity.visualisations.util.LoggerDecorator;

public abstract class JobExecutionInfoAware {

    private static final LoggerDecorator LOGGER = new LoggerDecorator(JobExecutionInfoAware.class);

    private JobExecutionInfo jobExecutionInfo;


    public void setJobExecutionInfo(JobExecutionInfo jobExecutionInfo) {
        this.jobExecutionInfo = jobExecutionInfo;
    }

    protected Long getJobExecutionId() {
        return jobExecutionInfo.getJobExecutionId();
    }

    protected String getJobName() {
        return jobExecutionInfo.getJobName();
    }

    protected String getProjectName() {
        return jobExecutionInfo.getProjectName();
    }

    protected String getStudyName() {
        return jobExecutionInfo.getStudyName();
    }

    protected String getUniqueKey() {
        return jobExecutionInfo.getUniqueKey();
    }

    protected void error(String format, Object[] argArray) {
        LOGGER.error(jobExecutionInfo.getJobExecutionId(), jobExecutionInfo.getJobName(), jobExecutionInfo.getProjectName(),
                jobExecutionInfo.getStudyName(), format, argArray);
    }

    protected void error(String format, Object arg) {
        LOGGER.error(jobExecutionInfo.getJobExecutionId(), jobExecutionInfo.getJobName(), jobExecutionInfo.getProjectName(),
                jobExecutionInfo.getStudyName(), format, arg);
    }

    protected void error(String message) {
        LOGGER.error(jobExecutionInfo.getJobExecutionId(), jobExecutionInfo.getJobName(), jobExecutionInfo.getProjectName(),
                jobExecutionInfo.getStudyName(), message);
    }

    protected void error(String message, Throwable t) {
        LOGGER.error(jobExecutionInfo.getJobExecutionId(), jobExecutionInfo.getJobName(), jobExecutionInfo.getProjectName(),
                jobExecutionInfo.getStudyName(), message, t);
    }

    protected void debug(String format, Object[] argArray) {
        LOGGER.debug(jobExecutionInfo.getJobExecutionId(), jobExecutionInfo.getJobName(), jobExecutionInfo.getProjectName(),
                jobExecutionInfo.getStudyName(), format, argArray);
    }

    protected void debug(String format, Object arg) {
        LOGGER.debug(jobExecutionInfo.getJobExecutionId(), jobExecutionInfo.getJobName(), jobExecutionInfo.getProjectName(),
                jobExecutionInfo.getStudyName(), format, arg);
    }

    protected void debug(String message) {
        LOGGER.debug(jobExecutionInfo.getJobExecutionId(), jobExecutionInfo.getJobName(), jobExecutionInfo.getProjectName(),
                jobExecutionInfo.getStudyName(), message);
    }

    protected void debug(String message, Throwable t) {
        LOGGER.debug(jobExecutionInfo.getJobExecutionId(), jobExecutionInfo.getJobName(), jobExecutionInfo.getProjectName(),
                jobExecutionInfo.getStudyName(), message, t);
    }

    protected void info(String format, Object[] argArray) {
        LOGGER.info(jobExecutionInfo.getJobExecutionId(), jobExecutionInfo.getJobName(), jobExecutionInfo.getProjectName(),
                jobExecutionInfo.getStudyName(), format, argArray);
    }

    protected void info(String format, Object arg) {
        LOGGER.info(jobExecutionInfo.getJobExecutionId(), jobExecutionInfo.getJobName(), jobExecutionInfo.getProjectName(),
                jobExecutionInfo.getStudyName(), format, arg);
    }

    protected void info(String message) {
        LOGGER.info(jobExecutionInfo.getJobExecutionId(), jobExecutionInfo.getJobName(), jobExecutionInfo.getProjectName(),
                jobExecutionInfo.getStudyName(), message);
    }

    protected void info(String message, Throwable t) {
        LOGGER.info(jobExecutionInfo.getJobExecutionId(), jobExecutionInfo.getJobName(), jobExecutionInfo.getProjectName(),
                jobExecutionInfo.getStudyName(), message, t);
    }

    protected void warn(String format, Object[] argArray) {
        LOGGER.warn(jobExecutionInfo.getJobExecutionId(), jobExecutionInfo.getJobName(), jobExecutionInfo.getProjectName(),
                jobExecutionInfo.getStudyName(), format, argArray);
    }

    protected void warn(String format, Object arg) {
        LOGGER.warn(jobExecutionInfo.getJobExecutionId(), jobExecutionInfo.getJobName(), jobExecutionInfo.getProjectName(),
                jobExecutionInfo.getStudyName(), format, arg);
    }

    protected void warn(String message) {
        LOGGER.warn(jobExecutionInfo.getJobExecutionId(), jobExecutionInfo.getJobName(), jobExecutionInfo.getProjectName(),
                jobExecutionInfo.getStudyName(), message);
    }

    protected void warn(String message, Throwable t) {
        LOGGER.warn(jobExecutionInfo.getJobExecutionId(), jobExecutionInfo.getJobName(), jobExecutionInfo.getProjectName(),
                jobExecutionInfo.getStudyName(), message, t);
    }

}
