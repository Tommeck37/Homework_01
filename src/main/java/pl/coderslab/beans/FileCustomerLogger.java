package pl.coderslab.beans;

import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

@Component
public class FileCustomerLogger implements CustomerLogger {

    private String filename = "log.txt";

    @Override
    public void log() throws FileNotFoundException {
        String message = LocalDateTime.now() + " Customer Operation";

        PrintWriter printWriter = new PrintWriter(this.filename);
        printWriter.println(message);
        printWriter.close();

    }
}
