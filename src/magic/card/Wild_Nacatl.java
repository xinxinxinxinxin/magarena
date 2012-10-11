package magic.card;

import magic.model.MagicGame;
import magic.model.MagicPermanent;
import magic.model.MagicPowerToughness;
import magic.model.mstatic.MagicLayer;
import magic.model.mstatic.MagicStatic;
import magic.model.target.MagicTarget;
import magic.model.target.MagicTargetFilter;

import java.util.Collection;

public class Wild_Nacatl {
    public static final MagicStatic S = new MagicStatic(MagicLayer.ModPT) {
        @Override
        public void modPowerToughness(final MagicPermanent source,final MagicPermanent permanent,final MagicPowerToughness pt) {
            final MagicGame game = source.getGame();
            final Collection<MagicPermanent> targets1 =
                    game.filterPermanents(permanent.getController(),MagicTargetFilter.TARGET_MOUNTAIN_YOU_CONTROL);
            if (targets1.size() > 0) {
                pt.add(1,1);
            }
            
            final Collection<MagicPermanent> targets2 =
                    game.filterPermanents(permanent.getController(),MagicTargetFilter.TARGET_PLAINS_YOU_CONTROL);
            if (targets2.size() > 0) {
                pt.add(1,1);
            }    
        }
    };
}
