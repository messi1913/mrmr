package com.ddastudio.mrmr.measure;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QHeight is a Querydsl query type for Height
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QHeight extends EntityPathBase<Height> {

    private static final long serialVersionUID = -1775503081L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QHeight height = new QHeight("height");

    public final QMeasureId id;

    public final NumberPath<Double> l = createNumber("l", Double.class);

    public final NumberPath<Double> m = createNumber("m", Double.class);

    public final NumberPath<Double> per1 = createNumber("per1", Double.class);

    public final NumberPath<Double> per10 = createNumber("per10", Double.class);

    public final NumberPath<Double> per15 = createNumber("per15", Double.class);

    public final NumberPath<Double> per2 = createNumber("per2", Double.class);

    public final NumberPath<Double> per25 = createNumber("per25", Double.class);

    public final NumberPath<Double> per5 = createNumber("per5", Double.class);

    public final NumberPath<Double> per50 = createNumber("per50", Double.class);

    public final NumberPath<Double> per75 = createNumber("per75", Double.class);

    public final NumberPath<Double> per85 = createNumber("per85", Double.class);

    public final NumberPath<Double> per90 = createNumber("per90", Double.class);

    public final NumberPath<Double> per95 = createNumber("per95", Double.class);

    public final NumberPath<Double> per97 = createNumber("per97", Double.class);

    public final NumberPath<Double> per99 = createNumber("per99", Double.class);

    public final NumberPath<Double> s = createNumber("s", Double.class);

    public final NumberPath<Double> std0 = createNumber("std0", Double.class);

    public final NumberPath<Double> stdl1 = createNumber("stdl1", Double.class);

    public final NumberPath<Double> stdl2 = createNumber("stdl2", Double.class);

    public final NumberPath<Double> stdl3 = createNumber("stdl3", Double.class);

    public final NumberPath<Double> stdr1 = createNumber("stdr1", Double.class);

    public final NumberPath<Double> stdr2 = createNumber("stdr2", Double.class);

    public final NumberPath<Double> stdr3 = createNumber("stdr3", Double.class);

    public QHeight(String variable) {
        this(Height.class, forVariable(variable), INITS);
    }

    public QHeight(Path<? extends Height> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QHeight(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QHeight(PathMetadata metadata, PathInits inits) {
        this(Height.class, metadata, inits);
    }

    public QHeight(Class<? extends Height> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.id = inits.isInitialized("id") ? new QMeasureId(forProperty("id")) : null;
    }

}

