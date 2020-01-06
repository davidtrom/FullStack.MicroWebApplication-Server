package com.theocho.youflix.controllers;

import com.theocho.youflix.models.Video;
import com.theocho.youflix.repositories.VideoRepository;
import com.theocho.youflix.services.VideoServices;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {TestContext.class, WebAppContext.class})

public class VideoControllerTest {

    @Mock
    VideoServices videoServices;
    @InjectMocks
    VideoController videoController;
    Video testVideo;

    @Before
    public void setUp() throws Exception {
        testVideo = new Video("sample title", "sample description", "sample url");
        testVideo.setId(1L);
//        videoServices = new VideoServices(videoRepository);
//        videoController = new VideoController(videoServices);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void createVideo() {
        // Given
        HttpStatus expected = HttpStatus.CREATED;
        when(videoServices.create(testVideo)).thenReturn(testVideo);
        // When
        ResponseEntity<Video> response = videoController.createVideo(testVideo);
        HttpStatus actual = response.getStatusCode();
        Video actualVideo = response.getBody();
        // Then
        Assert.assertEquals(expected,actual);
        Assert.assertEquals(testVideo, actualVideo);
    }

    @Test
    public void hello() {
        String expected = "Hello World";
        assertEquals(expected,videoController.hello());
    }

    @Test
    public void show() {
        // given
        Long testVideoId = 1L;
        HttpStatus expectedHttpStatus = HttpStatus.OK;
        Video expectedVideo = new Video(null, null, null);
        BDDMockito
                .given(videoServices.showOne(testVideoId))
                .willReturn(expectedVideo);
        // when
        ResponseEntity<Video> response = videoController.show(testVideoId);
        HttpStatus actualHttpStatus = response.getStatusCode();
        Video actualVideo = response.getBody();
        // then
        Assert.assertEquals(expectedHttpStatus,actualHttpStatus);
//        Assert.assertEquals(expectedVideo, actualVideo);
    }

    @Test
    public void showAllVideos() {
        assertEquals(1,2);
    }
}
