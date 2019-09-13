package cn.edu360.web.pojo;

import java.util.List;

public class ZoneVO {

    private List<String> names;

    private List<ValueName> valueNames;

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public List<ValueName> getValueNames() {
        return valueNames;
    }

    public void setValueNames(List<ValueName> valueNames) {
        this.valueNames = valueNames;
    }
}
