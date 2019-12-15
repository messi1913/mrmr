package com.ddastudio.mrmr.measure.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBmi is a Querydsl query type for Bmi
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QBmi extends EntityPathBase<Bmi> {

    private static final long serialVersionUID = 403726153L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBmi bmi = new QBmi("bmi");

    public final QMeasureId id;

    public final NumberPath<Double> l = createNumber("l", Double.class);

    public final NumberPath<Double> m = createNumber("m", Double.class);

    public final NumberPath<Double> per1 = createNumber("per1", Double.class);

    public final NumberPath<Double> per10 = createNumber("per10", Double.class);

    public final NumberPath<Double> per15 = createNumber("per15", Double.class);

    public final NumberPath<Double> per25 = createNumber("per25", Double.class);

    public final NumberPath<Double> per3 = createNumber("per3", Double.class);

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

    public QBmi(String variable) {
        this(Bmi.class, forVariable(variable), INITS);
    }

    public QBmi(Path<? extends Bmi> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBmi(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBmi(PathMetadata metadata, PathInits inits) {
        this(Bmi.class, metadata, inits);
    }

    public QBmi(Class<? extends Bmi> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.id = inits.isInitialized("id") ? new QMeasureId(forProperty("id")) : null;
    }

}

