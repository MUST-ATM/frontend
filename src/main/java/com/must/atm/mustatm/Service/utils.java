package com.must.atm.mustatm.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * utils class
 * @author 25325
 */
public class utils
{
    /**
     * Convert BufferedImage to byte[]
     * @param image BufferedImage
     * @return byte[]
     * @throws IOException IOException
     */
    public static byte[] bufferToByte(BufferedImage image) throws IOException
    {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", stream);
        return stream.toByteArray();
    }
}
