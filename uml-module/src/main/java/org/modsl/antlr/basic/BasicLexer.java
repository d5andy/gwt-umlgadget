// $ANTLR 3.0.1 C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g 2009-11-12 21:16:30

	package org.modsl.antlr.basic;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class BasicLexer extends Lexer {
    public static final int WS=8;
    public static final int NEWLINE=7;
    public static final int EDGEOP=6;
    public static final int T10=10;
    public static final int T11=11;
    public static final int INT=5;
    public static final int T12=12;
    public static final int T13=13;
    public static final int T14=14;
    public static final int T9=9;
    public static final int T15=15;
    public static final int ID=4;
    public static final int Tokens=17;
    public static final int T16=16;
    public static final int EOF=-1;
    public BasicLexer() {;} 
    public BasicLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g"; }

    // $ANTLR start T9
    public final void mT9() throws RecognitionException {
        try {
            int _type = T9;
            // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:10:4: ( 'graph' )
            // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:10:6: 'graph'
            {
            match("graph"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T9

    // $ANTLR start T10
    public final void mT10() throws RecognitionException {
        try {
            int _type = T10;
            // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:11:5: ( '{' )
            // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:11:7: '{'
            {
            match('{'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T10

    // $ANTLR start T11
    public final void mT11() throws RecognitionException {
        try {
            int _type = T11;
            // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:12:5: ( '}' )
            // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:12:7: '}'
            {
            match('}'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T11

    // $ANTLR start T12
    public final void mT12() throws RecognitionException {
        try {
            int _type = T12;
            // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:13:5: ( '(' )
            // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:13:7: '('
            {
            match('('); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T12

    // $ANTLR start T13
    public final void mT13() throws RecognitionException {
        try {
            int _type = T13;
            // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:14:5: ( ',' )
            // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:14:7: ','
            {
            match(','); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T13

    // $ANTLR start T14
    public final void mT14() throws RecognitionException {
        try {
            int _type = T14;
            // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:15:5: ( ')' )
            // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:15:7: ')'
            {
            match(')'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T14

    // $ANTLR start T15
    public final void mT15() throws RecognitionException {
        try {
            int _type = T15;
            // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:16:5: ( ':' )
            // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:16:7: ':'
            {
            match(':'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T15

    // $ANTLR start T16
    public final void mT16() throws RecognitionException {
        try {
            int _type = T16;
            // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:17:5: ( ';' )
            // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:17:7: ';'
            {
            match(';'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T16

    // $ANTLR start EDGEOP
    public final void mEDGEOP() throws RecognitionException {
        try {
            int _type = EDGEOP;
            // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:39:7: ( '->' | '--' )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='-') ) {
                int LA1_1 = input.LA(2);

                if ( (LA1_1=='>') ) {
                    alt1=1;
                }
                else if ( (LA1_1=='-') ) {
                    alt1=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("39:1: EDGEOP : ( '->' | '--' );", 1, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("39:1: EDGEOP : ( '->' | '--' );", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:39:9: '->'
                    {
                    match("->"); 


                    }
                    break;
                case 2 :
                    // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:39:16: '--'
                    {
                    match("--"); 


                    }
                    break;

            }
            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end EDGEOP

    // $ANTLR start ID
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:40:3: ( '\"' ( . )* '\"' | ( '_' | 'a' .. 'z' | 'A' .. 'Z' | 'À' .. 'ÿ' ) ( INT | '_' | 'a' .. 'z' | 'A' .. 'Z' | 'À' .. 'ÿ' )* )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='\"') ) {
                alt4=1;
            }
            else if ( ((LA4_0>='A' && LA4_0<='Z')||LA4_0=='_'||(LA4_0>='a' && LA4_0<='z')||(LA4_0>='\u00C0' && LA4_0<='\u00FF')) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("40:1: ID : ( '\"' ( . )* '\"' | ( '_' | 'a' .. 'z' | 'A' .. 'Z' | 'À' .. 'ÿ' ) ( INT | '_' | 'a' .. 'z' | 'A' .. 'Z' | 'À' .. 'ÿ' )* );", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:40:5: '\"' ( . )* '\"'
                    {
                    match('\"'); 
                    // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:40:9: ( . )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0=='\"') ) {
                            alt2=2;
                        }
                        else if ( ((LA2_0>='\u0000' && LA2_0<='!')||(LA2_0>='#' && LA2_0<='\uFFFE')) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:40:9: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:40:19: ( '_' | 'a' .. 'z' | 'A' .. 'Z' | 'À' .. 'ÿ' ) ( INT | '_' | 'a' .. 'z' | 'A' .. 'Z' | 'À' .. 'ÿ' )*
                    {
                    if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z')||(input.LA(1)>='\u00C0' && input.LA(1)<='\u00FF') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse =
                            new MismatchedSetException(null,input);
                        recover(mse);    throw mse;
                    }

                    // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:40:57: ( INT | '_' | 'a' .. 'z' | 'A' .. 'Z' | 'À' .. 'ÿ' )*
                    loop3:
                    do {
                        int alt3=6;
                        switch ( input.LA(1) ) {
                        case '0':
                        case '1':
                        case '2':
                        case '3':
                        case '4':
                        case '5':
                        case '6':
                        case '7':
                        case '8':
                        case '9':
                            {
                            alt3=1;
                            }
                            break;
                        case '_':
                            {
                            alt3=2;
                            }
                            break;
                        case 'a':
                        case 'b':
                        case 'c':
                        case 'd':
                        case 'e':
                        case 'f':
                        case 'g':
                        case 'h':
                        case 'i':
                        case 'j':
                        case 'k':
                        case 'l':
                        case 'm':
                        case 'n':
                        case 'o':
                        case 'p':
                        case 'q':
                        case 'r':
                        case 's':
                        case 't':
                        case 'u':
                        case 'v':
                        case 'w':
                        case 'x':
                        case 'y':
                        case 'z':
                            {
                            alt3=3;
                            }
                            break;
                        case 'A':
                        case 'B':
                        case 'C':
                        case 'D':
                        case 'E':
                        case 'F':
                        case 'G':
                        case 'H':
                        case 'I':
                        case 'J':
                        case 'K':
                        case 'L':
                        case 'M':
                        case 'N':
                        case 'O':
                        case 'P':
                        case 'Q':
                        case 'R':
                        case 'S':
                        case 'T':
                        case 'U':
                        case 'V':
                        case 'W':
                        case 'X':
                        case 'Y':
                        case 'Z':
                            {
                            alt3=4;
                            }
                            break;
                        case '\u00C0':
                        case '\u00C1':
                        case '\u00C2':
                        case '\u00C3':
                        case '\u00C4':
                        case '\u00C5':
                        case '\u00C6':
                        case '\u00C7':
                        case '\u00C8':
                        case '\u00C9':
                        case '\u00CA':
                        case '\u00CB':
                        case '\u00CC':
                        case '\u00CD':
                        case '\u00CE':
                        case '\u00CF':
                        case '\u00D0':
                        case '\u00D1':
                        case '\u00D2':
                        case '\u00D3':
                        case '\u00D4':
                        case '\u00D5':
                        case '\u00D6':
                        case '\u00D7':
                        case '\u00D8':
                        case '\u00D9':
                        case '\u00DA':
                        case '\u00DB':
                        case '\u00DC':
                        case '\u00DD':
                        case '\u00DE':
                        case '\u00DF':
                        case '\u00E0':
                        case '\u00E1':
                        case '\u00E2':
                        case '\u00E3':
                        case '\u00E4':
                        case '\u00E5':
                        case '\u00E6':
                        case '\u00E7':
                        case '\u00E8':
                        case '\u00E9':
                        case '\u00EA':
                        case '\u00EB':
                        case '\u00EC':
                        case '\u00ED':
                        case '\u00EE':
                        case '\u00EF':
                        case '\u00F0':
                        case '\u00F1':
                        case '\u00F2':
                        case '\u00F3':
                        case '\u00F4':
                        case '\u00F5':
                        case '\u00F6':
                        case '\u00F7':
                        case '\u00F8':
                        case '\u00F9':
                        case '\u00FA':
                        case '\u00FB':
                        case '\u00FC':
                        case '\u00FD':
                        case '\u00FE':
                        case '\u00FF':
                            {
                            alt3=5;
                            }
                            break;

                        }

                        switch (alt3) {
                    	case 1 :
                    	    // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:40:58: INT
                    	    {
                    	    mINT(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:40:64: '_'
                    	    {
                    	    match('_'); 

                    	    }
                    	    break;
                    	case 3 :
                    	    // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:40:70: 'a' .. 'z'
                    	    {
                    	    matchRange('a','z'); 

                    	    }
                    	    break;
                    	case 4 :
                    	    // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:40:80: 'A' .. 'Z'
                    	    {
                    	    matchRange('A','Z'); 

                    	    }
                    	    break;
                    	case 5 :
                    	    // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:40:91: 'À' .. 'ÿ'
                    	    {
                    	    matchRange('\u00C0','\u00FF'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);


                    }
                    break;

            }
            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end ID

    // $ANTLR start INT
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:41:5: ( ( '0' .. '9' )+ )
            // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:41:7: ( '0' .. '9' )+
            {
            // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:41:7: ( '0' .. '9' )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='0' && LA5_0<='9')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:41:7: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end INT

    // $ANTLR start NEWLINE
    public final void mNEWLINE() throws RecognitionException {
        try {
            int _type = NEWLINE;
            // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:42:8: ( ( '\\r' )? '\\n' )
            // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:42:9: ( '\\r' )? '\\n'
            {
            // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:42:9: ( '\\r' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='\r') ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:42:9: '\\r'
                    {
                    match('\r'); 

                    }
                    break;

            }

            match('\n'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end NEWLINE

    // $ANTLR start WS
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:43:3: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:43:5: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:43:5: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='\t' && LA7_0<='\n')||LA7_0=='\r'||LA7_0==' ') ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);

             skip(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end WS

    public void mTokens() throws RecognitionException {
        // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:1:8: ( T9 | T10 | T11 | T12 | T13 | T14 | T15 | T16 | EDGEOP | ID | INT | NEWLINE | WS )
        int alt8=13;
        switch ( input.LA(1) ) {
        case 'g':
            {
            int LA8_1 = input.LA(2);

            if ( (LA8_1=='r') ) {
                int LA8_15 = input.LA(3);

                if ( (LA8_15=='a') ) {
                    int LA8_17 = input.LA(4);

                    if ( (LA8_17=='p') ) {
                        int LA8_18 = input.LA(5);

                        if ( (LA8_18=='h') ) {
                            int LA8_19 = input.LA(6);

                            if ( ((LA8_19>='0' && LA8_19<='9')||(LA8_19>='A' && LA8_19<='Z')||LA8_19=='_'||(LA8_19>='a' && LA8_19<='z')||(LA8_19>='\u00C0' && LA8_19<='\u00FF')) ) {
                                alt8=10;
                            }
                            else {
                                alt8=1;}
                        }
                        else {
                            alt8=10;}
                    }
                    else {
                        alt8=10;}
                }
                else {
                    alt8=10;}
            }
            else {
                alt8=10;}
            }
            break;
        case '{':
            {
            alt8=2;
            }
            break;
        case '}':
            {
            alt8=3;
            }
            break;
        case '(':
            {
            alt8=4;
            }
            break;
        case ',':
            {
            alt8=5;
            }
            break;
        case ')':
            {
            alt8=6;
            }
            break;
        case ':':
            {
            alt8=7;
            }
            break;
        case ';':
            {
            alt8=8;
            }
            break;
        case '-':
            {
            alt8=9;
            }
            break;
        case '\"':
        case 'A':
        case 'B':
        case 'C':
        case 'D':
        case 'E':
        case 'F':
        case 'G':
        case 'H':
        case 'I':
        case 'J':
        case 'K':
        case 'L':
        case 'M':
        case 'N':
        case 'O':
        case 'P':
        case 'Q':
        case 'R':
        case 'S':
        case 'T':
        case 'U':
        case 'V':
        case 'W':
        case 'X':
        case 'Y':
        case 'Z':
        case '_':
        case 'a':
        case 'b':
        case 'c':
        case 'd':
        case 'e':
        case 'f':
        case 'h':
        case 'i':
        case 'j':
        case 'k':
        case 'l':
        case 'm':
        case 'n':
        case 'o':
        case 'p':
        case 'q':
        case 'r':
        case 's':
        case 't':
        case 'u':
        case 'v':
        case 'w':
        case 'x':
        case 'y':
        case 'z':
        case '\u00C0':
        case '\u00C1':
        case '\u00C2':
        case '\u00C3':
        case '\u00C4':
        case '\u00C5':
        case '\u00C6':
        case '\u00C7':
        case '\u00C8':
        case '\u00C9':
        case '\u00CA':
        case '\u00CB':
        case '\u00CC':
        case '\u00CD':
        case '\u00CE':
        case '\u00CF':
        case '\u00D0':
        case '\u00D1':
        case '\u00D2':
        case '\u00D3':
        case '\u00D4':
        case '\u00D5':
        case '\u00D6':
        case '\u00D7':
        case '\u00D8':
        case '\u00D9':
        case '\u00DA':
        case '\u00DB':
        case '\u00DC':
        case '\u00DD':
        case '\u00DE':
        case '\u00DF':
        case '\u00E0':
        case '\u00E1':
        case '\u00E2':
        case '\u00E3':
        case '\u00E4':
        case '\u00E5':
        case '\u00E6':
        case '\u00E7':
        case '\u00E8':
        case '\u00E9':
        case '\u00EA':
        case '\u00EB':
        case '\u00EC':
        case '\u00ED':
        case '\u00EE':
        case '\u00EF':
        case '\u00F0':
        case '\u00F1':
        case '\u00F2':
        case '\u00F3':
        case '\u00F4':
        case '\u00F5':
        case '\u00F6':
        case '\u00F7':
        case '\u00F8':
        case '\u00F9':
        case '\u00FA':
        case '\u00FB':
        case '\u00FC':
        case '\u00FD':
        case '\u00FE':
        case '\u00FF':
            {
            alt8=10;
            }
            break;
        case '0':
        case '1':
        case '2':
        case '3':
        case '4':
        case '5':
        case '6':
        case '7':
        case '8':
        case '9':
            {
            alt8=11;
            }
            break;
        case '\r':
            {
            int LA8_12 = input.LA(2);

            if ( (LA8_12=='\n') ) {
                int LA8_13 = input.LA(3);

                if ( ((LA8_13>='\t' && LA8_13<='\n')||LA8_13=='\r'||LA8_13==' ') ) {
                    alt8=13;
                }
                else {
                    alt8=12;}
            }
            else {
                alt8=13;}
            }
            break;
        case '\n':
            {
            int LA8_13 = input.LA(2);

            if ( ((LA8_13>='\t' && LA8_13<='\n')||LA8_13=='\r'||LA8_13==' ') ) {
                alt8=13;
            }
            else {
                alt8=12;}
            }
            break;
        case '\t':
        case ' ':
            {
            alt8=13;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("1:1: Tokens : ( T9 | T10 | T11 | T12 | T13 | T14 | T15 | T16 | EDGEOP | ID | INT | NEWLINE | WS );", 8, 0, input);

            throw nvae;
        }

        switch (alt8) {
            case 1 :
                // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:1:10: T9
                {
                mT9(); 

                }
                break;
            case 2 :
                // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:1:13: T10
                {
                mT10(); 

                }
                break;
            case 3 :
                // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:1:17: T11
                {
                mT11(); 

                }
                break;
            case 4 :
                // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:1:21: T12
                {
                mT12(); 

                }
                break;
            case 5 :
                // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:1:25: T13
                {
                mT13(); 

                }
                break;
            case 6 :
                // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:1:29: T14
                {
                mT14(); 

                }
                break;
            case 7 :
                // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:1:33: T15
                {
                mT15(); 

                }
                break;
            case 8 :
                // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:1:37: T16
                {
                mT16(); 

                }
                break;
            case 9 :
                // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:1:41: EDGEOP
                {
                mEDGEOP(); 

                }
                break;
            case 10 :
                // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:1:48: ID
                {
                mID(); 

                }
                break;
            case 11 :
                // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:1:51: INT
                {
                mINT(); 

                }
                break;
            case 12 :
                // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:1:55: NEWLINE
                {
                mNEWLINE(); 

                }
                break;
            case 13 :
                // C:\\dev\\googlecode\\modsl-read-only\\modsl-core\\src\\main\\antlr\\org\\modsl\\antlr\\basic\\Basic.g:1:63: WS
                {
                mWS(); 

                }
                break;

        }

    }


 

}