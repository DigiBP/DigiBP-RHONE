package ch.fhnw.digibp.model;

public class SurveyModel {
    private String uuid;
    private String survey_uuid;
    @javax.persistence.Transient
    private int survey_score;

    public SurveyModel() {
    }

    public SurveyModel(String uuid, String survey_uuid, int score) {
        this.uuid = uuid;
        this.survey_uuid = survey_uuid;
        this.survey_score = score;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getSurvey_uuid() {
        return survey_uuid;
    }

    public void setSurvey_uuid(String survey_uuid) {
        this.survey_uuid = survey_uuid;
    }

    public int getSurvey_score() {
        return survey_score;
    }

    public void setSurvey_score(int survey_score) {
        this.survey_score = survey_score;
    }
}