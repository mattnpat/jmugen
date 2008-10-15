package org.lee.mugen.sprite.cns.type.function;

import org.lee.mugen.core.StateMachine;
import org.lee.mugen.parser.type.Valueable;
import org.lee.mugen.sprite.character.Sprite;
import org.lee.mugen.sprite.character.SpriteCns;
import org.lee.mugen.sprite.cns.eval.function.StateCtrlFunction;
import org.lee.mugen.sprite.parser.ExpressionFactory;
import org.lee.mugen.sprite.parser.Parser;

public class Sprpriority extends StateCtrlFunction {

	public Sprpriority() {
		super("sprpriority", new String[] {"value"});
	}
	
	@Override
	public Object getValue(String spriteId, Valueable... p) {
		Sprite sprite = StateMachine.getInstance().getSpriteInstance(spriteId);
		
		SpriteCns spriteInfo = sprite.getInfo();
		int valueIndex = getParamIndex("value");
		Valueable value = valueableParams[valueIndex][0];
		int ivalue = Parser.getIntValue(value.getValue(spriteId));

		spriteInfo.setSprpriority(ivalue);
		
		return null;
	}
	public static Valueable[] parse(String name, String value) {
		String[] tokens = ExpressionFactory.expression2Tokens(value);
		return ExpressionFactory.evalExpression(tokens);
	}
}
