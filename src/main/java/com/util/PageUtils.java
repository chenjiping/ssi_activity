package com.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

public class PageUtils {

	public static PageBounds getPageBounds() {

		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
		Integer page = 0;
		Integer rows = 0;
		if (request.getParameter("page") != null) {
			page = Integer.valueOf(request.getParameter("page"));
		}
		if (request.getParameter("rows") != null) {
			rows = Integer.valueOf(request.getParameter("rows"));
		}
		PageBounds pageBounds = new PageBounds(page, rows);
		return pageBounds;
	}
}
