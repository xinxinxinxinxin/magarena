[
    new MagicComesIntoPlayWithCounterTrigger() {
        @Override
        public MagicEvent executeTrigger(final MagicGame game, final MagicPermanent permanent,final MagicPayedCost payedCost) {
            if (payedCost.isKicked()) {
                game.doAction(new MagicChangeCountersAction(permanent,MagicCounterType.PlusOne,1));
            }
            return MagicEvent.NONE;
        }
    }
]
