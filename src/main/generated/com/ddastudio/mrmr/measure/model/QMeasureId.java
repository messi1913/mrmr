package com.ddastudio.mrmr.measure.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMeasureId is a Querydsl query type for MeasureId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QMeasureId extends BeanPath<MeasureId> {

    private static final long serialVersionUID = -1790120796L;

    public static final QMeasureId measureId = new QMeasureId("measureId");

    public final NumberPath<Integer> age = createNumber("age", Integer.class);

    public final NumberPath<Integer> gender = createNumber("gender", Integer.class);

    public final NumberPath<Integer> month = createNumber("month", Integer.class);

    public final StringPath publishYear = createString("publishYear");

    public QMeasureId(String variable) {
        super(MeasureId.class, forVariable(variable));
    }

    public QMeasureId(Path<? extends MeasureId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMeasureId(PathMetadata metadata) {
        super(MeasureId.class, metadata);
    }

}

