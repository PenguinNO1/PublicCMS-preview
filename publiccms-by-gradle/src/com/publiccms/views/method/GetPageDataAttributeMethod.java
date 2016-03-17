package com.publiccms.views.method;

import static com.publiccms.common.tools.ExtendUtils.getExtendMap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.publiccms.entities.cms.CmsPageDataAttribute;
import com.publiccms.logic.service.cms.CmsPageDataAttributeService;
import com.sanluan.common.base.BaseMethod;

import freemarker.template.TemplateModelException;

@Component
public class GetPageDataAttributeMethod extends BaseMethod {

    /*
     * (non-Javadoc)
     * 
     * @see freemarker.template.TemplateMethodModelEx#exec(java.util.List)
     */
    @SuppressWarnings("unchecked")
    @Override
    public Object exec(@SuppressWarnings("rawtypes") List arguments) throws TemplateModelException {
        Integer id = getInteger(0, arguments);
        if (notEmpty(id)) {
            CmsPageDataAttribute entity = service.getEntity(id);
            if (notEmpty(entity)) {
                return getExtendMap(entity.getData());
            }
        }
        return null;
    }

    @Autowired
    private CmsPageDataAttributeService service;
}
