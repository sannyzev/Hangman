package game;

// This class retains information about the words (they have a name (str) and a hint)...
public class Word {

	// ... and it also provides the dictionary of words:
	public static int nrWords;
	public static Word[][] words = new Word[3][];
	
	public String str;
	public String hint;
	
	public Word(String str, String hint) {
		this.str = str;
		this.hint = hint;
	}
	
	public static void initWords() {
		nrWords = 100;
		
		// Easy:
		words[0] = new Word[] {
				new Word("                 ABILITY                                ", "PREPAREDNESS OR CAPACITY"),
				new Word("                  ADVICE                                ", "GUIDANCE"),
				new Word("                 APPLAUSE                               ", "HAND CLAPPING"),
				new Word("                  BLAST                                 ", "EXPLOSION"),
				new Word("                  BLOCK                                 ", "BUILDING OR STRUCTURE"),
				new Word("                  BLURRY                                ", "FAINT OR FOGGY"),
				new Word("                  BORROW                                ", "TAKE FOR ONESELF"),
				new Word("                  CLING                                 ", "HOLD ON TO"),
				new Word("                 COMPETE                                ", "COMPETITOR"),
				new Word("                CONTRIBUTE                              ", "DONATE"),
				new Word("                 CONVINCE                               ", "PERSUADE"),
				new Word("                   CROP                                 ", "CUT OR TRIM"),
				new Word("                 CUSTOMER                               ", "CONSUMER"),
				new Word("                DISSAPPEAR                              ", "VANISH"),
				new Word("                   DOZE                                 ", "HAND CLAPPING"),
				new Word("                   EARN                                 ", "BE ENTITLED TO"),
				new Word("                EXCITEMENT                              ", "INTENSITY"),
				new Word("                 FAMILIAR                               ", "SIMILAR"),
				new Word("                 FLEXIBLE                               ", "ADJUSTABLE"),
				new Word("                   FOND                                 ", "PASSIONATE ABOUT"),
				new Word("                  FOGGY                                 ", "BLURRY"),
				new Word("                  GADGET                                ", "TOOL"),
				new Word("                  GRUNT                                 ", "MURMURING"),
				new Word("                  GENIUS                                ", "SMART"),
				new Word("                  GUILTY                                ", "FAULTY"),
				new Word("                 HARVEST                                ", "EXTRACT"),
				new Word("                  HONEST                                ", "TRUTHFUL"),
				new Word("                 IMMITATE                               ", "PATTERN ONESELF"),
				new Word("                ILLUSTRATE                              ", "DECORATE"),
				new Word("                 IMPROVE                                ", "BETTER"),
				new Word("                   JURY                                 ", "JUDGES"),
				new Word("                  LEAGUE                                ", "GROUP OR CLUB"),
				new Word("                  LOYAL                                 ", "TRUSTWORTHY"),
				new Word("                   MIST                                 ", "FOG"),
				new Word("                  MURMER                                ", "BUZZ OR HUM"),
				new Word("                 NUMEROUS                               ", "SEVERAL"),
				new Word("                OCCASIONAL                              ", "PARTICULAR"),
				new Word("                 PARTNER                                ", "COMPANION"),
				new Word("                  PATCH                                 ", "CHUNK"),
				new Word("                  POLISH                                ", "BRIGHTEN"),
				new Word("                 PROCESS                                ", "DEVELOPMENT"),
				new Word("                  PROFIT                                ", "EARNING OR BENEFIT"),
				new Word("                  RISKY                                 ", "TRICKY"),
				new Word("                   RUDE                                 ", "DISRESPECTFUL"),
				new Word("                  QUIVER                                ", "THRILL"),
				new Word("                  RAISE                                 ", "BOOST"),
				new Word("                RECOMMEND                               ", "ADVOCATE OR ENDORSE"),
				new Word("                  SCORE                                 ", "TO GAIN OR RESULT"),
				new Word("                 SCRIBBLE                               ", "TO SCRAWL"),
				new Word("                 SLITHER                                ", "SMOOTHLY MOVE AROUND"),
				new Word("                  SQUEAK                                ", "A HIGH PITCHED NOISE"),
				new Word("                 SNUGGLE                                ", "BE IN A COMFORTABLE POSITION"),
				new Word("                 TEXTURE                                ", "A FEEL OR TOUCH"),
				new Word("                   TUG                                  ", "A SUDDEN PULL"),
				new Word("                 ALTITUDE                               ", "THE DISTANCE FROM THE GROUND"),
				new Word("                  ABSORB                                ", "TO TAKE IN"),
				new Word("                AVALANCHE                               ", "BARRAGE OR VOLLEY"),
				new Word("                   BAY                                  ", "A COVE OR INLET"),
				new Word("                  BURDEN                                ", "A HEAVY LOAD"),
				new Word("                  CHILLY                                ", "COLD"),
				new Word("                 CLATTER                                ", "RATTLE OR CLANK"),
				new Word("                 CONSTANT                               ", "WITHOUT CHANGE"),
				new Word("                 DISSOLVE                               ", "DISSIPATE"),
				new Word("                  DROWSY                                ", "SLEEPY"),
				new Word("                 EVIDENCE                               ", "PROOF"),
				new Word("                  FIERCE                                ", "FEARSOME"),
				new Word("                  FOSSIL                                ", "OLD OR PRESERVED BONES"),
				new Word("                  GLANCE                                ", "PEEK OR BRIEF LOOK"),
				new Word("                  GLOBAL                                ", "WELL KNOWN OR WORLDWIDE"),
				new Word("                 GREEDILY                               ", "IN A SELFISH MANNER"),
				new Word("                   HALT                                 ", "STOP"),
				new Word("                HESITATION                              ", "UNCERTAINTY"),
				new Word("                  IGNORE                                ", "TO PAY NO MIND"),
				new Word("                 INSPIRE                                ", "MOTIVATE OR UNFLUENCE"),
				new Word("                 INCREASE                               ", "GROW OR ENLARGE"),
				new Word("                   LAVA                                 ", "MOLTEN ROCK"),
				new Word("                  LAYER                                 ", "A COATING"),
				new Word("                   LOAD                                 ", "CARGO OR FREIGHT"),
				new Word("                  MANAGE                                ", "OVERSEE OR CONTROL"),
				new Word("                 MIGRATE                                ", "MOVE"),
				new Word("                OVERHEATED                              ", "PAST NORMAL TEMPERATURES"),
				new Word("                 PASSAGE                                ", "MOVING THROUGH"),
				new Word("                 PLEASURE                               ", "HAPPY FEELING OR SATISFACTION"),
				new Word("                POLLUTION                               ", "CONTAMINATION OR IMPURITY"),
				new Word("                 PRAIRIE                                ", "OPEN GRASSLAND"),
				new Word("                 RECYCLE                                ", "TO REUSE"),
				new Word("                  ROUGH                                 ", "COARSE OR "),
				new Word("                  RUSTLE                                ", "TO STEAL OR SWISH"),
				new Word("                  SCOLD                                 ", "TO PUNISH"),
				new Word("                 SINCERE                                ", "HEARTFELT"),
				new Word("                  SLICK                                 ", "EFFICIENT OR SMOOTH"),
				new Word("                  SNIFF                                 ", "INHALE OR SMELL"),
				new Word("                 SURVIVAL                               ", "CONTINUANCE OF EXISTENCE"),
				new Word("                  TERROR                                ", "SCARE"),
				new Word("                THUNDEROUS                              ", "EXTREMELY LOUD"),
				new Word("                 TROPICAL                               ", "VERY HOT"),
				new Word("                UNEXPECTED                              ", "SUDDEN OR UNFORESEEN"),
				new Word("                  UNITED                                ", "TOGETHER"),
				new Word("                  VOYAGE                                ", "A LONG JOURNEY"),
				new Word("                WILDERNESS                              ", "UNCIVILIZED OR UNINHABITED")
		};
		
		// Medium:
		words[1] = new Word[] {
				new Word("                 ABRIDGE                                ", "ABBREVIATE"),
				new Word("                 ABSTRACT                               ", "HYPOTHETICAL"),
				new Word("                ACCESSIBLE                              ", "AVAILABLE"),
				new Word("                 ACCLAIM                                ", "PRAISE"),
				new Word("               ACKNOWLEDGE                              ", "ACCESIBLE"),
				new Word("                ADULATION                               ", "APPLAUSE"),
				new Word("                ADVERSITY                               ", "DIFFICULTY"),
				new Word("                 ADVOCATE                               ", "DEFENDER"),
				new Word("                 AFFABLE                                ", "PLEASANT"),
				new Word("               AFFIRMATION                              ", "CONFIRMATION"),
				new Word("                  ALOOF                                 ", "DISTANT"),
				new Word("                AMBIGUOUS                               ", "UNCERTAIN"),
				new Word("                ANARCHIST                               ", "REVOLUTIONARY"),
				new Word("                ANTAGONISM                              ", "DISAGREEMENT"),
				new Word("                  APATHY                                ", "INDIFFERENCE"),
				new Word("                ARBITRARY                               ", "ERRATIC"),
				new Word("                ARROGANCE                               ", "SMUGNESS"),
				new Word("                ARTICULATE                              ", "EXPRESSIVE"),
				new Word("                 ARTISAN                                ", "CRAFTSMAN"),
				new Word("                ASCENDANCY                              ", "DOMINANCE"),
				new Word("                 ASCETIC                                ", "DISCIPLINED"),
				new Word("                  ASPIRE                                ", "PURSUE"),
				new Word("                  ASTUTE                                ", "CRAFTY"),
				new Word("                 AUGMENT                                ", "DEVELOP"),
				new Word("                 AUSTERE                                ", "SOMBER"),
				new Word("                AUTONOMOUS                              ", "SOVEREIGN"),
				new Word("                 AVERSION                               ", "ALLERGY"),
				new Word("                  BELIE                                 ", "CONTRADICT"),
				new Word("                 BRAGGART                               ", "BRAG"),
				new Word("                CALCULATED                              ", "MEASURED"),
				new Word("                CENSORIOUS                              ", "ACCUSATORY"),
				new Word("               COMMEMORATE                              ", "REMEMBER"),
				new Word("                COMPLIANCE                              ", "SUBMISSION"),
				new Word("                COMPOSURE                               ", "CALM"),
				new Word("                 CONCEDE                                ", "YIELD"),
				new Word("               CONCILITARY                              ", "COMPROMISING"),
				new Word("                  CONCUR                                ", "AGREE"),
				new Word("                 CONDONE                                ", "EXCUSE"),
				new Word("                 CONFOUND                               ", "CONFUSE"),
				new Word("                 CONSESUS                               ", "ACCORD"),
				new Word("                 CONTEND                                ", "(FIGHT"),
				new Word("               CONTENTIOUS                              ", "DISPUTATIOUS"),
				new Word("               CORROBORATE                              ", "SUPPORT"),
				new Word("                 CRYPTIC                                ", "DEEP"),
				new Word("                 DECORUM                                ", "DECOROUSNESS"),
				new Word("                DELINEATE                               ", "OUTLINE"),
				new Word("                DEPRECATE                               ", "DEPRECIATE"),
				new Word("                DERIVATIVE                              ", "DERIVED"),
				new Word("                DESPONDENT                              ", "HEARTSICK"),
				new Word("                DETTERENT                               ", "HANDICAP"),
				new Word("               DETRIMENTAL                              ", "DAMAGING"),
				new Word("                  DEVISE                                ", "FORGE"),
				new Word("                 DIFFUSE                                ", "SPREAD OUT"),
				new Word("                DILIGENCE                               ", "INDUSTRY"),
				new Word("                DIMINUTION                              ", "DECREASE"),
				new Word("                DISCERNING                              ", "DISCREET"),
				new Word("                 DISCOUNT                               ", "DISMISS"),
				new Word("                 DISDAIN                                ", "SCORN"),
				new Word("                DISPARAGE                               ", "BELITTLE"),
				new Word("               DISPUTATIONS                             ", "DEBATE"),
				new Word("                DIVERGENT                               ", "(DIVERGING"),
				new Word("                 DOCTRINE                               ", "PHILOSOPHY"),
				new Word("                 DOCUMENT                               ", "PAPERS"),
				new Word("                 DUBIOUS                                ", "DOUBTFUL"),
				new Word("                DUPLICITY                               ", "FRAUDULENCE"),
				new Word("                 EGOTISM                                ", "SELF-IMPORTANCE"),
				new Word("                  ELATED                                ", "JOYFUL"),
				new Word("                 ELUSIVE                                ", "SUBTLE"),
				new Word("                EMBELLISH                               ", "BEAUTIFY"),
				new Word("                 ENDORSE                                ", "CERTIFY"),
				new Word("                 ENHANCE                                ", "RAISE"),
				new Word("                  ENMITY                                ", "HOSTILITY"),
				new Word("                EPHEMERAL                               ", "TRANSITORY"),
				new Word("                ERRONEOUS                               ", "INACCURATE"),
				new Word("                 ERUDITE                                ", "LEARNED"),
				new Word("                  EULOGY                                ", "EULOGIUM"),
				new Word("                EUPHEMISM                               ", "DELICACY"),
				new Word("                  EXALT                                 ", "PROCLAIM"),
				new Word("                 EXECUTE                                ", "ACCOMPLISH"),
				new Word("                EXEMPLIFY                               ", "ILLUSTRATE"),
				new Word("                EXHAUSTIVE                              ", "THOUROUGH"),
				new Word("                 EXPEDITE                               ", "HASTEN"),
				new Word("                 EXPLOIT                                ", "WORK"),
				new Word("                  EXTOL                                 ", "GLORIFY"),
				new Word("                EXTRICATE                               ", "UNTANGLE"),
				new Word("                EXUBERANCE                              ", "ENTHUSIASM"),
				new Word("                FALLACIOUS                              ", "UNSOUND"),
				new Word("                FANATICISM                              ", "ZEALOTRY"),
				new Word("                 FEASIBLE                               ", "VIABLE"),
				new Word("                  FERVOR                                ", "EXCITEMENT"),
				new Word("                FRIVOLOUS                               ", "JOKINGLY"),
				new Word("                FRUGALITY                               ", "FRUGAL"),
				new Word("                GARRULOUS                               ", "CHATTY"),
				new Word("                 GLUTTON                                ", "GOURMAND"),
				new Word("                GRATUITOUS                              ", "NEEDLESS"),
				new Word("                 GRAVITY                                ", "SOLEMNITY"),
				new Word("                  GUILE                                 ", "TRICKERY"),
				new Word("                 GULLIBLE                               ", "FLEECEABLE"),
				new Word("                  HARDY                                 ", "STURDY"),
				new Word("               HAUGHTINESS                              ", "ARROGANCE")

		};
		
		// Hard:
		words[2] = new Word[] {
				new Word("                  AVIARY                                ", "BIRD SANCTUARY"),
				new Word("                 BEQUEATH                               ", "LEAVE OR WILL"),
				new Word("                BOMBASTIC                               ", "LARGE OR DECLAMATORY"),
				new Word("                 BUTTRESS                               ", "SUPPORT"),
				new Word("               CACOPHONOUS                              ", "NOISY"),
				new Word("               CARDIOLOGIST                             ", "HEART SURGEON"),
				new Word("                 CARPING                                ", "FAULTFINDING OR NITPICKING"),
				new Word("                CERTITUDE                               ", "OVERCONFIDENCE"),
				new Word("                CHARLATAN                               ", "SHAM OR FRAUD"),
				new Word("              CIRCUMLOCUTION                            ", "WORDINESS"),
				new Word("                  CLICHE                                ", "OVERUSED THOUGHT"),
				new Word("                COLLOQUIAL                              ", "CONVERSATIONAL"),
				new Word("               COMBUSTIBLE                              ", "ABLE TO BURN EASILY"),
				new Word("              COMPLEMENTARY                             ", "FLATTERING OR APPROVING"),
				new Word("                CONFLUENCE                              ", "MERGING MEETING"),
				new Word("                CONJECTURE                              ", "THEORIZE OR SPECULATE"),
				new Word("                 CONVERGE                               ", "MEET"),
				new Word("                 CORRODE                                ", "RUST OR EAT"),
				new Word("                CORRUGATED                              ", "FLOOTED OR GROOVED"),
				new Word("                 CULPABLE                               ", "BLAMABLE"),
				new Word("                DEBILITATE                              ", "ENFEEBLE OR DRAIN"),
				new Word("                  DEBUNK                                ", "EXPOSE"),
				new Word("                DEHYDRATE                               ", "DESICCATE OR DRY UP"),
				new Word("               DELETERIOUS                              ", "HURTFUL"),
				new Word("                  DEPOSE                                ", "FORCE OUT OR SWEAR"),
				new Word("                DESICCATE                               ", "DRY OUT"),
				new Word("               ICONOCLASTIC                             ", "ATTACK ON BELIEFS"),
				new Word("               IDIOSYNCRASY                             ", "MANNERISM"),
				new Word("                 ILLUSORY                               ", "FALSE OR UNREAL"),
				new Word("                IMMUTABLE                               ", "CHANGELESS"),
				new Word("                  IMPAIR                                ", "WEAKEN"),
				new Word("                IMPECCABLE                              ", "PERFECT OR FAULTLESS"),
				new Word("                  IMPEDE                                ", "TO STOP OR BLOCK"),
				new Word("                INCIDENTAL                              ", "NOT A MAJOR PART OF SOMETHING"),
				new Word("              INCONTROVERTIBLE                            ", "IRREFUTABLE OR POSITIVE"),
				new Word("              INDEFATIGABLE                             ", "TIRELESS OR UNWEARYING"),
				new Word("                 INDOLENT                               ", "LAZY OR SLOTHFUL"),
				new Word("                INEFFABLE                               ", "UNSPEAKABLE OR UNTELLABLE"),
				new Word("                INEXORABLE                              ", "STERN OR UNFORGIVING"),
				new Word("                INNOCUOUS                               ", "HARMLESS OR INNOCENT"),
				new Word("                INNOVATION                              ", "CREATION OR CONCEPTION"),
				new Word("                 INSIPID                                ", "BORING OR BLAND"),
				new Word("                INSOLVENT                               ", "BANKRUPT OR UNABLE TO PAY DEBT"),
				new Word("                INSULARITY                              ", "INSULATION OR DETACHMENT"),
				new Word("               INSUPERABLE                              ", "UNCONQUERABLE"),
				new Word("               INTRACTABLE                              ", "HARD TO CONTROL"),
				new Word("                  IRONIC                                ", "SARCASTIC OR CYNICAL"),
				new Word("              IRREPROACHABLE                            ", "BLAMELESS OR IMPECCABLE"),
				new Word("                 JOCULAR                                ", "JESTING OR JOKING"),
				new Word("                LABYRINTH                               ", "MAZE OR INNER EAR"),
				new Word("                 LACONIC                                ", "CRISP OR CURT"),
				new Word("                 LAGGARD                                ", "DRONE OR DAWDLER"),
				new Word("                 LAMPOON                                ", "PARODY OR SPOOF"),
				new Word("                LASSITUDE                               ", "LETHARGY OR SLACKNESS"),
				new Word("                   LAUD                                 ", "FLORIFY OR PROCLAIM"),
				new Word("                  LAVISH                                ", "MUNIFICENT OR LUXURIOUS"),
				new Word("                LETHARGIC                               ", "UNENERGETIC"),
				new Word("                  LEVITY                                ", "CHEERFULNESS"),
				new Word("                  LINGER                                ", "DAWDLE OR LURK"),
				new Word("                 LISTLESS                               ", "DISPIRITED"),
				new Word("                  LITHE                                 ", "SLENDER OR SUPPLE"),
				new Word("                  LOFTY                                 ", "EMINENT OR TOWERING"),
				new Word("                  LURID                                 ", "SHOCKING"),
				new Word("                LUXURIANT                               ", "LUSH AND EXUBERANT"),
				new Word("                MALICIOUS                               ", "BAD INTENT OR HURTFUL"),
				new Word("                 MEANDER                                ", "ZIGZAG OR TWIST"),
				new Word("                MERCENARY                               ", "MAKING MONEY AT THE EXPENSE OF ETHICS"),
				new Word("                MERCURIAL                               ", "ERRATIC OR FICKLE"),
				new Word("                  MIRTH                                 ", "HALIRITY OR GLEE"),
				new Word("               MISANTHROPE                              ", "HATER OR CYNIC"),
				new Word("                 MISNOMER                               ", "A WRONG USE OF A WORD"),
				new Word("                 OBLIVION                               ", "LIMBO OR UNCONSCIOUSNESS"),
				new Word("                 OBSCURE                                ", "BLOCK OR HIDE"),
				new Word("                OBSTINATE                               ", "CONTRARY OR STUBBORN"),
				new Word("                 OMINOUS                                ", "MENACING OR THREATENING"),
				new Word("                  OPAQUE                                ", "UNINTELLIGIBLE"),
				new Word("               PREDECESSOR                              ", "CAME BEFORE"),
				new Word("               PRESUMPTUOUS                             ", "ASSUMPTIVE"),
				new Word("                PROVINCIAL                              ", "PEASANT AND BUCOLIC"),
				new Word("                PROXIMITY                               ", "CLOSELESNESS"),
				new Word("                QUALIFIED                               ", "CERTIFIED OR ABLE"),
				new Word("                 QUANDARY                               ", "DILEMMA OR PREDICAMENT"),
				new Word("                  RAMBLE                                ", "WANDER OR STRAY"),
				new Word("                  RATIFY                                ", "SIGN"),
				new Word("                 REBUTTAL                               ", "A CONTRADICTION"),
				new Word("                 RECLUSE                                ", "WITHDRAWN OR SOLITARY"),
				new Word("                 TURMOIL                                ", "AGITATION"),
				new Word("                UNDERMINE                               ", "SABOTAGE OR SUBVERT"),
				new Word("                VACILLATE                               ", "FLUCTUATE"),
				new Word("                 VENERATE                               ", "REVERENCE OR FEAR"),
				new Word("                 ILLICIT                                ", "ILLEGAL OR UNLAWFUL"),
				new Word("                  BLEAK                                 ", "BARE OR EXPOSED"),
				new Word("               IMPECUNIOUS                              ", "PENNILESS OR POOR"),
				new Word("                 BLIGHTED                               ", "SPOIL OR HARM"),
				new Word("               IMPREGNABLE                              ", "IMPENETRABLE"),
				new Word("                 OBDURATE                               ", "STUBBORN OR OBSTINATE"),
				new Word("                  ORNATE                                ", "ELABORATE OR DECORATED"),
				new Word("                  PARIAH                                ", "AN OUTCAST"),
				new Word("                  PARODY                                ", "A MOCK OR SATIRE"),
				new Word("                PARSIMONY                               ", "CHEAPNESS")
		};
	}
}
