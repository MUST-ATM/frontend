package com.must.atm.mustatm.Template;

import javafx.scene.text.Text;

import static com.must.atm.mustatm.Template.GetStyle.getTextStyleBig;

/**
 * A basic text library
 * @author bywang
 */
public class TextLib
{
    private final String content;
    public TextLib(String content)
    {
        this.content = content;
    }

    /**
     * @return a text with big font size
     */
    public Text noticeText()
    {
        var text = new Text(content);
        text.setStyle(getTextStyleBig());
        return text;
    }
}
