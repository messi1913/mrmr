package com.ddastudio.mrmr.measure.controller;

import com.ddastudio.mrmr.measure.MeasureParams;
import com.ddastudio.mrmr.measure.model.MeasureDTO;
import com.ddastudio.mrmr.measure.model.MeasureModel;
import com.ddastudio.mrmr.measure.service.MeasureService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author messi1913@gmail.com
 * @Github http://github.com/messi1913
 * @since 2019/12/08
 */

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/measures")
public class MeasureController {

    private final MeasureService service;

    @GetMapping
    public ResponseEntity<PagedResources<MeasureModel>> getMeasures(Pageable pageable, PagedResourcesAssembler<MeasureDTO> assembler, MeasureParams params) throws Exception {
        Page<MeasureDTO> measureDTOS = this.service.getInfoByCondition(params, pageable);
        PagedResources<MeasureModel> model = assembler.toResource(measureDTOS, r -> new MeasureModel(r));
        model.add(new Link("/docs/measure.html#resources-measure-list").withRel("profile"));
        return ResponseEntity.ok(model);
    }
}
