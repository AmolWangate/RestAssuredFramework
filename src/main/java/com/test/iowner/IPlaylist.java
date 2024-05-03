package com.test.iowner;

import org.aeonbits.owner.Config;

@Config.Sources(value = "file:${user.dir}/src/test/resources/playlist.properties")
public interface IPlaylist extends Config {

	String userid();

	String playlistid();
}
