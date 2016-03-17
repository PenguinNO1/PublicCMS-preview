package com.sanluan.common.base;

import static org.apache.commons.lang3.StringUtils.isEmpty;
import static org.springframework.web.servlet.view.UrlBasedViewResolver.FORWARD_URL_PREFIX;
import static org.springframework.web.servlet.view.UrlBasedViewResolver.REDIRECT_URL_PREFIX;

import java.util.Map;

/**
 * 
 * BaseController
 *
 */
public abstract class BaseController extends Base {
    protected static final String REDIRECT = REDIRECT_URL_PREFIX;
    protected static final String FORWARD = FORWARD_URL_PREFIX;
    protected static final String ERROR = "error";

    /**
     * @param field
     * @param value
     * @param model
     * @return
     */
    protected static boolean virifyNotEmpty(String field, String value, Map<String, Object> model) {
        if (isEmpty(value)) {
            model.put(ERROR, "verify.notEmpty." + field);
            return true;
        }
        return false;
    }

    /**
     * @param field
     * @param value
     * @param model
     * @return
     */
    protected static boolean virifyCustom(String field, boolean value, Map<String, Object> model) {
        if (value) {
            model.put(ERROR, "verify.custom." + field);
            return true;
        }
        return false;
    }

    /**
     * @param field
     * @param value
     * @param model
     * @return
     */
    protected static boolean virifyNotEmpty(String field, Object value, Map<String, Object> model) {
        if (null == value) {
            model.put(ERROR, "verify.notEmpty." + field);
            return true;
        }
        return false;
    }

    /**
     * @param field
     * @param value
     * @param specific
     * @param model
     * @return
     */
    protected static boolean virifyNotGreaterThen(String field, Integer value, int specific, Map<String, Object> model) {
        if (null == value) {
            model.put(ERROR, "verify.notEmpty." + field);
            return true;
        } else if (value <= specific) {
            model.put(ERROR, "verify.notGreaterThen." + field);
            return true;
        }
        return false;
    }

    /**
     * @param field
     * @param value
     * @param specific
     * @param model
     * @return
     */
    protected static boolean virifyNotLongThen(String field, String value, int specific, Map<String, Object> model) {
        if (null == value) {
            model.put(ERROR, "verify.notEmpty." + field);
            return true;
        } else if (value.length() > specific) {
            model.put(ERROR, "verify.notLongThen." + field);
            return true;
        }
        return false;
    }

    /**
     * @param field
     * @param value
     * @param specific
     * @param model
     * @return
     */
    protected static boolean virifyNotLessThen(String field, String value, int specific, Map<String, Object> model) {
        if (null == value) {
            model.put(ERROR, "verify.notEmpty." + field);
            return true;
        } else if (value.length() < specific) {
            model.put(ERROR, "verify.notLessThen." + field);
            return true;
        }
        return false;
    }

    /**
     * @param field
     * @param value
     * @param model
     * @return
     */
    protected static boolean virifyNotExist(String field, Object value, Map<String, Object> model) {
        if (null == value) {
            model.put(ERROR, "verify.notExist." + field);
            return true;
        }
        return false;
    }

    /**
     * @param field
     * @param value
     * @param model
     * @return
     */
    protected static boolean virifyHasExist(String field, Object value, Map<String, Object> model) {
        if (notEmpty(value)) {
            model.put(ERROR, "verify.hasExist." + field);
            return true;
        }
        return false;
    }

    /**
     * @param field
     * @param value1
     * @param value2
     * @param model
     * @return
     */
    protected static boolean virifyNotEquals(String field, String value1, String value2, Map<String, Object> model) {
        if (notEmpty(value1) && !value1.equals(value2)) {
            model.put(ERROR, "verify.notEquals." + field);
            return true;
        }
        return false;
    }

    /**
     * @param field
     * @param value1
     * @param value2
     * @param model
     * @return
     */
    protected static boolean virifyNotEquals(String field, Integer value1, Integer value2, Map<String, Object> model) {
        if (notEmpty(value1) && !value1.equals(value2)) {
            model.put(ERROR, "verify.notEquals." + field);
            return true;
        }
        return false;
    }
}
