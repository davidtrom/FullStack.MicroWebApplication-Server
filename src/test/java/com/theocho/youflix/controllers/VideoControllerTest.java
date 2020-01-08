package com.theocho.youflix.controllers;

import com.amazonaws.services.devicefarm.model.Run;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@WebMvcTest(VideoController.class)
public class VideoControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    VideoServices videoServices;

    @InjectMocks
    VideoController videoController;
    @MockBean
        VideoRepository videoRepository;
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
    public void createVideo() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .post("/videos")
                .content(asJsonString(new Video("sample title", "sample description", "sample url")))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));
        verify(videoServices,times(1)).create(any(Video.class));
    }

    public static String asJsonString(final Object obj){
        try{
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Test
    public void show() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .get("/videos/{id}", 1)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print());
        verify(videoServices, times(1)).showOne(1L);
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1));
    }

    @Test
    public void showAllVideos() throws Exception{
        this.mvc.perform(MockMvcRequestBuilders
                .get("/videos")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print());
        verify(videoServices, times(1)).showAll();
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.videos").exists())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.videos[*].id").isNotEmpty());
    }

}
