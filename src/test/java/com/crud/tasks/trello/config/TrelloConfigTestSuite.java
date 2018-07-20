package com.crud.tasks.trello.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrelloConfigTestSuite {
    @Autowired
    TrelloConfig trelloConfig;

    @Test
    public void testTrelloConfig() {
        assertEquals("michabanbura", trelloConfig.getTrelloUsername());
        assertEquals("https://api.trello.com/1", trelloConfig.getTrelloApiEndpoint());
        assertEquals("39258a03d58c23a1b904058bd8f9ad2c", trelloConfig.getTrelloAppKey());
        assertEquals("8420b48ca404d4504c0dce236469d96b4dc75055405947a5f483d7c379961919", trelloConfig.getTrelloToken());
    }
}
