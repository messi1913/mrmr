package com.ddastudio.mrmr.measure.controller;

import com.ddastudio.mrmr.common.BaseControllerTest;
import org.junit.jupiter.api.Test;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.Collections;

import static org.springframework.restdocs.headers.HeaderDocumentation.*;
import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.linkWithRel;
import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.links;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author messi1913@gmail.com
 * @Github http://github.com/messi1913
 * @since 2019/12/15
 */
class MeasureControllerTest extends BaseControllerTest {

    @Test
    void getMeasures() throws Exception {
        mockMvc.perform(get("/api/measures")
                .accept(MediaTypes.HAL_JSON)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .param("type", "bmi")
                .param("gender", "1")
                .param("age", "2")
                .param("page", "0")
                .param("size", "1000"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("_embedded.measureDTOList[0].publishYear").exists())
                .andExpect(jsonPath("_embedded.measureDTOList[0].gender").exists())
                .andExpect(jsonPath("_links.self").exists())
                .andExpect(jsonPath("_links.profile").exists())
                .andDo(document("get-measures",
//                        links(
//                                linkWithRel("self").description("Link to self"),
//                                linkWithRel("profile").description("Link to profile")
//                        ),
                        requestHeaders(
                                headerWithName(HttpHeaders.ACCEPT).description("Accept Type to Server")
                        ),
                        responseHeaders(
                                headerWithName(HttpHeaders.CONTENT_TYPE).description("Contents Type to Client")
                        ),
                        relaxedResponseFields(
//                                fieldWithPath("_embedded.measureDTOList[].publishYear").type(String.class).description("Publish Year"),
//                                fieldWithPath("_embedded.measureDVOList[].gender").type(Integer.class).description("Type of Gender (1:male, 2:female"),
//                                fieldWithPath("_embedded.measureDVOList[].age").type(Integer.class).description("Age"),
//                                fieldWithPath("_embedded.measureDVOList[].month").type(Integer.class).description("Month"),
//                                fieldWithPath("_embedded.measureDVOList[].height").type(Long.class).description("Height"),
//                                fieldWithPath("_embedded.measureDVOList[].fromMonth").type(Integer.class).description("Start month"),
//                                fieldWithPath("_embedded.measureDVOList[].toMonth").type(Integer.class).description("End month"),
//                                fieldWithPath("_links.self.href").type(String.class).description("Link to retrieve body information"),
//                                fieldWithPath("_links.profile.href").type(String.class).description("Link to profile body information"),
//                                fieldWithPath("_links.first.href").type(String.class).description("Link to first page of reservations"),
//                                fieldWithPath("_links.last.href").type(String.class).description("Link to last page of reservations"),
//                                fieldWithPath("_links.prev.href").type(String.class).description("Link to previous page of reservations"),
//                                fieldWithPath("_links.next.href").type(String.class).description("Link to next page of reservations"),
                                fieldWithPath("page.size").type(String.class).description("Size of page"),
                                fieldWithPath("page.totalElements").type(String.class).description("The total number of elements"),
                                fieldWithPath("page.totalPages").type(String.class).description("The total number of pages"),
                                fieldWithPath("page.number").type(String.class).description("The current page number")
                        )
                ));

    }


    @Test
    void getWeightByHeight() {
    }
}