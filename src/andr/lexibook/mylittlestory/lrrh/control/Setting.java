package andr.lexibook.mylittlestory.lrrh.control;

import andr.lexibook.mylittlestory.lrrh.model.ReadMode;
import andr.lexibook.mylittlestory.lrrh.util.ReadModeToFile;

/**
 * Created by rain on 5/20/13.
 */
public class Setting {

    private static Setting instance;
    private ReadMode readMode;
    private ReadModeToFile io;
    private boolean langChanged = false;

    private Setting() {
        io = new ReadModeToFile();
        readMode = io.get();
    }

    public static Setting getInstance() {
        if (instance == null)
            instance = new Setting();
        return instance;
    }

    public ReadMode getReadMode() {
        return this.readMode;
    }

    public void save() {
        io.save(this.readMode);
    }

    public String getLang() {
        return readMode.getLang();
    }

    public void setLang(String lang) {
        this.readMode.setLang(lang);
        this.langChanged = true;
    }

    public boolean isLangChanged() {
        return langChanged;
    }

    public void setLangChanged(boolean langChanged) {
        this.langChanged = langChanged;
    }

    public void setFirst(boolean isFirst) {
        this.readMode.setFirst(isFirst);
    }

    public boolean isFirst() {
        return this.readMode.isFirst();
    }

    public boolean isAuto() {
        return this.readMode.isAuto();
    }

    public void setAuto(boolean isAuto) {
        this.readMode.setAuto(isAuto);
    }
}
