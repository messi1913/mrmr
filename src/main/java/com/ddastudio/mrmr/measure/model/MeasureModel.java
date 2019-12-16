package com.ddastudio.mrmr.measure.model;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;

/**
 * @author messi1913@gmail.com
 * @Github http://github.com/messi1913
 * @since 2019/12/15
 */
public class MeasureModel extends Resource<MeasureDTO> {
    public MeasureModel(MeasureDTO content, Link... links) {
        super(content, links);
    }
}
