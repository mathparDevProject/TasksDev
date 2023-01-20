package mathpar.web.learning.tasks.utils;

import mathpar.web.learning.tasks._configs.security.UserAuthentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtils {
    public static long extractAccountId(String token){
        try {
            return Long.parseLong(token.substring(0, token.indexOf("_")));
        }catch (NumberFormatException e){
            throw new RuntimeException("AuthenticationToken is invalid");
        }
    }

    public static long getCurrentlyAuthenticatedAccountId(){
        var auth = SecurityContextHolder.getContext().getAuthentication();
        if(!(auth instanceof UserAuthentication)) throw new RuntimeException("Proper authentication hasn't been populated");
        return ((UserAuthentication) auth).getPrincipal();
    }
}
