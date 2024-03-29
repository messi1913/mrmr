package com.ddastudio.mrmr.history.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QRecordId is a Querydsl query type for RecordId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QRecordId extends BeanPath<RecordId> {

    private static final long serialVersionUID = -1968777109L;

    public static final QRecordId recordId = new QRecordId("recordId");

    public final DateTimePath<java.time.LocalDateTime> measureDate = createDateTime("measureDate", java.time.LocalDateTime.class);

    public final NumberPath<Integer> profileId = createNumber("profileId", Integer.class);

    public QRecordId(String variable) {
        super(RecordId.class, forVariable(variable));
    }

    public QRecordId(Path<? extends RecordId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRecordId(PathMetadata metadata) {
        super(RecordId.class, metadata);
    }

}

