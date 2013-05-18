package andr.lexibook.mylittlestory.lrrh.model;

import java.io.Serializable;

/**
 * User: rain
 * Date: 5/13/13
 * Time: 10:53 AM
 */
public class ReadMode implements Serializable {

    private static final long serialVersionUID = 1L;
    private boolean isFirst;
    private String mode;
    private String lang;

    public ReadMode() {
        this.setFirst(true);
        this.setMode("self");
        this.setLang("English");
    }

    public ReadMode(boolean isFirst, String mode, String lang) {
        this.isFirst = isFirst;
        this.mode = mode;
        this.lang = lang;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public void setFirst(boolean first) {
        isFirst = first;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public boolean isFirst() {
        return isFirst;
    }

    public String getMode() {
        return mode;
    }

}
