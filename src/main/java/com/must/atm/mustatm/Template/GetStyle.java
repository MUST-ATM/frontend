package com.must.atm.mustatm.Template;

/**
 * A class which can provide css style to the component
 *
 */
 public class GetStyle {

    public String getButtonStyle() {
        var style = """

                -fx-background-color: white;
                -fx-border-color: transparent;
                -fx-text-fill:#033D8B ;
                -fx-font-size: 30px;
                -fx-font-weight: bold;
     
                    """;
        return style;
    }
    public String getTextStyle() {
        var style = """

               -fx-font-size: 35px;
                -fx-font-weight: bold;
                -fx-fill: white;
                -fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.2), 3, 0, 3, 3);
     
                    """;
        return style;
    }
    public String getTextStyleBig() {
        var style = """

               -fx-font-size: 45px;
                -fx-font-weight: bold;
                -fx-fill: white;
                -fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.2), 3, 0, 3, 3);
     
                    """;
        return style;
    }
     public String getTextFieldStyle() {
         var style = """

                -fx-font-size: 35px;
                -fx-font-weight: bold;
                -fx-text-fill: white;
                -fx-effect: innershadow(gaussian, rgba(0, 0, 0, 0.2), 9, 0, 0, 0);
                -fx-background-color:#0550AE;
                -fx-highlight-text-fill:#FFF8C5;
                -fx-highlight-fill:#FAE17D ;
     
                    """;
         return style;
     }
    public String getTextFieldStyleTwo() {
        var style = """

                -fx-font-size: 35px;
                -fx-font-weight: bold;
                -fx-text-fill: white;
                -fx-effect: innershadow(gaussian, rgba(0, 0, 0, 0.2), 9, 0, 0, 0);
                -fx-background-color:linear-gradient(to right,#0550AE,#033D8B) ;
                -fx-highlight-text-fill:#FFF8C5;
                -fx-highlight-fill:#FAE17D ;
     
                    """;
        return style;
    }
}
