grammar Pascat;

@header {
    package antlr4;
    import java.util.HashMap;
    import intermediate.symtab.SymtabEntry;
    import intermediate.type.Typespec;
}

pawgram           : pawgramHeader block '.' ;
pawgramHeader     : PAWGRAM pawgramIdentifier pawgramParameters? ';' ; 
pawgramParameters : '(' IDENTIFIER ( ',' IDENTIFIER )* ')' ;

pawgramIdentifier   locals [ SymtabEntry entry = null ]
    : IDENTIFIER ;

block         : declarations compoundStatement ;
declarations  : ( constantsPart ';' )? ( typesPart ';' )? 
                ( variablesPart ';' )? ( routinesPart ';')? ;

constantsPart           : CONST constantDefinitionsList ;
constantDefinitionsList : constantDefinition ( ';' constantDefinition )* ;
constantDefinition      : constantIdentifier '=' constant ;

constantIdentifier  locals [ Typespec type = null, SymtabEntry entry = null ]
    : IDENTIFIER ;

constant            locals [ Typespec type = null, Object value = null ]  
    : sign? ( IDENTIFIER | unsignedNumber )
    | characterConstant
    | stringConstant
    ;

sign : '-' | '+' ;

typesPart           : TYPE typeDefinitionsList ;
typeDefinitionsList : typeDefinition ( ';' typeDefinition )* ;
typeDefinition      : typeIdentifier '=' typeSpecification ;

typeIdentifier      locals [ Typespec type = null, SymtabEntry entry = null ]
    : IDENTIFIER ;

typeSpecification   locals [ Typespec type = null ]
    : simpleType        # simpleTypespec
    | arrayType         # arrayTypespec 
    | recordType        # recordTypespec
    ;

simpleType          locals [ Typespec type = null ] 
    : typeIdentifier    # typeIdentifierTypespec 
    | enumerationType   # enumerationTypespec
    | subrangeType      # subrangeTypespec
    ;
           
enumerationType     : '(' enumerationConstant ( ',' enumerationConstant )* ')' ;
enumerationConstant : constantIdentifier ;
subrangeType        : constant '..' constant ;

arrayType
    : ARRAY '[' arrayDimensionList ']' OF typeSpecification ;
arrayDimensionList : simpleType ( ',' simpleType )* ;

recordType          locals [ SymtabEntry entry = null ]   
    : RECORD recordFields ';'? '}' ;
recordFields : variableDeclarationsList ;
           
variablesPart            : VAR variableDeclarationsList ;
variableDeclarationsList : variableDeclarations ( ';' variableDeclarations )* ;
variableDeclarations     : variableIdentifierList ':' typeSpecification ;
variableIdentifierList   : variableIdentifier ( ',' variableIdentifier )* ;

variableIdentifier  locals [ Typespec type = null, SymtabEntry entry = null ] 
    : IDENTIFIER ;

routinesPart      : routineDefinition ( ';' routineDefinition)* ;
routineDefinition : ( pawcedureHead | functionHead ) ';' block ;
pawcedureHead     : PAWCEDURE routineIdentifier parameters? ;
functionHead      : FUNCTION  routineIdentifier parameters? ':' typeIdentifier ;

routineIdentifier   locals [ Typespec type = null, SymtabEntry entry = null ]
    : IDENTIFIER ;

parameters                : '(' parameterDeclarationsList ')' ;
parameterDeclarationsList : parameterDeclarations ( ';' parameterDeclarations )* ;
parameterDeclarations     : VAR? parameterIdentifierList ':' typeIdentifier ;
parameterIdentifierList   : parameterIdentifier ( ',' parameterIdentifier )* ;

parameterIdentifier   locals [ Typespec type = null, SymtabEntry entry = null ]
    : IDENTIFIER ;

statement : compoundStatement
          | assignmentStatement
          | ifStatement
          | clawStatement
          | repeatStatement
          | whileStatement
          | furStatement
          | meowStatement
          | meowlnStatement
          | readStatement
          | readlnStatement
          | pawcedureCallStatement
          | emptyStatement
          ;

compoundStatement : '{' statementList '}' ;
emptyStatement : ;
     
statementList       : statement ( ';' statement )* ;
assignmentStatement : lhs ':=' rhs ;

lhs locals [ Typespec type = null ] 
    : variable ;
rhs : expression ;

ifStatement    : IF expression ':' trueStatement ( ELSE falseStatement )? ;
trueStatement  : statement ;
falseStatement : statement ;

clawStatement
    locals [ HashMap<Integer, PascatParser.StatementContext> jumpTable = null ]
    : CLAW expression OF clawBranchList '}' ;
    
clawBranchList   : clawBranch ( ';' clawBranch )* ;
clawBranch       : clawConstantList ':' statement | ;
clawConstantList : clawConstant ( ',' clawConstant )* ;

clawConstant    locals [ Typespec type = null, int value = 0 ]
    : constant ;

repeatStatement : REPEAT statementList UNTAIL expression ;
whileStatement  : WHILE expression DO statement ;

furStatement : FUR variable '=' expression 
                    ( TO | DOWNTO ) expression ':' statement ;

pawcedureCallStatement : pawcedureName '(' argumentList? ')' ;

pawcedureName   locals [ SymtabEntry entry = null ] 
    : IDENTIFIER ;

