package com.test.testcases;

import org.aeonbits.owner.ConfigFactory;
import static com.test.constants.Author.*;
import static com.test.constants.Module.*;
import static com.test.constants.Group.*;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.test.annotations.TestAnnotation;
import com.test.appapis.PlayListApi;
import com.test.assertions.AssertionsUtil;
import com.test.enums.StatusCode;
import com.test.iowner.IPlaylist;
import com.test.listener.TestListener;

import io.restassured.response.Response;

@Listeners(TestListener.class)
public class GetTests {

	@TestAnnotation(author = { AMOL }, module = PLAYLIST)
	@Test(groups = SMOKE, description = "Get a playlist")
	public void GetAPlayList() {
		String playListID = ConfigFactory.create(IPlaylist.class).playlistid();
		Response response = PlayListApi.get(playListID);
		AssertionsUtil.isEqualsTo(response, StatusCode.CODE_200);

	}

}
