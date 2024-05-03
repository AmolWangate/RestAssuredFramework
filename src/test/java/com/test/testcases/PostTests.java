package com.test.testcases;

import static org.assertj.core.api.Assertions.assertThat;
import static com.test.constants.Author.*;
import static com.test.constants.Module.*;
import static com.test.constants.Group.*;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.test.annotations.TestAnnotation;
import com.test.appapis.PlayListApi;
import com.test.assertions.AssertionsUtil;
import com.test.enums.StatusCode;
import com.test.listener.TestListener;
import com.test.pojo.PlayList;

import io.restassured.response.Response;

import static com.test.utils.RandomUtils.*;

@Listeners(TestListener.class)
public class PostTests {
	
	@TestAnnotation(author = { AMOL }, module = PLAYLIST)
	@Test(groups = REGRESSION, description = "Create a playlist")
	public void createAPlaylist() {	
		PlayList requestedPlayList=PlayList.builder()
				.setName(getName())
				.setDescription(getDescription())
				.setIsPublic(false)
				.build();
		
		Response response=PlayListApi.post(requestedPlayList);
		AssertionsUtil.isEqualsTo(response, StatusCode.CODE_201);
		PlayList responsePlayList=response.as(PlayList.class);
		assertThat(responsePlayList.getName()).isEqualTo(requestedPlayList.getName());
				
		
	}

}
