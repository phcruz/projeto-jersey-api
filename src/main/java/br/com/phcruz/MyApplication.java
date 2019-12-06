package br.com.phcruz;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.Application;

public class MyApplication extends Application{

	@Override
	public Map<String, Object> getProperties() {
		Map<String, Object> properties = new HashMap<>();
		// Configura o pacote para fazer scan das classes com anota��es REST.
		properties.put("jersey.config.server.provider.packages", "br.com.phcruz");
		return properties;
	}
}
