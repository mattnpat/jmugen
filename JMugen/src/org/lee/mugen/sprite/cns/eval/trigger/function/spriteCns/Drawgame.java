package org.lee.mugen.sprite.cns.eval.trigger.function.spriteCns;

import org.lee.mugen.core.StateMachine;
import org.lee.mugen.parser.type.Valueable;
import org.lee.mugen.sprite.character.Sprite;
import org.lee.mugen.sprite.cns.eval.function.SpriteCnsTriggerFunction;

public class Drawgame extends SpriteCnsTriggerFunction {

	// TODO : Drawgame
	public Drawgame() {
		super("drawgame", new String[] {});
	}

	@Override
	public Object getValue(String spriteId, Valueable... params) {
		int lifeTeamOne = 0;
		int lifeTeamTwo = 0;
		
		for (Sprite s: StateMachine.getInstance().getTeamOne().values()) {
			if (s.getClass() == Sprite.class) {
				lifeTeamOne += s.getInfo().getLife();
			}
		}
		for (Sprite s: StateMachine.getInstance().getTeamTwo().values()) {
			if (s.getClass() == Sprite.class) {
				lifeTeamTwo += s.getInfo().getLife();
			}
		}
		return (lifeTeamOne == lifeTeamTwo) /* TODO : gamestate */? 1: 0;
	}
}
