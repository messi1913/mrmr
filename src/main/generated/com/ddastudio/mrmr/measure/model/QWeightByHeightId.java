package com.ddastudio.mrmr.measure.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QWeightByHeightId is a Querydsl query type for WeightByHeightId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QWeightByHeightId extends BeanPath<WeightByHeightId> {

    private static final long serialVersionUID = 1461395142L;

    public static final QWeightByHeightId weightByHeightId = new QWeightByHeightId("weightByHeightId");

    public final NumberPath<Integer> fromMonth = createNumber("fromMonth", Integer.class);

    public final NumberPath<Integer> gender = createNumber("gender", Integer.class);

    public final NumberPath<Double> height = createNumber("height", Double.class);

    public final StringPath publishYear = createString("publishYear");

    public final NumberPath<Integer> toMonth = createNumber("toMonth", Integer.class);

    public QWeightByHeightId(String variable) {
        super(WeightByHeightId.class, forVariable(variable));
    }

    public QWeightByHeightId(Path<? extends WeightByHeightId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QWeightByHeightId(PathMetadata metadata) {
        super(WeightByHeightId.class, metadata);
    }

}

