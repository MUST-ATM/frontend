package com.must.atm.mustatm.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * @author bywang
 */
public class Init
{
    public static Properties getProperties()
    {
        FileReader reader;

        {
            try
            {
                reader = new FileReader("src/main/resources/server.properties");
                Properties config = new Properties();
                config.load(reader);
                return config;
            } catch (IOException e)
            {
                throw new RuntimeException(e);
            }

        }
    }
}
