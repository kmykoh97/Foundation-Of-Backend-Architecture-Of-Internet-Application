package hello;

import org.springframework.stereotype.Service;


@Service
public class ServiceOne {
    public String getName() {
        return "example service class";
    }
}
