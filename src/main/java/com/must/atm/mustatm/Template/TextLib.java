package com.must.atm.mustatm.Template;

import javafx.scene.text.Text;

import static com.must.atm.mustatm.Template.GetStyle.getTextStyleBig;

/**
 * @author bywang
 */
public class TextLib
{
    private final String content;
    public TextLib(String content)
    {
        this.content = content;
    }

    public Text noticeText()
    {
        var text = new Text(content);
        text.setStyle(getTextStyleBig());
        return text;
    }
}
