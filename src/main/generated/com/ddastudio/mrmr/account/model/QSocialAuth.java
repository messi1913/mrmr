package com.ddastudio.mrmr.account.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSocialAuth is a Querydsl query type for SocialAuth
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSocialAuth extends EntityPathBase<SocialAuth> {

    private static final long serialVersionUID = -116854373L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSocialAuth socialAuth = new QSocialAuth("socialAuth");

    public final StringPath accessToken = createString("accessToken");

    public final NumberPath<java.math.BigDecimal> expireTime = createNumber("expireTime", java.math.BigDecimal.class);

    public final QSocialAuthId id;

    public final StringPath refreshToken = createString("refreshToken");

    public final StringPath secret = createString("secret");

    public QSocialAuth(String variable) {
        this(SocialAuth.class, forVariable(variable), INITS);
    }

    public QSocialAuth(Path<? extends SocialAuth> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSocialAuth(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSocialAuth(PathMetadata metadata, PathInits inits) {
        this(SocialAuth.class, metadata, inits);
    }

    public QSocialAuth(Class<? extends SocialAuth> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.id = inits.isInitialized("id") ? new QSocialAuthId(forProperty("id")) : null;
    }

}

