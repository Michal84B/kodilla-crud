package com.crud.tasks.trello.mapper;

import com.crud.tasks.domain.*;
import com.crud.tasks.mapper.TrelloMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrelloMapperTestSuite {
    @Autowired
    TrelloMapper trelloMapper;

    @Test
    public void testMapToBoards() {
        //Given
        List<TrelloBoardDto> trelloBoardDto = new ArrayList<>();
        List<TrelloListDto> trelloListDto = new ArrayList<>();
        trelloListDto.add(new TrelloListDto("List1", "id1", false));
        trelloBoardDto.add(new TrelloBoardDto("Board1", "id1", trelloListDto));
        //When
        List<TrelloBoard> trelloBoard = trelloMapper.mapToBoards(trelloBoardDto);
        //Then
        assertEquals("Board1", trelloBoard.get(0).getName());
        assertEquals(1, trelloBoard.get(0).getLists().size());
    }
    @Test
    public void testMapToBoardsDto() {
        //Given
        List<TrelloBoard> trelloBoard = new ArrayList<>();
        List<TrelloList> trelloList = new ArrayList<>();
        trelloList.add(new TrelloList("id1", "List1", false));
        trelloBoard.add(new TrelloBoard("id1", "Board1", trelloList));
        //When
        List<TrelloBoardDto> trelloBoardDto = trelloMapper.mapToBoardsDto(trelloBoard);
        //Then
        assertEquals("Board1", trelloBoardDto.get(0).getName());
        assertEquals(1, trelloBoardDto.get(0).getLists().size());
    }
    @Test
    public void testMapToList() {
        //Given
        List<TrelloListDto> trelloListDto = new ArrayList<>();
        trelloListDto.add(new TrelloListDto("List1", "id1", false));
        //When
        List<TrelloList> trelloList = trelloMapper.mapToList(trelloListDto);
        //Then
        assertEquals("List1", trelloList.get(0).getName());
        assertEquals(1, trelloList.size());
    }
    @Test
    public void testMapToListDto() {
        //Given
        List<TrelloList> trelloList = new ArrayList<>();
        trelloList.add(new TrelloList("id1", "List1", false));
        //When
        List<TrelloListDto> trelloListDto = trelloMapper.mapToListDto(trelloList);
        //Then
        assertEquals("List1", trelloListDto.get(0).getName());
        assertEquals(1, trelloList.size());
    }
    @Test
    public void testMapToCardDto() {
        //Given
        TrelloCard trelloCard = new TrelloCard("Card1", "New card1", "pos1", "List1");
        //When
        TrelloCardDto trelloCardDto = trelloMapper.mapToCardDto(trelloCard);
        //Then
        assertEquals("Card1", trelloCardDto.getName());
        assertEquals("New card1", trelloCardDto.getDescription());
        assertEquals("pos1", trelloCardDto.getPos());
        assertEquals("List1", trelloCardDto.getListId());
    }
    @Test
    public void testMapToCard() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("Card1", "New card1", "pos1", "List1");
        //When
        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto);
        //Then
        assertEquals("Card1", trelloCardDto.getName());
        assertEquals("New card1", trelloCardDto.getDescription());
        assertEquals("pos1", trelloCardDto.getPos());
        assertEquals("List1", trelloCardDto.getListId());
    }
}
