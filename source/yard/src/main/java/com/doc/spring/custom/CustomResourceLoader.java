/**
 * 
 */
package com.doc.spring.custom;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

/**
 * @author Elmehdi.zangui
 *
 */

@Component
public class CustomResourceLoader {

	private ResourceLoader resourceLoader;

	@Value("classpath:DumpFile.txt")
	private ClassPathResource resource;
	
	public CustomResourceLoader() {
		
	}
	public CustomResourceLoader(ResourceLoader resourceLoader) {
		this.setResourceLoader(resourceLoader);
	}

	public ResourceLoader getResourceLoader() {
		return resourceLoader;
	}

	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}

	public ClassPathResource getResource() {
		return resource;
	}

	public void setResource(ClassPathResource resource) {
		this.resource = resource;
	}
}
