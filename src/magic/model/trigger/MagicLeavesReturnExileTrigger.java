package magic.model.trigger;

import magic.model.MagicGame;
import magic.model.MagicLocationType;
import magic.model.MagicPermanent;
import magic.model.MagicCardList;
import magic.model.action.MagicReturnExiledUntilThisLeavesPlayAction;
import magic.model.event.MagicEvent;

public class MagicLeavesReturnExileTrigger extends MagicWhenLeavesPlayTrigger {

    private static final MagicLeavesReturnExileTrigger INSTANCE = new MagicLeavesReturnExileTrigger();

    private MagicLeavesReturnExileTrigger() {}

    public static final MagicLeavesReturnExileTrigger create() {
        return INSTANCE;
    }
    
    @Override
    public MagicEvent executeTrigger(final MagicGame game,final MagicPermanent permanent, final MagicPermanent left) {
        if (permanent == left &&
            !permanent.getExiledCards().isEmpty()) {
            final MagicCardList clist = new MagicCardList(permanent.getExiledCards());
            return new MagicEvent(
                permanent,
                this,
                clist.size() > 1 ?
                    "Return exiled cards to the battlefield." :
                    "Return " + clist.get(0) + " to the battlefield."
            );
        }
        return MagicEvent.NONE;
    }
    @Override
    public void executeEvent(final MagicGame game, final MagicEvent event) {
        game.doAction(new MagicReturnExiledUntilThisLeavesPlayAction(event.getPermanent(),MagicLocationType.Play));
    }
}
