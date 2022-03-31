package pl.coderslab.beans;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class SimpleCustomerLogger implements CustomerLogger{
    @Override
    public void log() {
        System.out.println(LocalDateTime.now() + "Customer Operation");
    }
}
