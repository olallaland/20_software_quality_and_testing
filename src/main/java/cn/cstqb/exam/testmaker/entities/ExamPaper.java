package cn.cstqb.exam.testmaker.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "exampaper")
public class ExamPaper extends AbstractBaseEntity{
    @JsonIgnore
    private String custom_field1;
    @JsonIgnore
    private String custom_field2;
    @JsonIgnore
    private String custom_field3;
    @Temporal(TemporalType.TIMESTAMP)
    private Date exportedOn;

    private Integer exportedBy;

    private Integer syllabus_id;

    private Integer status_id;

    private Integer facilitator_id;

    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Temporal(TemporalType.DATE)
    private Date finishDate;

    private String name;

    public String getCustom_field1() {
        return custom_field1;
    }

    public void setCustom_field1(String custom_field1) {
        this.custom_field1 = custom_field1;
    }

    public String getCustom_field2() {
        return custom_field2;
    }

    public void setCustom_field2(String custom_field2) {
        this.custom_field2 = custom_field2;
    }

    public String getCustom_field3() {
        return custom_field3;
    }

    public void setCustom_field3(String custom_field3) {
        this.custom_field3 = custom_field3;
    }

    public Date getExportedOn() {
        return exportedOn;
    }

    public void setExportedOn(Date exportedOn) {
        this.exportedOn = exportedOn;
    }

    public int getExportedBy() {
        return exportedBy;
    }

    public void setExportedBy(int exportedBy) {
        this.exportedBy = exportedBy;
    }

    public int getSyllabus_id() {
        return syllabus_id;
    }

    public void setSyllabus_id(int syllabus_id) {
        this.syllabus_id = syllabus_id;
    }

    public int getStatus_id() {
        return status_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }

    public int getFacilitator_id() {
        return facilitator_id;
    }

    public void setFacilitator_id(int facilitator_id) {
        this.facilitator_id = facilitator_id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
