lexer grammar Basic;
options {
  language=Java;

}
@header {
	package org.modsl.antlr.basic;
}

T9 : 'graph' ;
T10 : '{' ;
T11 : '}' ;
T12 : '(' ;
T13 : ',' ;
T14 : ')' ;
T15 : ':' ;
T16 : ';' ;

// $ANTLR src "C:\dev\googlecode\modsl-read-only\modsl-core\src\main\antlr\org\modsl\antlr\basic\Basic.g" 39
EDGEOP: '->' | '--';
// $ANTLR src "C:\dev\googlecode\modsl-read-only\modsl-core\src\main\antlr\org\modsl\antlr\basic\Basic.g" 40
ID: '"' .* '"' |  ('_' | 'a'..'z' |'A'..'Z' | 'À'..'ÿ') (INT | '_' | 'a'..'z' |'A'..'Z' | 'À'..'ÿ')* ;
// $ANTLR src "C:\dev\googlecode\modsl-read-only\modsl-core\src\main\antlr\org\modsl\antlr\basic\Basic.g" 41
INT : '0'..'9'+ ;
// $ANTLR src "C:\dev\googlecode\modsl-read-only\modsl-core\src\main\antlr\org\modsl\antlr\basic\Basic.g" 42
NEWLINE:'\r'? '\n';
// $ANTLR src "C:\dev\googlecode\modsl-read-only\modsl-core\src\main\antlr\org\modsl\antlr\basic\Basic.g" 43
WS: (' ' |'\t' | '\r' | '\n')+ { skip(); };