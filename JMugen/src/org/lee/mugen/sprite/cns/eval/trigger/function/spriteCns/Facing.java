package org.lee.mugen.sprite.cns.eval.trigger.function.spriteCns;

import org.lee.mugen.core.StateMachine;
import org.lee.mugen.parser.type.Valueable;
import org.lee.mugen.sprite.cns.eval.function.SpriteCnsTriggerFunction;

public class Facing extends SpriteCnsTriggerFunction {

	public Facing() {
		super("facing", new String[] {});
	}

	@Override
	public Object getValue(String spriteId, Valueable... params) {
		return StateMachine.getInstance().getSpriteInstance(spriteId).isFlip()? -1: 1;
	}

}
