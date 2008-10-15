package org.lee.mugen.sprite.cns.type.function;

import org.lee.mugen.core.StateMachine;
import org.lee.mugen.parser.type.Valueable;
import org.lee.mugen.sprite.character.Sprite;
import org.lee.mugen.sprite.character.SpriteCns;
import org.lee.mugen.sprite.cns.eval.function.StateCtrlFunction;
import org.lee.mugen.sprite.parser.ExpressionFactory;

public class Statetypeset extends StateCtrlFunction {

	// TODO : Statetypeset
	public Statetypeset() {
		super("statetypeset", new String[] {"physics", "statetype", "movetype"});
	}
	public static Valueable[] parse(String name, String value) {
		String[] tokens = ExpressionFactory.expression2Tokens(value);
		return ExpressionFactory.evalExpression(tokens);
	}
	@Override
	public Object getValue(String spriteId, Valueable... p) {
		Sprite sprite = StateMachine.getInstance().getSpriteInstance(spriteId);
		SpriteCns sprInfo = sprite.getInfo();
		
		int physicIndex = getParamIndex("physics");
		if (valueableParams[physicIndex] != null) {
			Valueable physic = valueableParams[physicIndex][0];
			if (physic != null) {
				String sphysic = physic.getValue(spriteId).toString().toUpperCase();
				sprInfo.setPhysics(sphysic);
			}
			
		}
		int statetypeIndex = getParamIndex("statetype");
		if (valueableParams[statetypeIndex] != null) {
			Valueable statetype = valueableParams[statetypeIndex][0];
			if (statetype != null) {
				String fstatetype = statetype.getValue(spriteId).toString().toUpperCase();
				sprInfo.setType(fstatetype);
			}		
		}
		int movetypeIndex = getParamIndex("movetype");
		if (valueableParams[movetypeIndex] != null) {
			
			Valueable movetype = valueableParams[movetypeIndex][0];
			if (movetype != null) {
				String fmovetype = movetype.getValue(spriteId).toString().toUpperCase();
				sprInfo.setMovetype(fmovetype);
			}
		}
		return null;
	}
}
