package com.publiccms.entities.plugin;

// Generated 2016-3-2 16:22:41 by Hibernate Tools 4.3.1

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.publiccms.common.base.Staticable;
import com.sanluan.common.source.entity.MyColumn;

/**
 * PluginVote generated by hbm2java
 */
@Entity
@Table(name = "plugin_vote")
public class PluginVote implements java.io.Serializable , Staticable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    @MyColumn(title = "ID")
    private Integer id;
    @MyColumn(title = "站点", condition = true)
    private int siteId;
    @MyColumn(title = "开始日期", condition = true, order = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startDate;
    @MyColumn(title = "结束日期", condition = true, order = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endDate;
    @MyColumn(title = "时间间隔")
    private int intervalHour;
    @MyColumn(title = "最大投票数")
    private int maxVote;
    @MyColumn(title = "允许匿名")
    private boolean anonymous;
    @MyColumn(title = "参与人数", order = true)
    private int userCounts;
    @MyColumn(title = "地址")
    private String url;
    @MyColumn(title = "标题")
    private String title;
    @MyColumn(title = "描述")
    private String description;
    @MyColumn(title = "已禁用", condition = true)
    private boolean disabled;

    public PluginVote() {
    }

    public PluginVote(int siteId, Date startDate, Date endDate, int intervalHour, int maxVote, boolean anonymous, int userCounts,
            String url, String title, boolean disabled) {
        this.siteId = siteId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.intervalHour = intervalHour;
        this.maxVote = maxVote;
        this.anonymous = anonymous;
        this.userCounts = userCounts;
        this.url = url;
        this.title = title;
        this.disabled = disabled;
    }

    public PluginVote(int siteId, Date startDate, Date endDate, int intervalHour, int maxVote, boolean anonymous, int userCounts,
            String url, String title, String description, boolean disabled) {
        this.siteId = siteId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.intervalHour = intervalHour;
        this.maxVote = maxVote;
        this.anonymous = anonymous;
        this.userCounts = userCounts;
        this.url = url;
        this.title = title;
        this.description = description;
        this.disabled = disabled;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "site_id", nullable = false)
    public int getSiteId() {
        return this.siteId;
    }

    public void setSiteId(int siteId) {
        this.siteId = siteId;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "start_date", nullable = false, length = 19)
    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "end_date", nullable = false, length = 19)
    public Date getEndDate() {
        return this.endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Column(name = "interval_hour", nullable = false)
    public int getIntervalHour() {
        return this.intervalHour;
    }

    public void setIntervalHour(int intervalHour) {
        this.intervalHour = intervalHour;
    }

    @Column(name = "max_vote", nullable = false)
    public int getMaxVote() {
        return this.maxVote;
    }

    public void setMaxVote(int maxVote) {
        this.maxVote = maxVote;
    }

    @Column(name = "anonymous", nullable = false)
    public boolean isAnonymous() {
        return this.anonymous;
    }

    public void setAnonymous(boolean anonymous) {
        this.anonymous = anonymous;
    }

    @Column(name = "user_counts", nullable = false)
    public int getUserCounts() {
        return this.userCounts;
    }

    public void setUserCounts(int userCounts) {
        this.userCounts = userCounts;
    }

    @Column(name = "url", nullable = false, length = 2048)
    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Column(name = "title", nullable = false, length = 100)
    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "description", length = 300)
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "disabled", nullable = false)
    public boolean isDisabled() {
        return this.disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

}
