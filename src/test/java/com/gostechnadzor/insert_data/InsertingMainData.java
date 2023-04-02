package com.gostechnadzor.insert_data;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:Secret_data.properties")
public interface InsertingMainData extends Config {
    String login();
    String password();
    String site_port();
    String site();
    String remoteUrl();

}