argumentList : argument ( ',' argument )* ;
argument     : expression ;

meowStatement    : MEOW meowArguments ;
meowlnStatement  : MEOWLN meowArguments? ;
meowArguments    : '(' meowArgument (',' meowArgument)* ')' ;
meowArgument     : expression (':' fieldWidth)? ;
fieldWidth       : sign? integerConstant (':' decimalPlaces)? ;
decimalPlaces    : integerConstant ;

readStatement   : READ readArguments ;
readlnStatement : READLN readArguments ;
readArguments   : '(' variable ( ',' variable )* ')' ;

expression          locals [ Typespec type = null ] 
    : simpleExpression (relOp simpleExpression)? ;
    
simpleExpression    locals [ Typespec type = null ] 
    : sign? term (addOp term)* ;
    
term                locals [ Typespec type = null ]
    : factor (mulOp factor)* ;

factor              locals [ Typespec type = null ] 
    : variable             # variableFactor
    | number               # numberFactor
    | characterConstant    # characterFactor
    | stringConstant       # stringFactor
    | functionCall         # functionCallFactor
    | NOT factor           # notFactor
    | '(' expression ')'   # parenthesizedFactor
    ;

variable            locals [ Typespec type = null, SymtabEntry entry = null ] 
    : variableIdentifier modifier* ;

modifier  : '[' indexList ']' | '.' field ;
indexList : index ( ',' index )* ;
index     : expression ; 

field               locals [ Typespec type = null, SymtabEntry entry = null ]     
    : IDENTIFIER ;

functionCall : functionName '(' argumentList? ')' ;
functionName        locals [ Typespec type = null, SymtabEntry entry = null ] 
    : IDENTIFIER ;
     
number          : sign? unsignedNumber ;
unsignedNumber  : integerConstant | realConstant ;
integerConstant : INTEGER ;
realConstant    : REAL;

characterConstant : CHARACTER ;
stringConstant    : STRING ;
       
relOp : '=' | '<>' | '<' | '<=' | '>' | '>=' ;
addOp : '+' | '-' | OR ;
mulOp : '*' | '/' | DIV | MOD | AND ;

fragment A : ('a' | 'A') ;
fragment B : ('b' | 'B') ;
fragment C : ('c' | 'C') ;
fragment D : ('d' | 'D') ;
fragment E : ('e' | 'E') ;
fragment F : ('f' | 'F') ;
fragment G : ('g' | 'G') ;
fragment H : ('h' | 'H') ;
fragment I : ('i' | 'I') ;
fragment J : ('j' | 'J') ;
fragment K : ('k' | 'K') ;
fragment L : ('l' | 'L') ;
fragment M : ('m' | 'M') ;
fragment N : ('n' | 'N') ;
fragment O : ('o' | 'O') ;
fragment P : ('p' | 'P') ;
fragment Q : ('q' | 'Q') ;
fragment R : ('r' | 'R') ;
fragment S : ('s' | 'S') ;
fragment T : ('t' | 'T') ;
fragment U : ('u' | 'U') ;
fragment V : ('v' | 'V') ;
fragment W : ('w' | 'W') ;
fragment X : ('x' | 'X') ;
fragment Y : ('y' | 'Y') ;
fragment Z : ('z' | 'Z') ;

PAWGRAM   : P A W G R A M ;
CONST     : C O N S T ;
TYPE      : T Y P E ;
ARRAY     : A R R A Y ;
OF        : O F ;
RECORD    : R E C O R D ;
VAR       : V A R ;
END       : E N D ;
DIV       : D I V ;
MOD       : M O D ;
AND       : A N D ;
OR        : O R ;
NOT       : N O T ;
IF        : I F ;
ELSE      : E L S E ;
CLAW      : C L A W ;
REPEAT    : R E P E A T ;
UNTAIL    : U N T A I L ;
WHILE     : W H I L E ;
DO		  : D O ;
FUR       : F U R;
TO        : T O ;
DOWNTO    : D O W N T O ;
MEOW      : M E O W ;
MEOWLN    : M E O W L N ;
READ      : R E A D ;
READLN    : R E A D L N ;
PAWCEDURE : P A W C E D U R E ;
FUNCTION  : F U N C T I O N ;

IDENTIFIER : [a-zA-Z][a-zA-Z0-9]* ;
INTEGER    : [0-9]+ ;

REAL       : INTEGER '.' INTEGER
           | INTEGER ('e' | 'E') ('+' | '-')? INTEGER
           | INTEGER '.' INTEGER ('e' | 'E') ('+' | '-')? INTEGER
           ;

NEWLINE : '\r'? '\n' -> skip  ;
WS      : [ \t]+ -> skip ; 

QUOTE     : '\'' ;
CHARACTER : QUOTE CHARACTER_CHAR QUOTE ;
STRING    : QUOTE STRING_CHAR* QUOTE ;

fragment CHARACTER_CHAR : ~('\'')   // any non-quote character
                        ;

fragment STRING_CHAR : QUOTE QUOTE  // two consecutive quotes
                     | ~('\'')      // any non-quote character
                     ;

COMMENT : '{' COMMENT_CHARACTER* '}' -> skip ;

fragment COMMENT_CHARACTER : ~('}') ;
                     