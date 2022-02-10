package abdullah.todomanagement.config;


import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created On:  2:43 AM 11-Feb-22
 *
 * @author Syed Abdullah
 */

@WebListener
public class TokenListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent sessionEvent) {
        HttpSession session = sessionEvent.getSession();
        session.setAttribute(
                TokenManager.getTokenKey()
                ,   TokenManager.nextToken()
        );
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {

    }

}