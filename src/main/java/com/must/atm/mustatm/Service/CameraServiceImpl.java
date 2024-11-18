package com.must.atm.mustatm.Service;

import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.OpenCVFrameConverter;
import org.bytedeco.javacv.OpenCVFrameGrabber;
import org.bytedeco.opencv.helper.opencv_imgcodecs;
import org.bytedeco.opencv.opencv_core.IplImage;

import java.io.IOException;

/**
 * CameraService implementation
 * @author bywang
 */
public class CameraServiceImpl implements CameraService
{
    /**
     * Capture the image to resources/capture.jpg
     * @throws IOException IOException
     */
    @Override
    public void capture() throws IOException
    {
        try (FrameGrabber grabber = new OpenCVFrameGrabber(0))
        {
            grabber.start();
            Frame frame = grabber.grab();
            try(OpenCVFrameConverter.ToIplImage converter = new OpenCVFrameConverter.ToIplImage())
            {
                IplImage img = converter.convert(frame);
                opencv_imgcodecs.cvSaveImage("src/main/resources/capture.jpg", img);
                grabber.stop();
            }
        }

    }
}
