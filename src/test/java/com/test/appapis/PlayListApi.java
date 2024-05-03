package com.test.appapis;

import com.test.pojo.PlayList;
import com.test.utils.APIUtils;
import static com.test.constants.Route.*;

import org.aeonbits.owner.ConfigFactory;

import com.test.iowner.IPlaylist;

import io.restassured.response.Response;

public final class PlayListApi {

	private PlayListApi() {

	}

	private static IPlaylist iPlaylist = ConfigFactory.create(IPlaylist.class);

	public static Response get(String playListID) {
		return APIUtils.get(PLAYLISTS + "/" + playListID);
	}

	public static Response post(PlayList requestedPlayList) {
		return APIUtils.post(USERS + "/" + iPlaylist.userid() + "/" + PLAYLISTS, requestedPlayList);
	}

	public static Response put(String playListID, PlayList requestedPlayList) {
		return APIUtils.put("/" + PLAYLISTS + "/" + playListID, requestedPlayList);
	}
}
