package listeners;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ScreenshotListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        Object webDriver = result.getTestContext().getAttribute("driver");
        if (webDriver != null) {
            byte [] screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
            AttachmentUtils.makeImageAttachment("screenshot on failure", screenshot);
        }
    }
}
