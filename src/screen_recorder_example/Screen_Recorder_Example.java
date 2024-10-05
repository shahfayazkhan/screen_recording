package screen_recorder_example;
import org.bytedeco.javacv.CanvasFrame;
import org.bytedeco.javacv.OpenCVFrameGrabber;
import org.bytedeco.javacv.Frame;
import org.opencv.core.Core;

public class Screen_Recorder_Example {

    public static void main(String[] args) {
        // Load OpenCV native library
        System.load("C:/opencv/build/java/x64/opencv_java490.dll");
        // Create a frame grabber
        OpenCVFrameGrabber grabber = new OpenCVFrameGrabber(0); // 0 for default camera
        try {
            grabber.start(); // Start the camera
            
            // Create a window to display the camera feed
            CanvasFrame canvas = new CanvasFrame("Camera Feed", CanvasFrame.getDefaultGamma() / grabber.getGamma());

            // Window will close when you press the close button
            canvas.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
            canvas.setCanvasSize(grabber.getImageWidth(), grabber.getImageHeight());

            // Grab and display frames in a loop
            while (canvas.isVisible() && (grabber.grab()) != null) {
                Frame frame = grabber.grab();
                canvas.showImage(frame);
            }

            grabber.stop();
            canvas.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
