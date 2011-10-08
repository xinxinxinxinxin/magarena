package magic.card;

import magic.model.trigger.MagicBecomesBlockedPumpTrigger;
import magic.model.trigger.MagicWhenBlocksPumpTrigger;

public class Samurai_Enforcers {
	private static final int amount = 2;
	
	public static final MagicBecomesBlockedPumpTrigger T1 = new MagicBecomesBlockedPumpTrigger(amount,amount);
	
	public static final MagicWhenBlocksPumpTrigger T2 = new MagicWhenBlocksPumpTrigger(amount,amount);
}
