
package com.otn.lrms.util.entity;

/**
 * 快速预约 <一句话功能简述> <功能详细描述>
 * 
 * @author wWX173427
 * @version [版本号, 2013-5-28]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class FreeBookResp extends BaseResponseHeader {

    private PreordainInfo data;

    public PreordainInfo getData() {
        return data;
    }

    public void setData(PreordainInfo data) {
        this.data = data;
    }

}
