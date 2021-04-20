package com.sparta.wahdel.nbastatsspringproject.utils;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.id.IdentityGenerator;

import java.io.Serializable;

/**
 * This class auto generates an Id if no value is passed else it assigns the passed value
 */
public class IDGenerator extends IdentityGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) {
        Serializable id = session.getEntityPersister(null, object)
                .getClassMetadata().getIdentifier(object, session);
        return id != null ? id : super.generate(session, object);
    }
}