package com.sso.domains;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QImmutable is a Querydsl query type for Immutable
 */
@Generated("com.querydsl.codegen.DefaultSupertypeSerializer")
public class QImmutable extends EntityPathBase<Immutable> {

    private static final long serialVersionUID = 1152663447L;

    public static final QImmutable immutable = new QImmutable("immutable");

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final StringPath createdBy = createString("createdBy");

    public QImmutable(String variable) {
        super(Immutable.class, forVariable(variable));
    }

    public QImmutable(Path<? extends Immutable> path) {
        super(path.getType(), path.getMetadata());
    }

    public QImmutable(PathMetadata metadata) {
        super(Immutable.class, metadata);
    }

}

