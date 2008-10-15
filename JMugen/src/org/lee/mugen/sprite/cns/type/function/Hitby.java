package org.lee.mugen.sprite.cns.type.function;

import org.lee.mugen.core.StateMachine;
import org.lee.mugen.parser.type.Valueable;
import org.lee.mugen.sprite.character.Sprite;
import org.lee.mugen.sprite.character.spiteCnsSubClass.HitBySub;
import org.lee.mugen.sprite.character.spiteCnsSubClass.ReversaldefSub.ReversalAttrClass;
import org.lee.mugen.sprite.cns.eval.function.StateCtrlFunction;
import org.lee.mugen.sprite.parser.ExpressionFactory;
import org.lee.mugen.util.BeanTools;

public class Hitby extends StateCtrlFunction {
	// TODO do it in SpriteCns
	public Hitby() {
		super("hitby", new String[] {"value", "value2", "time"});
	}
	@Override
	public Object getValue(String spriteId, Valueable... p) {
		Sprite sprite = StateMachine.getInstance().getSpriteInstance(spriteId);

		HitBySub hitBySub = new HitBySub();
		hitBySub.setTime(1); 
		fillBean(spriteId, hitBySub);
		
		// + 1 because in this time binding time is decrease of 1
		hitBySub.addTime(1);
		
		sprite.getInfo().setHitby(hitBySub);
		return null;
	}
	public static Valueable[] parse(String name, String value) {
		return ExpressionFactory.evalExpression(value);
	}
	// TODO HITBY
	public static Valueable[] parseForValue(String name, String value) {
		final Object v = BeanTools.getConvertersMap().get(ReversalAttrClass.class).convert(value);
		Valueable[] vals = new Valueable[1];
		vals = new Valueable[1];
		vals[0] = new Valueable() {
			public Object getValue(String spriteId, Valueable... params) {
				return v;
			}
		};
		return vals;
	}
	public static Valueable[] parseForValue2(String name, String value) {
		final Object v = BeanTools.getConvertersMap().get(ReversalAttrClass.class).convert(value);
		Valueable[] vals = new Valueable[1];
		vals = new Valueable[1];
		vals[0] = new Valueable() {
			public Object getValue(String spriteId, Valueable... params) {
				return v;
			}
		};
		return vals;
	}
}
