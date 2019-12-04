package com.ddastudio.mrmr.account;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QChild is a Querydsl query type for Child
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QChild extends EntityPathBase<Child> {

    private static final long serialVersionUID = -54485829L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QChild child = new QChild("child");

    public final QAccount account;

    public final DateTimePath<java.time.LocalDateTime> birthday = createDateTime("birthday", java.time.LocalDateTime.class);

    public final StringPath color = createString("color");

    public final NumberPath<Integer> gender = createNumber("gender", Integer.class);

    public final NumberPath<Double> headCircumference = createNumber("headCircumference", Double.class);

    public final NumberPath<Double> height = createNumber("height", Double.class);

    public final StringPath icon = createString("icon");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath name = createString("name");

    public final StringPath useYn = createString("useYn");

    public final NumberPath<Double> weight = createNumber("weight", Double.class);

    public QChild(String variable) {
        this(Child.class, forVariable(variable), INITS);
    }

    public QChild(Path<? extends Child> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QChild(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QChild(PathMetadata metadata, PathInits inits) {
        this(Child.class, metadata, inits);
    }

    public QChild(Class<? extends Child> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.account = inits.isInitialized("account") ? new QAccount(forProperty("account")) : null;
    }

}

