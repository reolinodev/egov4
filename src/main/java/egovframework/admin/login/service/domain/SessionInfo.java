package egovframework.admin.login.service.domain;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Getter
@Setter
@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@ToString
public class SessionInfo implements Serializable {

    public static final long serialVersionUID = 1L;

    public int user_id;

    public String user_nm;

    public int auth_id;

    public String auth_nm;

    public String login_id;
}
