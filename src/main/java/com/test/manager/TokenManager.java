package com.test.manager;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.test.customexception.RenewTokenException;
import com.test.iowner.IConfig;
import com.test.utils.APIUtils;
import static com.test.constants.FormParam.*;

import io.restassured.response.Response;

public class TokenManager {

	private TokenManager() {

	}

	private static final Logger LOG = LogManager.getLogger();
	private static String accessToken;
	private static Instant tokenExpiryTime;

	public static final String getToken() {
		if (accessToken == null || Instant.now().isAfter(tokenExpiryTime)) {
			LOG.info("Renewing access token...");
			renewToken();
		} else {
			LOG.info("Good to use access token");
		}
		return accessToken;
	}

	public static synchronized Response renewToken() {
		IConfig config = ConfigFactory.create(IConfig.class);
		Map<String, String> paramMap = new HashMap<>();
		paramMap.put(GRANT_TYPE, config.granttype());
		paramMap.put(REFRESH_TOEKN, config.refreshtoken());
		paramMap.put(CLIENT_ID, config.clientid());
		paramMap.put(CLIENT_SECRET, config.clientsecret());

		Response response = APIUtils.postAccount(paramMap);

		if (response.getStatusCode() != 200) {
			throw new RenewTokenException("Unable to renew access token");
		} else {
			LOG.info("Successfully renewed access token");
			accessToken = response.path("access_token");
			int expiresIn = response.path("expires_in");
			tokenExpiryTime = Instant.now().plusSeconds(expiresIn);
		}
		return response;
	}
}