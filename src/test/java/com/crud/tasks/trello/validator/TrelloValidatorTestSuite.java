package com.crud.tasks.trello.validator;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloCard;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class TrelloValidatorTestSuite {
    @Mock
    TrelloValidator trelloValidator;

    @Test
    public void testValidateCard() {
        //Given
        TrelloCard trelloCard1 = new TrelloCard("test", "description", "pos", "1");
        TrelloCard trelloCard2 = new TrelloCard("card", "description", "pos", "2");
        //When
        trelloValidator.validateCard(trelloCard1);
        trelloValidator.validateCard(trelloCard2);
        //Then
        verify(trelloValidator, times(1)).validateCard(trelloCard1);
        verify(trelloValidator, times(1)).validateCard(trelloCard2);
    }
    @Test
    public void testValidateTrelloBoards() {
        //Given
        TrelloBoard trelloBoard1 = new TrelloBoard("1", "test", new ArrayList<>());
        TrelloBoard trelloBoard2 = new TrelloBoard("2", "board", new ArrayList<>());
        List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(trelloBoard1);
        trelloBoards.add(trelloBoard2);
        TrelloValidator trelloValidator = new TrelloValidator();
        //When
        List<TrelloBoard> validatedBoards = trelloValidator.validateTrelloBoards(trelloBoards);
        //Then
        assertEquals(1, validatedBoards.size());
    }
}
