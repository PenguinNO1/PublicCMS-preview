package com.publiccms.logic.dao.cms;

// Generated 2015-5-8 16:50:23 by com.sanluan.common.source.SourceMaker

import java.util.Date;
import java.util.HashMap;

import org.hibernate.search.FullTextQuery;
import org.springframework.stereotype.Repository;

import com.publiccms.entities.cms.CmsContent;
import com.sanluan.common.base.BaseDao;
import com.sanluan.common.handler.FacetPageHandler;
import com.sanluan.common.handler.PageHandler;
import com.sanluan.common.handler.QueryHandler;

@Repository
public class CmsContentDao extends BaseDao<CmsContent> {
    private static final String[] textFields = new String[] { "title", "author", "editor", "description" };
    private static final String[] tagFields = new String[] { "tagIds" };
    private static final String[] facetFields = new String[] { "categoryId", "modelId" };

    public PageHandler query(Integer siteId, String text, String tagId, Integer pageIndex, Integer pageSize) {
        FullTextQuery query;
        if (notEmpty(tagId)) {
            query = getQuery(tagFields, null, tagId);
        } else {
            query = getQuery(textFields, null, text);
        }
        query.enableFullTextFilter("publishDate").setParameter("publishDate", getDate());
        return getPage(query, pageIndex, pageSize);
    }

    public FacetPageHandler facetQuery(Integer siteId, final String categoryId, final String modelId, String text, String tagId,
            Integer pageIndex, Integer pageSize) {
        FullTextQuery query;
        if (notEmpty(tagId)) {
            query = getQuery(tagFields, facetFields, tagId);
        } else {
            query = getQuery(textFields, facetFields, text);
        }
        query.enableFullTextFilter("publishDate").setParameter("publishDate", getDate()).setParameter("siteId", siteId);
        return getFacetPage(query, facetFields, new HashMap<String, String>() {
            private static final long serialVersionUID = 1L;
            {
                if (notEmpty(categoryId)) {
                    put("categoryId", categoryId);
                }
                if (notEmpty(modelId)) {
                    put("modelId", modelId);
                }
            }
        }, pageIndex, pageSize);
    }

    public int deleteByCategoryIds(int siteId, Integer[] categoryIds) {
        QueryHandler queryHandler = getQueryHandler("update CmsContent bean set bean.disabled = :disabled");
        queryHandler.condition("bean.siteId = :siteId").setParameter("siteId", siteId);
        queryHandler.condition("bean.categoryId in (:categoryIds)").setParameter("categoryIds", categoryIds)
                .setParameter("disabled", true);
        return update(queryHandler);
    }

    public void index(int siteId, Integer[] ids) {
        for (CmsContent entity : getEntitys(ids)) {
            if (siteId == entity.getSiteId()) {
                index(entity);
            }
        }
    }

    public PageHandler getPage(Integer siteId, Integer[] status, Integer categoryId, Integer[] categoryIds, Boolean disabled,
            Integer[] modelId, Integer parentId, Boolean emptyParent, Boolean onlyUrl, Boolean hasImages, Boolean hasFiles,
            String title, Integer userId, Integer checkUserId, Date startPublishDate, Date endPublishDate, String orderField,
            String orderType, Integer pageIndex, Integer pageSize) {
        QueryHandler queryHandler = getQueryHandler("from CmsContent bean");
        if (notEmpty(siteId)) {
            queryHandler.condition("bean.siteId = :siteId").setParameter("siteId", siteId);
        }
        if (notEmpty(status)) {
            queryHandler.condition("bean.status in (:status)").setParameter("status", status);
        }
        if (notEmpty(categoryIds)) {
            queryHandler.condition("bean.categoryId in (:categoryIds)").setParameter("categoryIds", categoryIds);
        } else if (notEmpty(categoryId)) {
            queryHandler.condition("bean.categoryId = :categoryId").setParameter("categoryId", categoryId);
        }
        if (notEmpty(disabled)) {
            queryHandler.condition("bean.disabled = :disabled").setParameter("disabled", disabled);
        }
        if (notEmpty(modelId)) {
            queryHandler.condition("bean.modelId in (:modelId)").setParameter("modelId", modelId);
        }
        if (notEmpty(parentId)) {
            queryHandler.condition("bean.parentId = :parentId").setParameter("parentId", parentId);
        } else {
            if (notEmpty(emptyParent) && emptyParent) {
                queryHandler.condition("bean.parentId is null");
            }
        }
        if (notEmpty(onlyUrl)) {
            queryHandler.condition("bean.onlyUrl = :onlyUrl").setParameter("onlyUrl", onlyUrl);
        }
        if (notEmpty(hasImages)) {
            queryHandler.condition("bean.hasImages = :hasImages").setParameter("hasImages", hasImages);
        }
        if (notEmpty(hasFiles)) {
            queryHandler.condition("bean.hasFiles = :hasFiles").setParameter("hasFiles", hasFiles);
        }
        if (notEmpty(title)) {
            queryHandler.condition("(bean.title like :title)").setParameter("title", like(title));
        }
        if (notEmpty(userId)) {
            queryHandler.condition("bean.userId = :userId").setParameter("userId", userId);
        }
        if (notEmpty(checkUserId)) {
            queryHandler.condition("bean.checkUserId = :checkUserId").setParameter("checkUserId", checkUserId);
        }
        if (notEmpty(startPublishDate)) {
            queryHandler.condition("bean.publishDate > :startPublishDate").setParameter("startPublishDate", startPublishDate);
        }
        if (notEmpty(endPublishDate)) {
            queryHandler.condition("bean.publishDate <= :endPublishDate").setParameter("endPublishDate", endPublishDate);
        }
        if ("asc".equalsIgnoreCase(orderType)) {
            orderType = "asc";
        } else {
            orderType = "desc";
        }
        if (null == orderField) {
            orderField = BLANK;
        }
        switch (orderField) {
        case "scores":
            queryHandler.order("bean.scores " + orderType);
            break;
        case "comments":
            queryHandler.order("bean.comments " + orderType);
            break;
        case "clicks":
            queryHandler.order("bean.clicks " + orderType);
            break;
        default:
            queryHandler.order("bean.publishDate " + orderType);
        }
        return getPage(queryHandler, pageIndex, pageSize);
    }

    @Override
    protected CmsContent init(CmsContent entity) {
        if (empty(entity.getCreateDate())) {
            entity.setCreateDate(getDate());
        }
        if (empty(entity.getPublishDate())) {
            entity.setPublishDate(getDate());
        }
        return entity;
    }

}