package com.publiccms.views.directive.api;

//Generated 2015-5-10 17:54:56 by com.sanluan.common.source.SourceMaker

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.publiccms.common.base.AbstractAppV1Directive;
import com.publiccms.entities.sys.SysApp;
import com.publiccms.entities.sys.SysUser;
import com.publiccms.logic.component.StatisticsComponent;
import com.publiccms.views.pojo.CmsContentStatistics;
import com.sanluan.common.handler.RenderHandler;

@Component
public class ContentScoresDirective extends AbstractAppV1Directive {
    @Autowired
    private StatisticsComponent statisticsComponent;

    @Override
    public void execute(RenderHandler handler, SysApp app, SysUser user) throws IOException, Exception {
        Integer id = handler.getInteger("id");
        CmsContentStatistics contentStatistics = statisticsComponent.scores(id);
        if (notEmpty(contentStatistics) && notEmpty(contentStatistics.getEntity())) {
            handler.put("scores", contentStatistics.getEntity().getScores() + contentStatistics.getScores()).render();
        } else {
            handler.put("error", REQUIRED_PARAMTER + "id").render();
        }

    }

    @Override
    public boolean needUserToken() {
        return false;
    }

    @Override
    public boolean needAppToken() {
        return false;
    }

}