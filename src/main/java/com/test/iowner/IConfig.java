package com.test.iowner;

import org.aeonbits.owner.Config;

@Config.Sources(value = "file:${user.dir}/src/test/resources/config.properties")
public interface IConfig extends Config {

	String baseuri();

	String accounturi();

	String clientid();

	String clientsecret();

	String refreshtoken();

	String granttype();
}
