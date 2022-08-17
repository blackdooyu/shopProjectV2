package refactor.shopproject.common;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

@Component
public class AuthUtil {

    public HttpSession createSession() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder
                .currentRequestAttributes();

        return servletRequestAttributes.getRequest().getSession(true);
    }
}
