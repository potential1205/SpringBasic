package talkwith.semogong.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QEmailCodeEntity is a Querydsl query type for EmailCodeEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QEmailCodeEntity extends EntityPathBase<EmailCodeEntity> {

    private static final long serialVersionUID = -1111802593L;

    public static final QEmailCodeEntity emailCodeEntity = new QEmailCodeEntity("emailCodeEntity");

    public final StringPath code = createString("code");

    public final StringPath email = createString("email");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QEmailCodeEntity(String variable) {
        super(EmailCodeEntity.class, forVariable(variable));
    }

    public QEmailCodeEntity(Path<? extends EmailCodeEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QEmailCodeEntity(PathMetadata metadata) {
        super(EmailCodeEntity.class, metadata);
    }

}

