package cn.chinajdt.bussiness.sys.model;

import java.io.Serializable;

public class Sysmenucode implements Serializable {
    private String sysmenucodeid;

    private String sysmenuid;

    private String cname;

    private Integer ccode;

    public String getSysmenucodeid() {
        return sysmenucodeid;
    }

    public void setSysmenucodeid(String sysmenucodeid) {
        this.sysmenucodeid = sysmenucodeid == null ? null : sysmenucodeid.trim();
    }

    public String getSysmenuid() {
        return sysmenuid;
    }

    public void setSysmenuid(String sysmenuid) {
        this.sysmenuid = sysmenuid == null ? null : sysmenuid.trim();
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    public Integer getCcode() {
        return ccode;
    }

    public void setCcode(Integer ccode) {
        this.ccode = ccode;
    }
}