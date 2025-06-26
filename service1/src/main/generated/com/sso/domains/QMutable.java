package com.sso.domains;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMutable is a Querydsl query type for Mutable
 */
@Generated("com.querydsl.codegen.DefaultSupertypeSerializer")
public class QMutable extends EntityPathBase<Mutable> {

    private static final long serialVersionUID = -1152442757L;

    public static final QMutable mutable = new QMutable("mutable");

    public final QImmutable _super = new QImmutable(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final DateTimePath<java.time.LocalDateTime> updatedAt = createDateTime("updatedAt", java.time.LocalDateTime.class);

    public final StringPath updatedBy = createString("updatedBy");

    public QMutable(String variable) {
        super(Mutable.class, forVariable(variable));
    }

    public QMutable(Path<? extends Mutable> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMutable(PathMetadata metadata) {
        super(Mutable.class, metadata);
    }

}

