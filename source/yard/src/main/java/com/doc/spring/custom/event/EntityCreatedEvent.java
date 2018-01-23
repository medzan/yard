package com.doc.spring.custom.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.core.ResolvableType;
import org.springframework.core.ResolvableTypeProvider;

public class EntityCreatedEvent<T> extends ApplicationEvent implements ResolvableTypeProvider {

	private static final long serialVersionUID = 4489844130967537770L;

	public EntityCreatedEvent(T source) {
		super(source);
	}

	public ResolvableType getResolvableType() {
		ResolvableType type = ResolvableType.forClassWithGenerics(getClass(),
                ResolvableType.forInstance(getSource()));
		return type;
//		return null;
	}

}
