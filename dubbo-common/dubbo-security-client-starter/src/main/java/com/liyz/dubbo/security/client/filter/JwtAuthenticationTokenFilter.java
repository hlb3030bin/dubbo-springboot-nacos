package com.liyz.dubbo.security.client.filter;

import com.google.common.base.Charsets;
import com.liyz.dubbo.common.api.result.Result;
import com.liyz.dubbo.common.remote.exception.RemoteServiceException;
import com.liyz.dubbo.common.util.JsonMapperUtil;
import com.liyz.dubbo.security.client.config.AnonymousMappingConfig;
import com.liyz.dubbo.security.client.context.AuthContext;
import com.liyz.dubbo.security.client.user.AuthUserDetails;
import com.liyz.dubbo.service.auth.bo.AuthUserBO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;

/**
 * Desc:
 *
 * @author lyz
 * @version 1.0.0
 * @date 2023/3/9 14:34
 */
@Slf4j
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    private final String tokenHeaderKey;

    public JwtAuthenticationTokenFilter(String tokenHeaderKey) {
        this.tokenHeaderKey = tokenHeaderKey;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader(this.tokenHeaderKey);
        try {
            if (!AnonymousMappingConfig.getAnonymousMappings().contains(request.getServletPath()) && StringUtils.isNotBlank(token)) {
                token = URLDecoder.decode(token, String.valueOf(Charsets.UTF_8));
                final AuthUserBO authUser = AuthContext.JwtService.parseToken(token);
                AuthUserDetails authUserDetails = AuthUserDetails.build(authUser);
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        authUserDetails,
                        null,
                        authUserDetails.getAuthorities()
                );
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authentication);
                AuthContext.setAuthUser(authUser);
            }
            //处理下一个过滤器
            filterChain.doFilter(request, response);
        } catch (RemoteServiceException exception) {
            response.setCharacterEncoding(Charsets.UTF_8.name());
            response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            response.getWriter().println(JsonMapperUtil.toJSONString(Result.error(exception.getCode(), exception.getMessage())));
            response.getWriter().flush();
        } catch (Exception e) {
           throw e;
        } finally {
            AuthContext.remove();
            SecurityContextHolder.getContextHolderStrategy().clearContext();
            SecurityContextHolder.clearContext();
        }
    }
}
