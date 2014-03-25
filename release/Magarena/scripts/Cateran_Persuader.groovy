def MERCENARY_CMC_1_OR_LESS = new MagicCardFilterImpl() {
    public boolean accept(final MagicGame game,final MagicPlayer player,final MagicCard target) {
        return target.hasSubType(MagicSubType.Mercenary) && target.getConvertedCost() <= 1;
    }
    public boolean acceptType(final MagicTargetType targetType) {
        return targetType==MagicTargetType.Library;
    }
};

[
    new MagicPermanentActivation(
        new MagicActivationHints(MagicTiming.Main),
        "Search"
    ) {
        @Override
        public Iterable<MagicEvent> getCostEvent(final MagicPermanent source) {
            return [new MagicTapEvent(source), new MagicPayManaCostEvent(source, "{1}")];
        }

        @Override
        public MagicEvent getPermanentEvent(final MagicPermanent source,final MagicPayedCost payedCost) {
            return new MagicEvent(
                source,
                this,
                "PN searches his or her library for a Mercenary permanent card with converted mana cost 1 or less and puts that card onto the battlefield. Then shuffle PN's library."
            );
        }
        
        @Override
        public void executeEvent(final MagicGame game, final MagicEvent event) {
            game.addEvent(new MagicSearchOntoBattlefieldEvent(
                event,
                new MagicTargetChoice(MERCENARY_CMC_1_OR_LESS, "a Mercenary permanent card with converted mana cost 1 or less")    
            ));
        }
    }
]
