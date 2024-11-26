package com.must.atm.mustatm.Template;

/**
 * A class which can provide css style to the component
 *
 * @author bywang
 */
 public class GetStyle
{

    public static String getButtonStyle()
    {
        return """

                -fx-background-color: white;
                -fx-border-color: transparent;
                -fx-text-fill:#033D8B ;
                -fx-font-size: 30px;
                -fx-font-weight: bold;
     
                """;
    }
    public static String getTextStyle()
    {
        return """

               -fx-font-size: 35px;
                -fx-font-weight: bold;
                -fx-fill: white;
                -fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.2), 3, 0, 3, 3);
     
               """;
    }
    public static String getTextStyleBig()
    {
        return """

               -fx-font-size: 45px;
                -fx-font-weight: bold;
                -fx-fill: white;
                -fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.2), 3, 0, 3, 3);
     
               """;
    }
     public static String getTextFieldStyle()
     {
         return """

                -fx-font-size: 35px;
                -fx-font-weight: bold;
                -fx-text-fill: white;
                -fx-effect: innershadow(gaussian, rgba(0, 0, 0, 0.2), 9, 0, 0, 0);
                -fx-background-color:#0550AE;
                -fx-highlight-text-fill:#FFF8C5;
                -fx-highlight-fill:#FAE17D ;
     
                """;
     }
    public static String getTextFieldStyleTwo()
    {
        return """

                -fx-font-size: 35px;
                -fx-font-weight: bold;
                -fx-text-fill: white;
                -fx-effect: innershadow(gaussian, rgba(0, 0, 0, 0.2), 9, 0, 0, 0);
                -fx-background-color:linear-gradient(to right,#0550AE,#033D8B) ;
                -fx-highlight-text-fill:#FFF8C5;
                -fx-highlight-fill:#FAE17D ;
     
                """;
    }
}
