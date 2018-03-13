package com.test.webservices.config;
import org.glassfish.jersey.media.multipart.MultiPartFeature;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@ApplicationPath("/rest")
public class ApplicationConfig extends Application {

	@Override
	public Map<String, Object> getProperties() {
		Map<String, Object> properties = new HashMap<String, Object>();
		properties.put("jersey.config.server.provider.packages", "com.test.webservices.rest");
		return properties;
	}
	
	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> resources = new java.util.HashSet<Class<?>>();
		resources.add(MultiPartFeature.class);
		return resources;
	}
}