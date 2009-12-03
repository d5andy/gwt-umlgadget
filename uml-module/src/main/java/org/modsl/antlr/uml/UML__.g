lexer grammar UML;
options {
  language=Java;

}
@header {
	package org.modsl.antlr.uml;
}

T12 : 'collab' ;
T13 : 'collaboration' ;
T14 : 'communication' ;
T15 : 'diagram' ;
T16 : '{' ;
T17 : '}' ;
T18 : ';' ;
T19 : '.' ;
T20 : 'sequence' ;
T21 : 'seq' ;
T22 : 'class' ;
T23 : 'abstract' ;
T24 : '<' ;
T25 : ',' ;
T26 : '>' ;
T27 : 'extends' ;
T28 : 'implements' ;
T29 : 'interface' ;
T30 : 'static' ;
T31 : '(' ;
T32 : ')' ;
T33 : ':' ;
T34 : '-' ;
T35 : '+' ;
T36 : '#' ;
T37 : '..' ;
T38 : '*' ;

// $ANTLR src "C:\dev\googlecode\modsl-read-only\modsl-core\src\main\antlr\org\modsl\antlr\uml\UML.g" 111
ML_COMMENT: '/*' .* '*/' { skip(); };
// $ANTLR src "C:\dev\googlecode\modsl-read-only\modsl-core\src\main\antlr\org\modsl\antlr\uml\UML.g" 112
SL_COMMENT: '//' .* NEWLINE { skip(); };
// $ANTLR src "C:\dev\googlecode\modsl-read-only\modsl-core\src\main\antlr\org\modsl\antlr\uml\UML.g" 113
STRING: '"' .* '"';

// $ANTLR src "C:\dev\googlecode\modsl-read-only\modsl-core\src\main\antlr\org\modsl\antlr\uml\UML.g" 115
EDGEOP: '->';
// $ANTLR src "C:\dev\googlecode\modsl-read-only\modsl-core\src\main\antlr\org\modsl\antlr\uml\UML.g" 116
ID: ('_' | 'a'..'z' | 'A'..'Z' | 'À'..'ÿ') (INT | '_' | 'a'..'z' |'A'..'Z' | 'À'..'ÿ' | '[' | ']')*;
// $ANTLR src "C:\dev\googlecode\modsl-read-only\modsl-core\src\main\antlr\org\modsl\antlr\uml\UML.g" 117
INT : '0'..'9'+ ;
// $ANTLR src "C:\dev\googlecode\modsl-read-only\modsl-core\src\main\antlr\org\modsl\antlr\uml\UML.g" 118
WS: (' ' | '\t' | NEWLINE)+ { skip(); };
// $ANTLR src "C:\dev\googlecode\modsl-read-only\modsl-core\src\main\antlr\org\modsl\antlr\uml\UML.g" 119
fragment NEWLINE:'\r'? '\n';
