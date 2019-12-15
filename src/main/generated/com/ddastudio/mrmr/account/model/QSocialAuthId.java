package com.ddastudio.mrmr.account.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSocialAuthId is a Querydsl query type for SocialAuthId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QSocialAuthId extends BeanPath<SocialAuthId> {

    private static final long serialVersionUID = -627900394L;

    public static final QSocialAuthId socialAuthId = new QSocialAuthId("socialAuthId");

    public final StringPath accountId = createString("accountId");

    public final StringPath provider_id = createString("provider_id");

    public QSocialAuthId(String variable) {
        super(SocialAuthId.class, forVariable(variable));
    }

    public QSocialAuthId(Path<? extends SocialAuthId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSocialAuthId(PathMetadata metadata) {
        super(SocialAuthId.class, metadata);
    }

}

