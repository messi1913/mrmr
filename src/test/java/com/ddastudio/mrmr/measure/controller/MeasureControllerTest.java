package com.ddastudio.mrmr.measure.controller;

import com.ddastudio.mrmr.common.BaseControllerTest;
import org.junit.Test;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import static org.springframework.restdocs.headers.HeaderDocumentation.*;
import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.linkWithRel;
import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.links;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.relaxedResponseFields;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author messi1913@gmail.com
 * @Github http://github.com/messi1913
 * @since 2019/12/15
 */
public class MeasureControllerTest extends BaseControllerTest {

    @Test
    public void getMeasures() throws Exception {
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
                        links(
                                linkWithRel("self").description("Link to self"),
                                linkWithRel("profile").description("Link to profile")
                        ),
                        requestHeaders(
                                headerWithName(HttpHeaders.ACCEPT).description("Accept Type to Server")
                        ),
                        responseHeaders(
                                headerWithName(HttpHeaders.CONTENT_TYPE).description("Contents Type to Client")
                        ),
                        relaxedResponseFields(
                                fieldWithPath("_embedded.measureDTOList[].publishYear").type(String.class).description("Publish Year"),
                                fieldWithPath("_embedded.measureDTOList[].gender").type(Integer.class).description("Type of Gender (1:male, 2:female"),
                                fieldWithPath("_embedded.measureDTOList[].age").type(Integer.class).description("Age"),
                                fieldWithPath("_embedded.measureDTOList[].month").type(Integer.class).description("Month"),
                                fieldWithPath("_embedded.measureDTOList[].height").type(Long.class).description("Height"),
                                fieldWithPath("_embedded.measureDTOList[].fromMonth").type(Integer.class).description("Start month"),
                                fieldWithPath("_embedded.measureDTOList[].toMonth").type(Integer.class).description("End month"),
                                fieldWithPath("_links.self.href").type(String.class).description("Link to retrieve body information"),
                                fieldWithPath("_links.profile.href").type(String.class).description("Link to profile body information"),
                                fieldWithPath("page.size").type(String.class).description("Size of page"),
                                fieldWithPath("page.totalElements").type(String.class).description("The total number of elements"),
                                fieldWithPath("page.totalPages").type(String.class).description("The total number of pages"),
                                fieldWithPath("page.number").type(String.class).description("The current page number")
                        )
                ));

    }


    @Test
    public void getWeightByHeight() {
    }
}