[
    new MagicStatic(MagicLayer.Ability,CREATURE) {
        @Override
        public void modAbilityFlags(final MagicPermanent source, final MagicPermanent permanent, final Set<MagicAbility> flags) {
            flags.remove(MagicAbility.Flying);
            flags.remove(MagicAbility.Islandwalk);
        }
    }
]
