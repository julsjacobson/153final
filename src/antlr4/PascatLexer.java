// Generated from Pascat.g4 by ANTLR 4.8

    package antlr4;
    import java.util.HashMap;
    import intermediate.symtab.SymtabEntry;
    import intermediate.type.Typespec;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PascatLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, PAWGRAM=24, 
		CONST=25, TYPE=26, ARRAY=27, OF=28, RECORD=29, VAR=30, END=31, DIV=32, 
		MOD=33, AND=34, OR=35, NOT=36, IF=37, ELSE=38, CLAW=39, REPEAT=40, UNTAIL=41, 
		WHILE=42, DO=43, FUR=44, TO=45, DOWNTO=46, MEOW=47, MEOWLN=48, READ=49, 
		READLN=50, PAWCEDURE=51, FUNCTION=52, BEGIN=53, IDENTIFIER=54, INTEGER=55, 
		REAL=56, NEWLINE=57, WS=58, QUOTE=59, CHARACTER=60, STRING=61, COMMENT=62;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "A", "B", "C", 
			"D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", 
			"R", "S", "T", "U", "V", "W", "X", "Y", "Z", "PAWGRAM", "CONST", "TYPE", 
			"ARRAY", "OF", "RECORD", "VAR", "END", "DIV", "MOD", "AND", "OR", "NOT", 
			"IF", "ELSE", "CLAW", "REPEAT", "UNTAIL", "WHILE", "DO", "FUR", "TO", 
			"DOWNTO", "MEOW", "MEOWLN", "READ", "READLN", "PAWCEDURE", "FUNCTION", 
			"BEGIN", "IDENTIFIER", "INTEGER", "REAL", "NEWLINE", "WS", "QUOTE", "CHARACTER", 
			"STRING", "CHARACTER_CHAR", "STRING_CHAR", "COMMENT", "COMMENT_CHARACTER"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'.'", "';'", "'('", "','", "')'", "'='", "'-'", "'+'", "'..'", 
			"'['", "']'", "'}'", "':'", "'<<'", "'>>'", "'=='", "'!='", "'<'", "'<='", 
			"'>'", "'>='", "'*'", "'/'", null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "'''"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"PAWGRAM", "CONST", "TYPE", "ARRAY", "OF", "RECORD", "VAR", "END", "DIV", 
			"MOD", "AND", "OR", "NOT", "IF", "ELSE", "CLAW", "REPEAT", "UNTAIL", 
			"WHILE", "DO", "FUR", "TO", "DOWNTO", "MEOW", "MEOWLN", "READ", "READLN", 
			"PAWCEDURE", "FUNCTION", "BEGIN", "IDENTIFIER", "INTEGER", "REAL", "NEWLINE", 
			"WS", "QUOTE", "CHARACTER", "STRING", "COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public PascatLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Pascat.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2@\u0217\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\3\2\3\2\3\3\3\3\3\4"+
		"\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\f"+
		"\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3"+
		"\22\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\26\3\26\3\26\3\27\3"+
		"\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3"+
		"\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3"+
		"(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3"+
		"\62\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\64\3\64\3\64\3\64\3\64\3"+
		"\64\3\65\3\65\3\65\3\65\3\65\3\66\3\66\3\66\3\66\3\66\3\66\3\67\3\67\3"+
		"\67\38\38\38\38\38\38\38\39\39\39\39\3:\3:\3:\3:\3;\3;\3;\3;\3<\3<\3<"+
		"\3<\3=\3=\3=\3=\3>\3>\3>\3?\3?\3?\3?\3@\3@\3@\3A\3A\3A\3A\3A\3B\3B\3B"+
		"\3B\3B\3C\3C\3C\3C\3C\3C\3C\3D\3D\3D\3D\3D\3D\3D\3E\3E\3E\3E\3E\3E\3F"+
		"\3F\3F\3G\3G\3G\3G\3H\3H\3H\3I\3I\3I\3I\3I\3I\3I\3J\3J\3J\3J\3J\3K\3K"+
		"\3K\3K\3K\3K\3K\3L\3L\3L\3L\3L\3M\3M\3M\3M\3M\3M\3M\3N\3N\3N\3N\3N\3N"+
		"\3N\3N\3N\3N\3O\3O\3O\3O\3O\3O\3O\3O\3O\3P\3P\3P\3P\3P\3P\3Q\3Q\7Q\u01c6"+
		"\nQ\fQ\16Q\u01c9\13Q\3R\6R\u01cc\nR\rR\16R\u01cd\3S\3S\3S\3S\3S\3S\3S"+
		"\5S\u01d7\nS\3S\3S\3S\3S\3S\3S\3S\5S\u01e0\nS\3S\3S\5S\u01e4\nS\3T\5T"+
		"\u01e7\nT\3T\3T\3T\3T\3U\6U\u01ee\nU\rU\16U\u01ef\3U\3U\3V\3V\3W\3W\3"+
		"W\3W\3X\3X\7X\u01fc\nX\fX\16X\u01ff\13X\3X\3X\3Y\3Y\3Z\3Z\3Z\3Z\5Z\u0209"+
		"\nZ\3[\3[\7[\u020d\n[\f[\16[\u0210\13[\3[\3[\3[\3[\3\\\3\\\2\2]\3\3\5"+
		"\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21"+
		"!\22#\23%\24\'\25)\26+\27-\30/\31\61\2\63\2\65\2\67\29\2;\2=\2?\2A\2C"+
		"\2E\2G\2I\2K\2M\2O\2Q\2S\2U\2W\2Y\2[\2]\2_\2a\2c\2e\32g\33i\34k\35m\36"+
		"o\37q s!u\"w#y${%}&\177\'\u0081(\u0083)\u0085*\u0087+\u0089,\u008b-\u008d"+
		".\u008f/\u0091\60\u0093\61\u0095\62\u0097\63\u0099\64\u009b\65\u009d\66"+
		"\u009f\67\u00a18\u00a39\u00a5:\u00a7;\u00a9<\u00ab=\u00ad>\u00af?\u00b1"+
		"\2\u00b3\2\u00b5@\u00b7\2\3\2#\4\2CCcc\4\2DDdd\4\2EEee\4\2FFff\4\2GGg"+
		"g\4\2HHhh\4\2IIii\4\2JJjj\4\2KKkk\4\2LLll\4\2MMmm\4\2NNnn\4\2OOoo\4\2"+
		"PPpp\4\2QQqq\4\2RRrr\4\2SSss\4\2TTtt\4\2UUuu\4\2VVvv\4\2WWww\4\2XXxx\4"+
		"\2YYyy\4\2ZZzz\4\2[[{{\4\2\\\\||\4\2C\\c|\5\2\62;C\\c|\3\2\62;\4\2--/"+
		"/\4\2\13\13\"\"\3\2))\3\2\177\177\2\u0204\2\3\3\2\2\2\2\5\3\2\2\2\2\7"+
		"\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2"+
		"\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2"+
		"\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2"+
		"\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i"+
		"\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2"+
		"\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081"+
		"\3\2\2\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2\2\2\u0089\3\2\2"+
		"\2\2\u008b\3\2\2\2\2\u008d\3\2\2\2\2\u008f\3\2\2\2\2\u0091\3\2\2\2\2\u0093"+
		"\3\2\2\2\2\u0095\3\2\2\2\2\u0097\3\2\2\2\2\u0099\3\2\2\2\2\u009b\3\2\2"+
		"\2\2\u009d\3\2\2\2\2\u009f\3\2\2\2\2\u00a1\3\2\2\2\2\u00a3\3\2\2\2\2\u00a5"+
		"\3\2\2\2\2\u00a7\3\2\2\2\2\u00a9\3\2\2\2\2\u00ab\3\2\2\2\2\u00ad\3\2\2"+
		"\2\2\u00af\3\2\2\2\2\u00b5\3\2\2\2\3\u00b9\3\2\2\2\5\u00bb\3\2\2\2\7\u00bd"+
		"\3\2\2\2\t\u00bf\3\2\2\2\13\u00c1\3\2\2\2\r\u00c3\3\2\2\2\17\u00c5\3\2"+
		"\2\2\21\u00c7\3\2\2\2\23\u00c9\3\2\2\2\25\u00cc\3\2\2\2\27\u00ce\3\2\2"+
		"\2\31\u00d0\3\2\2\2\33\u00d2\3\2\2\2\35\u00d4\3\2\2\2\37\u00d7\3\2\2\2"+
		"!\u00da\3\2\2\2#\u00dd\3\2\2\2%\u00e0\3\2\2\2\'\u00e2\3\2\2\2)\u00e5\3"+
		"\2\2\2+\u00e7\3\2\2\2-\u00ea\3\2\2\2/\u00ec\3\2\2\2\61\u00ee\3\2\2\2\63"+
		"\u00f0\3\2\2\2\65\u00f2\3\2\2\2\67\u00f4\3\2\2\29\u00f6\3\2\2\2;\u00f8"+
		"\3\2\2\2=\u00fa\3\2\2\2?\u00fc\3\2\2\2A\u00fe\3\2\2\2C\u0100\3\2\2\2E"+
		"\u0102\3\2\2\2G\u0104\3\2\2\2I\u0106\3\2\2\2K\u0108\3\2\2\2M\u010a\3\2"+
		"\2\2O\u010c\3\2\2\2Q\u010e\3\2\2\2S\u0110\3\2\2\2U\u0112\3\2\2\2W\u0114"+
		"\3\2\2\2Y\u0116\3\2\2\2[\u0118\3\2\2\2]\u011a\3\2\2\2_\u011c\3\2\2\2a"+
		"\u011e\3\2\2\2c\u0120\3\2\2\2e\u0122\3\2\2\2g\u012a\3\2\2\2i\u0130\3\2"+
		"\2\2k\u0135\3\2\2\2m\u013b\3\2\2\2o\u013e\3\2\2\2q\u0145\3\2\2\2s\u0149"+
		"\3\2\2\2u\u014d\3\2\2\2w\u0151\3\2\2\2y\u0155\3\2\2\2{\u0159\3\2\2\2}"+
		"\u015c\3\2\2\2\177\u0160\3\2\2\2\u0081\u0163\3\2\2\2\u0083\u0168\3\2\2"+
		"\2\u0085\u016d\3\2\2\2\u0087\u0174\3\2\2\2\u0089\u017b\3\2\2\2\u008b\u0181"+
		"\3\2\2\2\u008d\u0184\3\2\2\2\u008f\u0188\3\2\2\2\u0091\u018b\3\2\2\2\u0093"+
		"\u0192\3\2\2\2\u0095\u0197\3\2\2\2\u0097\u019e\3\2\2\2\u0099\u01a3\3\2"+
		"\2\2\u009b\u01aa\3\2\2\2\u009d\u01b4\3\2\2\2\u009f\u01bd\3\2\2\2\u00a1"+
		"\u01c3\3\2\2\2\u00a3\u01cb\3\2\2\2\u00a5\u01e3\3\2\2\2\u00a7\u01e6\3\2"+
		"\2\2\u00a9\u01ed\3\2\2\2\u00ab\u01f3\3\2\2\2\u00ad\u01f5\3\2\2\2\u00af"+
		"\u01f9\3\2\2\2\u00b1\u0202\3\2\2\2\u00b3\u0208\3\2\2\2\u00b5\u020a\3\2"+
		"\2\2\u00b7\u0215\3\2\2\2\u00b9\u00ba\7\60\2\2\u00ba\4\3\2\2\2\u00bb\u00bc"+
		"\7=\2\2\u00bc\6\3\2\2\2\u00bd\u00be\7*\2\2\u00be\b\3\2\2\2\u00bf\u00c0"+
		"\7.\2\2\u00c0\n\3\2\2\2\u00c1\u00c2\7+\2\2\u00c2\f\3\2\2\2\u00c3\u00c4"+
		"\7?\2\2\u00c4\16\3\2\2\2\u00c5\u00c6\7/\2\2\u00c6\20\3\2\2\2\u00c7\u00c8"+
		"\7-\2\2\u00c8\22\3\2\2\2\u00c9\u00ca\7\60\2\2\u00ca\u00cb\7\60\2\2\u00cb"+
		"\24\3\2\2\2\u00cc\u00cd\7]\2\2\u00cd\26\3\2\2\2\u00ce\u00cf\7_\2\2\u00cf"+
		"\30\3\2\2\2\u00d0\u00d1\7\177\2\2\u00d1\32\3\2\2\2\u00d2\u00d3\7<\2\2"+
		"\u00d3\34\3\2\2\2\u00d4\u00d5\7>\2\2\u00d5\u00d6\7>\2\2\u00d6\36\3\2\2"+
		"\2\u00d7\u00d8\7@\2\2\u00d8\u00d9\7@\2\2\u00d9 \3\2\2\2\u00da\u00db\7"+
		"?\2\2\u00db\u00dc\7?\2\2\u00dc\"\3\2\2\2\u00dd\u00de\7#\2\2\u00de\u00df"+
		"\7?\2\2\u00df$\3\2\2\2\u00e0\u00e1\7>\2\2\u00e1&\3\2\2\2\u00e2\u00e3\7"+
		">\2\2\u00e3\u00e4\7?\2\2\u00e4(\3\2\2\2\u00e5\u00e6\7@\2\2\u00e6*\3\2"+
		"\2\2\u00e7\u00e8\7@\2\2\u00e8\u00e9\7?\2\2\u00e9,\3\2\2\2\u00ea\u00eb"+
		"\7,\2\2\u00eb.\3\2\2\2\u00ec\u00ed\7\61\2\2\u00ed\60\3\2\2\2\u00ee\u00ef"+
		"\t\2\2\2\u00ef\62\3\2\2\2\u00f0\u00f1\t\3\2\2\u00f1\64\3\2\2\2\u00f2\u00f3"+
		"\t\4\2\2\u00f3\66\3\2\2\2\u00f4\u00f5\t\5\2\2\u00f58\3\2\2\2\u00f6\u00f7"+
		"\t\6\2\2\u00f7:\3\2\2\2\u00f8\u00f9\t\7\2\2\u00f9<\3\2\2\2\u00fa\u00fb"+
		"\t\b\2\2\u00fb>\3\2\2\2\u00fc\u00fd\t\t\2\2\u00fd@\3\2\2\2\u00fe\u00ff"+
		"\t\n\2\2\u00ffB\3\2\2\2\u0100\u0101\t\13\2\2\u0101D\3\2\2\2\u0102\u0103"+
		"\t\f\2\2\u0103F\3\2\2\2\u0104\u0105\t\r\2\2\u0105H\3\2\2\2\u0106\u0107"+
		"\t\16\2\2\u0107J\3\2\2\2\u0108\u0109\t\17\2\2\u0109L\3\2\2\2\u010a\u010b"+
		"\t\20\2\2\u010bN\3\2\2\2\u010c\u010d\t\21\2\2\u010dP\3\2\2\2\u010e\u010f"+
		"\t\22\2\2\u010fR\3\2\2\2\u0110\u0111\t\23\2\2\u0111T\3\2\2\2\u0112\u0113"+
		"\t\24\2\2\u0113V\3\2\2\2\u0114\u0115\t\25\2\2\u0115X\3\2\2\2\u0116\u0117"+
		"\t\26\2\2\u0117Z\3\2\2\2\u0118\u0119\t\27\2\2\u0119\\\3\2\2\2\u011a\u011b"+
		"\t\30\2\2\u011b^\3\2\2\2\u011c\u011d\t\31\2\2\u011d`\3\2\2\2\u011e\u011f"+
		"\t\32\2\2\u011fb\3\2\2\2\u0120\u0121\t\33\2\2\u0121d\3\2\2\2\u0122\u0123"+
		"\5O(\2\u0123\u0124\5\61\31\2\u0124\u0125\5]/\2\u0125\u0126\5=\37\2\u0126"+
		"\u0127\5S*\2\u0127\u0128\5\61\31\2\u0128\u0129\5I%\2\u0129f\3\2\2\2\u012a"+
		"\u012b\5\65\33\2\u012b\u012c\5M\'\2\u012c\u012d\5K&\2\u012d\u012e\5U+"+
		"\2\u012e\u012f\5W,\2\u012fh\3\2\2\2\u0130\u0131\5W,\2\u0131\u0132\5a\61"+
		"\2\u0132\u0133\5O(\2\u0133\u0134\59\35\2\u0134j\3\2\2\2\u0135\u0136\5"+
		"\61\31\2\u0136\u0137\5S*\2\u0137\u0138\5S*\2\u0138\u0139\5\61\31\2\u0139"+
		"\u013a\5a\61\2\u013al\3\2\2\2\u013b\u013c\5M\'\2\u013c\u013d\5;\36\2\u013d"+
		"n\3\2\2\2\u013e\u013f\5S*\2\u013f\u0140\59\35\2\u0140\u0141\5\65\33\2"+
		"\u0141\u0142\5M\'\2\u0142\u0143\5S*\2\u0143\u0144\5\67\34\2\u0144p\3\2"+
		"\2\2\u0145\u0146\5[.\2\u0146\u0147\5\61\31\2\u0147\u0148\5S*\2\u0148r"+
		"\3\2\2\2\u0149\u014a\59\35\2\u014a\u014b\5K&\2\u014b\u014c\5\67\34\2\u014c"+
		"t\3\2\2\2\u014d\u014e\5\67\34\2\u014e\u014f\5A!\2\u014f\u0150\5[.\2\u0150"+
		"v\3\2\2\2\u0151\u0152\5I%\2\u0152\u0153\5M\'\2\u0153\u0154\5\67\34\2\u0154"+
		"x\3\2\2\2\u0155\u0156\5\61\31\2\u0156\u0157\5K&\2\u0157\u0158\5\67\34"+
		"\2\u0158z\3\2\2\2\u0159\u015a\5M\'\2\u015a\u015b\5S*\2\u015b|\3\2\2\2"+
		"\u015c\u015d\5K&\2\u015d\u015e\5M\'\2\u015e\u015f\5W,\2\u015f~\3\2\2\2"+
		"\u0160\u0161\5A!\2\u0161\u0162\5;\36\2\u0162\u0080\3\2\2\2\u0163\u0164"+
		"\59\35\2\u0164\u0165\5G$\2\u0165\u0166\5U+\2\u0166\u0167\59\35\2\u0167"+
		"\u0082\3\2\2\2\u0168\u0169\5\65\33\2\u0169\u016a\5G$\2\u016a\u016b\5\61"+
		"\31\2\u016b\u016c\5]/\2\u016c\u0084\3\2\2\2\u016d\u016e\5S*\2\u016e\u016f"+
		"\59\35\2\u016f\u0170\5O(\2\u0170\u0171\59\35\2\u0171\u0172\5\61\31\2\u0172"+
		"\u0173\5W,\2\u0173\u0086\3\2\2\2\u0174\u0175\5Y-\2\u0175\u0176\5K&\2\u0176"+
		"\u0177\5W,\2\u0177\u0178\5\61\31\2\u0178\u0179\5A!\2\u0179\u017a\5G$\2"+
		"\u017a\u0088\3\2\2\2\u017b\u017c\5]/\2\u017c\u017d\5? \2\u017d\u017e\5"+
		"A!\2\u017e\u017f\5G$\2\u017f\u0180\59\35\2\u0180\u008a\3\2\2\2\u0181\u0182"+
		"\5\67\34\2\u0182\u0183\5M\'\2\u0183\u008c\3\2\2\2\u0184\u0185\5;\36\2"+
		"\u0185\u0186\5Y-\2\u0186\u0187\5S*\2\u0187\u008e\3\2\2\2\u0188\u0189\5"+
		"W,\2\u0189\u018a\5M\'\2\u018a\u0090\3\2\2\2\u018b\u018c\5\67\34\2\u018c"+
		"\u018d\5M\'\2\u018d\u018e\5]/\2\u018e\u018f\5K&\2\u018f\u0190\5W,\2\u0190"+
		"\u0191\5M\'\2\u0191\u0092\3\2\2\2\u0192\u0193\5I%\2\u0193\u0194\59\35"+
		"\2\u0194\u0195\5M\'\2\u0195\u0196\5]/\2\u0196\u0094\3\2\2\2\u0197\u0198"+
		"\5I%\2\u0198\u0199\59\35\2\u0199\u019a\5M\'\2\u019a\u019b\5]/\2\u019b"+
		"\u019c\5G$\2\u019c\u019d\5K&\2\u019d\u0096\3\2\2\2\u019e\u019f\5S*\2\u019f"+
		"\u01a0\59\35\2\u01a0\u01a1\5\61\31\2\u01a1\u01a2\5\67\34\2\u01a2\u0098"+
		"\3\2\2\2\u01a3\u01a4\5S*\2\u01a4\u01a5\59\35\2\u01a5\u01a6\5\61\31\2\u01a6"+
		"\u01a7\5\67\34\2\u01a7\u01a8\5G$\2\u01a8\u01a9\5K&\2\u01a9\u009a\3\2\2"+
		"\2\u01aa\u01ab\5O(\2\u01ab\u01ac\5\61\31\2\u01ac\u01ad\5]/\2\u01ad\u01ae"+
		"\5\65\33\2\u01ae\u01af\59\35\2\u01af\u01b0\5\67\34\2\u01b0\u01b1\5Y-\2"+
		"\u01b1\u01b2\5S*\2\u01b2\u01b3\59\35\2\u01b3\u009c\3\2\2\2\u01b4\u01b5"+
		"\5;\36\2\u01b5\u01b6\5Y-\2\u01b6\u01b7\5K&\2\u01b7\u01b8\5\65\33\2\u01b8"+
		"\u01b9\5W,\2\u01b9\u01ba\5A!\2\u01ba\u01bb\5M\'\2\u01bb\u01bc\5K&\2\u01bc"+
		"\u009e\3\2\2\2\u01bd\u01be\5\63\32\2\u01be\u01bf\59\35\2\u01bf\u01c0\5"+
		"=\37\2\u01c0\u01c1\5A!\2\u01c1\u01c2\5K&\2\u01c2\u00a0\3\2\2\2\u01c3\u01c7"+
		"\t\34\2\2\u01c4\u01c6\t\35\2\2\u01c5\u01c4\3\2\2\2\u01c6\u01c9\3\2\2\2"+
		"\u01c7\u01c5\3\2\2\2\u01c7\u01c8\3\2\2\2\u01c8\u00a2\3\2\2\2\u01c9\u01c7"+
		"\3\2\2\2\u01ca\u01cc\t\36\2\2\u01cb\u01ca\3\2\2\2\u01cc\u01cd\3\2\2\2"+
		"\u01cd\u01cb\3\2\2\2\u01cd\u01ce\3\2\2\2\u01ce\u00a4\3\2\2\2\u01cf\u01d0"+
		"\5\u00a3R\2\u01d0\u01d1\7\60\2\2\u01d1\u01d2\5\u00a3R\2\u01d2\u01e4\3"+
		"\2\2\2\u01d3\u01d4\5\u00a3R\2\u01d4\u01d6\t\6\2\2\u01d5\u01d7\t\37\2\2"+
		"\u01d6\u01d5\3\2\2\2\u01d6\u01d7\3\2\2\2\u01d7\u01d8\3\2\2\2\u01d8\u01d9"+
		"\5\u00a3R\2\u01d9\u01e4\3\2\2\2\u01da\u01db\5\u00a3R\2\u01db\u01dc\7\60"+
		"\2\2\u01dc\u01dd\5\u00a3R\2\u01dd\u01df\t\6\2\2\u01de\u01e0\t\37\2\2\u01df"+
		"\u01de\3\2\2\2\u01df\u01e0\3\2\2\2\u01e0\u01e1\3\2\2\2\u01e1\u01e2\5\u00a3"+
		"R\2\u01e2\u01e4\3\2\2\2\u01e3\u01cf\3\2\2\2\u01e3\u01d3\3\2\2\2\u01e3"+
		"\u01da\3\2\2\2\u01e4\u00a6\3\2\2\2\u01e5\u01e7\7\17\2\2\u01e6\u01e5\3"+
		"\2\2\2\u01e6\u01e7\3\2\2\2\u01e7\u01e8\3\2\2\2\u01e8\u01e9\7\f\2\2\u01e9"+
		"\u01ea\3\2\2\2\u01ea\u01eb\bT\2\2\u01eb\u00a8\3\2\2\2\u01ec\u01ee\t \2"+
		"\2\u01ed\u01ec\3\2\2\2\u01ee\u01ef\3\2\2\2\u01ef\u01ed\3\2\2\2\u01ef\u01f0"+
		"\3\2\2\2\u01f0\u01f1\3\2\2\2\u01f1\u01f2\bU\2\2\u01f2\u00aa\3\2\2\2\u01f3"+
		"\u01f4\7)\2\2\u01f4\u00ac\3\2\2\2\u01f5\u01f6\5\u00abV\2\u01f6\u01f7\5"+
		"\u00b1Y\2\u01f7\u01f8\5\u00abV\2\u01f8\u00ae\3\2\2\2\u01f9\u01fd\5\u00ab"+
		"V\2\u01fa\u01fc\5\u00b3Z\2\u01fb\u01fa\3\2\2\2\u01fc\u01ff\3\2\2\2\u01fd"+
		"\u01fb\3\2\2\2\u01fd\u01fe\3\2\2\2\u01fe\u0200\3\2\2\2\u01ff\u01fd\3\2"+
		"\2\2\u0200\u0201\5\u00abV\2\u0201\u00b0\3\2\2\2\u0202\u0203\n!\2\2\u0203"+
		"\u00b2\3\2\2\2\u0204\u0205\5\u00abV\2\u0205\u0206\5\u00abV\2\u0206\u0209"+
		"\3\2\2\2\u0207\u0209\n!\2\2\u0208\u0204\3\2\2\2\u0208\u0207\3\2\2\2\u0209"+
		"\u00b4\3\2\2\2\u020a\u020e\7}\2\2\u020b\u020d\5\u00b7\\\2\u020c\u020b"+
		"\3\2\2\2\u020d\u0210\3\2\2\2\u020e\u020c\3\2\2\2\u020e\u020f\3\2\2\2\u020f"+
		"\u0211\3\2\2\2\u0210\u020e\3\2\2\2\u0211\u0212\7\177\2\2\u0212\u0213\3"+
		"\2\2\2\u0213\u0214\b[\2\2\u0214\u00b6\3\2\2\2\u0215\u0216\n\"\2\2\u0216"+
		"\u00b8\3\2\2\2\r\2\u01c7\u01cd\u01d6\u01df\u01e3\u01e6\u01ef\u01fd\u0208"+
		"\u020e\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}