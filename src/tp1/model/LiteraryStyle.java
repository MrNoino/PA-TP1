package tp1.model;

/**
 *
 */
public class LiteraryStyle {
    private int id;
    private String literaryStyle;

    public LiteraryStyle(int aId, String aLiteraryStyle) {
        this.id = aId;
        this.literaryStyle = aLiteraryStyle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLiteraryStyle() {
        return literaryStyle;
    }

    public void setLiteraryStyle(String literaryStyle) {
        this.literaryStyle = literaryStyle;
    }
    
}
