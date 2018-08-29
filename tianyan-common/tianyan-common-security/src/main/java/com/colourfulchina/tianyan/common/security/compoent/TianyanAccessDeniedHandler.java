

package com.colourfulchina.tianyan.common.security.compoent;


import cn.hutool.http.HttpStatus;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.colourfulchina.tianyan.common.core.constant.CommonConstant;
import com.colourfulchina.tianyan.common.core.exception.TianyanDeniedException;
import com.colourfulchina.tianyan.common.core.util.R;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * 授权拒绝处理器，覆盖默认的OAuth2AccessDeniedHandler
 * 包装失败信息到TianyanDeniedException
 */
@Slf4j
@Component
@AllArgsConstructor
public class TianyanAccessDeniedHandler extends OAuth2AccessDeniedHandler {
	private final ObjectMapper objectMapper;

	/**
	 * 授权拒绝处理，使用R包装
	 *
	 * @param request       request
	 * @param response      response
	 * @param authException authException
	 * @throws IOException      IOException
	 * @throws ServletException ServletException
	 */
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException authException) throws IOException, ServletException {
		log.info("授权失败，禁止访问 {}", request.getRequestURI());
		response.setCharacterEncoding(CommonConstant.UTF8);
		response.setContentType(CommonConstant.CONTENT_TYPE);
		R<String> result = new R<>(new TianyanDeniedException("授权失败，禁止访问"));
		response.setStatus(HttpStatus.HTTP_FORBIDDEN);
		PrintWriter printWriter = response.getWriter();
		printWriter.append(objectMapper.writeValueAsString(result));
	}
}
