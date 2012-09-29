package com.openshift.notebook.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.Mongo;

@Configuration
@Profile("dev")
public class DevMongoDBFactoryConfig implements MongoDbFactoryConfig {

	/* (non-Javadoc)
	 * @see com.openshift.notebook.core.config.MongoDbConfig#mongoDbFactory()
	 */
	@Override
	@Bean
	public MongoDbFactory mongoDbFactory() throws Exception {
		Mongo mongo = new Mongo("localhost", 27017);
		String databaseName = "notebook";
		MongoDbFactory mongoDbFactory = new SimpleMongoDbFactory(mongo,
				databaseName);
		return mongoDbFactory;
	}

}
