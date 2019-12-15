package com.ddastudio.mrmr;

import com.ddastudio.mrmr.common.BaseControllerTest;
import com.ddastudio.mrmr.measure.MeasureParams;
import com.ddastudio.mrmr.measure.model.Bmi;
import com.ddastudio.mrmr.measure.model.MeasureDTO;
import com.ddastudio.mrmr.measure.model.QMeasureId;
import com.ddastudio.mrmr.measure.service.MeasureService;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * @author messi1913@gmail.com
 * @Github http://github.com/messi1913
 * @since 2019/12/15
 */
public class UnitTest extends BaseControllerTest {

    @Autowired
    MeasureService service;

    @Test
    public void test() throws Exception {
        MeasureParams params = new MeasureParams();
        params.setGender(1);


        mockMvc.perform(get("/api/measures/conditions")
                .param("type", "bmi")
                .param("gender", "1")
                .param("page", "0")
                .param("size", "10"))
                .andDo(print());

    }
}
