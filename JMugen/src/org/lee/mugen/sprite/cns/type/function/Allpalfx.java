package org.lee.mugen.sprite.cns.type.function;

import org.lee.mugen.core.StateMachine;
import org.lee.mugen.parser.type.Valueable;
import org.lee.mugen.renderer.PalFxSub;
import org.lee.mugen.sprite.character.Sprite;
import org.lee.mugen.sprite.cns.eval.function.StateCtrlFunction;
import org.lee.mugen.sprite.parser.ExpressionFactory;

/**
 * Render Problem
 * @author Dr Wong
 *
 */
public class Allpalfx extends StateCtrlFunction {
	
    public Allpalfx() {
        super("allpalfx", new String[] {"time", "add", "mul", "sinadd",
				"invertall", "color" });
	}
	public static Valueable[] parse(String name, String value) {
		String[] tokens = ExpressionFactory.expression2Tokens(value);
		Valueable[] vals = ExpressionFactory.evalExpression(tokens);
		return vals;
	}


	@Override
	public Object getValue(String spriteId, Valueable... params) {
		PalFxSub fx = StateMachine.getInstance().getGlobalEvents().getBgpalfx();
		fx.init();
		getValue(spriteId, StateMachine.getInstance().getGlobalEvents(), "bgpalfx", params);
		
		for (Sprite sprite: StateMachine.getInstance().getSprites()) {
			fx = sprite.getPalfx();
			fx.init();
			getValue(spriteId, sprite, "palfx", params);
		}
		
		return null;
	}
}
