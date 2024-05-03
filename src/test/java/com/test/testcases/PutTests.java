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
import com.test.pojo.PlayList;

import io.restassured.response.Response;

import static com.test.utils.RandomUtils.*;

@Listeners(TestListener.class)
public class PutTests {

	@TestAnnotation(author = { AMOL }, module = PLAYLIST)
	@Test(groups = REGRESSION, description = "Update a playlist")
	public void updateAPlayList() {
		PlayList requestedPlayList=PlayList.builder()
				.setName(getName())
				.setDescription(getDescription())
				.setIsPublic(false)
				.build();
		
		String playListID=ConfigFactory.create(IPlaylist.class).playlistid();
		Response response=PlayListApi.put(playListID, requestedPlayList);
		AssertionsUtil.isEqualsTo(response, StatusCode.CODE_200);
	}
}
