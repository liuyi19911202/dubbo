package cn.ly.common.web.editor;

import java.beans.PropertyEditorSupport;

import cn.ly.common.utils.DateHelper;

/**
 * @author liuyi
 */
public class DateEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) {
        setValue(DateHelper.parseDate(text));
    }

}
