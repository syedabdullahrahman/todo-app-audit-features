package abdullah.todomanagement.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Random;

/**
 * Created On:  2:44 AM 11-Feb-22
 *
 * @author Syed Abdullah
 */
public class TokenManager {

    private static final String TOKEN_KEY = "_synchronizerToken";
    private static String invalidTokenView = "";

    public static synchronized boolean isTokenValid(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String sessionToken = (String)session.getAttribute(getTokenKey());
        String requestToken = request.getParameter(getTokenKey());
        if (requestToken == null) {
            // The hidden field wasn't provided
            throw new TokenException("Missing synchronizer token in request");
        }
        if (sessionToken == null) {
            // The session has lost the token.
            throw new TokenException("Missing synchronizer token in session");
        }
        if (sessionToken.equals(requestToken)) {
            // Accept the submission and increment the token so this form can't
            // be submitted again ...
            session.setAttribute(getTokenKey(), nextToken());
            return true;
        }
        return false;
    }

    public static String getTokenKey() {
        return TOKEN_KEY;
    }

    public static String nextToken() {
        long seed = System.currentTimeMillis();
        Random r = new Random();
        r.setSeed(seed);
        return Long.toString(seed) + Long.toString(Math.abs(r.nextLong()));
    }

    public static String getInvalidTokenView() {
        return invalidTokenView;
    }
}
