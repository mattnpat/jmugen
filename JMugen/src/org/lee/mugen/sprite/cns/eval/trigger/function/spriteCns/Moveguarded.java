package org.lee.mugen.sprite.cns.eval.trigger.function.spriteCns;

import java.util.LinkedList;

import org.lee.mugen.core.FightEngine;
import org.lee.mugen.core.StateMachine;
import org.lee.mugen.parser.type.Valueable;
import org.lee.mugen.sprite.character.Sprite;
import org.lee.mugen.sprite.character.SpriteHelper;
import org.lee.mugen.sprite.character.SpriteCns.MoveType;
import org.lee.mugen.sprite.character.spiteCnsSubClass.HitDefSub;
import org.lee.mugen.sprite.character.spiteCnsSubClass.ReversaldefSub;
import org.lee.mugen.sprite.cns.eval.function.SpriteCnsTriggerFunction;

public class Moveguarded extends SpriteCnsTriggerFunction {

	// TODO : Moveguarded
	public Moveguarded() {
		super("moveguarded", new String[] {});
	}

	@Override
	public Object getValue(String spriteId, Valueable... params) {
		Sprite one = StateMachine.getInstance().getSpriteInstance(spriteId);
		if (one.getInfo().getMovetype() == MoveType.A) {
			LinkedList<HitDefSub> hitdefs = StateMachine.getInstance().getFightEngine().getHitdefBySpriteHitter(spriteId);
			HitDefSub strictHitdef = null;
			for (HitDefSub h: hitdefs)
				if (h.getClass() != ReversaldefSub.class)
					strictHitdef = h;
			if (hitdefs.size() > 0 && (strictHitdef != null && strictHitdef.getTargetId() == null))
				return 0;
//			boolean isHitDefWithHitExist = false;
//			for (HitDefSub h: hitdefs)
//				if (h.getTargetId() == null)
//					isHitDefWithHitExist = true;
//			if (!isHitDefWithHitExist)
//				return 0;
			for (Sprite s: StateMachine.getInstance().getSprites()) {
				if (s == one || (s instanceof SpriteHelper))
					continue;
				if (s.getInfo().getLastHitdef() == null || !spriteId.equals(s.getInfo().getLastHitdef().getSpriteId())) {
					continue;
					
				} else if (FightEngine.isBlockState(s)) {
					continue;
				} else if (FightEngine.isBlockState(s) 
						&& spriteId.equals(s.getInfo().getLastHitdef().getSpriteId()) 
//						&& s.getInfo().getLastHitdef().getHittime() > 0
						&& s.getInfo().getLastHitdef().getLastTimeHitSomething() == s.getInfo().getLastHitdef().getLastTimeBlockBySomething()
						&& s.getInfo().getLastHitdef().getLastTimeBlockBySomething() + 1 < StateMachine.getInstance().getGameState().getGameTime()
				) {
					return 1;
				}
			}
		}
		return 0;
	}
}
