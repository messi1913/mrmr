package com.ddastudio.mrmr.measure.model;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;

/**
 * @author messi1913@gmail.com
 * @Github http://github.com/messi1913
 * @since 2019/12/15
 */
public class WeightByHeightModel extends EntityModel<WeightByHeight> {
    public WeightByHeightModel(WeightByHeight content, Link... links) {
        super(content, links);
    }
}
