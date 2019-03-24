package com.initcat.frontend.config;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;

/**
 * class description
 *
 * @author libo
 * @package com.initcat.frontend.config
 * @company xmiles
 * @date 2019/3/19
 */
@Configuration
public class GlobalConfig {

	@Bean
	public WebServerFactoryCustomizer<TomcatServletWebServerFactory> customizer() {
		return (factory) -> factory.addContextCustomizers((context) -> {
					// 模块中webapp相对路径
					String relativePath = "frontend_service/src/main/webapp";
					File docBaseFile = new File(relativePath);
					// 路径是否存在
					if (docBaseFile.exists()) {
						context.setDocBase(docBaseFile.getAbsolutePath());
					}
				}
		);
	}

}